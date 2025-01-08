

public class BinarySearchTree {

    int  min;
    int max;
    boolean isBST;


    BinarySearchTree(int min,int max,boolean isBST){
        this.min=min;
        this.max=max;
        this.isBST=isBST;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> dynamicRoot =BinaryTreeNode.levelWiseInput();
        BinaryTreeNode.printDetailedTree(dynamicRoot);

        System.out.println(CheckisBST(dynamicRoot));

        System.out.println("optimised version");
        System.out.println(CheckisBSTOptimised(dynamicRoot).isBST);

        System.out.println("out of the boox approach");
        System.out.println(isBST3(dynamicRoot, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    public static boolean isBST3(BinaryTreeNode<Integer> root,int minrange,int maxRange){
        if(root==null)
            return true;
        
        if(minrange>root.data || maxRange<root.data) 
            return false;

        
        boolean isleftSubtree=isBST3(root.left, minrange, root.data-1);
        boolean isRightSubtree=isBST3(root.right, root.data, maxRange);

        return isRightSubtree && isleftSubtree;
    }

    public static BinarySearchTree CheckisBSTOptimised(BinaryTreeNode<Integer> root){
        if(root==null){
            return new BinarySearchTree(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
        }

        BinarySearchTree leftTreeObj=CheckisBSTOptimised(root.left);
        BinarySearchTree rightTreeObj=CheckisBSTOptimised(root.right);

        if(leftTreeObj.max<=root.data && rightTreeObj.min>root.data){
            if(leftTreeObj.isBST && rightTreeObj.isBST){
                int min=Math.min(root.data,Math.min(leftTreeObj.min,rightTreeObj.min));
                int max=Math.max(root.data,Math.max(leftTreeObj.max,rightTreeObj.max));
                return new BinarySearchTree(min, max, true);
            }
            else{
                return new BinarySearchTree(0, 0, false);
            }  
        }
        else{
            return new BinarySearchTree(0, 0, false);
        }
    }
    public static boolean CheckisBST(BinaryTreeNode<Integer> root){
        if(root==null)
            return true;
        
        int leftmax=BinaryTreeNode.largestNode(root.left);
        if(leftmax > root.data)
            return false;

        int rightmin=BinaryTreeNode.smallestnode(root.right);
        if(rightmin < root.data)
            return false;
        

        boolean isleftBST=CheckisBST(root.left);
        boolean isRightBST=CheckisBST(root.right);
        return isleftBST && isRightBST;
    }
}
