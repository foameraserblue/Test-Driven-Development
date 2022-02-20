package money;

import com.test.money.Bank;
import com.test.money.Expression;
import com.test.money.Money;
import com.test.money.Sum;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);

        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));

    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals((Money.dollar(5))));
        assertFalse(Money.dollar(5).equals((Money.dollar(6))));
        assertTrue(Money.franc(5).equals((Money.franc(5))));

    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);

        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).getCurrency());
        assertEquals("CHF", Money.franc(1).getCurrency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);

        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");


        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;


        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(7), result);

    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");

        assertEquals(Money.dollar(1), result);
    }


}
