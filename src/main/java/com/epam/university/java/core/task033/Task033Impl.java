package com.epam.university.java.core.task033;

public class Task033Impl implements Task033 {
    /**
     * Throws different exceptions.
     *
     * @param first  first value
     * @param second second value
     */
    @Override
    public void doSomething(int first, int second) throws Exception {
        if (first == 0 && second == 0) {
            throw new ArithmeticException();
        }
        if (first > second) {
            throw new GreaterExceptionImpl("First > Second", new BaseExceptionImpl());
        }
        if (first < second) {
            throw new LessExceptionImpl("Second > First", new BaseExceptionImpl());
        }
    }
}
