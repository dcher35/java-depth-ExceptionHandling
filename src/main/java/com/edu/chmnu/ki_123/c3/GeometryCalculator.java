package com.edu.chmnu.ki_123.c3;

public class GeometryCalculator {
    private static final double PI = 3.14159265358979323846;

    public double calculateCubeVolume(double sideLength) throws ValidationException {
        if (sideLength <= 0) {
            throw new ValidationException("Cube side length must be greater than zero.");
        }
        return Math.pow(sideLength, 3);
    }

    public double calculateSphereVolume(double radius) throws ValidationException {
        if (radius <= 0) {
            throw new ValidationException("Sphere radius must be greater than zero.");
        }
        return (4.0 / 3.0) * PI * Math.pow(radius, 3);
    }

    public double calculateCylinderVolume(double radius, double height) throws ValidationException, CalculationException {
        if (radius <= 0 || height <= 0) {
            throw new ValidationException("Cylinder radius and height must be greater than zero.");
        }
        if (radius * height > 1e6) {
            throw new CalculationException("Calculated volume exceeds the allowed limit.");
        }
        return PI * Math.pow(radius, 2) * height;
    }
}