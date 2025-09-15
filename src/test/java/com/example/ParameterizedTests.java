package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTests {

    @ParameterizedTest
    @ValueSource(strings = {"Хищник", "Травоядное"})
    void testGetFood(String animalType) throws Exception {
        Feline feline = new Feline();
        List<String> actualFood = feline.getFood(animalType);
        switch (animalType) {
            case "Хищник":
                assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
                break;
            case "Травоядное":
                assertEquals(List.of("Трава", "Различные растения"), actualFood);
                break;
        }
    }
}
