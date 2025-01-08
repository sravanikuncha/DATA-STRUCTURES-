import java.util.Scanner;

import org.w3c.dom.Node;

public class Test6 {
   public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);

    int data=sc.nextInt();

    NodeLL<Integer> head=new NodeLL<Integer>(data);
    NodeLL<Integer> temph=head;

    data=sc.nextInt();

    while(data!=-1){
        NodeLL<Integer> n=new NodeLL<Integer>(data);
        temph.next=n;
        temph=n;
        data=sc.nextInt();
    }

    Integer n=1;
    NodeLL<Integer> newHead=null,temp=head,prevTemp=head,ntempHead=null,nTemp=null;
    while(temp!=null){
        System.out.println(temp.data+ "  ----  "+n);
        if(temp.data!=n && newHead==null){
            newHead=temp;
            prevTemp=newHead;
            System.out.println(prevTemp.data);
        }

        else if(temp.data==n){
            if(ntempHead==null){
                nTemp=temp;
                ntempHead=temp;
            }
            else{
                nTemp.next=temp;
                nTemp=temp;
            }
        }

        else{
            System.out.println(prevTemp.data);
            prevTemp.next=temp;
            prevTemp=temp;
            System.out.println(prevTemp.data);
        }
        
        temp=temp.next;

    }

    prevTemp.next=ntempHead;
    if(nTemp!=null)
        nTemp.next=null;
    

   temp=newHead;
   while(temp!=null){
    System.out.print(temp.data +"  ");
    temp=temp.next;
   }
}
}
