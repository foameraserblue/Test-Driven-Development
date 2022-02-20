package com.test.money;


public class Money implements Expression {
    private final int amount;
    private final String currency;


    public static Money dollar(final int amount) {
        return new Money(amount, "USD");

    }

    public static Money franc(final int amount) {
        return new Money(amount, "CHF");
    }


    public Money times(final int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Money(final int amount, final String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    public Expression plus(final Money added) {
        return new Sum(this, added);
    }

    public Money reduce(String to) {
        return this;
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


    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

}
