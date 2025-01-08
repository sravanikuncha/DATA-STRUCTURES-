import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class NodeAndPresent{
    boolean present;
    int nodeData;

    NodeAndPresent(boolean present,int nodeData){
        this.present=present;
        this.nodeData=nodeData;
    }
}


class BSTMinMaxHeight{
    int min;
    int max;
    int height;
    boolean isBST;

    BSTMinMaxHeight(int min,int max,int height,boolean isBST){
        this.min=min;
        this.max=max;
        this.height=height;
        this.isBST=isBST;
    }
}

class MaxMinBST{
    int min;
    int max;
    boolean isBSt;

    MaxMinBST(int min,int max,boolean isBSt){
        this.max=max;
        this.min=min;
        this.isBSt=isBSt;
    }
}
public class BSTPractice {
   static  Scanner sc=new Scanner(System.in);


    private  BinaryTreeNodePractice constructTree(){
        System.out.println("Enter roots data");
        int data=sc.nextInt();
        if(data!=-1){
        BinaryTreeNodePractice bst=new BinaryTreeNodePractice(data);
        Queue<BinaryTreeNodePractice> queue=new LinkedList<>();
        queue.add(bst);
        while(!queue.isEmpty()){
            BinaryTreeNodePractice front=queue.poll();
            System.out.println("Enter left of "+front.data+" child");
            data=sc.nextInt();
            if(data!=-1){
                front.left=new BinaryTreeNodePractice(data);
                queue.add(front.left);
            }

            System.out.println("Enter right of "+front.data+" child");
            data=sc.nextInt();
            if(data!=-1){
                front.right=new BinaryTreeNodePractice(data);
                queue.add(front.right);
            }
        }
        return bst;
    }
    else{
        return null;
    }
        
        
    }

    private static  int getMaxValue(BinaryTreeNodePractice root){
        if(root==null){
            return Integer.MIN_VALUE;
        }

        int leftAns=getMaxValue(root.left);
        int rightAns=getMaxValue(root.right);

        return Math.max(root.data,Math.max(leftAns, rightAns));
    }

    private static int getMinValue(BinaryTreeNodePractice root){
        if(root==null){
            return Integer.MAX_VALUE;
        }

        int leftAns=getMinValue(root.left);
        int rightAns=getMinValue(root.right);
        
        return Math.min(root.data,Math.min(leftAns,rightAns));
    }

    private static boolean checkIfBST(BinaryTreeNodePractice root){
        if(root==null){
            return true;
        }

        int leftAns=getMaxValue(root.left);
        int rightAns=getMinValue(root.right);

        boolean rootAns=false;
        if(root.data>=leftAns && root.data<rightAns){
            rootAns=true;
        }

        if(!rootAns){
            return false;
        }

        boolean leftBST=checkIfBST(root.left);
        boolean rightBST=checkIfBST(root.right);

        return rootAns && leftBST && rightBST;


    }

