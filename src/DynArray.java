import java.lang.reflect.Array;
import java.util.Arrays;

public class DynArray<T> {
    public static final int MIN_CAPACITY = 16;
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
        if (index < 0 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return array[index];
    }

    public void append(T itm) {
        ensureCapacity();
        array[count++] = itm;
    }

    public void insert(T itm, int index) {
        ensureCapacity();
        if (index == count - 1) {
            append(itm);
        }  else {
            System.arraycopy(array, index + 1, array, index + 2, count - index - 1);
            array[index] = itm;
        }
    }

    private void ensureCapacity() {
        if (count + 1 > capacity) {
            makeArray(capacity * 2);
        }
    }

    public void remove(int index) {
        // ваш код
    }

}