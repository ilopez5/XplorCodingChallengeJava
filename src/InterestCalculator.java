import java.util.Collection;

public interface InterestCalculator {
    public double calculateInterest(Card card);
    public double calculateInterest(Wallet card);
    public double calculateInterest(Collection<Wallet> wallets);
}
