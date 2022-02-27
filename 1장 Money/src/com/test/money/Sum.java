package com.test.money;

public class Sum implements Expression {
    public final Expression augend;
    public final Expression addend;

    public Sum(final Expression augend, final Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(final Bank bank, final String to) {
        int amount = augend.reduce(bank, to).getAmount() + addend.reduce(bank, to).getAmount();

        return new Money(amount, to);
    }

    @Override
    public Expression plus(final Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(final int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
