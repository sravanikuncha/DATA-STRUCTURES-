import java.io.EOFException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class MapNode{
    String key;
    int value;
    MapNode next;

    MapNode(String key,int value){
        this.key=key;
        this.value=value;
    }
}

class HashMapException extends Exception{
    String message;
    HashMapException(String s){
        message=s;
    }
}



public class HashMapPractice {

    static MapNode[] buckets=new MapNode[20]; 

    private static void insert(String key){
        int bucketIndex=key.hashCode();
        bucketIndex=bucketIndex%(buckets.length);
        MapNode head=buckets[bucketIndex];
       if(head==null){
            MapNode newNode=new MapNode(key, 1);
            head=newNode;
            buckets[bucketIndex]=head;
       }
       else{
        MapNode temp=head;
        if(head.key.equals(key)){
            head.value=head.value+1;
        }
        else{
            while(temp.next!=null && !temp.key.equals(key)){
                temp=temp.next;
            }
            if(temp.next==null && !temp.key.equals(key)){
                temp.next=new MapNode(key, 1);
            }
            else{
                temp.value=temp.value+1;
            }
        }
       }
    }


    private static void delete(String key) throws HashMapException{
        int bucketIndex=key.hashCode();
        bucketIndex=bucketIndex%(buckets.length);
        MapNode head=buckets[bucketIndex];

        if(head==null){
            throw new HashMapException("No Such key Exception");
        }

        else{
            MapNode temp=head,prevTemp=null;
            while(temp!=null){
                if(temp.key.equals(key)){
                    if(prevTemp==null){
                        buckets[bucketIndex]=temp.next;
                    }
                    else{
                        prevTemp.next=temp.next;
                    }
                    break;
                }
                prevTemp=temp;
                temp=temp.next;
            }
        }
    }

    private static int getValue(String key) throws HashMapException{
        int bucketIndex=key.hashCode();
        bucketIndex=bucketIndex%(buckets.length);
        MapNode head=buckets[bucketIndex];
        if(head==null){
            throw new HashMapException("Key not present");
        }
        else{
            MapNode temp=head;
            while(temp!=null){
                if(temp.key.equals(key)){
                    return temp.value;
                }
                throw new HashMapException("Key not present");
            }
        }
        return -1;
    }

