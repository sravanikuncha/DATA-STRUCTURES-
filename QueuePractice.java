import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class QueueEmptyException extends Exception{
    void message(){
        System.out.println("Queue EmptyException");
    }
}

class QueueTwoStacks{

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    QueueTwoStacks(){
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    void statck2QueuesPush(int data){
        queue1.add(data);
    }

    int stack2QueuesPoll() throws QueueEmptyException{
        if(isEmptystack2Queues()){
            throw new QueueEmptyException();
        }
        int lastpopedEle=-1;
        while(!queue1.isEmpty()){
            lastpopedEle=queue1.peek();
            if(queue1.size()>1){
                queue2.add(queue1.poll());
            }
            else {
                queue1.poll();
            }
        }

        Queue<Integer> temp=queue1;
        queue1=queue2;
        queue2=temp;
        
        return lastpopedEle;
    }

    boolean isEmptystack2Queues(){
        return queue1.size()==0;
    }

    int stack2QueuesTop() throws QueueEmptyException{
        if(isEmptystack2Queues()){
            throw new QueueEmptyException();
        }
        return queue1.peek();
    }

    int size(){
        return queue1.size();
    }
}

class QueuePracticeLL{
    NodePractice head, lastNode;
    int size;

    QueuePracticeLL(){
        head=null;
        lastNode=null;
        size=0;
    }

    void enQueueLL(int data){
        NodePractice newNode=new NodePractice(data,null);
        if(lastNode==null){
            lastNode=newNode;
            head=newNode;
        }
        else{
            lastNode.next=newNode;
            lastNode=newNode;
        }
        size++;
    }

    int deQueueLL() throws QueueEmptyException{
        if(isEmptyQueueLL()){
            throw new QueueEmptyException();
        }
        int deQueuedEle=head.data;
        head=head.next;
        size--;
        return deQueuedEle;
    }   

    int frontLL() throws QueueEmptyException{
        if(isEmptyQueueLL()){
            throw new QueueEmptyException();
        }
        return head.data;
    }

    boolean isEmptyQueueLL(){
        return size==0?true:false;
    }

    int size(){
        return size;
    }

