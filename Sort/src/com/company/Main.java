package com.company;
import java.util.Map;
import java.util.LinkedHashMap;
import static java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Map<Integer, Integer> test = new LinkedHashMap<>();
	    Map<Integer, Integer> result;
	    test.put(1, 10);
	    test.put(2, 5);
	    test.put(3, 7);
	    result = sortByValue(test);
	    for(int item : result.keySet())
	        System.out.println(item);
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
