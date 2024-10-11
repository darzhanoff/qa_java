package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.hamcrest.MatcherAssert;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Mock
    Feline feline;

    @Test
    public void ShouldReturnCorrectKittensCount() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedCount = 1;
        Mockito.when(feline.getKittens()).thenReturn(expectedCount);

        MatcherAssert.assertThat("Некорректное количество котят",
                lion.getKittens(),
                equalTo(expectedCount)
        );
        verify(feline, times(1)).getKittens();
    }

    @Test
    public void ShouldReturnCorrectFoodForPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedListOfFood = List.of("Баранина");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat("Некорректный список еды",
                lion.getFood(),
                equalTo(expectedListOfFood)
        );
        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    public void ShouldThrowExceptionForInvalidSex() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Используйте допустимые значения пола животного - самец или самка");

        new Lion("Не определено", feline);
    }
}
