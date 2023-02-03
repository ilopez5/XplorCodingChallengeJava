public final class JcbCard extends Card {
    public JcbCard(String number, String cvc, double balance, double interestRate) {
        super(number, cvc, balance, interestRate);
        if (validateCardNumber(number))
            throw new IllegalArgumentException(String.format("Invalid JCB card number '%s'", number));
    }

    @Override
    public boolean validateCardNumber(String number) {
        if (number == null)
            return true;

        if (!number.startsWith("35")) //naive validation to prove the point.
            return true;

        var cleaned = number.replace("-", "");
        if (cleaned.length() != 16)
            return true;

        return !cleaned.chars().allMatch(Character::isDigit);
    }
}
