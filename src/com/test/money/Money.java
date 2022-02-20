package com.test.money;

public class Money {
    protected int amount;
    protected String currency;

    

    public static Money dollar(final int amount) {
        return new Money(amount, "USD");

    }

    public static Money franc(final int amount) {
        return new Money(amount, "CHF");
    }




    public Money times(final int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }




    @Override
    public boolean equals(final Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && currency.equals(money.currency);

    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }


}
