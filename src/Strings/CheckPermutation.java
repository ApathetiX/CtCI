package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 * Example:
 * Sameet Fatimah -> false
 * fatimah fatiham -> true
 * samtee sameet -> true
 *
 * We can use two hashmaps and check if their frequencies match. This will use O(N) space and O(N) time
 * We also know their lengths have to match, otherwise they are definitely not permutations of each other
 */
public class CheckPermutation {

    // this uses O(N) space to store the char and their frequencies and takes O(N) time
    private static boolean checkPerm(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = addToMap(s1);
        Map<Character, Integer> map2 = addToMap(s2);

        // now we iterate through both hashmaps and check their frequencies
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();
            // get the value from map2, if it doesn't exist, then def not perm.
            // also if the values arent the same, then its not a perm
            if (!map2.containsKey(c)) return false;
            if (map2.get(c) != freq) return false;
        }
        return true;
    }

    private static HashMap<Character, Integer> addToMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        return map;
    }

    // This method sorts both strings and then compares char of each string
    // This takes NLogN time to do but uses no space
    private static boolean checkPerm2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // convert string to char array and sort both arrays
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // now compare each char in both arrays
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPerm2("sameet", "fatimah"));
        System.out.println(checkPerm2("fatimah", "fatiham"));
        System.out.println(checkPerm2("samtee", "sameet"));


    }

}
