package com.io.Java11.dev.code.Collections.DeckOfCards;

import java.util.*;

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

        learningExerciseOne_CollectionsMethods();
    }

/**
 * Demonstrates various collection manipulation techniques using a deck of cards.
 * <p>
 * This method performs the following operations:
 * - Creates an array of 13 'Ace of Hearts' cards and prints them.
 * - Attempts to fill an empty ArrayList with 'Ace of Hearts' cards, demonstrating that Collections.fill
 *   does not work on empty lists.
 * - Uses Collections.nCopies to create lists of 'Aces of Hearts' and 'Kings of Clubs'.
 * - Adds the contents of a card array to an ArrayList twice and prints the result.
 * - Copies a list of 'Kings of Clubs' into another list and prints it.
 * - Creates an immutable copy of a list and prints it.
 */
    private static void learningExerciseOne_CollectionsMethods() {
        // Create an array of Cards with a length of 13
        Card[] cardArray = new Card[13];

        // Get the 'Ace of Hearts' card using the getFaceCard method
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');

        // Fill the entire cardArray with the 'Ace of Hearts' card
        Arrays.fill(cardArray, aceOfHearts);

        // Print the deck consisting of only 'Aces of Hearts'
        Card.printDeck(Arrays.asList(cardArray), "The Ace of Hearts", 1);

        // Create an ArrayList with an initial capacity of 52
        List<Card> cards = new ArrayList<>(52);

        // Attempt to fill the list with 'Aces of Hearts' - will not work as intended since cards is empty
        Collections.fill(cards, aceOfHearts);

        // Print the cards list to show it's currently empty
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        // Create a list of 13 'Aces of Hearts' using Collections.nCopies
        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);

        // Print the deck of 'Aces of Hearts'
        Card.printDeck(acesOfHearts, "The Aces of Hearts", 1);

        // Get the 'King of Clubs' card
        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');

        // Create a list of 13 'Kings of Clubs'
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);

        // Print the deck of 'Kings of Clubs'
        Card.printDeck(kingsOfClubs, "King of Clubs", 1);

        // Add all elements of cardArray twice to the cards list
        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);

        // Print the updated cards collection with 'Aces of Hearts' added
        Card.printDeck(cards, "Card Collection with Aces added", 2);

        // Copy the kingsOfClubs list into the cards list
        Collections.copy(cards, kingsOfClubs);

        // Print the cards collection showing 'Kings of Clubs' copied
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        // Create a new immutable list copy of kingsOfClubs
        cards = List.copyOf(kingsOfClubs);

        // Print the immutable list copy of 'Kings of Clubs'
        Card.printDeck(cards, "List Copy of Kings", 1);

        // Get the standard deck of cards
        List<Card> deck = Card.getStandardDeck();
        // Print the standard deck
        Card.printDeck(deck);

        // Shuffle the deck of cards
        Collections.shuffle(deck);
        // Print the shuffled deck
        Card.printDeck(deck, "Shuffled Deck", 4);

        // Reverse the deck of cards
        Collections.reverse(deck);
        // Print the reversed deck
        Card.printDeck(deck, "Reversed Deck", 4);

        // Create a comparator to sort cards by rank, then by suit
        Comparator<Card> sortingAlgorithm = Comparator
                .comparing(Card::rank) // Compare by rank first
                .thenComparing(Card::suit); // If ranks are equal, compare by suit

        // Sort the deck of cards using the defined comparator
        Collections.sort(deck, sortingAlgorithm);

        // Print the deck sorted by rank and suit
        Card.printDeck(deck, "Standard Deck sorted by rank suit", 13);

        // Reverse the order of the sorted deck
        Collections.reverse(deck);

        // Print the deck sorted by rank and suit, but in reversed order
        Card.printDeck(deck, "Sorted by rank, suit reversed", 13);

    }
}
