public final class AmericanExpressCard extends Card {
    public AmericanExpressCard(String number, String cvc, double balance, double interestRate) {
        super(number, cvc, balance, interestRate);
        if (isInvalidCardNumber(number))
            throw new IllegalArgumentException(String.format("Invalid AmericanExpress card number '%s'", number));
        if (isInvalidCardCvc(cvc))
            throw new IllegalArgumentException(String.format("Invalid AmericanExpress card cvc '%s'", cvc));
    }

    @Override
    public void setCvc(String cvc)
    {
        if (isInvalidCardCvc(cvc))
            throw new IllegalArgumentException(String.format("Invalid AmericanExpress card cvc '%s'", cvc));
        super.setCvc(cvc);
    }

    @Override
    public boolean isInvalidCardNumber(String number) {
        if (number == null)
            return true;

        if (!number.startsWith("34") && !number.startsWith("37"))
            return true;

        var cleaned = number.replace("-", "");
        if (cleaned.length() != 15)
            return true;

        return !cleaned.chars().allMatch(Character::isDigit);
    }

    @Override
    public boolean isInvalidCardCvc(String cvc) {
        if (cvc == null)
            return true;

        if (cvc.length() != 4)
            return true;

        return !cvc.chars().allMatch(Character::isDigit);
    }
}