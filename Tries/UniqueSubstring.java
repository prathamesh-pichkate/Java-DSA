public class UniqueSubstring {
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
     
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int count = 0;
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }
        return count+1;
    }

    
    public static void main(String[] args) {
        String words = "ababa";
        for(int i=0;i<words.length();i++){
            String suffix = words.substring(i);
            insert(suffix);
        }
       System.out.println(countNodes(root));
        
    }
}
