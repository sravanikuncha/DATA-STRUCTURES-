import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeNode<T> {

    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;//hereT is imp because , first is integger then all T should aso be same 

    BinaryTreeNode(T data){                                                                                                 
        this.data=data;
        left=null;
        right=null;
    }

    public static void printDetailedTree(BinaryTreeNode<Integer> root){
        if(root==null){
            return ;
        }
        
        System.out.print(root.data+":");
        if(root.left!=null)
            System.out.print("L"+root.left.data);
        if(root.right!=null)
            System.err.print(" "+"R"+root.right.data);
        
        System.out.println();
        printDetailedTree(root.left);
        printDetailedTree(root.right);
    }

    public void printTree(BinaryTreeNode<T> root){
        //one type 
        if(root==null)
            return;

        System.out.print(root.data+" ");
        printTree(root.left);
        printTree(root.right);

        //2nd type handles base here itself  but issue is if root is null then nullpointer exception
        // if(root.left!=null)
        //     printTree(root.left);

        // if(root.right!=null)
        //     printTree(root.right);
        //always to move to right we needto come to its ans=cestor/root of the preset node and go to right 
           
    }

    // public static BinaryTreeNode<Integer> takeInput(){
        public static BinaryTreeNode<Integer> takeInput(boolean isRoot){
            if(isRoot)
                System.out.println("Enter root data");//improve print statement by asking specific node data 
            Scanner sc=new Scanner(System.in);
            int data=sc.nextInt();

            if(data==-1)
                return null;
            
            
            BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(data);
            System.out.println("Enter left child of "+root.data);
            BinaryTreeNode<Integer> leftChild=takeInput(false);
            System.out.println("Enter right child of "+root.data);
            BinaryTreeNode<Integer> rightChild=takeInput(false);

            root.left=leftChild;
            root.right=rightChild;
            
            return root;
            
    }

    public static BinaryTreeNode<Integer> levelWiseInput(){
        // Queue<Integer> queue=new LinkedList<>();   

        System.out.println("Start enterig levelwise i/p1");
        Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();  
        Scanner sc=new Scanner(System.in);
        int rootdata=sc.nextInt();
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootdata);
        if(root.data ==-1)
            return null;
        queue.add(root);

        while(!queue.isEmpty()){

            BinaryTreeNode<Integer> parent=queue.poll();

            System.out.println("Enter"+parent.data+" left child element");
            int leftdata=sc.nextInt();
            if(leftdata!=-1){
                BinaryTreeNode<Integer> leftCHild=new BinaryTreeNode<Integer>(leftdata);
                parent.left=leftCHild;
                queue.add(leftCHild);
            }

            System.out.println("Enter"+parent.data+" right child element");
            int rightdata=sc.nextInt();
            if(rightdata!=-1){
                BinaryTreeNode<Integer> rightChild=new BinaryTreeNode<Integer>(rightdata);
                parent.right=rightChild;
                queue.add(rightChild);
            }
        }

        return root;
    }

    public static void printlevelWiseTree(BinaryTreeNode<Integer> root){
        if(root==null)
            return;

        Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> parentnode=queue.poll();
            System.out.print(parentnode.data+" ");
            if(parentnode.left!=null)
                queue.add(parentnode.left);
            if(parentnode.right!=null)
                queue.add(parentnode.right);
        }
    }

    public static int largestNode(BinaryTreeNode<Integer> root){
        if(root==null)
            return Integer.MIN_VALUE;
        
        int leftlargeNode=largestNode(root.left);
        int rightlargeNode=largestNode(root.right);

        return Math.max(leftlargeNode, Math.max(root.data, rightlargeNode));
    }

    public static int smallestnode(BinaryTreeNode<Integer> root){
        if(root==null)
            return Integer.MAX_VALUE;
        
        int leftlargeNode=smallestnode(root.left);
        int rightlargeNode=smallestnode(root.right);

        return Math.min(leftlargeNode, Math.min(root.data, rightlargeNode));
    }

    
    public static int leafOfTree(BinaryTreeNode<Integer> root){
        if(root==null)
            return 0;
        
        if(root.left==null && root.right==null)
            return 1;
        
        int leftAns=leafOfTree(root.left);
        int rightAns=leafOfTree(root.right);

        return leftAns+rightAns;
    }

    public static void depthOftree(BinaryTreeNode<Integer> root,int k){
        if(root==null)
            return ;
        
        if(k==0){
            System.out.print(root.data+" ");
            return ;
        }
        
        depthOftree(root.left,k-1);
        depthOftree(root.right,k-1);
    }

    public static BinaryTreeNode<Integer> deleteLeafNodes(BinaryTreeNode<Integer> root){
        if(root==null)
            return null;
        
        if(root.left==null  && root.right==null)
            return null;


        root.left=deleteLeafNodes(root.left);
        root.right=deleteLeafNodes(root.right);

        return root;
    }

    static int height(BinaryTreeNode<Integer> root){
        if(root==null)
            return 0;
        
        int leftAns=height(root.left);
        int rightAns=height(root.right);

        return 1+Math.max(leftAns, rightAns);
    }
    public static boolean isBalancedOrNot(BinaryTreeNode<Integer> root){
        if(root==null)
            return true;
        
        int heightleft=height(root.left);
        int heightright=height(root.right);

        int res=Math.abs(heightleft-heightright);
        if(res>1){
            return false;
        }   

        //here first we cheked root and then checking left and then right , so when we goto left then it acts as root where we heck first root 
        boolean isLeftBalanced=isBalancedOrNot(root.left);
        boolean isRightBalancec=isBalancedOrNot(root.right);

        return isLeftBalanced && isRightBalancec;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> rootLeft=new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> rootRight=new BinaryTreeNode<Integer>(3);

        root.left=rootLeft;
        root.right=rootRight;

        BinaryTreeNode<Integer> twoRight=new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> threeLeft=new BinaryTreeNode<Integer>(5);

        rootLeft.right=twoRight;
        rootRight.left=threeLeft;


        root.printTree(root);
        System.out.println();

        System.out.println("more detiasled");
        printDetailedTree(root);


        //take Input Dynamically 
        // BinaryTreeNode<Integer> dynamicRoot=takeInput();
        // BinaryTreeNode<Integer> dynamicRoot =takeInput(true);
        // dynamicRoot.printDetailedTree(dynamicRoot);

        //levelwise i/p -codinng will always be in this fashion 

        // BinaryTreeNode<Integer> levelWiseRoot=levelWiseInput();
        // printDetailedTree(levelWiseRoot);

        // printlevelWiseTree(levelWiseRoot);


        //largest node 
        // System.out.println("Largest Node");
        // System.out.println(largestNode(root));

        // System.out.println("nr of leafs ");
        // System.out.println(leafOfTree(root));

        // System.out.println("level 2");
        // depthOftree(root,2);


        //-----------------------Binary Trees 2
        // System.out.println("delete leaf nodes");
        // printDetailedTree(deleteLeafNodes(root));

        System.out.println("Balancedree");
        System.out.println(isBalancedOrNot(rootRight)==false?"NotBalanced":"Balanced");
    }

    // target printing more explicit way how data is stored 
    //1:L2,R3
    // 2:R4
    // 4:
    // 3:L5

}
