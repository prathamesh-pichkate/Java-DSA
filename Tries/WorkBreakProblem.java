public class WorkBreakProblem {
    public static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // eow - end of word

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean searchKey(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public static boolean checkKey(String key) {
        // Base case: if key is empty, return true.
        if (key.length() == 0) {
            return true;
        }

        // Check for every possible prefix.
        for (int i = 1; i <= key.length(); i++) {
            // Check if the prefix is present, and the remaining part is also valid.
            if (searchKey(key.substring(0, i)) && checkKey(key.substring(i))) {
                return true;
            }
        }

        return false; 
    }

    public static void main(String[] args) {
        String words[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (String word : words) {
            insert(word);
        }

        String key = "ilikesamsung";

        if (checkKey(key)) {
            System.out.println("Present");
        } else {
            System.out.println("Not Present");
        }
    }
}
