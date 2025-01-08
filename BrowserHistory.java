
class Node {
    public String data;
  public Node next;
 public Node prev;
 public static  Node head=null,temp=null;
public Node(String data) {
     this.data=data;
 }
}



public class BrowserHistory {

     // public String data;
    // public BrowserHistory next;
    // public BrowserHistory prev;
    // public  BrowserHistory head,temp;
public BrowserHistory(String homepage) {
    Node headNode=new Node(homepage);
    Node.head=headNode;
    Node.temp=headNode;
    System.out.println(Node.head+" "+Node.temp);
}

public void visit(String url) {
    Node newNode=new Node(url);

    Node.temp.next=newNode;
    System.out.println(Node.temp.next+"  "+newNode+"  "+Node.temp);
    newNode.prev=Node.temp;
    Node.temp=newNode;

    Node temp=Node.head;
    while(temp!=null){
        System.out.print(temp.data+" ");
        temp=temp.next;
    }
}

public String back(int steps) {

    Node prevtemp=Node.temp;
    System.out.println("back  "+prevtemp.data);
    int index=0;
    while(index!=steps && prevtemp.prev!=null){
        prevtemp=prevtemp.prev;
        System.out.println(prevtemp.data);
        index++;
    }

    Node.temp=prevtemp;

    return prevtemp.data;
}

public String forward(int steps) {
    Node nexttemp=Node.temp;
    int index=0;
    while(index==steps || nexttemp.next!=null){
        nexttemp=nexttemp.next;
        index++;
    }

    Node.temp=nexttemp;

    return nexttemp.data;
}
}
