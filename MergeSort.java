package DSA;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={9,7,10,6,2,1,4,3};

        mergeSortRecursion(arr);

        for(int i:arr)
            System.out.print(i+" ");
    }

    public static void mergeSortRecursion(int[] arr){

        if(arr.length==1)
            return;

        
        int[] b=new int[arr.length/2];
        int[] c=new int[arr.length-b.length];

        for(int i=0;i<b.length;i++)
            b[i]=arr[i];

       for(int i=arr.length/2;i<arr.length;i++)
            c[i-arr.length/2]=arr[i];

        mergeSortRecursion(b);
        mergeSortRecursion(c);

        merge(b,c,arr);
    }

    public static int[] merge(int[] b,int[] c,int[] target){
        int i=0,j=0,k=0;
        while(i<c.length && j<b.length){
            if(c[i]<=b[j]){
                target[k++]=c[i];
                i++;
            }
            else if(c[i]>b[j]){
                target[k++]=b[j];
                j++;
            }
        }

        while(i<c.length)
            target[k++]=c[i++];

        while(j<b.length)
            target[k++]=b[j++];

        return target;
    }
}
