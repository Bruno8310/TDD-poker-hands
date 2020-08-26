package com.example.service;

import com.example.domain.Poker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
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
        List<String> pairListOne = new ArrayList<>();
        List<String> pairListSecond = new ArrayList<>();
        AtomicInteger pairCounterOne = new AtomicInteger();
        AtomicInteger pairCounterSecond = new AtomicInteger();
        counterOne.forEach((k, v) -> {
            if (v > 1) {
                pairListOne.add(k);
                pairCounterOne.getAndIncrement();
            }
        });
        counterSecond.forEach((k, v) -> {
            if (v > 1) {
                pairListSecond.add(k);
                pairCounterSecond.getAndIncrement();
            }
        });
        if (pairListOne.size() == 0 && pairListSecond.size() != 0) {
            return "player2";
        } else if (pairListOne.size() != 0 && pairListSecond.size() == 0) {
            return "player1";
        } else if (pairListOne.size() != 0 && pairListSecond.size() != 0) {
            if (pairCounterOne.get() < pairCounterSecond.get()) {
                return "player2";
            }
            if (comparator.compare(pairListOne.get(0), pairListSecond.get(0)) < 0) {
                return "player2";
            } else {
                return "player1";
            }
        }
        return "";
    }
}
