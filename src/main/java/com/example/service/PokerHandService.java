package com.example.service;

import com.example.domain.Poker;

import java.util.List;

public class PokerHandService {
    public static final Integer HIGH_CARD = 1;

    public Integer convertToNumber(String input) {
        switch (input) {
            case "T":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(input);
        }
    }

    public String compare(List<Poker> playerOnePokers, List<Poker> playerTwoPokers) {
        return getMaxPoker(playerOnePokers) > getMaxPoker(playerTwoPokers) ? "player1" : "player2";
    }

    private Integer getMaxPoker(List<Poker> pokers) {
        Integer maxPokerID = pokers.stream().mapToInt(Poker::getId).max().getAsInt();
        return maxPokerID;
    }
}
