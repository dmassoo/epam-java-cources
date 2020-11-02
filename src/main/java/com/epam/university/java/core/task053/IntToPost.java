package com.epam.university.java.core.task053;

import java.util.ArrayList;

public class IntToPost {
    private StackX stackX;
    private String input;
    private ArrayList<String> output;

    /**
     * Constructor.
     *
     * @param input is input string
     */
    public IntToPost(String input) {
        this.input = input;
        int stackSize = input.length();
        stackX = new StackX(stackSize);
        output = new ArrayList<>();
    }

    public ArrayList<String> toPostfix() {
        String operators = "()^+-*/";
        for (int j = 0; j < input.length(); j++) {
            String e = Character.toString(input.charAt(j));
            //handling more than one-digit numbers
            //is ok
            if (!operators.contains(e) && j + 1 < input.length()) {
                String d = Character.toString(input.charAt(j + 1));
                while (!operators.contains(d)) {
                    e += d;
                    j++;
                    if (j + 1 >= input.length()) {
                        break;
                    }
                    d = Character.toString(input.charAt(j + 1));
                }
            }
            switch(e) {
                case "+":
                case "-":
                    gotOperator(e, 1);
                    break;
                case "*":
                case "/":
                    gotOperator(e, 2);
                    break;
                case "^":
                    gotOperator(e, 3);
                    break;
                case "(":
                    stackX.push(e);
                    break;
                case ")":
                    gotParen(e);
                    break;
                default:
                    output.add(e);
                    break;
            }
        }
        while (!stackX.isEmpty()) {
            output.add(stackX.pop());
        }
        return output;
    }

    public void gotOperator(String opThis, int prec1) {
        while (!stackX.isEmpty()) {
            String opTop = stackX.pop();
            if (opTop.equals("(")) {
                stackX.push(opTop);
                break;
            } else {
                int prec2;
                if(opTop.equals("+") || opTop.equals("-")) {
                    prec2 = 1;
                    //now without exponentiation
                } else if (opTop.equals("^")) {
                    prec2 = 3;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1) {
                    stackX.push(opTop);
                    break;
                } else {
                    output.add(opTop);
                }
            }
        }
        stackX.push(opThis);
    }

    public void gotParen(String p) {
        while (!stackX.isEmpty()) {
            String q = stackX.pop();
            if (q.equals("(")) {
                break;
            } else {
                output.add(q);
            }
        }
    }
}
