import java.util.*;
public class Anagram {
    public static boolean isAnagram(String str1, String str2) {
       if(str1.length()!= str2.length()){
         return false;
       }

       char[] ch1 = str1.toCharArray();
       System.out.println(ch1);
       char[] ch2 = str2.toCharArray();
       System.out.println(ch2);
       Arrays.sort(ch1);
       Arrays.sort(ch2);
       return Arrays.equals(ch1, ch2);
    }
    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "care";

        System.out.println(isAnagram(str1, str2));
    }
}
