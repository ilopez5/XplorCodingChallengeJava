public final class VisaCard extends Card {
    public VisaCard(String number, String cvc, double balance, double interestRate) {
        super(number, cvc, balance, interestRate);
        if (validateCardNumber(number))
            throw new IllegalArgumentException(String.format("Invalid Visa card number '%s'", number));
        if (!validateCvc(cvc))
            throw new IllegalArgumentException(String.format("Invalid Visa card cvc '%s'", cvc));
    }

    @Override
    public boolean validateCardNumber(String number) {
        if (number == null)
            return true;

        if (!number.startsWith("4"))
            return true;

        var cleaned = number.replace("-", "");
        if (cleaned.length() != 16)
            return true;

        return !cleaned.chars().allMatch(Character::isDigit);
    }

    @Override
    public boolean validateCvc(String cvc) {
        if (cvc == null)
            return false;
        if (!cvc.chars().allMatch(Character::isDigit))
            return false;
        return cvc.length() == 3;
    }
}