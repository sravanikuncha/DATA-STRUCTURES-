import java.util.Scanner;
import java.util.Stack;

public class StackPracticeproblems {

    static boolean isBalanced(String inp){        
        Stack<Character> stack=new Stack<>();
        for(char c : inp.toCharArray()){
            if(c=='('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private static void reverseStack(Stack<Integer> input,Stack<Integer> extra){
        if(input.isEmpty()){
            return;
        }

        int temp=input.pop();
        reverseStack(input, extra);
        while(!input.isEmpty()){
            extra.push(input.pop());
        }

        input.push(temp);
        while(!extra.isEmpty()){
            input.push(extra.pop());
        }
       
    }

    private static void printStack(Stack<Integer> stack){
        System.out.println("printing stack");
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    private static boolean isRedundant(String inp){
        Stack<Character> stack=new Stack<>();
        for(char c:inp.toCharArray()){
            if(c==')'){
                int count=0;
                while(!stack.isEmpty()){
                    char stackPeekChar=stack.peek();
                    if(stackPeekChar=='(' && count==0)
                        return true;
                    else{
                        count++;
                        char c1=stack.peek();
                        stack.pop();
                        if(c1=='(')
                            break;
                    }
                }
                if(count==2)
                    return true;
            }
            else{
                stack.push(c);
            }
        }

        return false;
    }

    private static int[] stockSpan(int[] price){
        Stack<Integer> stack=new Stack<>();

        int[] stockSpan=new int[price.length];
        stack.push(0);
        stockSpan[0]=1;
        for(int i=1;i<price.length;i++){
            if(stack.size()!=0){
                int count=1;
                int j=i;
                while(!stack.isEmpty()){
                    int topPrice=price[stack.peek()];
                    if(topPrice<price[i]){
                        count+=stockSpan[stack.pop()];
                    }
                    else{                        
                        break;
                    }
                    
                }
                stack.push(i);
                stockSpan[i]=count;
            }
            else{
                stack.push(i);
                stockSpan[i]=1;
            }
        }

        return stockSpan;
    }

    private static int minimumBrackets(String inp){
        Stack<Character> stack=new Stack<>();

        for(char c:inp.toCharArray()){
            if(c=='{'){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty()){
                    char c1=stack.peek();
                    if(c1=='{'){
                        stack.pop();
                    }
                    else{
                        stack.push(c);
                    }
                }
                else{
                    stack.push(c);
                }
            }
        }

        int size=stack.size();
        if(size%2==0){
            return size/2;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String inp=sc.next();
    //    boolean isbalanced=isBalanced(inp);
    //    if(isbalanced){
    //     System.out.println("brackets balanced");
    //    }
    //    else{
    //     System.out.println("Brackets not balaced");
    //    }

        // boolean isRedundant=isRedundant(inp);
        // if(isRedundant){
        //     System.out.println("redundant brackets are present");
        // }
        // else{
        //     System.out.println("no redundant brackets ");
        // }

        // Stack<Integer> input=new Stack<>();
        // Stack<Integer> print=new Stack<>();
        // Stack<Integer> extra =new Stack<>();
        // int data=sc.nextInt();
        // while(data!=-1){
        //     input.push(data);
        //     print.push(data);
        //     data=sc.nextInt();
        // }
        // printStack(print);
        // System.out.println("after reverse");
        // reverseStack(input,extra);
        // printStack(input);
        
        // int n=sc.nextInt();
        // int[] price=new int[n];
        // for(int i=0;i<n;i++){
        //     price[i]=sc.nextInt();
        // }
        // int[] stockSpan=stockSpan(price);
        // for(int i: stockSpan){
        //     System.out.print(i+" ");
        // }

        System.out.println(minimumBrackets(inp));
        sc.close();
    }
}
