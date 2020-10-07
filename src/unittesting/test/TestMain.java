package unittesting.test;

import unittesting.Main;
import org.junit.*;

/**
 * Простые тесты для методов
 */
public class TestMain {

    @Test
    public void testArrayCutOk1() {
        int[] sourceArray = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] resultArray = Main.arrayCut(sourceArray);

        Assert.assertArrayEquals(new int[]{1, 7}, resultArray);
    }

    @Test
    public void testArrayCutOk2() {
        int[] sourceArray = new int[]{1, 2, 4, 4, 2, 3, 5, 1, 7};
        int[] resultArray = Main.arrayCut(sourceArray);

        Assert.assertArrayEquals(new int[]{2, 3, 5, 1, 7}, resultArray);
    }

    @Test
    public void testArrayCutOk3() {
        int[] sourceArray = new int[]{4, 2, 5, 6, 2, 8, 5, 1, 7};
        int[] resultArray = Main.arrayCut(sourceArray);

        Assert.assertArrayEquals(new int[]{2, 5, 6, 2, 8, 5, 1, 7}, resultArray);
    }

    @Test
    public void testArrayCutEmpty1() {
        int[] sourceArray = new int[]{1, 5, 3, 6, 2, 3, 3, 1, 7};
        int[] resultArray = Main.arrayCut(sourceArray);

        Assert.assertArrayEquals(new int[]{}, resultArray);
    }

    @Test
    public void testArrayCutEmpty2() {
        int[] sourceArray = new int[]{1, 5, 4, 6, 2, 3, 3, 1, 4};
        int[] resultArray = Main.arrayCut(sourceArray);

        Assert.assertArrayEquals(new int[]{}, resultArray);
    }

    @Test
    public void testArrayOnesAndFoursTrue1() {
        int[] sourceArray = new int[]{1, 1, 1, 1, 4, 1, 4, 1};

        boolean result = Main.arrayOnlyOnesAndFours(sourceArray);

        Assert.assertTrue(result);
    }


    @Test
    public void testArrayOnesAndFoursFalse1() {
        int[] sourceArray = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

        boolean result = Main.arrayOnlyOnesAndFours(sourceArray);

        Assert.assertFalse(result);
    }

    @Test
    public void testArrayOnesAndFoursFalse2() {
        int[] sourceArray = new int[]{4, 4, 4, 4};

        boolean result = Main.arrayOnlyOnesAndFours(sourceArray);

        Assert.assertFalse(result);
    }

    @Test
    public void testArrayOnesAndFoursFalse3() {
        int[] sourceArray = new int[]{1, 1, 4, 3};

        boolean result = Main.arrayOnlyOnesAndFours(sourceArray);

        Assert.assertFalse(result);
    }

}
