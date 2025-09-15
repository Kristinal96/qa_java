package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {

    @InjectMocks
    private Cat cat;

    @Mock
    private Feline feline;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this); // инициализация моков
    }

    @Test
    void testGetSound() {
        assertEquals("Мяу", cat.getSound()); // простая проверка звука кошки
    }

    @Test
    void testGetFood() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Животные")); // задаём ожидания на mock-методе
        assertEquals(List.of("Животные"), cat.getFood()); // проверяем результат
    }
    @Test
    void testGetFoodWithNoMock() throws Exception {
        Cat cat = new Cat(new Feline());
        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}