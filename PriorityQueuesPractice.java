import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class PriorityQueuesEmptyException extends Exception{
   void message(){
    System.out.println("Priority  Queue Empty Exception");
   }
}
public class PriorityQueuesPractice {

    ArrayList<Integer> priorityQueue;

    PriorityQueuesPractice(){
        priorityQueue=new ArrayList<>();
    }

    private void minHeapInsert(int data){
        priorityQueue.add(data);
        //we perform upheapify operation to make sure newly entered one is reached to its respective  position
        int newIndex=priorityQueue.size()-1;
        int parentIndex=(newIndex-1)/2;
        while(parentIndex>=0){
            if(priorityQueue.get(newIndex)<priorityQueue.get(parentIndex)){
                //swap them ;
                int  temp=priorityQueue.get(newIndex);
                priorityQueue.set(newIndex, priorityQueue.get(parentIndex));
                priorityQueue.set(parentIndex, temp);
            }
            else{
                return;
            }

            newIndex=parentIndex;
            parentIndex=(parentIndex-1)/2;
        }
    }

    private int size(){
        return priorityQueue.size();
    }

    private int minHeapRemove() throws PriorityQueuesEmptyException{
        
        int element=priorityQueue.get(size()-1);
        
       
        int deletedElement=-1;
        if(size()>0){
            deletedElement=priorityQueue.get(0);
        }
        else{
            throw new PriorityQueuesEmptyException();
        }

        
        priorityQueue.set(0, element);
        priorityQueue.remove(size()-1);
        int parentIndex=0;
        int leftIndex=2*parentIndex+1;
        int rightIndex=2*parentIndex+2;

        while(leftIndex<size()){
            //down heapify push largets element is present to down
            int minIndex=parentIndex;
            if(priorityQueue.get(leftIndex)<priorityQueue.get(minIndex)){
                minIndex=leftIndex;
            }
            
            if(rightIndex<size() && priorityQueue.get(rightIndex)<priorityQueue.get(minIndex)){
                minIndex=rightIndex;
            }

            if(minIndex==parentIndex){
                return deletedElement;
            }

            //swap minindex with parentIndex;
           
            int  temp=priorityQueue.get(minIndex);
            priorityQueue.set(minIndex, priorityQueue.get(parentIndex));
            priorityQueue.set(parentIndex, temp);

            parentIndex=minIndex;
            leftIndex=2*parentIndex+1;
            rightIndex=2*parentIndex+2;
           
        }

        return deletedElement;
         
    }

    private void maxHeapInsert(int data){
        priorityQueue.add(data);
        //we perform upheapify operation to make sure newly entered one is reached to its respective  position
        int newIndex=priorityQueue.size()-1;
        int parentIndex=(newIndex-1)/2;
        while(parentIndex>=0){
            if(priorityQueue.get(newIndex)>priorityQueue.get(parentIndex)){
                //swap them ;
                int  temp=priorityQueue.get(newIndex);
                priorityQueue.set(newIndex, priorityQueue.get(parentIndex));
                priorityQueue.set(parentIndex, temp);
            }
            else{
                return;
            }

            newIndex=parentIndex;
            parentIndex=(parentIndex-1)/2;
        }
    }

    private int maxHeapRemove() throws PriorityQueuesEmptyException{
        
        int element=priorityQueue.get(size()-1);
        
       
        int deletedElement=-1;
        if(size()>0){
            deletedElement=priorityQueue.get(0);
        }
        else{
            throw new PriorityQueuesEmptyException();
        }

        
        priorityQueue.set(0, element);
        priorityQueue.remove(size()-1);
        int parentIndex=0;
        int leftIndex=2*parentIndex+1;
        int rightIndex=2*parentIndex+2;

        while(leftIndex<size()){
            //down heapify push largets element is present to down
            int minIndex=parentIndex;
            if(priorityQueue.get(leftIndex)>priorityQueue.get(minIndex)){
                minIndex=leftIndex;
            }
            
            if(rightIndex<size() && priorityQueue.get(rightIndex)>priorityQueue.get(minIndex)){
                minIndex=rightIndex;
            }

            if(minIndex==parentIndex){
                return deletedElement;
            }

            //swap minindex with parentIndex;
           
            int  temp=priorityQueue.get(minIndex);
            priorityQueue.set(minIndex, priorityQueue.get(parentIndex));
            priorityQueue.set(parentIndex, temp);

            parentIndex=minIndex;
            leftIndex=2*parentIndex+1;
            rightIndex=2*parentIndex+2;
           
        }

        return deletedElement;
         
    }

