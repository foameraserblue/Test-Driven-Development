package com.test.money;

import java.util.Hashtable;

public class Bank {

    private Hashtable rates = new Hashtable();

    public Money reduce(final Expression source, final String to) {
        return source.reduce(this, to);
    }

    public int rate(final String from, final String to) {
        if (from.equals(to)) return 1;

        Integer rate = (Integer) rates.get(new Pair(from, to));

        return rate;
    }

    public void addRate(final String from, final String to, final int rate) {
        rates.put(new Pair(from, to), new Integer(rate));
    }

}
