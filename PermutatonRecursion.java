import java.util.Scanner;

class solution {
	
	public static String[] permutationOfString(String input){
		// Write your code here


		return permutationOfStringHelper(input);
		
	}

    private static int Fact(int n){
        if(n==1)
            return 1;
        int smallAns=Fact(n-1);
        return n* smallAns;
    }

	private static String[] permutationOfStringHelper(String input){

	
		
		if(input.length()==1){
			String[] ans=new String[1];
			ans[0]=input;
			return ans;
		}
		
		String finalOutput[]=new String[Fact(input.length())];
        int k=0;
		for(int i=0;i<input.length();i++){

			String permutationString=input.substring(0,i)+input.substring(i+1);

			String smallOutput[]=permutationOfStringHelper(permutationString);

			for(int j=0;j<smallOutput.length;j++){
				finalOutput[k]=input.charAt(i)+smallOutput[j];
                k++;
			}

		}

			return finalOutput;
	
	}
	

public static void printSubsetsSumTok(int input[], int k) {
    // Write your code here

    printSubsetsSumTokHelper(input, k, new int[0]);
    
}

private static void printSubsetsSumTokHelper(int input[],int k,int[] removedElements){


   
    
    if(k==0){
        for(int i=0;i<removedElements.length;i++){
            System.out.print(removedElements[i]+" ");
        }
        System.out.println();
        return ;
    }

    if(input.length==0 || k<0)
    return ;
    

    int[] arr=new int[input.length-1];
    for(int i=0;i<arr.length;i++)
        arr[i]=input[i+1];
    int[] arr2=new int[removedElements.length+1];
    for(int i=0;i<removedElements.length;i++){
        arr2[i]=removedElements[i];
    }
    arr2[arr2.length-1]=input[0];
    printSubsetsSumTokHelper(arr,k-input[0],arr2);
    printSubsetsSumTokHelper(arr,k,removedElements);

}
}



public class PermutatonRecursion {
    
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
		// String input = s.nextLine();
		// String output[] = solution.permutationOfString(input);
		// for(int i = 0; i < output.length; i++) {
		// 	System.out.println(output[i]);
		// }
         Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
		int k = s.nextInt();
		solution.printSubsetsSumTok(arr, k);
    }
}
