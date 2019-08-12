public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        // всегда возвращает корректный индекс слота

        int sum = 0;
        for (char chr : value.toCharArray()) {
            sum += chr;
        }
        return sum % size;
    }

    public int seekSlot(String value) {
        // находит индекс пустого слота для значения, или -1
        // - функцию поиска слота seek_slot(value), которая по входному значению

        int index = hashFun(value);

        if (slots[index] == null) {
            return index;
        }

        for (int i = index + step; i < slots.length; i += step) {
            if (slots[i] == null) {
                return i;
            }
        }

        for (int i = index; i > 0; i -= step) {
            if (slots[i] == null) {
                return i;
            }
        }

        return -1;
    }


    public int put(String value) {
        // записываем значение по хэш-функции

        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить

        int index = seekSlot(value);
        if (index > -1) {
            slots[index] = value;
            return index;
        }

        return -1;
    }

    public int find(String value) {
        // находит индекс слота со значением, или -1
        for (int index = 0; index < slots.length; index++) {
            if (slots[index] != null && slots[index].equals(value)) {
                return index;
            }
        }

        return -1;
    }
}