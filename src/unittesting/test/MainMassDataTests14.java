package unittesting.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import unittesting.Main;

import java.util.Arrays;
import java.util.Collection;

/**
 * Параметризованные тесты для метода arrayOnlyOnesAndFours
 */
@RunWith(Parameterized.class)
public class MainMassDataTests14 {

    private final int[] a;
    private final boolean b;

    public MainMassDataTests14(int[] a, boolean b) {
        this.a = a;
        this.b = b;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 1}, false},
                {new int[]{1, 4, 4, 2}, false},
                {new int[]{1, 1, 4, 1, 1, 4, 1}, true},
                {new int[]{4, 4, 4}, false},
                {new int[]{1, 4, 4, 1}, true},
                {new int[]{1, 1, 1, 1, 4, 4, 3}, false}
        });
    }

    @Test
    public void testOnesAndFours() {
        Assert.assertEquals(this.b, Main.arrayOnlyOnesAndFours(this.a));
    }
}
