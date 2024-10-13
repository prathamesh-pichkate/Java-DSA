import java.util.*;

public class Anagram {
    public static boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Populate the HashMap with character counts from s1
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Reduce the character counts using characters from s2
        for (int i = 0; i < s2.length(); i++) {
            char t = s2.charAt(i);
            if (map.get(t) != null) {
                if (map.get(t) == 1) {
                    map.remove(t);
                } else {
                    map.put(t, map.get(t) - 1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty(); // Check if all counts are balanced
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        boolean result = checkAnagram(s1, s2);
        System.out.println("Are the two strings anagrams? " + result);
    }
}
