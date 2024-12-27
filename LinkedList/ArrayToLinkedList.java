public class ArrayToLinkedList {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static void main(String[] args) {
        int arr[] = {10,2,3,4,5};
        // Node head;
        // Node tail;
        Node temp = new Node(arr[0]);
        head = tail = temp;

        for(int i=1;i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp = temp.next;
            tail = temp;
        }
        System.out.println(head.data);
        printLinkedList(head);
    }


    public static void printLinkedList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }
}
