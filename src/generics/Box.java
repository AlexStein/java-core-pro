package generics;

import java.util.ArrayList;
import java.util.Collection;

public class Box<T extends Fruit> {

    private final ArrayList<T> payload;

    public Box() {
        payload = new ArrayList<>();
    }

    public float getWeight() {
        if (payload.size() == 0) {
            return 0;
        }

        Fruit f = payload.get(0);
        return payload.size() * f.getWeight();
    }

    public void add(T fruit) {
        payload.add(fruit);
    }

    public void fill(Collection<T> fruits) {
        payload.addAll(fruits);
    }

    private void clear() {
        payload.clear();
    }

    public boolean compare(Box<? extends Fruit> box) {
        return (Math.abs(getWeight() - box.getWeight()) < 0.001);
    }

    public void movePayloadTo(Box<T> box) {
        box.fill(payload);
        clear();
    }
}
