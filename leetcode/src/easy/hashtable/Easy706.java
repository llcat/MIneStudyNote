package easy.hashtable;

import java.util.HashMap;
import java.util.LinkedList;

public class Easy706 {
    static class MyHashMap {
        static class Entry {
            int k;
            int v;
            public Entry(int k, int v) {
                this.k = k;
                this.v = v;
            }
            int getK() {
                return k;
            }
            int getV() {
                return v;
            }
            void setV(int v) {
                this.v = v;
            }
        }
        static class Bucket {
            LinkedList<Entry> list;
            public Bucket() {
                this.list = new LinkedList<>();
            }
            Entry findEntry(int k) {
                for (Entry e:list) {
                    if (e.getK() == k) {
                        return e;
                    }
                }
                return null;
            }
            void put(int key, int value) {
                Entry f = findEntry(key);
                if (f != null) {
                    f.setV(value);
                } else {
                    list.add(new Entry(key, value));
                }
            }
            int get(int key) {
                Entry f = findEntry(key);
                if (f!=null) {
                    return f.getV();
                }
                return -1;
            }
            void remove(int key) {
                Entry f = findEntry(key);
                if (f!=null) {
                    list.remove(f);
                }
            }
        }
        /** Initialize your data structure here. */
        private final int BUCKET_SIZE = 76;
        private Bucket[] buckets = new Bucket[BUCKET_SIZE];
        public MyHashMap() {
            for(int i=0; i<buckets.length;i++) {
                buckets[i] = new Bucket();
            }
        }

        int hash(int k) {
            return k % BUCKET_SIZE;
        }
        /** value will always be non-negative. */
        public void put(int key, int value) {
            Bucket b = buckets[hash(key)];
            b.put(key, value);
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            Bucket b = buckets[hash(key)];
            return b.get(key);
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            Bucket b = buckets[hash(key)];
            b.remove(key);
        }
    }
}
