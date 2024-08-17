import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Deck deck;
    private final List<Player> players;
    private DealStrategy dealStrategy;  // 策略模式

    public List<Player> getPlayers() {
        return players;
    }

    public Game( ) {
        this.deck = Deck.getInstance();
        this.deck.initDeck();
        this.players = new ArrayList<>();
    }

    public void setDealStrategy(DealStrategy dealStrategy) {
        this.dealStrategy = dealStrategy;  // 设置发牌策略
    }
    public void addPlayer(Player player) {
        players.add(player);
    }

    public void start() {
        deck.shuffle();
        dealCards();
    }

    private void dealCards() {
        if (dealStrategy != null) {
            dealStrategy.deal(deck, players);  // 根据策略发牌
        } else {
            System.out.println("No deal strategy selected!");
        }
    }

    public void showHands() {
        for (Player player : players) {
            System.out.println(player + "'s hand: " + player.showHand());
        }
    }

    public void resetGame() {
        deck.getCards().clear();
        this.deck.initDeck();
        this.players.clear();
    }
}