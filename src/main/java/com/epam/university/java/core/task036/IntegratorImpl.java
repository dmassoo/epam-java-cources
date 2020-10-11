package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {
    /**
     * Integration algorithm implementation.
     *
     * @param left     left limit
     * @param right    right limit
     * @param function function to integrate
     * @return integration results
     */
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        return (function.apply(left) + function.apply(right)) * (right - left) / 2.0;
    }
}