    private static int maxFreqNumber(int[] arr){
        int maxFreqCount=0;
        int number=0;

        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int value=hm.get(arr[i]);
                hm.put(arr[i], value+1);
            }
            else{
                hm.put(arr[i], 1);
            }
            if(maxFreqCount==hm.get(arr[i]) && arr[i]<number){
                maxFreqCount=hm.get(arr[i]);
                number=arr[i];
            }
            else if(maxFreqCount<hm.get(arr[i])){
                maxFreqCount=hm.get(arr[i]);
                number=arr[i];
            }
            
        }

        return number;
    }

    private static void intersectionPractice(int[] arr1, int[] arr2, int n,int m){
        
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<n;i++){
            if(hm.containsKey(arr1[i])){
                int value=hm.get(arr1[i]);
                hm.put(arr1[i], value+1);
            }
            else{
                hm.put(arr1[i], 1);
            }
        }

        Arrays.sort(arr2);

        for(int i=0;i<m;i++){
            if(hm.containsKey(arr2[i])){
                System.out.print(arr2[i]+" ");
                hm.put(arr2[i], hm.get(arr2[i])-1);
                if(hm.get(arr2[i])<=0){
                    hm.remove(arr2[i]);
                }
            }
        }


    }

    private static int pairsumto0practice(int[] arr){

        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int value=hm.get(arr[i]);
                hm.put(arr[i], value+1);
            }
            else{
                hm.put(arr[i],1);
            }
        }

        int nrofPairs=0;
        for(int i=0;i<arr.length;i++){
            int remainingValue=0-arr[i];

            if(remainingValue==0){
                int value=hm.get(remainingValue);
                nrofPairs+=((value-1)*value)/2;
                hm.put(remainingValue, 0);
            }
            else if(hm.containsKey(remainingValue)){
                int value1=hm.get(arr[i]);
                int value2=hm.get(remainingValue);
                nrofPairs+=value1*value2;
                hm.put(arr[i], 0);
                hm.put(remainingValue, 0);
            }
        }

        return nrofPairs;
    }

    private static void uniqueCharPractice(String s){
        
        HashMap<Character,Integer> hm=new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                int value=hm.get(s.charAt(i));
                hm.put(s.charAt(i), value+1);
            }
            else{
                hm.put(s.charAt(i), 1);
                System.out.print(s.charAt(i));
            }
        }


        
    }

    private static void longestSequencePractice(int[] arr){

        HashMap<Integer,Integer> hm=new HashMap<>();

        int count=0,maxcount=0,index=-1,value=-1;

        for(int i=0;i<arr.length;i++){
            hm.put(arr[i], i);
        }

        Arrays.sort(arr);

        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==1){
                count++;
                continue;
            }
            else{
              if(maxcount<count){
                index=hm.get(arr[i-1]-count);
                maxcount=count;
                value=arr[i-1]-count;
              }
              else if(maxcount==count){
                    int startValue=arr[i-1]-count;
                    int startValueIndex=hm.get(startValue);
                    if(startValueIndex<index){
                        index=startValueIndex;
                        value=arr[i-1]-count;
                    }
              }
              count=0;
            }
        }

        int lastValue=value+maxcount;
        System.out.println(value+" "+lastValue);
      
    }

    private static int pairsWithDifferenceK(int[] arr,int k){
        HashMap<Integer,Integer> hm =new HashMap<>();

        int count=0;
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int value=hm.get(arr[i]);
                hm.put(arr[i], value+1);
            }
            else{
                hm.put(arr[i],1);
            }
        }

        for(int i=0;i<arr.length;i++){
            int remainingValueK=arr[i]-k;

            if(k==0){
                int value=hm.get(remainingValueK);
                count+=((value)*(value-1))/2;
                hm.put(arr[i],0);
            }
            else if(hm.containsKey(remainingValueK)){
                int value=hm.get(remainingValueK);
                int value1=hm.get(arr[i]);
                count+=value*value1;
                hm.put(remainingValueK, 0);
            }
        }

        return count;
    }

    private static int lengthOfLongestArraySumZero(int[] arr){
        HashMap<Integer,Integer> hm=new HashMap<>();

        int sum=arr[0],longestLenCout=-1;
        hm.put(sum,0);

        for(int i=1;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                longestLenCout=i+1;
            }
            else if(hm.containsKey(sum)){
                int index=hm.get(sum);
                int indexLen=i-index;
                if(indexLen>longestLenCout)
                    longestLenCout=indexLen;
            }
            else{
                hm.put(sum,i);
            }
        }

        return longestLenCout;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // System.out.println("Eneter string to find words frequency ");
        // String input=sc.nextLine();

        // String[] stringArray=input.split(" ");
        // for(String s: stringArray){
        //     insert(s);
        // }

        // System.out.println("Enter key that needs to be deleted");
        // String s=sc.nextLine();
        // try{
        //     delete(s);

        //     System.out.println("Eneter key whose value needs to be fetched");
        //     s=sc.nextLine();
        //     int value=getValue(s);
        //     System.out.println(value);
        // }
        // catch(HashMapException e){
        //     System.out.println(e.message);
        // }
        

        // int n=sc.nextInt();
        // int []arr=new int[n];
        // for(int i=0;i<arr.length;i++){
        //     arr[i]=sc.nextInt();
        // }
        // int maxFreqNum=maxFreqNumber(arr);
        // System.out.println(maxFreqNum);

        // int testcases=sc.nextInt();
        // while(testcases>0){
        //     int n=sc.nextInt();
        //     int[] arr1=new int[n];
        //     for(int i=0;i<n;i++){
        //         arr1[i]=sc.nextInt();
        //     }

        //     int m=sc.nextInt();
        //     int[] arr2=new int[m];
        //     for(int i=0;i<m;i++){
        //         arr2[i]=sc.nextInt();
        //     }

        //     intersectionPractice(arr1,arr2,n,m);
        //     System.out.println();
        //     testcases--;
        // }

    //     System.out.println("Enter size of array");
    //     int size=sc.nextInt();
    //     int[] arr=new int[size];
    //     for(int i=0;i<size;i++){
    //         arr[i]=sc.nextInt();
    //     }
    //    int nrofPairs= pairsumto0practice(arr);
    //    System.out.println(nrofPairs);

        // System.out.println("Enter String to remian duplicates");
        // String s=sc.nextLine();
        // uniqueCharPractice(s);

        // System.out.println("Longest Consecutive Sequence eneter array");
        // int size=sc.nextInt();
        // int[] arr=new int[size];
        // for(int i=0;i<size;i++){
        //     arr[i]=sc.nextInt();
        // }

        // longestSequencePractice(arr);


        // System.out.println("pairs with difference k ");
        // int size=sc.nextInt();
        // int[] arr=new int[size];
        // for(int i=0;i<size;i++){
        //     arr[i]=sc.nextInt();
        // }

        // System.out.println("Enter K");
        // int k=sc.nextInt();

        // int totalPairsK=pairsWithDifferenceK(arr,k);
        // System.out.println(totalPairsK);

        System.out.println("Longest Subarray sum");
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }

        int longestlength=lengthOfLongestArraySumZero(arr);
        System.out.println(longestlength);
        sc.close();
        
    }
}
