public class DeckCards {
    public static void main(String[] args) {
        String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        String[] suits = { "\u2660", "\u2663", "\u2666", "\u2665" };
        String[] deck = new String[52];

        for (int i = 0; i < suits.length; i++) {
            int deckStartPos = i * cards.length;
            
            for (int j = 0; j < cards.length; j++) {
                deck[deckStartPos + j] = cards[j] + suits[i];
                // System.out.print(deck[deckStartPos + j] + " ");
                // System.out.print(j + " ");
            }

            // System.out.println();
        }

        for (int i = 0; i < deck.length; i++) {
            System.out.print(deck[i] + " ");
        }

        System.out.println();
    }    
}
