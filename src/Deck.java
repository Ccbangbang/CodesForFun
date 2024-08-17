import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private static Deck instance;
    private final List<Card> cards;
    private static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private Deck() {
        this.cards = new ArrayList<>();
    }
    public void initDeck() {

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    //Singleton design pattern
    public static Deck getInstance() {
        if (instance == null) {
            instance = new Deck();
        }
        return instance;
    }

    public List<Card> getCards() {
        return cards;
    }

    //shuffle deck
    public void shuffle() {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(cards, i, j);
        }
    }

    private void swap(List<Card> cards, int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    //deal card to player
    public Card dealCard(){

        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
}
