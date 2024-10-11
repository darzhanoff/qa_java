package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.hamcrest.MatcherAssert;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void shouldReturnMeowSound() {
        String expectedSound = "Мяу";
        Cat cat = new Cat(feline);

        MatcherAssert.assertThat("Ожидается звук 'Мяу' от кошки",
                cat.getSound(),
                equalTo(expectedSound)
        );
    }

    @Test
    public void shouldCallEatMeatMethodFromPredator() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();

        verify(feline, times(1)).eatMeat();
    }

    @Test
    public void shouldReturnCorrectFoodList() throws Exception {
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFoodList);

        Cat cat = new Cat(feline);

        MatcherAssert.assertThat("Некорректный список еды для кошки",
                cat.getFood(),
                equalTo(expectedFoodList)
        );
    }
}
