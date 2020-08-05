package easy.hashtable;

import java.util.*;

public class Easy705 {
    static class MyHashSet {
        static class Bucket {
            List<Integer> list;
            public Bucket() {
                this.list = new LinkedList<>();
            }
            void add(Integer o) {
                if (list.indexOf(o) == -1){
                    list.add(o);
                }
            }
            void remove(Integer o) {
                list.remove(o);
            }
            boolean contains(Integer o) {
                return list.indexOf(o) != -1;
            }
        }
        int size = 769;
        Bucket[] bucketList = new Bucket[769];
        /** Initialize your data structure here. */
        public MyHashSet() {
            for (int i=0; i< size; i++) {
                bucketList[i] = new Bucket();
            }
        }

        private int hash(int key) {
            return key % size;
        }

        public void add(int key) {
            int hash = hash(key);
            bucketList[hash].add(key);
        }

        public void remove(int key) {
            int hash = hash(key);
            bucketList[hash].remove(key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int hash = hash(key);
            return bucketList[hash].contains(key);
        }
    }
}
