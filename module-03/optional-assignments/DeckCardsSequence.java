public class DeckCardsSequence {
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);

        String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        String[] suits = { "\u2660", "\u2663", "\u2666", "\u2665" };
        String[] deck = new String[52];

        for (int i = 0; i < cards.length; i++) {
            for (int j = 0, deckStartPos = 0; j < suits.length; j++) {
                deckStartPos = j * cards.length;
                deck[deckStartPos + i] = cards[i] + suits[j];
                // System.out.print(deck[deckStartPos + j] + " ");
                // System.out.print(j + " ");
            }

            // System.out.println();
        }

        int r;
        for (int i = 0; i < iN; i++) {
            r = (int) (Math.random() * 52);
            System.out.print(deck[r] + " ");
        }
        
        System.out.println();
    }    
}
