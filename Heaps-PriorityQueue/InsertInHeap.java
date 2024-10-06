import java.util.*;

public class InsertInHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        /// Add operation:
        public void add(int data) { // O(log n)
            // Add the data at the end
            arr.add(data);

            // Children index:
            int childIdx = arr.size() - 1;
            int parentIdx = (childIdx - 1) / 2;

            // Bubble up to maintain heap property
            while (childIdx > 0 && arr.get(childIdx) < arr.get(parentIdx)) {   //if want in descensing order then change < to >
                // Swap child and parent
                int temp = arr.get(childIdx);
                arr.set(childIdx, arr.get(parentIdx));
                arr.set(parentIdx, temp);

                // Move up the tree
                childIdx = parentIdx;
                parentIdx = (childIdx - 1) / 2;
            }
        }

        /// Peek operation:
        public int peek() { // O(1)
            if (arr.isEmpty()) {
                throw new NoSuchElementException("Heap is empty");
            }
            return arr.get(0);
        }

        /// Heapify operation:
        private void heapify(int i) { // O(log n)
            int minIdx = i;    // if want in descending order then change minIdx to maxIdx
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Check left child
            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {  //if want in descensing order then change > to <
                minIdx = left;
            }

            // Check right child
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {  //if want in descensing order then change > to <
                minIdx = right;
            }

            // If the smallest is not the current node, swap and continue heapifying
            if (minIdx != i) {
                // Swap current node with smallest child
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // Recursively heapify the affected subtree
                heapify(minIdx);
            }
            // **Do not call heapify if no swap occurred to prevent infinite recursion**
        }

        /// Remove operation:
        public int remove() { // O(log n)
            int data = arr.get(0);

            // Step 1: Swap first and last elements
            int lastIdx = arr.size() - 1;
            arr.set(0, arr.get(lastIdx));
            arr.remove(lastIdx);

            // Step 2: Heapify from the root to maintain heap property
            heapify(0);

            return data;
        }

        /// Check if heap is empty:
        public boolean isEmpty() { // O(1)
            return arr.isEmpty();
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(5);
        h.add(3);
        h.add(1);
        h.add(2);
        h.add(9);

        System.out.println("Elements in the heap in ascending order:");
        while (!h.isEmpty()) {
            System.out.println(h.remove());
        }
    }
}
