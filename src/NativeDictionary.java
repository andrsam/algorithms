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
        while (i < slots.length - 1) {
            i++;
            if (slots[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void put(String key, T value) {
        // гарантированно записываем
        // значение value по ключу key
        values[hashFun(key)] = value;
    }

    public T get(String key) {
        // возвращает value для key,
        // или null если ключ не найден
        return values[hashFun(key)];
    }
}