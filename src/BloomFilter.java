import java.util.BitSet;

public class BloomFilter {
    private static final int HASH1_RND = 17;
    private static final int HASH2_RND = 223;
    public int filter_len;
    private BitSet storage;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...
        storage = new BitSet(f_len);
    }

    // хэш-функции
    public int hash1(String str1) {
        return computeHash(str1, HASH1_RND);
    }

    public int hash2(String str1) {
        return computeHash(str1, HASH2_RND);
    }

    private int computeHash(String str1, int ratio) {
        int hash = 0;
        for (int i = 0; i < str1.length(); i++) {
            hash += str1.charAt(i) * ratio;
        }
        return hash;
    }

    public void add(String str1) {
        storage.set(hash1(str1));
        storage.set(hash2(str1));
    }

    public boolean isValue(String str1) {
        return storage.get(hash1(str1)) && storage.get(hash2(str1));
    }
}