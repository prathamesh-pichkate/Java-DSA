// import java.util.*;
import java.util.ArrayList;
public class ImplementUsingArrayList{
     static class ExplicitStack{
        static ArrayList<Integer> list = new ArrayList<Integer>();
        
        // Step 1: Push O(1)
        public static void push(int data){
          list.add(data);   ///add operation of ArrayList
        }

        //Step 2: pop O(1)
        public static int pop(){
          int value = list.get(list.size()-1);
          list.remove(list.size()-1);
          return value;
        }

        //Step 3: peek O(1)
        public static int peek(){
          return list.get(list.size()-1);
        }

        //Step 4: isEmpty()
        public static boolean isEmpty(){
          return list.size()==0;
        }
     }
    public static void main(String[] args) {

      //step1:

      // ExplicitStack.push(1);
      // ExplicitStack.push(2);
      // ExplicitStack.push(3);
      // ExplicitStack.push(4);
      // ExplicitStack.push(5);
      // System.out.println("Stack: " + ExplicitStack.list);
      // System.out.println("Top element: " + ExplicitStack.peek());
      // System.out.println("Popped element: " + ExplicitStack.pop());
      // System.out.println("Stack after pop: " + ExplicitStack.list);
      

      // step 2
      ExplicitStack s = new ExplicitStack();
      s.push(1);
      s.push(2);
      s.push(3);
      s.push(4);
      s.push(5);
      System.out.println("Stack: " + s.list);
      System.out.println("Top element: " + s.peek());
      System.out.println("Popped element: " + s.pop());
      System.out.println("Stack after pop: " + s.list);
    }
}