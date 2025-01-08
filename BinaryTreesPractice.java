import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class HeightDiameterPractice{
    int height;
    int diameter;

    HeightDiameterPractice(int height,int diameter){
        this.height=height;
        this.diameter=diameter;
    }
}
class MinandMax{
    int min;
    int max;

    MinandMax(int min,int max){
        this.min=min;
        this.max=max;
    }
}

class HeightAndBalanced{
    boolean isBalanced;
    int height;

    HeightAndBalanced(int height,boolean isBalanced){
        this.height=height;
        this.isBalanced=isBalanced;
    }
}
class BinaryTreeNodePractice{
    int data;
    BinaryTreeNodePractice left;
    BinaryTreeNodePractice right;

    BinaryTreeNodePractice(){}

    BinaryTreeNodePractice(int data){
        this.data=data;
        left=null;
        right=null;
    }
    
    BinaryTreeNodePractice buildTree(int data){
        Scanner sc=new Scanner(System.in);
        BinaryTreeNodePractice root=new BinaryTreeNodePractice(data);
        System.out.println("Enter left  data of "+root.data+" node");
        data=sc.nextInt();
        BinaryTreeNodePractice leftAns=null,rightAns=null;
        if(data!=-1){
             leftAns=buildTree(data);
        }
        System.out.println("Enter right  data of "+root.data+" node");
        data=sc.nextInt();
        if(data!=-1){
            rightAns=buildTree(data);
        }
        root.left=leftAns;
        root.right=rightAns;
        sc.close();
        return root;
    }
    
}
public class BinaryTreesPractice {
   
    static Scanner sc=new Scanner(System.in);

    BinaryTreeNodePractice buildTreeRecursively(int data){
        
        BinaryTreeNodePractice root=new BinaryTreeNodePractice(data);
        System.out.println("Enter left  data of "+root.data+" node");
        data=sc.nextInt();
        BinaryTreeNodePractice leftAns=null,rightAns=null;
        if(data!=-1){
             leftAns=buildTreeRecursively(data);
        }
        System.out.println("Enter right  data of "+root.data+" node");
        data=sc.nextInt();
        if(data!=-1){
            rightAns=buildTreeRecursively(data);
        }
        root.left=leftAns;
        root.right=rightAns;
        return root;
    }

     static void printBinaryTreePractice(BinaryTreeNodePractice root){
        if(root==null){
            return;
        }

        printBinaryTreePractice(root.left);
        System.out.print(root.data+" ");
        printBinaryTreePractice(root.right);
    }

    private  BinaryTreeNodePractice buildTreeLevelWise(){
        System.out.println("Enter roots data");
        int data=sc.nextInt();
        Queue<BinaryTreeNodePractice> queue=new LinkedList<>();
        BinaryTreeNodePractice root=new BinaryTreeNodePractice(data);
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNodePractice tempNode=queue.poll();
            System.out.println("Enter left of "+tempNode.data+" node");
            data=sc.nextInt();
            if(data!=-1){
                BinaryTreeNodePractice leftNode=new BinaryTreeNodePractice(data);
                queue.add(leftNode);
                tempNode.left=leftNode;
            }
            System.out.println("Enter right of "+tempNode.data+" node");
            data=sc.nextInt();
            if(data!=-1){
                BinaryTreeNodePractice rightNode=new BinaryTreeNodePractice(data);
                queue.add(rightNode);
                tempNode.right=rightNode;
            }          
        }

