public class SpliteAStringInBalancedStr {
    public static int balancedStringSplit(String s) {
        int count = 0;
        int total = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'L'){
                count--;
            }else{
                count++;
            }

            if(count == 0){
                total++;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        String s = "LLRRRLLLLRRRLLR";
        System.out.println(balancedStringSplit(s));
    }
}
