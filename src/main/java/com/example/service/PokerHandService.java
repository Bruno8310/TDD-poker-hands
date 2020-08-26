package com.example.service;

import com.example.domain.Poker;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHandService {
    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
        }
    };

    public String pokerHand(List<Poker> playerOnePokers, List<Poker> playerTwoPokers) {
        String idListOne = playerOnePokers.stream().map(Poker::getId).max(comparator).get();
        String idListTwo = playerTwoPokers.stream().map(Poker::getId).max(comparator).get();
        return comparator.compare(idListOne, idListTwo) > 0 ? "player1" : "player2";
    }


    public String pokerHandPair(List<Poker> playerOnePokers, List<Poker> playerTwoPokers) {
        Map<String, Long> counterOne = playerOnePokers.stream().map(Poker::getId).collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        Map<String, Long> counterSecond = playerTwoPokers.stream().map(Poker::getId).collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        return counterOne.size()>counterSecond.size()?"player2":"player1";
    }
}
