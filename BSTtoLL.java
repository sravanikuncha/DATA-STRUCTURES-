import java.util.LinkedList;

class LinkedListNode<T> { T data; LinkedListNode<T> next;
     
     public LinkedListNode(T data) { this.data = data; } }


    //  class AncestorObj{
	// 	int ancestorNodevalue;
	// 	boolean isPresent;

	// 	AncestorObj(int ancestorNodevalue,boolean isPresent){
	// 		this.ancestorNodevalue=ancestorNodevalue;
	// 		this.isPresent=isPresent;
	// 	}
	// }

public class BSTtoLL {
    public static void main(String[] args) {
         BinaryTreeNode<Integer> dynamicRoot =BinaryTreeNode.levelWiseInput();

        System.out.println(getLCA(dynamicRoot,7,1));
        

}


public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
  	LinkedList<Integer> ll=new LinkedList<>();
		boolean ans=helper(root,a,b,ll);
		if(!ll.isEmpty())
			return ll.get(ll.size()-1);
		return -1;
}

public  static boolean helper(BinaryTreeNode<Integer> root, int a , int b,LinkedList<Integer> ll){
   	if(root==null)
			return false;
		
		if(root.data==a || root.data==b){
			ll.add(root.data);
			return true;
		}


        
		boolean left=false,right=false;
        if(root.left!=null)
        left=helper(root.left, a, b,ll);
        if(root.right!=null)
		 right=helper(root.right,a,b,ll);


		if(left && right){
			ll.add(root.data);
			return true;
		}
		
		else 
			return false;
}


public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {

    if(root==null)
            return null;
        
        LinkedListNode<Integer> leftNode=constructLinkedList(root.left);
        LinkedListNode<Integer> rightNode=constructLinkedList(root.right);
        LinkedListNode<Integer> temp=null,head=null;
        if(leftNode!=null){
            head=leftNode;
            temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            LinkedListNode<Integer> newNode=new LinkedListNode<>(root.data);
            temp.next=newNode;
            temp=newNode;
        }
        else{
            head=new LinkedListNode<>(root.data);
            temp=head;
        }

        temp.next=rightNode;

        return head;

}
}
