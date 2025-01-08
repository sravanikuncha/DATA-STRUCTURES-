import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNodePractice{
    int data;
    ArrayList<TreeNodePractice> childrenNodes;

    TreeNodePractice(int data){
        this.data=data;
        this.childrenNodes=new ArrayList<>();
    }
}

class FirstSecond{
    int first;
    int second;

    FirstSecond(int first,int second){
        this.first=first;
        this.second=second;
    }
}


public class TressPractice {

    static Scanner sc=new Scanner(System.in);

    private  TreeNodePractice takeInput(){
        System.out.println("Enter roots data");
        int data=sc.nextInt();
        Queue<TreeNodePractice> queue=new LinkedList<>();
        TreeNodePractice root=null;
        if(data!=-1){
           root =new TreeNodePractice(data);
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNodePractice front=queue.poll();
                System.out.println("Enter number of child nodes for "+front.data);
                int n=sc.nextInt();
                while(n>0){
                    System.out.println("Enter "+front.data+ " children");
                    data=sc.nextInt();
                    TreeNodePractice childNode=new TreeNodePractice(data);
                    front.childrenNodes.add(childNode);
                    queue.add(childNode);
                    n--;
                }
            }
        }


        return root;
    } 

    private static void printLevelWiseTree(TreeNodePractice root){
        Queue<TreeNodePractice> queue=new LinkedList<>();
        if(root==null){
            return;
        }
        queue.add(root);
        System.out.print(root.data+" ");
        while(!queue.isEmpty()){
            TreeNodePractice front =queue.poll();
            for(int i=0;i<front.childrenNodes.size();i++){
                System.out.print(front.childrenNodes.get(i).data+" ");
                queue.add(front.childrenNodes.get(i));
            }
        }
    }

    private static void printDepthTree(TreeNodePractice root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        for(int i=0;i<root.childrenNodes.size();i++){
            printDepthTree(root.childrenNodes.get(i));
        }

    }

    private static int sumOfAllNodesPractice(TreeNodePractice root){
        if(root==null){
            return 0;
        }

        int sum=0;
        sum+=root.data;
        for(int i=0;i<root.childrenNodes.size();i++){
            sum+=sumOfAllNodesPractice(root.childrenNodes.get(i));
        }

        return sum;
    }

    private static int nrOfNodesPractice(TreeNodePractice root,int x){
        if(root==null){
            return 0;
        }

        int nrOfNodes=0;
        if(root.data>x){
            nrOfNodes=1;
        }

        for(int i=0;i<root.childrenNodes.size();i++){
            nrOfNodes+=nrOfNodesPractice(root.childrenNodes.get(i), x);
        }

        return nrOfNodes;
    }

    private static int heightTreePractice(TreeNodePractice root){
        if(root==null){
            return 0;
        }

        int height=0;
         
        for(int i=0;i<root.childrenNodes.size();i++){
            int smallTreeHeight=heightTreePractice(root.childrenNodes.get(i));
            height=Math.max(smallTreeHeight,height);
        }

        return height+1;
    }

    private static int nrOfleafNodesPractice(TreeNodePractice root){
        if(root==null){
            return 0;
        }

        int nrOfLeafNodes=0;

        if(root.childrenNodes.size()==0){
            nrOfLeafNodes=1;
        }

        for(int i=0;i<root.childrenNodes.size();i++){
            nrOfLeafNodes+=nrOfleafNodesPractice(root.childrenNodes.get(i));
        }

        return nrOfLeafNodes;

    }

    private  static void postOrderTravesalTreePractice(TreeNodePractice root){
        if(root==null){
            return ;
        }

        for(int i=0;i<root.childrenNodes.size();i++){
            postOrderTravesalTreePractice(root.childrenNodes.get(i));
        }

        System.out.print(root.data+" ");
    }

    private static boolean checkIfContainsX(TreeNodePractice root, int checkNnode){
        if(root==null){
            return false;
        }

        if(root.data==checkNnode){
            return true;
        }

        boolean nodePresent=false;
        for(int i=0;i<root.childrenNodes.size();i++){
            nodePresent=nodePresent ||  checkIfContainsX(root.childrenNodes.get(i), checkNnode);
        }

        return nodePresent;
    }

    private static  TreeNodePractice maxSumNodePractice(TreeNodePractice root){
        if(root==null){
            return root;
        }

        TreeNodePractice targetNode=null;

        Queue<TreeNodePractice> queue=new LinkedList<>();
        queue.add(root);
        int maxSum=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            TreeNodePractice front=queue.poll();
            int sum=front.data;
            for(int i=0;i<front.childrenNodes.size();i++){
                sum+=front.childrenNodes.get(i).data;
                queue.add(front.childrenNodes.get(i));
            }
            if(sum>maxSum){
                maxSum=sum;
                targetNode=front;
            }
        }

        return targetNode;

    }

    private static boolean isIdentical(TreeNodePractice root,TreeNodePractice root1){
        if(root==null && root1!=null){
            return false;
        }
        
        else if(root!=null && root1==null){
            return false;
        }

        else if(root==null && root1==null){
            return true;
        }

        else{
            boolean isIdentical=false;
            if(root.childrenNodes.size()==root1.childrenNodes.size() && root.data==root1.data){
                isIdentical=true;
                for(int i=0;i<root.childrenNodes.size();i++){
                    isIdentical= isIdentical && isIdentical(root.childrenNodes.get(i),root1.childrenNodes.get(i));
                }
            }
            else{
                isIdentical=false;
            }

            return isIdentical;
        }
    }

    private static TreeNodePractice nextLargestElement(TreeNodePractice root, int x){
        if(root==null){
            return null;
        }

        int nextLargestElement=Integer.MAX_VALUE;
        TreeNodePractice targetNode=null;
        if(root.data>x){
            nextLargestElement=root.data;
            targetNode=root;
        }

        for(int i=0;i<root.childrenNodes.size();i++){
            TreeNodePractice nextLargestEleNode=nextLargestElement(root.childrenNodes.get(i), x);
            if(nextLargestEleNode.data>x && nextLargestEleNode.data<nextLargestElement){
                nextLargestElement=nextLargestEleNode.data;
                targetNode=nextLargestEleNode;
            }
        }
        

        return targetNode;
    }

    private static int getnextEle(int[] values, int lastEle){
        for(int i=2;i>0;i--){
            if(lastEle!=values[i]){
                return values[i];
            }
        }
        return values[0];
    }
    private static FirstSecond secondLargestElementPractice(TreeNodePractice root){
        if(root==null){
            return new FirstSecond(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        FirstSecond rootFirstSecond= new FirstSecond(root.data, Integer.MIN_VALUE);

        for(int i=0;i<root.childrenNodes.size();i++){
            FirstSecond smallTreeAns=secondLargestElementPractice(root.childrenNodes.get(i));
            int[] values={rootFirstSecond.first,rootFirstSecond.second,smallTreeAns.first,smallTreeAns.second};
            Arrays.sort(values);
            rootFirstSecond.first=values[3];
            rootFirstSecond.second=getnextEle(values,values[3]);         
        }

        return rootFirstSecond;
    }

    private static void replaceNodeDepthPractice(TreeNodePractice root,int depth){
        if(root==null){
            return ;
        }

        root.data=depth;

        for(int i=0;i<root.childrenNodes.size();i++){
            replaceNodeDepthPractice(root.childrenNodes.get(i), depth+1);
        }
    }

    public static void main(String[] args) {
        //10 3 30 50 25 2 5 45 1 56 1 34 0 0 0 0
        TressPractice tree=new TressPractice();
        TreeNodePractice root=tree.takeInput();
        printLevelWiseTree(root);
        // printDepthTree(root);
        System.out.println();

        // int sumOfAllNodes=sumOfAllNodesPractice(root);
        // System.out.println(sumOfAllNodes);
        
        // System.out.println("Nr of Nodes greater than x");
        // int x=sc.nextInt() ;
        // int nrOfNodes=nrOfNodesPractice(root,x);
        // System.out.println(nrOfNodes);


        // int height=heightTreePractice(root);
        // System.out.println(height);

        // int nrOfLeafNodes=nrOfleafNodesPractice(root);
        // System.out.println(nrOfLeafNodes);

        // postOrderTravesalTreePractice(root);

        // int checkNnode=sc.nextInt();
        // boolean nodePresentPractice=checkIfContainsX(root,checkNnode);
        // System.out.println(nodePresentPractice);

        // TreeNodePractice maxNode=maxSumNodePractice(root);
        // System.out.println(maxNode.data);

        // TreeNodePractice root1=tree.takeInput();
        // System.out.println(isIdentical(root,root1));

        // System.out.println(" Enter data of Which next largest Element need to be found");
        // int x=sc.nextInt();
        // System.out.println(nextLargestElement(root,x).data);

        // FirstSecond fs=secondLargestElementPractice(root);
        // System.out.println(fs.second);

        replaceNodeDepthPractice(root,0);
        printLevelWiseTree(root);
    }
}