    private  void downHeapify(int size){
        int parentIndex=0;
        int leftIndex=2*parentIndex+1;
        int rightIndex=2*parentIndex+2;

        while(leftIndex<size){
            int maxIndex=parentIndex;
            if(priorityQueue.get(leftIndex)>priorityQueue.get(maxIndex)){
                maxIndex=leftIndex;
            }
            if(rightIndex<size && priorityQueue.get(rightIndex)>priorityQueue.get(maxIndex)){
                maxIndex=rightIndex;
            }

            if(maxIndex==parentIndex){
                return ;
            }

            
            int  temp=priorityQueue.get(maxIndex);
            priorityQueue.set(maxIndex, priorityQueue.get(parentIndex));
            priorityQueue.set(parentIndex, temp);

            parentIndex=maxIndex;
            leftIndex=2*parentIndex+1;
            rightIndex=2*parentIndex+2;

        }
    }

    private void heapSort(){
        //already priority queue is maxheapified 

        int temp=priorityQueue.get(0);
        priorityQueue.set(0,priorityQueue.get(size()-1));
        priorityQueue.set(size()-1, temp);

        int size=priorityQueue.size()-1;

        while(size>0){
            downHeapify(size);
            size--;
            temp=priorityQueue.get(0);
            priorityQueue.set(0,size);
            priorityQueue.set(size, temp);
        }

    }

    private static int[] kLargestEle(int []arr , int k){
        if(k>arr.length){
            k=arr.length;
        }
        int[] res=new int[k];

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        int startIndex=0;

        while(k>0){
            res[startIndex++]=pq.poll();
            k--;
        }
        return res;
    }
    
    private static int[] ksmallestEle(int[] arr, int k){
        if(k>arr.length){
            k=arr.length;
        }
        int[] res=new int[k];

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        int startIndex=0;

        while(k>0){
            res[startIndex++]=pq.poll();
            k--;
        }
        return res;
    }

    private static boolean isMaxHeap(int[] arr){
      

        for(int i=0;i<arr.length;i++){
            int parentIndex=i;
            int leftIndex=2*parentIndex+1;
            int rightIndex=2*parentIndex+2;
            if(leftIndex <arr.length &&arr[leftIndex]>arr[parentIndex]){
                return false;
            }
            
            if(rightIndex<arr.length && arr[rightIndex]>arr[parentIndex]){
                return false;
            }
            
        }

        return true;
    }

    private static int kthLargestElement(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        if(k>arr.length){
            return -1;
        }

        while(k>1){
            pq.poll();
            k--;
        }

        return pq.poll();
    }

    private static int buyTicketInSec(int[] arr, int k){

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<arr.length;i++){
            queue.add(i);
            pq.add(arr[i]);
        }

        boolean notFound=true;
        int time=0;

        while(notFound){
            if(queue.size()>0 && pq.size()>0 && arr[queue.peek()]==pq.peek()){
                if(queue.peek()==k){
                    notFound=false;
                }
                time++;
                pq.poll();
                queue.poll();
            }
            else if(queue.size()>0 && pq.size()>0){
                int value=queue.poll();
                queue.add(value);
            }
        }


        return time;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        PriorityQueuesPractice pq=new PriorityQueuesPractice();
        //minheap min element at top
        // System.out.println("Implementing MIN HEAP PRIORITy QUEUE");
        // System.out.println("Enter data into priority Queue will continue until -1 is entered");
        // int data=sc.nextInt();
        // while(data!=-1){
        //     pq.minHeapInsert(data);
        //     data=sc.nextInt();
        // }

        // //delete all data one by one which should  print all in ascending order 
        // try{
        //     while(pq.size()>0){
        //         int deletedElement =pq.minHeapRemove();
        //         System.out.println(deletedElement);
        //     }
        // }
        // catch(PriorityQueuesEmptyException e){
        //     e.message();
        // }


        // System.out.println("MAX HEAP PRIORITY QUEUE");
        // System.out.println("Enter data into priority Queue will continue until -1 is entered");
        // data=sc.nextInt();
        // while(data!=-1){
        //     pq.maxHeapInsert(data);
        //     data=sc.nextInt();
        // }

        //delete all data one by one which should  print all in ascending order 
        // try{
        //     while(pq.size()>0){
        //         int deletedElement =pq.maxHeapRemove();
        //         System.out.println(deletedElement);
        //     }
        // }
        // catch(PriorityQueuesEmptyException e){
        //     e.message();
        // }

        // pq.heapSort();
        // for(int i=0;i<pq.size();i++){
        //     System.out.print(pq.priorityQueue.get(i)+" ");
        // }

        // System.out.println("K Largest Elements");

        // System.out.println("K smallest Elements");
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }

        int k=sc.nextInt();
        //  int[] res=kLargestEle(arr,k);
        // int[] res=ksmallestEle(arr,k);
        // for(int i=0;i<res.length;i++){
        //     System.out.print(res[i]+" ");
        // }

       
        // boolean isMaxheap=isMaxHeap(arr);
        // System.out.println(isMaxheap);

        // System.out.println("Kth largest Elemet");
        // int kthLargest=kthLargestElement(arr,k);
        // System.out.println(kthLargest);

        System.out.println("Buy ticket in secs");
        int nrOfSecs=buyTicketInSec(arr,k);
        System.out.println(nrOfSecs);
        sc.close();
    }
}