        sc.close();
        return root;
    }

    private static void printDetailedTreePractice(BinaryTreeNodePractice root){
        if(root==null){
                return;
        }

        System.out.print(root.data+" -");
        if(root.left!=null){
            System.out.print(" L:"+root.left.data);
        }
        if(root.right!=null){
            System.out.print(" R:"+root.right.data);
        }
        System.out.println();

        printDetailedTreePractice(root.left);
        printDetailedTreePractice(root.right);
    }

    private static void printDetailedTreeLevelWise(BinaryTreeNodePractice root){
        if(root==null){
            return ;
        }

        Queue<BinaryTreeNodePractice> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNodePractice tempNode=queue.poll();
            System.out.print(tempNode.data+" -");
            if(tempNode.left!=null){
                System.out.print(" L:"+tempNode.left.data);
                queue.add(tempNode.left);
            }

            if(tempNode.right!=null){
                System.out.print(" R:"+tempNode.right.data);
                queue.add(tempNode.right);
            }
            System.out.println();
        }
    }   

    private static void treeToDepth(BinaryTreeNodePractice root, int k){
        if(root==null){
            return ;
        }

        root.data=k;
        treeToDepth(root.left,k+1);
        treeToDepth(root.right,k+1);
    }

    private static HeightDiameterPractice diameterPractice(BinaryTreeNodePractice root){
        if(root==null){
            return new HeightDiameterPractice(0, 0);
        }

        HeightDiameterPractice leftHD=diameterPractice(root.left);
        HeightDiameterPractice rightHD=diameterPractice(root.right);

        int tempDiameter=leftHD.height+rightHD.height+1;
        int leftDiameter=leftHD.diameter;
        int rightDiameter=rightHD.diameter;

        int finalDiameter=Math.max(tempDiameter,Math.max(leftDiameter, rightDiameter));
        int heightOfTree=Math.max(leftHD.height,rightHD.height)+1;

        return new HeightDiameterPractice(heightOfTree, finalDiameter);
    }

    private static void nodesWithoutSiblingsPractice(BinaryTreeNodePractice root){
        if(root==null){
            return ;
        }

        if(root.left!=null && root.right==null){
            System.out.println(root.left.data);
            nodesWithoutSiblingsPractice(root.left);
        }

        else if(root.left==null && root.right!=null){
            System.out.println(root.right.data);
            nodesWithoutSiblingsPractice(root.right);
        }
        else{
            nodesWithoutSiblingsPractice(root.left);
            nodesWithoutSiblingsPractice(root.right);
        }
    }

    private static BinaryTreeNodePractice mirrorBinaryTreePractice(BinaryTreeNodePractice root){
        if(root==null){
            return root;
        }

        BinaryTreeNodePractice leftAns=mirrorBinaryTreePractice(root.left);
        BinaryTreeNodePractice rightAns=mirrorBinaryTreePractice(root.right);

        root.left=rightAns;
        root.right=leftAns;

        return root;
        
    }

    private static HeightAndBalanced isBalanced(BinaryTreeNodePractice root){
        if(root==null){
            return new HeightAndBalanced(0, true);
        }

        HeightAndBalanced lefHeightAndBalanced=isBalanced(root.left);
        HeightAndBalanced rightHeightAndBalanced=isBalanced(root.right);

        int tempHeight=lefHeightAndBalanced.height-rightHeightAndBalanced.height;
        tempHeight=tempHeight<0?tempHeight*-1:tempHeight;
        Boolean isFullyBalanced=false;

        int height=Math.max(lefHeightAndBalanced.height,rightHeightAndBalanced.height)+1;
        if(tempHeight<=1 && lefHeightAndBalanced.isBalanced && rightHeightAndBalanced.isBalanced){
            isFullyBalanced=true;
        }
        return new HeightAndBalanced(height, isFullyBalanced);
    }

    private static MinandMax minAndMaxTreePractice(BinaryTreeNodePractice root){
        if(root==null){
            return new MinandMax(Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        MinandMax leftAns=minAndMaxTreePractice(root.left);
        MinandMax rightAns=minAndMaxTreePractice(root.right);

        int min=Math.min(leftAns.min,Math.min(rightAns.min,root.data));
        int max=Math.max(leftAns.max,Math.max(rightAns.max, root.data));

        return new MinandMax(min, max);
    }

    private static BinaryTreeNodePractice createAndInsertDuplicateNodePractice(BinaryTreeNodePractice root){
        if(root==null){
            return root;
        }

        BinaryTreeNodePractice newNode=new BinaryTreeNodePractice(root.data);
        
        BinaryTreeNodePractice leftAns=createAndInsertDuplicateNodePractice(root.left);
        BinaryTreeNodePractice rightAns=createAndInsertDuplicateNodePractice(root.right);

        newNode.left=leftAns;
        root.left=newNode;

        return root;

    }

    private static void pathSumRootToLeafPractice(BinaryTreeNodePractice root,Stack<Integer> arr,int k){
        if(root==null){
            return;
        }

        arr.add(root.data);
        if(root.left==null && root.right==null){
            int sum=0;
            for(int i=0;i<arr.size();i++){
                sum+=arr.get(i);
            }
            if(sum==k){
                for(int i=0;i<arr.size();i++){
                   System.out.print(arr.get(i)+" ");
                }
                System.out.println();
            }
        }

        pathSumRootToLeafPractice(root.left, arr, k);
        pathSumRootToLeafPractice(root.right, arr, k);
        arr.pop();
    }

    
    public static void main(String[] args) {
        BinaryTreesPractice tree=new BinaryTreesPractice();
        // BinaryTreeNodePractice root=tree.buildTreeRecursively(1);
        BinaryTreeNodePractice root=tree.buildTreeLevelWise();
        // printDetailedTreePractice(root);
        
        // System.out.println("Replace Tree nodes with depth");
        // treeToDepth(root,0);

        // nodesWithoutSiblingsPractice(root);
        // root=mirrorBinaryTreePractice(root);

        // HeightDiameterPractice diameter=diameterPractice(root);
        // System.out.println(diameter.diameter);

        // HeightAndBalanced isBalanced=isBalanced(root);
        // System.out.println(isBalanced.isBalanced);

        // printDetailedTreeLevelWise(root);
        // createAndInsertDuplicateNodePractice(root);

        // MinandMax minMax= minAndMaxTreePractice(root);
        // System.out.println(minMax.max+" "+minMax.min);

        // Stack<Integer> arr=new Stack<>();
        // pathSumRootToLeafPractice(root,arr,13);


        // printBinaryTreePractice(root);
        // printDetailedTreePractice(root);
        // printDetailedTreeLevelWise(root);
    }
}
