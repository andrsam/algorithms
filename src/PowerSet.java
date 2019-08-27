import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PowerSet<T> {
    public int size;
    public ArrayList<T> slots;


    @SuppressWarnings("unchecked")
    public PowerSet() {
        // ваша реализация хранилища
        slots = new ArrayList<>();
    }


    public int size() {
        // количество элементов в множестве
        return asList().size();
    }


    public List<T> asList() {
        return slots.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public void put(T value) {
        // всегда срабатывает
        if (value == null) {
            return;
        }

        if (!get(value)) {
            slots.add(value);
        }
    }

    public boolean get(T value) {
        // возвращает true если value имеется в множестве,
        // иначе false
        return slots.contains(value);
    }

    public boolean remove(T value) {
        // возвращает true если value удалено
        // иначе false
        if (get(value)) {
            slots.remove(value);
            return true;
        }
        return false;
    }

    public PowerSet<T> intersection(PowerSet<T> set2) {
        // пересечение текущего множества и set2
        PowerSet<T> result = new PowerSet<>();

        for (T slot : slots) {
            if (set2.get(slot)) {
                result.put(slot);
            }
        }

        return result;
    }

    public PowerSet<T> union(PowerSet<T> set2) {
        // объединение текущего множества и set2
        PowerSet<T> result = new PowerSet<>();

        for (T slot : slots) {
            result.put(slot);
        }

        for (T slot : set2.slots) {
            result.put(slot);
        }

        return result;
    }

    public PowerSet<T> difference(PowerSet<T> set2) {
        // разница текущего множества и set2
        PowerSet<T> result = new PowerSet<>();

        for (T slot : slots) {
            if (!set2.get(slot)) {
                result.put(slot);
            }
        }

        return result;
    }


    public boolean isSubset(PowerSet<T> set2) {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        boolean result = true;

        for (T slot : set2.slots) {
            result = result && get(slot);
        }

        return result;
    }

    public void fillFromList(List<T> list) {
        slots.clear();
        list.forEach(this::put);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerSet<?> powerSet = (PowerSet<?>) o;
        return size == powerSet.size &&
                Objects.equals(slots, powerSet.slots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, slots);
    }

}
