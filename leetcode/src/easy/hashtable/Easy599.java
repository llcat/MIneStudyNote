package easy.hashtable;

import java.util.ArrayList;
import java.util.HashMap;

public class Easy599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i=0; i<list1.length; i++) {
            map.put(list1[i], i);
        }
        for(int i=0; i<list2.length; i++) {
            if(map.containsKey(list2[i])) {
                map1.put(list2[i], map.get(list2[i]) + i);
            }
        }
        ArrayList<String> arr = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(String k:map1.keySet()) {
            int index = map1.get(k);
            if (index == min) {
                min = index;
                arr.add(k);
            }
            if (index < min) {
                arr.clear();
                min = index;
                arr.add(k);
            }
        }
        return arr.toArray(new String[arr.size()]);
    }

    public static void main(String[] args) {
        String[] arr1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] arr2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        new Easy599().findRestaurant(arr1, arr2);
    }
}
