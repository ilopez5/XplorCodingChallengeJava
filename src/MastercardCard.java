public final class MastercardCard extends Card {
    public MastercardCard(String number, String cvc, double balance, double interestRate) {
        super(number, cvc, balance, interestRate);
        if (validateCardNumber(number))
            throw new IllegalArgumentException(String.format("Invalid MasterCard card number '%s'", number));
    }

    @Override
    public boolean validateCardNumber(String number) {
        if (number == null)
            return true;

        if (!number.startsWith("5"))
            return true;

        var cleaned = number.replace("-", "");
        if (cleaned.length() != 16)
            return true;

        return !cleaned.chars().allMatch(Character::isDigit);
    }
}