/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeTwoSortedList {
     static class ListNode{ 
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode newList = new ListNode();
         ListNode currNode = newList;

         while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                currNode.next = list1;
                list1 = list1.next;
            }else{
                currNode.next = list2;
                list2 = list2.next;
            }
             currNode = currNode.next;
        }

        if(list1 != null){
            currNode.next = list1;
        }else{
            currNode.next = list2;
        }
         
        return newList.next; 
    }
}

