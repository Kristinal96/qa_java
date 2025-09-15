package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class FelineTest {

    @Test
    void testGetFamily() {
        Feline feline = new Feline(); // создаём экземпляр Feline
        assertEquals("Кошачьи", feline.getFamily()); // проверяем семейство
    }
    @Test
    void testGetKittensWithCustomCount() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }
    @Test
    void testGetKittensWithZeroAndNegativeCounts() {
        Feline feline = new Feline();
        assertEquals(0, feline.getKittens(0)); // проверка нуля
        assertEquals(-1, feline.getKittens(-1)); // проверка отрицательного значения
    }
    @Test
    void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens()); // проверяем количество котят по умолчанию
    }

    @Test
    void testGetFood() throws Exception { // Проверка питания хищника
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.getFood("Хищник"));
    }
    @Test
    void testGetKittensEdgeCases() {
        Feline feline = new Feline();
        assertEquals(Integer.MAX_VALUE, feline.getKittens(Integer.MAX_VALUE)); // максимальный размер
        assertEquals(Integer.MIN_VALUE, feline.getKittens(Integer.MIN_VALUE)); // минимальное отрицательное значение
    }
    @Test
    void testGetKittensEdgeValues() {
        Feline feline = new Feline();
        assertEquals(0, feline.getKittens(0)); // проверка минимального значения
        assertEquals(Integer.MAX_VALUE, feline.getKittens(Integer.MAX_VALUE)); // проверка максимальных значений
    }
    @Test
    void testEatMeatImplementation() throws Exception {
        Feline feline = new Feline();
        List<String> meatList = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), meatList);
    }
    @Test
    void testGetFoodWithInvalidArgument() {
        Feline feline = new Feline();
        try {
            feline.getFood("Некорректный аргумент"); // пробуем передать неверный аргумент
        } catch (Exception ex) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", ex.getMessage());
        }
    }
}