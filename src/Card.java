public abstract class Card extends Throwable {
    private final String number; //does not change.
    private String cvc; //changes upon expiration.
    private double balance; //expected to change frequently.
    private double interestRate;

    public Card(String number, String cvc, double balance, double interestRate) {
        this.number = number;
        this.cvc = cvc;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public String getNumber() {
        return this.number;
    }
    public String getCvc() {
        return this.cvc;
    }
    public double getBalance() {
        return this.balance;
    }
    public double getInterest() {
        return this.interestRate;
    }
    public void setCvc(String newCvc) {
        this.cvc = newCvc;
    }
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
    public void setInterest(float newRate) {
        this.interestRate = newRate;
    }
    public void modifyBalance(float amount) {
        this.balance += amount;
    }

    //See https://en.wikipedia.org/wiki/Payment_card_number for actual rules.
    //I kept the validations a bit naive as I think total coverage was not
    //the focus here.
    public abstract boolean isInvalidCardNumber(String number);

    //See https://www.legalstudies.com/faq/cvv-cvc-cid-credit-card-security-code-located-credit-card/
    //for actual rules (mainly on number of digits).
    public abstract boolean isInvalidCardCvc(String cvc);
}