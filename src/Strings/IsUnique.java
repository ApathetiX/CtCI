package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use an additional data structure?
 *
 * Examples:
 * abcdefg -> true
 * sameet -> false
 * fatimah -> false
 *
 * We can easily use a set and add each character to it. If the set contains the char, we know it's not unique.
 */
public class IsUnique {

    // this takes O(N) time and O(N) space
    private static boolean isUnique(String str) {
        // if the string is a single char, it's obviously unique
        if (str.length() <= 1) {
            return true;
        }
        // Set to store characters. This will take O(N) space
        Set<Character> set = new HashSet<>();
        // for each char in the string, if the char is not in the set, add it.
        // otherwise return false cos we know the string is not unique
        for (char c : str.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                return false;
            }
        }
        return true;
    }

    // if we dont want to use any space, we can sort the string and check from i = 1, and its prev index
    // It takes NLogN to sort the string, and N time to iterate. NLogN + N
    private static boolean isUnique2(String str) {
        if (str.length() <= 1) {
            return true;
        }
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        for (int i = 1; i <= arr.length - 1; i++) {
            if (arr[i] == arr[i - 1]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String test1 = "abcdefg";
        String test2 = "sameet";
        String test3 = "fatimah";

        System.out.println(isUnique(test1));
        System.out.println(isUnique(test2));
        System.out.println(isUnique(test3));

        System.out.println(isUnique2(test1));
        System.out.println(isUnique2(test2));
        System.out.println(isUnique2(test3));
    }
}
