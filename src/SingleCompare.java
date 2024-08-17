import java.util.List;

public class SingleCompare implements DealStrategy{

    @Override
    public void deal(Deck deck, List<Player> players) {
        for (Player player : players) {
            player.receiveCard(deck.dealCard());
        }
    }
}
