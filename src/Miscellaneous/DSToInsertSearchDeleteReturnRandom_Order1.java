package Miscellaneous;

import java.util.*;

public class DSToInsertSearchDeleteReturnRandom_Order1 {
    List<Integer> arr;
    Map<Integer, Integer> map;

    DSToInsertSearchDeleteReturnRandom_Order1 () {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }

    void insert (Integer val) {
        if (map.get(val) != null)
            return;
        arr.add(val);
        map.put(val, arr.size()-1);
    }

    void remove (Integer val) {
        Integer index = map.get(val);
        if (index == null)
            return;
        map.remove(val);
        Integer size = arr.size();
        Integer last = arr.get(size-1);
        Collections.swap(arr, index, size-1);
        arr.remove(size-1);
        map.put(last, index);
    }

    Integer getRandom () {
        Random random = new Random();
        Integer randomIndex = random.nextInt(arr.size());
        return arr.get(randomIndex);
    }

    Integer search (Integer val) {
        return map.get(val);
    }

    public static void main (String[] args) {
        DSToInsertSearchDeleteReturnRandom_Order1 ds = new DSToInsertSearchDeleteReturnRandom_Order1();
        ds.insert(10);
        ds.insert(20);
        ds.insert(30);
        ds.insert(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.insert(50);
        System.out.println(ds.search(50));
        System.out.println(ds.search(40));
        System.out.println(ds.getRandom());
    }
}
