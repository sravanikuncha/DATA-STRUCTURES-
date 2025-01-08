package DSA;

public class Recursion {
    public static void main(String[] args) {
		// System.out.println(fibonacci(10));
		int[] arr={1,2,3,4,5};
		int n=arr.length;
		boolean issorted=sorted(arr,n);

    }

	public static boolean sorted(int[] arr,int n){
		return false;
	}

	public static int fibonacci(int n){
		if(n==1 || n==2)
			return 1;
		
		int smallOutput1=fibonacci(n-1);
		int smallOutput2=fibonacci(n-2);

		int output=smallOutput1+smallOutput2;
		return output;

	}
}
