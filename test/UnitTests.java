import org.junit.Assert;
import org.junit.Test;

public final class UnitTests {
    private final double visaInterest = 0.10;
    private final double mcInterest = 0.05;
    private final double discoverInterest = 0.01;

    @Test
    public void testCaseOne() {
        //Any `var` supporters here? brought to you by the C#/JavaScript gang
        var interestCalculator = new SimpleInterestCalculator();
        var person = new Person();
        var wallet = new Wallet();
        var visa = new VisaCard("4123-1234-1234-1234", "121", 100, visaInterest);
        Assert.assertTrue(interestCalculator.calculateInterest(visa) == 10); //interest per card

        var mc = new MastercardCard("5123-1234-1234-1234", "212", 100, mcInterest);
        Assert.assertTrue(interestCalculator.calculateInterest(mc) == 5); //interest per card

        var discover = new DiscoverCard("6011-1234-1234-1234", "313", 100, discoverInterest);
        Assert.assertTrue(interestCalculator.calculateInterest(discover) == 1); //interest per card

        wallet.addCard(visa);
        wallet.addCard(mc);
        wallet.addCard(discover);
        person.addWallet(wallet);

        Assert.assertTrue(interestCalculator.calculateInterest(person.getWallets()) == 16); //interest per person
    }

    @Test
    public void testCaseTwo() {
        var interestCalculator = new SimpleInterestCalculator();
        var person = new Person();
        var walletOne = new Wallet();
        walletOne.addCard(new VisaCard("4123-2345-2345-2345", "212", 100, visaInterest));
        walletOne.addCard(new DiscoverCard("6011-2345-2345-2345", "312", 100, discoverInterest));
        Assert.assertTrue(interestCalculator.calculateInterest(walletOne) == 11); //interest per wallet

        var walletTwo = new Wallet();
        walletTwo.addCard(new MastercardCard("5234-2345-2345-2345", "313", 100, mcInterest));
        Assert.assertTrue(interestCalculator.calculateInterest(walletTwo) == 5); //interest per wallet

        person.addWallet(walletOne);
        person.addWallet(walletTwo);

        Assert.assertTrue(interestCalculator.calculateInterest(person.getWallets()) == 16); //interest per person
    }

    @Test
    public void testCaseThree() {
        var interestCalculator = new SimpleInterestCalculator();
        var personOne = new Person();
        var walletOne = new Wallet();
        walletOne.addCard(new VisaCard("4345-3456-3456-3456", "314", 100, visaInterest));
        walletOne.addCard(new MastercardCard("5345-3456-3456-3456", "314", 100, mcInterest));
        personOne.addWallet(walletOne);
        Assert.assertTrue(interestCalculator.calculateInterest(walletOne) == 15); //interest per wallet
        Assert.assertTrue(interestCalculator.calculateInterest(personOne.getWallets()) == 15); //interest per person

        var personTwo = new Person();
        var walletTwo = new Wallet();
        walletTwo.addCard(new VisaCard("4456-4567-4567-4567", "315", 100, visaInterest));
        walletTwo.addCard(new MastercardCard("5456-4567-4567-4567", "316", 100, mcInterest));
        personTwo.addWallet(walletTwo);
        Assert.assertTrue(interestCalculator.calculateInterest(walletTwo) == 15); //interest per wallet
        Assert.assertTrue(interestCalculator.calculateInterest(personTwo.getWallets()) == 15); //interest per person
    }

    @Test
    public void testInvalidCardNumbers() {
        //null card number
        Assert.assertThrows(IllegalArgumentException.class, () -> new VisaCard(null, "123", 100, visaInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new MastercardCard(null, "123", 100, mcInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new DiscoverCard(null, "123", 100, discoverInterest));

        //wrong starting digits
        Assert.assertThrows(IllegalArgumentException.class, () -> new VisaCard("0000-0000-0000-0000", "123", 100, visaInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new MastercardCard("0000-0000-0000-0000", "123", 100, mcInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new DiscoverCard("0000-0000-0000-0000", "123", 100, discoverInterest));

        //wrong number of digits
        Assert.assertThrows(IllegalArgumentException.class, () -> new VisaCard("4123-1234-1234", "123", 100, visaInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new MastercardCard("5123-1234-1234", "123", 100, mcInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new DiscoverCard("6011-1234-1234", "123", 100, discoverInterest));


    }

    @Test
    public void testInvalidCvcNumbers() {
        //null cvc
        Assert.assertThrows(IllegalArgumentException.class, () -> new VisaCard("4123-1234-1234-1234", null, 100, visaInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new MastercardCard("5123-1234-1234-1234", null, 100, mcInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new DiscoverCard("6011-1234-1234-1234", null, 100, discoverInterest));

        //non-digit cvc
        Assert.assertThrows(IllegalArgumentException.class, () -> new VisaCard("4123-1234-1234-1234", "123F", 100, visaInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new MastercardCard("5123-1234-1234-1234", "L234", 100, mcInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new DiscoverCard("6011-1234-1234-1234", "O123", 100, discoverInterest));

        //wrong number digits in cvc
        Assert.assertThrows(IllegalArgumentException.class, () -> new VisaCard("4123-1234-1234-1234", "1234", 100, visaInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new MastercardCard("5123-1234-1234-1234", "1234", 100, mcInterest));
        Assert.assertThrows(IllegalArgumentException.class, () -> new DiscoverCard("6011-1234-1234-1234", "1234", 100, discoverInterest));
    }
}
