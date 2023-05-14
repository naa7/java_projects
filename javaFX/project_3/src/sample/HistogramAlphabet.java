package sample;
import java.util.HashMap;
import java.util.Map;

public class HistogramAlphabet {
    public HistogramAlphabet() {
    }

    /*
      Count repeated number of each character
     */

    public Map<Character, Integer> count(String s) {   //takes the file content
        String w = s.replaceAll("[^a-zA-Z]",""); //replaceAll: replaces anything not between a-z or A-Z with ""
        Map<Character, Integer> data = new HashMap<>();
        for (int i = 0; i < w.length(); i++){
            // get each character
            Character ch = w.charAt(i); //charAt returns a char value at the given index for each letter
            // increment count
            incrementFrequency(data, ch);
        }
        return data;
    }

    private void incrementFrequency(Map<Character, Integer> map, Character key){  //increments of each letter frequency
        Integer count = map.get(key);   //get the value of the specified key
        if (count == null){         //if the map contains no mapping for the key, then map the key with value of 0
            map.put(key,0);
        }
        else{                  //else increment the found value by one
            map.put(key, count + 1);
        }
    }
}