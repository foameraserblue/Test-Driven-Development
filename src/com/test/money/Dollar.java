package com.test.money;

public class Dollar {
    private final int amount;

    public Dollar(final int amount) {
        this.amount = amount;
    }

    public Dollar times(final int multiplier) {
        return new Dollar(amount * multiplier);
    }

    public boolean equals(final Object object) {
        Dollar dollar = (Dollar) object;
        return this.amount == dollar.amount;

    }

}
