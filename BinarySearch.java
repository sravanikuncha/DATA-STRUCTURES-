

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int x=3;

       System.out.println(binarysearch(arr,0,arr.length-1,x));
    }

    public static int binarysearch(int[] arr,int i,int j,int matchElement){
        int mid=(i+j)/2;
        if(i>j)
            return -1;
        if(arr[mid]==matchElement)
            return mid;
        else if(arr[mid]>matchElement){
            int smallOutput=binarysearch(arr, i, mid-1, matchElement);
            return smallOutput;
        }
        else{
            int smallOutput=binarysearch(arr, mid+1, j, matchElement);
            return smallOutput;
        }
            
    }
}
