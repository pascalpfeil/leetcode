package string;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        int strsLength = strs.length;
        if (strsLength == 0)
            return new ArrayList<>();

        Map<List<Integer>, List<String>> result = new HashMap<>();
        int[] counts = new int[26];

        //noinspection ForLoopReplaceableByForEach because this would increase memory consumption
        for (int i = 0; i < strsLength; i++) {
            // reset counts
            Arrays.fill(counts, 0);

            int strLength = strs[i].length();
            for (int j = 0; j < strLength; j++)
                counts[strs[i].charAt(j) - 'a']++;

            List<Integer> key = Arrays.stream(counts).boxed().collect(Collectors.toList());

            if (!result.containsKey(key))
                result.put(key, new ArrayList<>());

            result.get(key).add(strs[i]);
        }

        return new ArrayList<>(result.values());
    }
}
