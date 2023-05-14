package sample;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class MyPieChart extends MyArc{

    public MyPieChart(int w, int h, int x, int y, MyColor color) {
        super(w, h, x, y, color);
    }

      // Number of displayed event have to less than total available characters

    public void setN(int n){
        if (n > keys.size()) {
            System.out.println("ERROR: N is too big \n" +
                    "Try setting N to: "+ keys.size());
            this.n = keys.size()-1;
        } else {
            this.n = n;
        }
    }

      // Calculate probability base on count of each character

    public void makeProbability(Map<String, Integer> map){
        float total = 0;
        for (String key : map.keySet()) {
            // calculate total of characters
            total += map.get(key);
        }
        // sort count map by from big count to small count
        Map<String, Integer> sortedMap = sortByValue(map);
        // spit Map to 2 ArrayList for easy handle later
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            keys.add(entry.getKey());
            probes.add(entry.getValue() / total);
        }
    }

      // Sort Map by DESC value

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortedMap.entrySet());

        Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
