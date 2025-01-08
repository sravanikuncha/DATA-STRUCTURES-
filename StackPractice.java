class StackEMptyException extends Exception{
    void message(){
        System.out.println("Stack Empty Exception");
    }
}
class StackLinkedList{
    NodePractice head;
    int top=0;

    StackLinkedList(){
        head=null;
    }

    void put(int data){
        top++;
        NodePractice newNode= new NodePractice(data,null);
        if(head==null){
            head=newNode;
        }
        else{
        newNode.next=head;
        head=newNode;
        }
    }

    int pop() throws StackEMptyException{
        if(isEmpty()){
            throw new StackEMptyException();
        }
        top--;
        int popedEle=head.data;
        head=head.next;
        return popedEle;
    }

    int top() throws StackEMptyException{
        if(isEmpty()){
            throw new StackEMptyException();
        }
        return head.data;
    }

    boolean isEmpty(){
        return head==null ? true:false;
    }

    void printStackLL(){
        System.out.println("printinhg");
        NodePractice temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    int size(){
        return top;
    }
}

public class StackPractice {

    int top=-1;
    int[] stack;

    StackPractice(){
        stack=new int[5];
    }

    void put(int data){
        top++;
        if(top>stack.length-1){
            int[] newStack=new int[10];
            for(int i=0;i<stack.length;i++){
                newStack[i]=stack[i];
            }
            stack=newStack;
        }
        stack[top]=data;
    }

    int pop() throws StackEMptyException{
        if(isEmpty()){
            throw new StackEMptyException();
        }
        int deletedEle=stack[top];
        top--;
        return deletedEle;
    }

    int top() throws StackEMptyException{
        if(isEmpty()){
            throw new StackEMptyException();
        }
        return stack[top];
    }

    boolean isEmpty(){
        return top==-1?true:false;
    }

    void printStack(){
        System.out.println("printinhg");
        for(int i=top;i>=0;i--){
            System.out.print(stack[i]+" ");
        }
    }

    int size(){
        return top+1;
    }

    public static void main(String[] args) {
        StackPractice stack=new StackPractice();
        try{
         System.out.println(stack.isEmpty());
         stack.put(1);
         stack.put(2);
         stack.put(3);
         stack.put(4);
         stack.put(5);
         System.out.println(stack.size());
         stack.printStack();
         System.out.println(stack.top());
         System.out.println(stack.pop());
         stack.put(6);
         stack.put(7);
         int top=stack.top;
         stack.printStack();
         while(top>=0){
            stack.pop();
            top--;
         }
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        stack.put(8);
        System.out.println(stack.size());
        System.out.println(stack.top());
         System.out.println(stack.pop());
        
        }
        catch(StackEMptyException e){
            e.message();
        }


        System.out.println("Stack using LinkedList");
        StackLinkedList stackLL=new StackLinkedList();
        try{
            System.out.println(stackLL.isEmpty());
            stackLL.put(1);
            stackLL.put(2);
            stackLL.put(3);
            stackLL.printStackLL();
            System.out.println(stackLL.top());
            System.out.println(stackLL.pop());
            stackLL.printStackLL();
            System.out.println(stackLL.isEmpty());
            System.out.println(stackLL.top());
            System.out.println(stackLL.pop());
            System.out.println(stackLL.pop());
            System.out.println(stack.size());
            System.out.println(stackLL.top());
        }
        catch(StackEMptyException e){
            e.message();
        }

    }
}
