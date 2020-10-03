package threads;

public class Main {

    private static char currentSymbol = 'A';
    private static final Object mon = new Object();
    private static final int repeats = 5;

    public static void main(String[] args) {
        Thread treadA = new Thread(()-> {
            printLetter('A', 'B');
        });

        Thread treadB = new Thread(()-> {
            printLetter('B', 'C');
        });

        Thread treadC = new Thread(()-> {
            printLetter('C', 'A');
        });

        treadA.start();
        treadB.start();
        treadC.start();

        try {
            treadA.join();
            treadB.join();
            treadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Все");

    }

    private static void printLetter(char letter, char next) {
        for (int i = 0; i < repeats; i++) {
            synchronized (mon) {
                while (currentSymbol != letter) {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        // Я проснулся! (с)
                    }
                }
                // Печатаем
                System.out.print(letter);
                currentSymbol = next;
                mon.notifyAll();
            }
        }
    }

}
