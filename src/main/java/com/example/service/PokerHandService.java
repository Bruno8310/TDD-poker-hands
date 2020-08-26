package com.example.service;

import com.example.domain.Poker;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHandService {

    public String pokerHand(List<Poker> playerOnePokers, List<Poker> playerTwoPokers) {

        List<String> idListOne = playerOnePokers.stream().map(Poker::getId).collect(Collectors.toList());
        List<Integer> idNewListOne = idListOne.stream().map(Integer::valueOf).collect(Collectors.toList());

        List<String> idListTwo = playerTwoPokers.stream().map(Poker::getId).collect(Collectors.toList());
        List<Integer> idNewListTwo = idListTwo.stream().map(Integer::valueOf).collect(Collectors.toList());

        return Collections.max(idNewListOne) > Collections.max(idNewListTwo) ? "player1" : "player2";
    }
}
