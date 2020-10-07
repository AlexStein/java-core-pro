package unittesting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    /**
     * Метод возвраащет новый массив, который получен путем
     * вытаскивания из исходного массива элементов, идущих
     * после последней четверки.
     *
     * @param sourceArray Исходный непустой одномерный целочисленный массив
     * @return Новый массив
     */
    public static int[] arrayCut(int[] sourceArray) {

        Integer[] objArray = new Integer[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++) {
            objArray[i] = sourceArray[i];
        }
        int i = Arrays.asList(objArray).lastIndexOf(4);

        if (i == -1 || i == sourceArray.length - 1) {
            return new int[]{};
        }

        int[] resultArray = new int[sourceArray.length - 1 - i];
        for (int j =0; j < resultArray.length; j++) {
            resultArray[j] = sourceArray[j + i + 1];
        }

        return resultArray;
    }

    /**
     * Метод проверяет состав массива из чисел 1 и 4.
     *
     * @param sourceArray Исходный массив
     * @return Если в массиве нет хоть одной четверки или единицы, то вернет false;
     */
    public static boolean arrayOnlyOnesAndFours(int[] sourceArray) {

        Integer[] objArray = new Integer[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++) {
            objArray[i] = sourceArray[i];
        }

        HashSet<Integer> set = new HashSet<>(Arrays.asList(objArray));

        return (set.size() == 2 && set.contains(1) && set.contains(4));
    }

}
