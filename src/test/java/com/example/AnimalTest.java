package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AnimalTest {

    @Test
    void testGetFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood;
        expectedFood = List.of("Трава", "Различные растения");
        assertEquals(expectedFood, animal.getFood("Травоядное"));
    }
    @Test
    void testGetFoodForCarnivore() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, animal.getFood("Хищник"));
    }
    // Этот тест проверяет правильность выбрасываемого исключения
    @Test
    void testGetFoodWithInvalidArgument() {
        Animal animal = new Animal();
        Throwable thrown = assertThrows(Exception.class, () -> animal.getFood("Некорректный тип"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", thrown.getMessage());
    }
    @Test
    void testGetFoodMoreTypes() throws Exception {
        Animal animal = new Animal();
        Throwable thrown = assertThrows(Exception.class, () -> animal.getFood("Другое животное"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", thrown.getMessage());
    }
    @Test
    void testGetFoodWithValidArguments() throws Exception {
        Animal animal = new Animal();
        List<String> herbivorousFood = animal.getFood("Травоядное");
        List<String> carnivorousFood = animal.getFood("Хищник");
        assertEquals(List.of("Трава", "Различные растения"), herbivorousFood);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), carnivorousFood);
    }
    @Test
    void testGeneralCoverage() throws Exception {
        Animal animal = new Animal();
        String familyDescription = animal.getFamily();
        assertTrue(familyDescription.contains("кошачьи") && familyDescription.contains("псовые"));
    }
    @Test
    void testFamilyStructure() {
        Animal animal = new Animal();
        String familyInfo = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", familyInfo);
    }
    @Test
    void testGetFamily() {
        Animal animal = new Animal();
        String familyInfo = animal.getFamily();
        assertTrue(familyInfo.contains("Существует несколько семейств")); // проверка на частичное совпадение текста
    }
    @Test
    void testGetFoodWithUnknownAnimalType() {
        Animal animal = new Animal();
        Throwable thrown = assertThrows(Exception.class, () -> animal.getFood("Прочие"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", thrown.getMessage());
    }
}