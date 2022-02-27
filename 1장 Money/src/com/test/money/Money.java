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

    @Override
    public Expression times(final int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Money(final int amount, final String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public Expression plus(final Expression addend) {
        return new Sum(this, addend);
    }

    public Money reduce(final Bank bank, final String to) {
        int rate = bank.rate(currency, to);

        return new Money(amount / rate, to);
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
