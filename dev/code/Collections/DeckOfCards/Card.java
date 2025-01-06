package com.io.Java11.dev.code.Collections.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {

    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        /**
         * Returns a character representing a playing card suit.
         * @return a character representing a playing card suit
         */
        public char getImage() {
            // The characters returned are:
            // 9827 - black club
            // 9830 - black diamond
            // 9829 - black heart
            // 9824 - black spade
            return (new char[] {9827, 9830, 9829, 9824})[this.ordinal()];
        }
        }

    /**
     * Converts the card details to a string representation.
     * The format is '[face][suit image]([rank])'.
     *
     * @return a string representation of the card
     */
    @Override
    public String toString() {
        // Determine the substring length for faceString based on whether the face is "10"
        int index = face.equals("10") ? 2 : 1;

        // Get the face string to be displayed
        String faceString = face.substring(0, index);

        // Format and return the card details as a string
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }

    /**
     * Creates a Card object based on the given suit and card number.
     * The card number can be between 1 and 10. The face of the card
     * is the card number converted to a string, and the rank is the
     * card number reduced by 2.
     *
     * @param suit The suit of the card to be created
     * @param cardNumber The number of the card to be created
     * @return A Card object with the given suit and card number
     */
    public static Card getNumericCard(Suit suit, int cardNumber) {
        // Check if the card number is between 1 and 10 inclusive
        // If it is then create a Card object with the given suit and card number
        // The face of the card is the card number converted to a string
        // The rank of the card is the card number reduced by 2
        if (cardNumber > 1 && cardNumber < 11) {
            return new Card(suit, String.valueOf(cardNumber), cardNumber - 2); // we want the rank of the lowest card to be zero. so we reduce by 2
        }
        System.out.println("Invalid numeric card selected: " + cardNumber);
        return null;
    }

    /**
     * Creates a face card (Jack, Queen, King, Ace) based on the given suit and abbreviation.
     *
     * @param suit The suit of the card to be created
     * @param abbrev The character abbreviation representing the face card ('J', 'Q', 'K', 'A')
     * @return A Card object representing the face card, or null if the abbreviation is invalid
     */
    public static Card getFaceCard(Suit suit, char abbrev) {
        // Determine the index of the abbreviation in the string "JQKA"
        int charIndex = "JQKA".indexOf(abbrev);

        // If the abbreviation is found, create and return a Card object
        if(charIndex > -1) {
            return new Card(suit, "" + abbrev, charIndex + 9);
        }

        // Print a message if the abbreviation is invalid
        System.out.println("Invalid face card selected: " + abbrev);
        return null;
    }

    /**
     * Creates a standard deck of 52 cards.
     * The deck includes 4 suits (Clubs, Diamonds, Hearts, Spades) and 13 cards for each suit.
     * The cards are created in the following order:
     * 2-10, Jack, Queen, King, Ace for each suit.
     * @return A list of 52 Card objects representing the standard deck
     */
    public static List<Card> getStandardDeck() {
        List<Card> deck = new ArrayList<>(52);
        // Iterate over all the suits
        for (Suit suit : Suit.values()) {
            // Create cards for the numbers 2-10
            for (int i = 2; i <= 10; i++) {
                deck.add(getNumericCard(suit, i));
            }
            // Create face cards (Jack, Queen, King, Ace)
            for (char c : new char[]{'J', 'Q', 'K', 'A'}) {
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }


    /**
     * Prints the given deck of cards to the console.
     * The deck is displayed in multiple rows.
     * The description parameter is used to add a description above the deck to help identify it.
     * @param deck The deck of cards to be printed
     */
    public static void printDeck(List<Card> deck) {
        printDeck(deck, "Current Deck", 4);

    }

    /**
     * Prints the given deck of cards to the console.
     * The deck is displayed in multiple rows, with the number of rows specified by the rows parameter.
     * The description parameter is used to add a description above the deck to help identify it.
     * @param deck The deck of cards to be printed
     * @param description A string to be printed above the deck
     * @param rows The number of rows to divide the deck into
     */
    public static void printDeck(List<Card> deck, String description, int rows) {
        // Print a separator line
        System.out.println("----------------------------");
        // Print the description if it is not null
        if(description != null) {
            System.out.println(description);
        }
        // Calculate the number of cards in each row
        int cardsInRow = deck.size() / rows;
        // Iterate over the rows
        for (int i = 0; i < rows; i++) {
            // Calculate the start and end index for the current row
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            // Print the cards in the current row
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            // Move to the next line
            System.out.println();
        }
    }
}








