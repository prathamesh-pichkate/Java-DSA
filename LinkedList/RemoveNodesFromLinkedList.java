public class RemoveNodesFromLinkedList {
    
}

// Brute force answer TC:0(n) Sc:O(n)
class Solution {
    public ListNode removeNodes(ListNode head) {
        int size=0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        int llToArr[] = new int[size];
        temp = head;
        int i=0;
        while(i<size){
            llToArr[i] = temp.val;
            temp = temp.next;
            i++;
        }

        int maxValOfIdx[] = new int[size];
        maxValOfIdx[size-1] = llToArr[size-1]; //stored the last value of Array.

        for(int j=size-2;j>=0;j--){
            if(llToArr[j] < maxValOfIdx[j+1]){
                maxValOfIdx[j] = maxValOfIdx[j+1];
            }else{
                maxValOfIdx[j] = llToArr[j];
            }
        } 

        //check for the values:
        List<Integer> al = new ArrayList<>();
        for(int k=0;k<llToArr.length;k++){
            if(llToArr[k] == maxValOfIdx[k]){
                al.add(llToArr[k]);
            }
        }

        //Convert Arr to ll
        ListNode newll = new ListNode(al.get(0));
        head = newll;
        for(int x=1;x<al.size();x++){
            newll.next = new ListNode(al.get(x));
            newll = newll.next;
        }

        return head;
    }
}


//