import java.util.*;

public class NativeCache<T> {
    private int size;
    private Map<String, T> storage;
    private Map<String, Integer> hits;

    public NativeCache(int size) {
        this.size = size;
        storage = new HashMap<>();
        hits = new TreeMap<>();
    }

    public void put(String key, T value) {

        if (storage.size() == size) {
            Comparator<Map.Entry<String, Integer>> byValue = Comparator.comparing(Map.Entry::getValue);
            String keyToRemove = Objects.requireNonNull(hits.entrySet().stream().min(byValue).orElse(null)).getKey();
            storage.remove(keyToRemove);
            hits.remove(keyToRemove);
        }

        storage.put(key, value);
        hits.put(key, 0);
    }

    public T get(String key) {
        T value = storage.get(key);
        if (value != null) {
            hits.put(key, hits.get(key) + 1);
        }
        return value;
    }

    public Map<String, T> getStorage() {
        return storage;
    }

    public Map<String, Integer> getHits() {
        return hits;
    }

    public int getSize() {
        return size;
    }
}
