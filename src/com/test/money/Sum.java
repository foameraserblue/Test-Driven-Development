package com.test.money;

public class Sum implements Expression {
    public final Money augend;
    public final Money addend;

    public Sum(final Money augend, final Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String to) {
        int amount = augend.getAmount() + addend.getAmount();
        return new Money(amount, to);
    }
}
