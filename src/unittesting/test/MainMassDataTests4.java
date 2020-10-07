package unittesting.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import unittesting.Main;

import java.util.Arrays;
import java.util.Collection;

/**
 * Параметризованные тесты для метода arrayCut
 */
@RunWith(Parameterized.class)
public class MainMassDataTests4 {

    private final int[] a;
    private final int[] b;

    public MainMassDataTests4(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                {new int[]{1, 2, 9, 8, 2}, new int[]{}},
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 4}, new int[]{}},
                {new int[]{4, 2, 7, 6, 2, 3, 1}, new int[]{2, 7, 6, 2, 3, 1}},
                {new int[]{4, 4, 4, 4, 4}, new int[]{}},
                {new int[]{1, 2, 4, 4, 2, 3, 5, 1, 7}, new int[]{2, 3, 5, 1, 7}}
        });
    }

    @Test
    public void testOnesAndFours() {
        Assert.assertArrayEquals(Main.arrayCut(this.a), this.b);
    }
}
