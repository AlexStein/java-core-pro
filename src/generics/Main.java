package generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // 1.
        String[] arr1 = {"Антошка", "картошку", "пошли", "копать", ","};
        swap(arr1, 1, 4);
        System.out.println(Arrays.toString(arr1));

        // 2.
        ArrayList<String> arrList = toArrayList(arr1);
        printArrayList(arrList);

        Integer[] numbers = {1, 2, 0, 3, 4, 5, 6, 7};
        ArrayList<Integer> arrListInt = toArrayList(numbers);
        printArrayList(arrListInt);

        // 3. Коробки
        Box<Apple> appleBox1 = new Box<>();
        for (int i = 0; i < 15; i++) {
            appleBox1.add(new Apple());
        }

        // appleBox1.add(new Orange()); Не разрешает

        Box<Orange> orangeBox1 = new Box<>();
        for (int i = 0; i < 10; i++) {
            orangeBox1.add(new Orange());
        }

        System.out.printf("Вес ящика яблок %f\n", appleBox1.getWeight());
        System.out.printf("Вес ящика апельсинов %f\n", orangeBox1.getWeight());

        System.out.printf("Вес одинаковый? %s\n", orangeBox1.compare(appleBox1));

        Box<Orange> orangeBox2 = new Box<>();
        for (int i = 0; i < 3; i++) {
            orangeBox2.add(new Orange());
        }
        System.out.printf("Вес 1го ящика апельсинов %.1f\n", orangeBox1.getWeight());
        System.out.printf("Вес 2го ящика апельсинов %.1f\n", orangeBox2.getWeight());

        System.out.println("Пересыпаем из 1го во второй");
        orangeBox1.movePayloadTo(orangeBox2);
        // orangeBox1.movePayloadTo(appleBox1); Не разрешает

        System.out.printf("Вес 1го ящика апельсинов %.1f\n", orangeBox1.getWeight());
        System.out.printf("Вес 2го ящика апельсинов %.1f\n", orangeBox2.getWeight());
    }

    /**
     * Обобщенный метод меняет два элемента массива местами
     *
     * @param arr Массив любого ссылочного типа
     * @param i   Первый элемент
     * @param j   Второй элемент
     * @param <T> Тип массива
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Обобщенный метод конвертации массив в <tt>ArrayList</tt>
     *
     * @param arr Массив любого ссылочного типа
     * @return <tt>ArrayList</tt> из элементов исходного массива
     */
    public static <T> ArrayList<T> toArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    /**
     * Печать <tt>ArrayList</tt> в консоль
     *
     * @param arrList исходный <tt>ArrayList</tt>
     */
    public static <T> void printArrayList(ArrayList<T> arrList) {
        for (T elem : arrList) {
            System.out.print(elem + "  ");
        }
        System.out.println();
    }
}
