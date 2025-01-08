package DSA;

public class ArraySortedRecursion {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,7,6};
        int n=arr.length;
        if(arraySorted(arr,n-1,n-2))
            System.out.println("Sorted");
        else
        System.out.println("Not Sorted");

    }

    public static boolean arraySorted(int[] arr, int a, int b){
        if(a==1 && b==0 ){
            if(arr[a]>=arr[b])
                return true;
            else if(arr[a]<arr[b])
                return false;
        }
        boolean smallOutput;
        if(arr[a]>=arr[b])
            smallOutput=arraySorted(arr, a-1,b-1);
        else
            return false;
        return smallOutput && true;
    }
}
