import java.lang.reflect.Array;
import java.util.Arrays;

public class DynArray<T> {
    public final int MIN_CAPACITY = 16;
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(MIN_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public void makeArray(int new_capacity) {
        if (array == null) {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
        } else {
            array = Arrays.copyOf(array, new_capacity);
        }
        capacity = new_capacity;
    }

    public T getItem(int index) {
        checkIndex(index);
        return array[index];
    }

    public void append(T itm) {
        insert(itm, count);
    }

    public void insert(T itm, int index) {
        checkIndex(index);
        if (count == capacity) {
            makeArray(capacity * 2);
        }

        if (index <= count - 1) {
            System.arraycopy(array, index, array, index + 1, count - index);
        }
        array[index] = itm;
        count++;
    }

    public void remove(int index) {
        checkIndex(index);
        if (count == 0) {
            return;
        }
        System.arraycopy(array, index + 1, array, index, count - index - 1);
        count--;

        if (capacity > MIN_CAPACITY && count < capacity / 2) {
            capacity = (capacity / 1.5 < MIN_CAPACITY) ? MIN_CAPACITY : (int) (capacity / 1.5);
            makeArray(capacity);
        }

    }

    private void checkIndex(int index) {
        if (index < 0 || index > capacity - 1 && count < capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}