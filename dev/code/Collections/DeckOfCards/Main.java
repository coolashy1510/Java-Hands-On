package com.io.Java11.dev.code.Collections.DeckOfCards;

import java.util.List;

public class Main {
    /**
     * This class contains a main method that creates a standard deck of cards
     * and prints it out.
     */
    public static void main(String[] args) {
        // Create a standard deck of cards
        List<Card> deck = Card.getStandardDeck();
        // Print the deck
        Card.printDeck(deck);
    }
}
