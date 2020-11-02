package com.epam.university.java.core.task053;

import java.util.ArrayList;

public class StackX<T> {
    private int maxSize;
    private ArrayList<T> stackArray;
    private int top;

    /**
     * Constructor with size parameter.
     *
     * @param maxSize size of stack
     */
    public StackX(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new ArrayList<>(maxSize);
        top = -1;
    }

    /**
     * Push in the stack.
     *
     * @param e element to be pushed
     */
    public void push(T e) {
        stackArray.add(e);
        top++;
    }

    /**
     * Remove and return the element from the top of the stack.
     *
     * @return element that was on the top of the stack before.
     */
    public T pop() {
        T onTop = stackArray.get(top);
        stackArray.remove(top);
        top--;
        return onTop;

    }

    public T peek() {
        T onTop = stackArray.get(stackArray.size() - 1);
        return onTop;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getSize() {
        return top + 1;
    }

    public T peekN(int n) {
        return stackArray.get(n);
    }

    /**
     * Method to print stack to termital.
     *
     */
    public void displayStack() {
        for (int j = 0; j < getSize(); j++) {
            System.out.print(peekN(j) + " ");
        }
        System.out.println();
    }
}
