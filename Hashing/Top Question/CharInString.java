import java.util.HashMap;

public class CharInString {

    public static void frequency(String str,HashMap<Character,Integer> hs){
         for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(hs.containsKey(ch)){
                hs.put(ch,hs.get(ch)+1);
            }else{
                hs.put(ch,1);
            }
         }
    }
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        HashMap<Character,Integer> hs = new HashMap<>();
        frequency(str, hs);

        System.out.println(hs);
    }
}
