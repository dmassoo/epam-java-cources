package com.epam.university.java.core.task053;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class ParsePost {
    private StackX<Double> stackX;
    private ArrayList<String> input;
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    /**
     * Constructor.
     *
     * @param input arraylist with expression in postfix form.
     */
    public ParsePost(ArrayList<String> input) {
        this.input = input;
    }

    /**
     * Method to parse postfix form to the numeric form (i.e. calculation).
     *
     * @return result
     */
    public double parse() {
        stackX = new StackX<Double>(input.size());
        String s;
        double num1;
        double num2;
        double interAns;
        for (int j = 0; j < input.size(); j++) {
            s = input.get(j);
            if (isNumeric(s)) {
                stackX.push(Double.parseDouble(s));
            } else {
                num2 = stackX.pop();
                num1 = stackX.pop();
                switch (s) {
                    case "+":
                        interAns = num1 + num2;
                        break;
                    case "-":
                        interAns = num1 - num2;
                        break;
                    case "*":
                        interAns = num1 * num2;
                        break;
                    case "/":
                        interAns = num1 / num2;
                        break;
                    case "^":
                        interAns = Math.pow(num1, num2);
                        break;
                    default:
                        interAns = 0;
                }
                stackX.push(interAns);
            }
        }
        interAns = stackX.pop();
        return interAns;
    }

    /**
     * Method to check whether a string can be converted to a number.
     *
     * @param strToCheck string to check
     * @return true if string is numeric
     */
    public boolean isNumeric(String strToCheck) {
        if (strToCheck == null) {
            return false;
        }
        return pattern.matcher(strToCheck).matches();
    }
}
