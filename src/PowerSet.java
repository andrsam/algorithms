import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PowerSet<T> {
    public int size;
    public List<T> slots;
    public Class<T> clazz;
    public static final int INITIAL_SIZE = 20000;


    @SuppressWarnings("unchecked")
    public PowerSet(Class<T> clazz) {
        // ваша реализация хранилища
        this.size = INITIAL_SIZE;
        this.clazz = clazz;
        slots = new ArrayList<>(Arrays.asList((T[]) Array.newInstance(clazz, INITIAL_SIZE)));
    }

    private int hashFun(T value) {
        // всегда возвращает корректный индекс слота
        if (clazz == Integer.class) {
            return (Integer) value;
        }
        String valStr = value.toString();
        int sum = 0;
        for (char chr : valStr.toCharArray()) {
            sum += chr;
        }
        return sum % size;
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
        int i = hashFun(value);

        if (i > slots.size()) {
            size = i;
            slots = (List<T>) Arrays.asList(Arrays.copyOf(slots.toArray(), i + 1));
        }

        T slotVal = slots.get(i);
        if (slotVal == null || (!slotVal.equals(value))) {
            slots.set(i, value);
        }
    }

    public boolean get(T value) {
        // возвращает true если value имеется в множестве,
        // иначе false
        int i = hashFun(value);
        return slots.get(i) != null && slots.get(i).equals(value);
    }

    public boolean remove(T value) {
        // возвращает true если value удалено
        // иначе false
        if (get(value)) {
            slots.set(hashFun(value), null);
            return true;
        }
        return false;
    }

    public PowerSet<T> intersection(PowerSet<T> set2) {
        // пересечение текущего множества и set2
        PowerSet<T> result = new PowerSet<>(this.clazz);

        for (int i = 0; i < size; i++) {
            if (slots.get(i) != null && set2.get(slots.get(i))) {
                result.put(slots.get(i));
            }
        }

        return result;
    }

    public PowerSet<T> union(PowerSet<T> set2) {
        // объединение текущего множества и set2
        PowerSet<T> result = new PowerSet<>(this.clazz);
        for (int i = 0; i < size; i++) {
            if (this.slots.get(i) != null) {
                result.put(this.slots.get(i));
            }
        }

        for (int i = 0; i < set2.size; i++) {
            if (set2.slots.get(i) != null) {
                result.put(set2.slots.get(i));
            }
        }

        return result;
    }

    public PowerSet<T> difference(PowerSet<T> set2) {
        // разница текущего множества и set2
        PowerSet<T> result = new PowerSet<>(this.clazz);

        for (int i = 0; i < size; i++) {
            if (slots.get(i) != null) {
                if (!set2.get(slots.get(i))) {
                    result.put(slots.get(i));
                }
            }
        }
        return result;
    }


    public boolean isSubset(PowerSet<T> set2) {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        boolean result = true;

        List<T> nonNullslots = set2.slots.stream().filter(Objects::nonNull).collect(Collectors.toList());

        for (int i = 0; i < nonNullslots.size(); i++) {
            result = result && get(nonNullslots.get(i));
        }

        return result;
    }

    public void fillFromList(List<T> list) {
        slots = new ArrayList<>(Arrays.asList((T[]) Array.newInstance(clazz, size)));
        for (int i = 0; i < list.size(); i++) {
            put(list.get(i));
        }
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
