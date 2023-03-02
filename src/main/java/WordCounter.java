import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCounter {
    public static void count(String filename) throws IOException {
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        TreeMap<String, Integer> words = new TreeMap<String, Integer>();
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            String[] strings = line.split("\\s+");
            for (String s : strings) {
                if (words.containsKey(s)) {
                    words.put(s, words.get(s) + 1);
                } else words.put(s, 1);
            }
            line = reader.readLine();
        }
        Map<String, Integer> sortedMap = valueSort(words);
        Set set = sortedMap.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry mp = (Map.Entry) i.next();
            System.out.print(mp.getKey() + ": ");
            System.out.println(mp.getValue());
        }
    }

    public static <K, V extends Comparable<V>> Map<K, V>
    valueSort(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int comp = map.get(k2).compareTo(map.get(k1));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }
}