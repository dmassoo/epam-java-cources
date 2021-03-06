package com.epam.university.java.core.task036;

import java.util.function.Function;

public class Task036Impl implements Task036 {
    /**
     * Integrate given <code>function</code> using <code>integrator</code>
     * as integration algorithm in a given limits.
     *
     * @param function   function to integrate
     * @param integrator integration algorithm
     * @param limitLeft  left limit
     * @param limitRight right limit
     * @return integration results
     */
    @Override
    public double integrate(Function<Double, Double> function,
                            Integrator integrator,
                            double limitLeft,
                            double limitRight) {
        int steps = 1000000;
        double h = (limitRight - limitLeft) / steps;
        double area = 0;
        double currentPoint = limitLeft;
        while (currentPoint < limitRight) {
            area += integrator.integrate(currentPoint, currentPoint + h, function);
            currentPoint += h;
        }
        return area;
    }
}
