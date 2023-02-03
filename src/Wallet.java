import java.util.ArrayList;
import java.util.Collection;

public final class Wallet {
    private final Collection<Card> cards;

    public Wallet() {
        this.cards = new ArrayList<>();
    }
    public Wallet(Collection<Card> cards) {
        this.cards = cards;
    }

    public Collection<Card> getCards() {
        return cards;
    }
    public void addCard(Card card) {
        this.cards.add(card);
    }
    public void removeCard(Card card) {
        this.cards.remove(card);
    }
}
