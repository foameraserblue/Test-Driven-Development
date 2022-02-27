package com.test.money;

public interface Expression {
    Money reduce(final Bank bank, final String to);

    Expression plus(final Expression addend);
}
