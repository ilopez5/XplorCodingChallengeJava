import java.util.ArrayList;
import java.util.Collection;

public final class Person {
    private final Collection<Wallet> wallets;

    public Person() {
        this.wallets = new ArrayList<>();
    }
    public Person(Collection<Wallet> wallets) {
        this.wallets = wallets;
    }

    public Collection<Wallet> getWallets() {
        return this.wallets;
    }
    public void addWallet(Wallet wallet) {
        wallets.add(wallet);
    }
    public void removeWallet(Wallet wallet) {
        wallets.remove(wallet);
    }
}