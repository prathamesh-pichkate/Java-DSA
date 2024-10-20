public class Insertion {
    public static class Node{
        Node children[] = new Node[26];
        boolean eow = false; //eow - end of word
        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }


    public static Node root = new Node();

    public static void insert(String words){
        Node curr = root;
        for(int level =0;level<words.length();level++){
            int idx = words.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow =true;
    }
    
    public static void main(String[] args) {
        String words[] = {"the","A","there","this","name","any"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
    }
}
