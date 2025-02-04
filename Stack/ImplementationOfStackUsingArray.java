import java.util.Arrays;

public class ImplementationOfStackUsingArray {
    public  class ExplicitStack{
        static int stack[] = new int[5];
        static int top = -1;
        static int size = 5;

        public static  void push(int data){
            if(top == size-1){
                System.out.println("Stack Overflow");
                return;
            }
            top++;
            stack[top] = data;
        }

        public static int pop(){
            if(top == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            int value = stack[top];
            top--;
            return value;
        }

        public static int peek(){
            if(top == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            return stack[top];
        }

        public static boolean isEmpty(){
            return top == -1;
        }

         public static String getStackContents() {
            return Arrays.toString(Arrays.copyOf(stack, top + 1)); // Copying only the elements in the stack
        }

    }
    public static void main(String[] args) {
        ExplicitStack.push(1);
        ExplicitStack.push(2);
        ExplicitStack.push(3);
        ExplicitStack.push(4);
        ExplicitStack.push(5);
        System.out.println("Stack: " + ExplicitStack.getStackContents());
        System.out.println("Top element: " + ExplicitStack.peek());
        System.out.println("Popped element: " + ExplicitStack.pop());
        System.out.println("Stack after pop: " + ExplicitStack.getStackContents());
    }
}