    private static MaxMinBST checkIfBSTBetterSolution(BinaryTreeNodePractice root){
        if(root==null){
            return new MaxMinBST(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        MaxMinBST leftAns=checkIfBSTBetterSolution(root.left);
        MaxMinBST rightAns=checkIfBSTBetterSolution(root.right);

        int min=Math.min(leftAns.min,Math.min(root.data,rightAns.min));
        int max=Math.max(leftAns.max,Math.max(root.data,rightAns.max));

        if(!leftAns.isBSt || !rightAns.isBSt){
            return new MaxMinBST(min, max, false);
        }
        else{
            if(root.data>=leftAns.max && root.data<rightAns.min){
                return new MaxMinBST(min,max,true);
            }
            return new MaxMinBST(min, max, false);
        }
    }

    private static boolean isNodePresent(BinaryTreeNodePractice root,int k){
        if(root==null){
            return false;
        }

        if(root.data==k){
            return true;
        }

        if(k<root.data){
            return isNodePresent(root.left, k);
        }
        return isNodePresent(root.right, k);
    }

    private static void elementsBetweenk1andK2(BinaryTreeNodePractice root,int k1,int k2){
        if(root==null){
            return ;
        }

        if(k1<root.data && k2<root.data){
           elementsBetweenk1andK2(root.left, k1, k2);
        }

        else if(k1>root.data && k2>root.data){
            elementsBetweenk1andK2(root.right, k1, k2);
        }

        else{
            elementsBetweenk1andK2(root.left, k1, root.data);
            System.out.print(root.data+" ");
            elementsBetweenk1andK2(root.right, root.data, k2);
        }
    }

    private  static BinaryTreeNodePractice constructBST(int[] arr,int i,int j){
        if(i>j){
            return null;
        }

        int mid=(i+j)/2;

        BinaryTreeNodePractice root=new BinaryTreeNodePractice(arr[mid]);
        BinaryTreeNodePractice leftAns=constructBST(arr, i, mid-1);
        BinaryTreeNodePractice rightAns=constructBST(arr, mid+1, j);

        root.left=leftAns;
        root.right=rightAns;

        return  root;
    }

    private static void printBSTPractice(BinaryTreeNodePractice root){

        if(root==null){
            return;
        }

        System.out.print(root.data+ " ");
        printBSTPractice(root.left);
        printBSTPractice(root.right);
    }


    private static NodePractice convertBSTToLLPractice(BinaryTreeNodePractice root){
        if(root==null){
            return null;
        }


        NodePractice leftHead=convertBSTToLLPractice(root.left);
        NodePractice midHead=new NodePractice(root.data, null);
        NodePractice rightHead=convertBSTToLLPractice(root.right);
        midHead.next=rightHead;
        NodePractice temp=leftHead;
        
        if(temp!=null){
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=midHead;
            return leftHead;
        }
        else{
            return midHead;
        }
    }

    private static NodeAndPresent LCAPractice(BinaryTreeNodePractice root, int a, int b){
        if(root==null){
            return new NodeAndPresent(false, -1);
        }
        if(root.data==a){
            return new NodeAndPresent(true, a);
        }
        else if(root.data==b){
            return new NodeAndPresent(true, b);
        }

        

        if(a<root.data && b>root.data){
            NodeAndPresent leftAns=LCAPractice(root.left, a, b);
            NodeAndPresent rightAns=LCAPractice(root.right, a, b);
            if(leftAns.present && rightAns.present){
                return new NodeAndPresent(true,root.data);
            }
            else if(leftAns.present){
                return new NodeAndPresent(true, leftAns.nodeData);
            }
            else if(rightAns.present){
                return new NodeAndPresent(true, rightAns.nodeData);
            }
            else{
                return new NodeAndPresent(false, -1);
            }
        }

        else if(a<root.data && b<root.data){
            return LCAPractice(root.left, a, b);
        }

        else{
            return LCAPractice(root.right, a, b);
        }
    }

    private static void replaceWithSumOfGreaterNodes(BinaryTreeNodePractice root,int[] sum){
        if(root==null){
            return;
        }

        replaceWithSumOfGreaterNodes(root.right, sum);
        sum[0]=sum[0]+root.data;
        root.data=sum[0];
        replaceWithSumOfGreaterNodes(root.left, sum);
    }

    private static void findPathBSTPractice(BinaryTreeNodePractice root,ArrayList<Integer> ans,int nodeData){
        if(root==null){
            return ;
        }

        if(root.data==nodeData){
            ans.add(root.data);
            return ;
        }

        if(nodeData<root.data){
            findPathBSTPractice(root.left, ans, nodeData);           
        }
        else{
            findPathBSTPractice(root.right, ans, nodeData);
        }
        if(ans.size()>0){
            ans.add(root.data);
        }

        return;
    }

    private static void insert(BinaryTreeNodePractice root, BinaryTreeNodePractice parentNode,int insertEle){
        if(root==null){
            if(insertEle<parentNode.data)
                parentNode.left=new BinaryTreeNodePractice(insertEle);
            else
                parentNode.right=new BinaryTreeNodePractice(insertEle);
            return;
        }

        if(insertEle<root.data){
            insert(root.left, root, insertEle);
        }
        else{
            insert(root.right, root, insertEle);
        }
    }

    private static BinaryTreeNodePractice delete(BinaryTreeNodePractice root,BinaryTreeNodePractice parentNode,int deleteEle){
        if(root==null){
            return null;
        }

        

        if(deleteEle<root.data){
            BinaryTreeNodePractice leftAns= delete(root.left,root, deleteEle);
            root.left=leftAns;
            return root;
        }

        else if(deleteEle>root.data){
            BinaryTreeNodePractice rightAns= delete(root.right,root, deleteEle);
            root.right=rightAns;
            return root;
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }
            else if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            else{
                int min=getMinValue(root.right);
                root.data=min;
                BinaryTreeNodePractice rightAns=delete(root.right,root, min);
                root.right=rightAns;
                return root;
            }
        }

        
    }

    private static ArrayList<NodePractice> levelBSTLL(BinaryTreeNodePractice root){

        if(root==null){
            return null;
        }
        Queue<BinaryTreeNodePractice> queue=new LinkedList<>();

        queue.add(root);
        NodePractice head=new NodePractice(root.data, null);
        ArrayList<NodePractice> res=new ArrayList<>();
        res.add(head);
        while(!queue.isEmpty()){
            int size=queue.size();            
            NodePractice temp=null;
            head=null;
            while(size>0){
                BinaryTreeNodePractice front=queue.poll();
                if(front.left!=null){
                    queue.add(front.left);
                    if(head==null){
                        head=new NodePractice(front.left.data, null);
                        temp=head;
                    }
                    else{
                        temp.next=new NodePractice(front.left.data, null);
                        temp=temp.next;
                    }
                }
                if(front.right!=null){
                    queue.add(front.right);
                    if(head==null){
                        head=new NodePractice(front.right.data, null);
                        temp=head;
                    }
                    else{
                        temp.next=new NodePractice(front.right.data, null);
                        temp=temp.next;
                    }
                }

              
                size--;
            }
            res.add(head);
        }
        return res;
    }


    private static BSTMinMaxHeight findLargestBST(BinaryTreeNodePractice root){
        if(root==null){
            return new BSTMinMaxHeight(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        BSTMinMaxHeight leftBST=findLargestBST(root.left);
        BSTMinMaxHeight rightBST=findLargestBST(root.right);

        int min=Math.min(root.data,Math.min(leftBST.min,rightBST.min));
        int max=Math.max(root.data,Math.max(leftBST.max,rightBST.max));
        
        int actualHeight=Math.max(leftBST.height,rightBST.height);

        

        if(leftBST.isBST && rightBST.isBST){    
            if(leftBST.max<root.data && rightBST.min>=root.data){
                return new BSTMinMaxHeight(min, max, actualHeight+1, true);
            }
        }
        return new BSTMinMaxHeight(min, max, actualHeight, false);
    }

    private static void getValues(BinaryTreeNodePractice root,ArrayList<Integer> res){
        if(root==null){
            return;
        }

        getValues(root.left, res);
        res.add(root.data);
        getValues(root.right, res);
    }


    private static void pairSumToS(BinaryTreeNodePractice root,int s){
        ArrayList<Integer> res=new ArrayList<>();
        getValues(root,res);

        int j=res.size()-1;
        int i=0;

        while(i<j){
            if(res.get(i)+res.get(j)>s){
                j--;
            }
            else if(res.get(i)+res.get(j)<s){
                i++;
            }
            else{
                System.out.println(res.get(i)+ " "+res.get(j));
                i++;
                j--;
            }
        }

    }


    public static void main(String[] args) {
        BSTPractice bst=new BSTPractice();
        BinaryTreeNodePractice root=bst.constructTree();

        // System.out.println("Checkinng is BST ");
        // System.out.println(checkIfBST(root));

        // MaxMinBST ans=checkIfBSTBetterSolution(root);
        // System.out.println(ans.isBSt);

        //10 6 15 4 8 14 18 3 -1 7 -1 -1 -1 16 -1 -1 -1 -1 -1 -1 -1  --true
        //10 6 15 4 8 14 18 3 -1 5 -1 -1 -1 16 -1 -1 -1 -1 -1 -1 -1  --false

        // System.out.println(isNodePresent(root,13));

        // elementsBetweenk1andK2(root,3,8);

        // int n=sc.nextInt();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i]=sc.nextInt();
        // }
        // BinaryTreeNodePractice root= constructBST(arr,0,n-1);
        // printBSTPractice(root);

        
        // NodePractice res=convertBSTToLLPractice(root);
        // while(res!=null){
        //     System.out.print(res.data+" ");
        //     res=res.next;
        // }

        // int a=sc.nextInt();
        // int b=sc.nextInt();
        // NodeAndPresent res= LCAPractice(root,a,b);
        // System.out.println(res.nodeData);
        
        // int[] arr=new int[1];
        // replaceWithSumOfGreaterNodes(root,arr);
        // printBSTPractice(root);

        // ArrayList<Integer> path=new ArrayList<>();
        // int nodeData=sc.nextInt();
        // findPathBSTPractice(root,path,nodeData);
        // for(int i:path){
        //     System.out.print(i+" ");
        // }

        //i/p: 8 5 10 2 6 -1 -1 -1 3 -1 7 -1 -1 -1 -1 
        // printBSTPractice(root);
        // insert(root,null,3);
        // System.out.println();
        // printBSTPractice(root);

        // BinaryTreeNodePractice newRoot=delete(root,null,6);
        // printBSTPractice(newRoot);

        // ArrayList<NodePractice> ans= levelBSTLL(root);
        // for(NodePractice i:ans){
        //     NodePractice temp=i;
        //     while(temp!=null){
        //         System.out.print(temp.data+" ");
        //         temp=temp.next;
        //     }
        //     System.out.println();
        // }

        // BSTMinMaxHeight res=findLargestBST(root);
        // System.out.println(res.height);
        
        int sum=sc.nextInt();
        pairSumToS(root,sum);
    }
}
