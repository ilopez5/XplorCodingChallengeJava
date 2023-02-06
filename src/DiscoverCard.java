public final class DiscoverCard extends Card {
    public DiscoverCard(String number, String cvc, double balance, double interestRate) {
        super(number, cvc, balance, interestRate);
        if (isInvalidCardNumber(number))
            throw new IllegalArgumentException(String.format("Invalid Discover card number '%s'", number));
        if (isInvalidCardCvc(cvc))
            throw new IllegalArgumentException(String.format("Invalid Discover card cvc '%s'", cvc));
    }

    @Override
    public void setCvc(String cvc)
    {
        if (isInvalidCardCvc(cvc))
            throw new IllegalArgumentException(String.format("Invalid Discover card cvc '%s'", cvc));
        super.setCvc(cvc);
    }

    @Override
    public boolean isInvalidCardNumber(String number) {
        if (number == null)
            return true;

        if (!number.startsWith("6011") && !number.startsWith("65"))
            return true;

        var cleaned = number.replace("-", "");
        if (cleaned.length() != 16)
            return true;

        return !cleaned.chars().allMatch(Character::isDigit);
    }

    @Override
    public boolean isInvalidCardCvc(String cvc) {
        if (cvc == null)
            return true;

        if (!cvc.chars().allMatch(Character::isDigit))
            return true;

        return cvc.length() != 3;
    }
}