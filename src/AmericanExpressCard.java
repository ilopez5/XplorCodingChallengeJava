public final class AmericanExpressCard extends Card {
    public AmericanExpressCard(String number, String cvc, double balance, double interestRate) {
        super(number, cvc, balance, interestRate);
        if (validateCardNumber(number))
            throw new IllegalArgumentException(String.format("Invalid AmericanExpress card number '%s'", number));
    }

    @Override
    public boolean validateCardNumber(String number) {
        if (number == null)
            return true;

        if (!number.startsWith("34") && !number.startsWith("37"))
            return true;

        var cleaned = number.replace("-", "");
        if (cleaned.length() != 15)
            return true;

        return !cleaned.chars().allMatch(Character::isDigit);
    }
}