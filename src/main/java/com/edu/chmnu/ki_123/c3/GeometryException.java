package com.edu.chmnu.ki_123.c3;

import java.util.Scanner;

public class GeometryException {
    public static void main(String[] args) {
        GeometryCalculator calculator = new GeometryCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Geometry Volume Calculator ===");
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Calculate cube volume");
            System.out.println("2. Calculate sphere volume");
            System.out.println("3. Calculate cylinder volume");
            System.out.println("0. Exit");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter the side of the cube: ");
                        double side = scanner.nextDouble();
                        double volume = calculator.calculateCubeVolume(side);
                        System.out.printf("The volume of the cube is: %.2f\n", volume);
                    }
                    case 2 -> {
                        System.out.print("Enter the radius of the sphere: ");
                        double radius = scanner.nextDouble();
                        double volume = calculator.calculateSphereVolume(radius);
                        System.out.printf("The volume of the sphere is: %.2f\n", volume);
                    }
                    case 3 -> {
                        System.out.print("Enter the radius of the cylinder: ");
                        double radius = scanner.nextDouble();
                        System.out.print("Enter the height of the cylinder: ");
                        double height = scanner.nextDouble();
                        double volume = calculator.calculateCylinderVolume(radius, height);
                        System.out.printf("The volume of the cylinder is: %.2f\n", volume);
                    }
                    case 0 -> {
                        System.out.println("Exiting");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } catch (ValidationException e) {
                System.out.println("Validation error: " + e.getMessage());
            } catch (CalculationException e) {
                System.out.println("Calculation error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}