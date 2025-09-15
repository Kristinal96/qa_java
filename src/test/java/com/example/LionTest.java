package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;

    @BeforeEach
    void setup() throws Exception {
        MockitoAnnotations.openMocks(this);

        // Создаем объект явно, указывая нужные аргументы
        lion = new Lion("Самец", feline);
    }
    @Test
    void testGetKittens() {
        when(feline.getKittens()).thenReturn(2); // Установка ожидания количества котят
        assertEquals(2, lion.getKittens());      // Проверка результата
    }

    @Test
    void testDoesHaveMane() {
        assertTrue(lion.doesHaveMane());  // Проверка наличия гривы
    }

    @Test
    void testGetFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные")); // Подготовка ожидания еды
        assertEquals(List.of("Животные"), lion.getFood());               // Проверка результата
    }
    @Test
    void testCreateMaleLion() throws Exception {
        Feline feline = new Feline();
        Lion maleLion = new Lion("Самец", feline);
        assertTrue(maleLion.doesHaveMane()); // проверяем наличие гривы
    }

    @Test
    void testCreateFemaleLion() throws Exception {
        Feline feline = new Feline();
        Lion femaleLion = new Lion("Самка", feline);
        assertFalse(femaleLion.doesHaveMane()); // проверяем отсутствие гривы
    }

    @Test
    void testCreateLionWithInvalidSex() {
        Feline feline = new Feline();
        Throwable thrown = assertThrows(Exception.class, () -> new Lion("Некорректный пол", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
    }
}