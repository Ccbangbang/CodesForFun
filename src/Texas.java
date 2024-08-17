import java.util.List;

public class Texas implements DealStrategy{

    @Override
    public void deal(Deck deck, List<Player> players) {
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {  // 示例：每个玩家发5张牌
                player.receiveCard(deck.dealCard());
            }
        }
    }
}
