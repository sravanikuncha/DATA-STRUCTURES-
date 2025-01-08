import java.util.Scanner;

class NodePractice{
    int data;
    NodePractice next;

    NodePractice(int data,NodePractice next){
        this.data=data;
        this.next=next;
    }
}

public class LinkedListRecursive {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter first ele");
        int data=sc.nextInt();
        NodePractice head=null,prevtempNode=null;
        while(data!=-1){
            NodePractice newNode=new NodePractice(data,null);
            if(head==null){
                head=newNode;
                prevtempNode=newNode;
            }
            else{
                prevtempNode.next=newNode;
                prevtempNode=newNode;
            }
            System.out.println("nextEle");
            data=sc.nextInt();
        }
        //second LL 
        // data=sc.nextInt();
        // NodePractice head2=null;
        // prevtempNode=null;
        // while(data!=-1){
        //     NodePractice newNode=new NodePractice(data,null);
        //     if(head2==null){
        //         head2=newNode;
        //         prevtempNode=newNode;
        //     }
        //     else{
        //         prevtempNode.next=newNode;
        //         prevtempNode=newNode;
        //     }
        //     System.out.println("nextEle");
        //     data=sc.nextInt();
        // }

        printLinkedList(head);
        // printLinkedList(head2);
        System.out.println();
        // NodePractice temp1=head;
        // NodePractice temp2=head2;

        NodePractice temp=head;

        // NodePractice newHead=mergerTwoSortedLL(temp1,temp2);

        // NodePractice newHead=mergeSortLL(temp);

        // NodePractice newHead=evenAfterOdd(temp);
        // deleteEveryNNodes(temp,2,3);
        // printLinkedList(temp);

        // NodePractice newHead= swapNode(temp,0,6);

        // NodePractice newHead=reverseLinkedListIteratively(temp);
        // NodePractice newHead=kReverse(temp,4);
        NodePractice newHead=bubbleSort(temp);
        printLinkedList(newHead);

        // System.out.println(findElementIteratively(temp,5));

        // System.out.println(findElementRecursively(temp,9,0));

        // NodePractice newHead=appendNToFirst(temp,head,3);

        // NodePractice newHead=removeduplicates(temp);

        // NodePractice newHead=deleteNodeRecursively(temp,0,0);

        // NodePractice newHead=reverseLLRecursively(temp);

        // midPoint(temp);
        
