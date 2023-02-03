import java.util.Collection;

public final class InterestCalculator {
    public static double calculateSimpleInterest(Card card) {
        return card.getInterest() * card.getBalance();
    }
    public static double calculateSimpleInterest(Wallet wallet) {
        var interest = 0.0;
        for (Card card: wallet.getCards()) {
            interest += calculateSimpleInterest(card);
        }
        return interest;
    }
    public static double calculateSimpleInterest(Collection<Wallet> wallets) {
        var interest = 0.0;
        for (Wallet wallet: wallets) {
            interest += calculateSimpleInterest(wallet);
        }
        return interest;
    }
}
