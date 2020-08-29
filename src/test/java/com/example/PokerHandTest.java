package com.example;

import com.example.domain.Poker;
import com.example.service.PokerHandService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandTest {
    PokerHandService pokerHandService = new PokerHandService();

    @Test
    void should_return_winner_is_player2_when_compare_high_card_given_player1_2H3D5S9CKD_and_player2_2C3H4S8CAH() {
        // given
        List<Poker> playerOnePokers = Arrays.asList(
                new Poker(2, 'H'),
                new Poker(3, 'D'),
                new Poker(5, 'S'),
                new Poker(9, 'C'),
                new Poker(pokerHandService.convertToNumber("K"), 'D'));

        List<Poker> playerTwoPokers = Arrays.asList(
                new Poker(2, 'C'),
                new Poker(3, 'H'),
                new Poker(4, 'S'),
                new Poker(8, 'C'),
                new Poker(pokerHandService.convertToNumber("A"), 'H'));
        // when
        String result = pokerHandService.compare(playerOnePokers, playerTwoPokers);

        // then
        assertEquals("player2", result);
    }


    @Test
    void should_return_winner_is_player2_when_compare_pair_card_given_player1_2H3D5S9CKD_and_player2_3H3D5S9CKD() {
        // given
        List<Poker> playerOnePokers = Arrays.asList(
                new Poker(2, 'H'),
                new Poker(3, 'D'),
                new Poker(5, 'S'),
                new Poker(9, 'C'),
                new Poker(pokerHandService.convertToNumber("K"), 'D'));

        List<Poker> playerTwoPokers = Arrays.asList(
                new Poker(3, 'H'),
                new Poker(3, 'D'),
                new Poker(5, 'S'),
                new Poker(9, 'C'),
                new Poker(pokerHandService.convertToNumber("K"), 'D'));
        // when
        PokerHandService pokerHandService = new PokerHandService();
        String result = pokerHandService.compare(playerOnePokers, playerTwoPokers);

        // then
        assertEquals("player2", result);
    }

    @Test
    void should_return_winner_is_player2_when_compare_pair_card_given_player1_2H2D5S9CKD_and_player2_3H3D5S9CKD() {
        // given
        List<Poker> playerOnePokers = Arrays.asList(
                new Poker(2, 'H'),
                new Poker(2, 'D'),
                new Poker(5, 'S'),
                new Poker(9, 'C'),
                new Poker(pokerHandService.convertToNumber("K"), 'D'));

        List<Poker> playerTwoPokers = Arrays.asList(
                new Poker(3, 'H'),
                new Poker(3, 'D'),
                new Poker(5, 'S'),
                new Poker(9, 'C'),
                new Poker(pokerHandService.convertToNumber("K"), 'D'));
        // when
        PokerHandService pokerHandService = new PokerHandService();
        String result = pokerHandService.compare(playerOnePokers, playerTwoPokers);

        // then
        assertEquals("player2", result);
    }
}
