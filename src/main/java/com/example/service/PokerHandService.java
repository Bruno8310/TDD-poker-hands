package com.example.service;

import com.example.domain.Poker;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (getPokerMap(playerOnePokers).size() < getPokerMap(playerTwoPokers).size()) {
            return "player1";
        }
        if (getPokerMap(playerOnePokers).size() > getPokerMap(playerTwoPokers).size()) {
            return "player2";
        } else {
            return getMaxPoker(playerOnePokers) > getMaxPoker(playerTwoPokers) ? "player1" : "player2";
        }
    }

    private Integer getMaxPoker(List<Poker> pokers) {
        Integer maxPokerID = pokers.stream().mapToInt(Poker::getId).max().getAsInt();
        return maxPokerID;
    }

    private Map getPokerMap(List<Poker> pokers) {
        Map<Integer, List<Poker>> pokerMap = pokers.stream().collect(Collectors.groupingBy(Poker::getId));
        return pokerMap;
    }
}
