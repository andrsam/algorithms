import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        // всегда возвращает корректный индекс слота
        int sum = 0;
        for (char chr : key.toCharArray()) {
            sum += chr;
        }
        return sum % size;
    }

    public boolean isKey(String key) {
        // возвращает true если ключ имеется,
        // иначе false
        int i = 0;
        while (i < slots.length) {
            if (slots[i] != null && slots[i].equals(key)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void put(String key, T value) {
        // гарантированно записываем
        // значение value по ключу key

        int index = hashFun(key);
        slots[index] = key;
        values[index] = value;
    }

    public T get(String key) {
        // возвращает value для key,
        // или null если ключ не найден
        return values[hashFun(key)];
    }
}