package DSA;

public class SummOfArrays {
    public static void main(String[] args) {
        int[] arr={1,4,5,7,13,15};
        int n=arr.length;

        System.out.println(sumOfArrays(arr,n-1));
    }

    public static int sumOfArrays(int[] arr,int a){
        if(a==0)
            return arr[0];
        int smallOutput=arr[a]+sumOfArrays(arr, a-1);
        return 0+smallOutput;
    }
}
