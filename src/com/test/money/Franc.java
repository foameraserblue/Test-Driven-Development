package com.test.money;

public class Franc {
    private final int amount;

    public Franc(final int amount) {
        this.amount = amount;
    }

    public Franc times(final int multiplier) {
        return new Franc(amount * multiplier);
    }

    public boolean equals(final Object object) {
        Franc dollar = (Franc) object;
        return this.amount == dollar.amount;

    }

}
