package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.hamcrest.MatcherAssert;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline spyFeline;

    @Mock
    Feline mockFeline;

    @Test
    public void shouldCallGetFoodWithPredatorType() throws Exception {
        spyFeline.eatMeat();
        verify(spyFeline, times(1)).getFood("Хищник");
    }

    @Test
    public void shouldReturnCorrectFamily() {
        String expectedFamily = "Кошачьи";
        MatcherAssert.assertThat("Неверное название семейства",
                new Feline().getFamily(),
                equalTo(expectedFamily)
        );
    }

    @Test
    public void shouldReturnDefaultKittensCount() {
        int expectedCount = 1;
        MatcherAssert.assertThat("Неверное количество котят по умолчанию",
                new Feline().getKittens(),
                equalTo(expectedCount)
        );
    }

    @Test
    public void shouldReturnCorrectKittensCountWhenProvided() {
        int expectedCount = 5;
        MatcherAssert.assertThat("Неверное количество котят при передаче значения",
                new Feline().getKittens(expectedCount),
                equalTo(expectedCount)
        );
    }

    @Test
    public void shouldReturnCorrectFoodListForPredator() throws Exception {
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(expectedFoodList);

        MatcherAssert.assertThat("Неверный список еды для хищника",
                mockFeline.getFood("Хищник"),
                equalTo(expectedFoodList)
        );
    }
}