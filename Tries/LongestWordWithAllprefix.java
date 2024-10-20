public class LongestWordWithAllprefix {
    public static class Node {
        Node[] children = new Node[26];
        boolean eow = false; // End of Word

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node(); // Root of the Trie
    public static String ans = ""; // Store the longest valid word

    // Insert a word into the Trie
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // Mark the end of a word
    }

    // Helper function to perform DFS and find the longest word
    public static void dfs(Node curr, String path) {
        if (curr == null) {
            return;
        }

        // Only consider paths where all prefixes are valid words
        if (!curr.eow && !path.isEmpty()) {
            return;
        }

        // Update the answer if this path is longer or lexicographically smaller
        if (path.length() > ans.length() || 
            (path.length() == ans.length() && path.compareTo(ans) < 0)) {
            ans = path;
        }

        // Explore all children in lexicographic order
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                char ch = (char) (i + 'a');
                dfs(curr.children[i], path + ch); // Recur with the updated path
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "app", "appl", "apple", "apply", "banana"};

        // Insert all words into the Trie
        for (String word : words) {
            insert(word);
        }

        // Perform DFS to find the longest word with all prefixes
        dfs(root, "");

        // Print the final answer
        System.out.println(ans);
    }
}
