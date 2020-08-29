package com.example.service;

import com.example.domain.Poker;

import java.util.Iterator;
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
        Map<Integer, List<Poker>> pokerMapOne = getPokerMap(playerOnePokers);
        Map<Integer, List<Poker>> pokerMapSecond = getPokerMap(playerTwoPokers);
        if (isFlush(playerOnePokers)) {
            return "player1";
        }
        if (isFlush(playerTwoPokers)) {
            return "player2";
        }
        if (isStraight(pokerMapOne)) {
            return "player1";
        }
        if (isStraight(pokerMapSecond)) {
            return "player2";
        }
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

    private Boolean isStraight(Map<Integer, List<Poker>> pokerMap) {
        Boolean result = true;
        Iterator<Integer> iterator = pokerMap.keySet().iterator();
        int num = iterator.next();
        while (iterator.hasNext()) {
            int nextNum = iterator.next();
            if (nextNum != num + 1) {
                result = false;
                break;
            }
            num = nextNum;
        }
        return result;
    }

    private Boolean isFlush(List<Poker> pokers) {
        Map<Character, List<Poker>> pokerMap = pokers.stream().collect(Collectors.groupingBy(Poker::getColor));
        return pokerMap.size() == 1;
    }
}
