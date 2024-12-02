package com.edu.chmnu.ki_123.c3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeometryExceptionTest {
    private final GeometryCalculator calculator = new GeometryCalculator();

    //Тест перевіряє правильність обчислення об'єму куба для валідного значення сторони
    @Test
    public void testCalculateCubeVolume_ValidInput() throws BaseGeometryException {
        double result = calculator.calculateCubeVolume(3);
        assertEquals(27, result, 1e-6);
    }

    //Тест перевіряє метод ValidationException
    @Test
    public void testCalculateCubeVolume_InvalidInput() {
        assertThrows(ValidationException.class, () -> calculator.calculateCubeVolume(-1));
    }

    //Тест перевіряє правильність обчислення об'єму сфери для валідного радіуса
    @Test
    public void testCalculateSphereVolume_ValidInput() throws BaseGeometryException {
        double result = calculator.calculateSphereVolume(2);
        assertEquals(33.5103, result, 1e-4);
    }

    //Тест перевіряє метод ValidationException
    @Test
    public void testCalculateSphereVolume_InvalidInput() {
        assertThrows(ValidationException.class, () -> calculator.calculateSphereVolume(0));
    }

    //Тест перевіряє правильність обчислення об'єму циліндра для валідних значень радіуса і висоти
    @Test
    public void testCalculateCylinderVolume_ValidInput() throws BaseGeometryException {
        double result = calculator.calculateCylinderVolume(2, 5);
        assertEquals(62.8318, result, 1e-4);
    }

    //Тест перевіряє метод ValidationException
    @Test
    public void testCalculateCylinderVolume_InvalidInput() {
        assertThrows(ValidationException.class, () -> calculator.calculateCylinderVolume(-2, 5));
    }

    //Тест перевіряє метод CalculationException
    @Test
    public void testCalculateCylinderVolume_ExceedsLimit() {
        assertThrows(CalculationException.class, () -> calculator.calculateCylinderVolume(500, 5000));
    }
}