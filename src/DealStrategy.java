import java.util.List;

public interface DealStrategy {
    void deal(Deck deck, List<Player> players);
}
