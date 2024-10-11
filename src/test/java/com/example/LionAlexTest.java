package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    Feline mockFeline;

    private LionAlex lionAlex;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        lionAlex = new LionAlex(mockFeline);
    }

    @Test
    public void shouldReturnCorrectFriendsList() {
        List<String> expectedFriends = List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман");

        assertEquals("Список друзей Алекса неверен", expectedFriends, lionAlex.getFriends());
    }

    @Test
    public void shouldReturnCorrectPlaceOfLiving() {
        assertEquals("Алекс живет не в Нью-Йоркском зоопарке", "Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }

    @Test
    public void shouldReturnZeroKittens() {
        assertEquals("У льва Алекса не должно быть котят", 0, lionAlex.getKittens());
    }
}