    void printQueueLL(){
        System.out.println("priniting LL ");
        NodePractice temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
public class QueuePractice {

    int[] queue;
    int front,rear;
    int size;

    QueuePractice(){
        queue=new int[4];
        front=-1;
        rear=-1;
        size=0;
    }

    void enqueue(int data){
        if(size<queue.length){
            if(front==-1 && rear==-1){
                front++;
                rear++;
            }
            else if(rear==queue.length-1){
                rear=0;
            }
            else{
                rear++;
            }
            queue[rear]=data;
            size++;
        }
        else {
            queue=increaseCapacity();
            size++;
            rear=size-1;
            queue[rear]=data;
        }
    }
    int deQueue() throws QueueEmptyException{
        if(isEmptyQueue()){
            throw new QueueEmptyException();
        }
        int deQueueElemnet=queue[front];
       if(front==queue.length-1){
            if(rear==front){
                front=-1;
                rear=-1;
            }
            else{
                front=0;
            }
       }
       else{
        front++;
       }
       size--;
        return deQueueElemnet;
    }

    int front() throws QueueEmptyException{
        if(isEmptyQueue()){
            throw new QueueEmptyException();
        }
       return queue[front]; 
    }

    boolean isEmptyQueue(){
        return size==0;
    }


    private int[] increaseCapacity(){
        int[] newQueue=new int[2*queue.length];
        int k=0;
        for(int i=front;i<queue.length;i++){
            newQueue[k++]=queue[i];
        }

        for(int i=0;i<=rear;i++){
            newQueue[k++]=queue[i];
        }
        front =0;
        
        return newQueue;
    }

     int size(){
        return size;
    }

    void printQueue(){
        System.out.println();
        for(int i=front;i<queue.length;i++){
            System.out.print(queue[i]+" ");
        }

        for(int i=0;i<=rear;i++){
            System.out.print(queue[i]+" ");
        }

        System.out.println();
    }

    private static void printQueueProblem(Queue<Integer> queue){
        while(!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
    }

    private static Queue<Integer> reverseQueue(Queue<Integer> queue){
        if(queue.size()<=1)
            return queue;

        int ele=queue.poll();
        Queue<Integer> smallAns=reverseQueue(queue);
        smallAns.add(ele);

        return smallAns;
    }

    private static Queue<Integer> reverseFirstKEle(Queue<Integer> queue,Queue<Integer> helperQueue,int k){
        
        for(int i=1;i<=k;i++){
            helperQueue.add(queue.poll());
        }
        helperQueue=reverseQueue(helperQueue);

        while(!queue.isEmpty()){
            helperQueue.add(queue.poll());
        }

        return helperQueue;
    }
    public static void main(String[] args) {
        // QueuePractice qp=new QueuePractice();
        // try{
        //     qp.enqueue(10);
        //     System.out.println(qp.size());
        //     qp.enqueue(20);
        //     qp.enqueue(30);
        //     qp.enqueue(40);
        //     System.out.println(qp.size());
        //     System.out.println(qp.deQueue());
        //     System.out.println(qp.size());
        //     System.out.println(qp.front());
        //     System.out.println(qp.isEmptyQueue());
        //     qp.enqueue(50);
        //     qp.enqueue(60);
        //     qp.enqueue(70);
        //     qp.printQueue();
        //     System.out.println(qp.deQueue());
        //     System.out.println(qp.deQueue());
        //     System.out.println(qp.deQueue());
        //     System.out.println(qp.front());
        //     qp.printQueue();
            
        //     System.out.println(qp.size()+" "+qp.isEmptyQueue());
        //     qp.printQueue();
        //     System.out.println(qp.front+" "+qp.rear);
        // }
        // catch(QueueEmptyException e){
        //     e.message();
        // }


        // System.out.println("LL Queue implementation");
        // try{
        //     QueuePracticeLL queueLL=new QueuePracticeLL();
        //     System.out.println(queueLL.size()+" "+queueLL.isEmptyQueueLL());
        //     queueLL.enQueueLL(10);
        //     queueLL.enQueueLL(20);
        //     queueLL.enQueueLL(30);
        //     queueLL.enQueueLL(40);
        //     queueLL.enQueueLL(50);
        //     queueLL.printQueueLL();
        //     System.out.println();
        //     System.out.println(queueLL.size()+" "+queueLL.isEmptyQueueLL());
        //     System.out.println(queueLL.frontLL());
        //     System.out.println(queueLL.deQueueLL());
        //     System.out.println(queueLL.deQueueLL());
        //     System.out.println(queueLL.deQueueLL());
        //     queueLL.printQueueLL();

        //     queueLL.enQueueLL(60);
        //     queueLL.printQueueLL();            
            
        // }
        // catch(QueueEmptyException e){

        // }

        // System.out.println("Stack with two queues");
        // try{
        //     QueueTwoStacks queueStack2=new QueueTwoStacks();
        //     queueStack2.statck2QueuesPush(10);
        //     queueStack2.statck2QueuesPush(20);
        //     queueStack2.statck2QueuesPush(30);
        //     queueStack2.statck2QueuesPush(40);
        //     queueStack2.statck2QueuesPush(50);

        //     System.out.println(queueStack2.size()+" "+queueStack2.isEmptystack2Queues());
        //     System.out.println(queueStack2.stack2QueuesTop());
        //     System.out.println(queueStack2.stack2QueuesPoll());

        //     System.out.println(queueStack2.stack2QueuesPoll());
        //     System.out.println(queueStack2.stack2QueuesPoll());
        //     System.out.println(queueStack2.stack2QueuesPoll());
        //     System.out.println(queueStack2.stack2QueuesPoll());
        //     System.out.println(queueStack2.size()+" "+queueStack2.isEmptystack2Queues());

        //     System.out.println(queueStack2.stack2QueuesTop());
        // }
        // catch(QueueEmptyException e){
        //     e.message();
        // }

        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        Queue<Integer> queue=new LinkedList<>();
        while(data!=-1){
            queue.add(data);
            data=sc.nextInt();
        }

        // queue=reverseQueue(queue);
        // System.out.println("After reverssal");
        int k=sc.nextInt();
        Queue<Integer> helperQueue=new LinkedList<>();
        queue=reverseFirstKEle(queue,helperQueue,k);
        printQueueProblem(queue);
        sc.close();
    }


}
