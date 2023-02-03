import java.util.Collection;

public final class SimpleInterestCalculator implements InterestCalculator {
    public double calculateInterest(Card card) {
        return card.getInterest() * card.getBalance();
    }

    public double calculateInterest(Wallet wallet) {
        var interest = 0.0;
        for (Card card : wallet.getCards()) {
            interest += this.calculateInterest(card);
        }
        return interest;
    }

    public double calculateInterest(Collection<Wallet> wallets) {
        var interest = 0.0;
        for (Wallet wallet : wallets) {
            interest += this.calculateInterest(wallet);
        }
        return interest;
    }
}
