package com.epam.university.java.core.task053;

public class StackX {
    private int maxSize;
    private String[] stackArray;
    private int top;

    /**
     * Constructor with size parameter.
     *
     * @param maxSize size of stack
     */
    public StackX(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new String[maxSize];
        top = -1;
    }

    public void push(String e) {
        stackArray[++top] = e;
    }

    public String pop() {
        return stackArray[top--];
    }

    public String peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
    public int getSize() {
        return top + 1;
    }

    public String peekN(int n) {
        return stackArray[n];
    }

    public void displayStack() {
        for (int j = 0; j < getSize(); j++) {
            System.out.print(peekN(j) + " ");
        }
        System.out.println();
    }
}
