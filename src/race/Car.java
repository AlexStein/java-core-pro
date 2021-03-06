package race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    private CountDownLatch finishLatch;
    private CyclicBarrier starterBarrier;
    
    public void setStarterBarrier(CyclicBarrier starterBarrier) {
        this.starterBarrier = starterBarrier;
    }

    public void setFinishLatch(CountDownLatch finishLatch) {
        this.finishLatch = finishLatch;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            starterBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        // Финишируем
        finishLatch.countDown();

        // Взять кубок, если еще никто не взял
        if (MainClass.winLock.tryLock()) {
            System.out.println(this.name + " Победил!!!");
            try {
                // Ждем когда все финишируют, чтобы идти на награждение
                finishLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MainClass.winLock.unlock();
        }
    }
}