        // printLinkedList(newHead);s
        sc.close();
    }

    private static NodePractice bubbleSort(NodePractice temp){
        NodePractice head=temp;

        while(temp!=null){
            NodePractice firstTemp=head,secondTemp=firstTemp.next;
            while(secondTemp!=null){
                if(firstTemp.data>=secondTemp.data){
                    int swap=firstTemp.data;
                    firstTemp.data=secondTemp.data;
                    secondTemp.data=swap;
                }
                firstTemp=secondTemp;
                secondTemp=secondTemp.next;
            }
            temp=temp.next;
        }
        return head;
    }

    private static NodePractice kReverse(NodePractice temp,int k){

        if(temp==null){
            return temp;
        }
        NodePractice headTemp=temp,lastTemp=null,prevTemp=null;

        int index=1;

        while(temp!=null){
            if(index==k){
                lastTemp=temp;
                break;
            }
            prevTemp=temp;
            temp=temp.next;
            index++;
        }
        if(index<k){
            lastTemp=prevTemp;
        }

        NodePractice smallTemp=lastTemp.next;
        lastTemp.next=null;
        NodePractice newHead=reverseLinkedListIteratively(headTemp);
        NodePractice smallAns=kReverse(smallTemp, k);
        headTemp.next=smallAns;

        return newHead;

    }

    private static NodePractice reverseLinkedListIteratively(NodePractice temp){
        NodePractice lastNode=temp,prevTemp=temp,nextTemp=null;

        temp=temp.next;
        while(temp!=null){
            nextTemp=temp.next;
            temp.next=prevTemp;
            prevTemp=temp;
            temp=nextTemp;
        }

        lastNode.next=null;
        return prevTemp;
    }


    private static NodePractice swapNode(NodePractice temp,int i,int j){
        NodePractice newHead=temp;

        if(i>j){
            int swap=i;
            i=j;
            j=swap;
        }

        NodePractice prevtempi=null,prevtempj=null,ithNode=null,jthNode=null;
        int index=0;

        while(temp!=null){
            if(index==i-1){
                prevtempi=temp;
            }
            else if(index==i){
                ithNode=temp;
            }
            else if(index==j-1){
                prevtempj=temp;
            }
            else if(index==j){
                jthNode=temp;
            }
            temp=temp.next;
            index++;
        }   

        if(prevtempi==null){
            newHead=jthNode;
        }
        else{
            prevtempi.next=jthNode;
        }

        if(j-i!=1){
            NodePractice savei=ithNode.next;
            NodePractice savej=jthNode.next;

          
            prevtempj.next=ithNode;
            jthNode.next=savei;
            ithNode.next=savej;
        }

        else{
            NodePractice savej=jthNode.next;
            
            jthNode.next=ithNode;
            ithNode.next=savej;

        }

        return newHead;
    }

    private static void deleteEveryNNodes(NodePractice temp,int M,int N){
        if(M!=0){
         int tempM=M,tempN=N;
         NodePractice prevTemp=null;
         while(temp!=null){
            if(tempM==0){
              while(temp!=null && tempN!=0){
                 tempN--;
                 temp=temp.next;
              }
              prevTemp.next=temp;
              tempM=M;
              tempN=N;
            }
            else{
                tempM--;
                prevTemp=temp;
                temp=temp.next;
            }
         }
        }
    }

    private static NodePractice evenAfterOdd(NodePractice temp){
        NodePractice prevEven=null,evenHead=null,oddHead=null,prevOdd=null;

        while(temp!=null){
            if(temp.data%2==0){
                if(evenHead==null){
                    evenHead=temp;
                    prevEven=temp;
                }
                else{
                    prevEven.next=temp;
                    prevEven=temp;
                }
            }
            else{
                if(oddHead==null){
                    oddHead=temp;
                    prevOdd=temp;
                }
                else{
                    prevOdd.next=temp;
                    prevOdd=temp;
                }
            }
            temp=temp.next;
        }

       prevEven.next=oddHead;
       if(prevOdd!=null)
       prevOdd.next=null;
       return evenHead;

    }

    private static NodePractice mergeSortLL(NodePractice temp){
        if(temp==null || temp.next==null){
            return temp;
        }

        NodePractice midPointNode=midPointNode(temp);
        NodePractice secondList=midPointNode.next;
        midPointNode.next=null;

        NodePractice smallAns1=mergeSortLL(temp);
        NodePractice smallAns2=mergeSortLL(secondList);
        NodePractice newHead=mergerTwoSortedLL(smallAns1,smallAns2);
        return newHead;

    }

    private static NodePractice mergerTwoSortedLL(NodePractice temp1,NodePractice temp2){
        if(temp1==null){
            return temp2;
        }

        if(temp2==null){
            return temp1;
        }

        if(temp1.data>temp2.data){
            NodePractice temp=temp1;
            temp1=temp2;
            temp2=temp;
        }

        NodePractice newHead=temp1;

        NodePractice prevtemp1=null;

        while(temp1!=null && temp2!=null){
            if(temp1.data<=temp2.data){
                prevtemp1=temp1;
                temp1=temp1.next;
            }
            else{
                prevtemp1.next=temp2;
                temp2=temp2.next;
                prevtemp1.next.next=temp1;
                prevtemp1=prevtemp1.next;
            }

        }

        if(temp1==null){
            prevtemp1.next=temp2;
        }

        return newHead;
    }

    private static void midPoint(NodePractice temp){
       NodePractice firstTemp=null,secondTemp=temp;
        
       while(secondTemp.next!=null){
        firstTemp=temp;
        if(firstTemp.next!=null){
            secondTemp=firstTemp.next.next;
        }
        temp=firstTemp.next;
       }
    
       System.out.println(firstTemp.data);

    }
    
    private static NodePractice midPointNode(NodePractice temp){
        NodePractice firstTemp=null,secondTemp=temp;

         
        while(secondTemp.next!=null){
         firstTemp=temp;
         if(firstTemp.next!=null){
             secondTemp=firstTemp.next.next;
             if(secondTemp==null){
                break;
             }
         }
         temp=firstTemp.next;
        }
     
        return firstTemp;
     }


    private static NodePractice reverseLLRecursively(NodePractice temp){
        if(temp==null || temp.next==null){
            return temp;
        }

        NodePractice smallAns=reverseLLRecursively(temp.next);
        NodePractice lastNode=temp.next;
        lastNode.next=temp;
        temp.next=null;
        return smallAns;
    }

    private static NodePractice deleteNodeRecursively(NodePractice temp,int index,int sI){
        if(temp==null){
            return temp;
        }

        if(sI==index){
            return temp.next;
        }

        NodePractice smallAns=deleteNodeRecursively(temp.next, index, ++sI);
        temp.next=smallAns;
        return temp;

    }
    private static NodePractice removeduplicates(NodePractice temp){
        if(temp==null || temp.next==null){
            return temp;
        }

        NodePractice smallAns=removeduplicates(temp.next);
        if(smallAns!=null && temp.data==smallAns.data){
            return smallAns;
        }
        else{
            temp.next=smallAns;
            return temp;
        }
    }

    private static NodePractice appendNToFirst(NodePractice temp,NodePractice head,int n){
        int len=0;
        NodePractice lastNode=null,tempNode=temp;

        while(tempNode!=null){
            len++;
            lastNode=tempNode;
            tempNode=tempNode.next;
            
        }
        
        tempNode=temp;

        int cutIndex=len-n;
        int index=1;
        NodePractice prevTemp=null;

        while(tempNode!=null){
            if(index==cutIndex){
                prevTemp=tempNode;
                break;
            }
            else{
                tempNode=tempNode.next;
                index++;
            }
        }

        NodePractice newHead=prevTemp.next;
        lastNode.next=head;
        prevTemp.next=null;

        return newHead;

    }

    private static int findElementRecursively(NodePractice temp,int elementToFind,int i){
        if(temp==null){
            return -1;
        }

        if(temp.data==elementToFind){
            return i;
        }
        return findElementRecursively(temp.next, elementToFind, ++i);
    }

    private static int findElementIteratively(NodePractice temp,int elementToFind){
        int i=0;
        while(temp!=null){
            int data=temp.data;
            if(data==elementToFind){
                return i;
            }
            else{
                i++;
                temp=temp.next;
            }
        }

        return -1;
    }

    private static void printLinkedList(NodePractice head){
        NodePractice temp=head;

        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
