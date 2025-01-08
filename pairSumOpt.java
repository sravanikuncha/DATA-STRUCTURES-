import java.util.Arrays;
public class pairSumOpt {
    public static void main(String[] args) {
        int[] arr={1 ,3 ,6 ,2 ,5 ,4 ,3 ,2 ,4};
        int num=7;
        //1,2,2,3,3,4,4,5,6
        System.out.println(pairSum(arr,num));
    }

    public static int pairSum(int[] arr, int num) {
		//Your code goes here
		if(arr.length==0)
			return 0;
		Arrays.sort(arr);
		int countPairs=0;
		int startIndex=0;
		int endIndex=arr.length-1;

		while(startIndex<=endIndex){
			if(arr[startIndex]+arr[endIndex]<num)
				startIndex+=1;
			else if(arr[startIndex]+arr[endIndex]>num)
				endIndex-=1;
			else{
				if(arr[startIndex]==arr[endIndex]){
                    System.out.println("start "+startIndex+" endI "+endIndex);
					int elementCount=funElementCount(arr,startIndex,endIndex,arr[startIndex]);
                    System.out.println("elemen"+elementCount);
					elementCount=(elementCount*(elementCount-1))/2;
					countPairs=countPairs+elementCount;
                    return countPairs;
				}
				else{
                                        // System.out.println("start "+startIndex+" endI "+endIndex);

					int elementCount=funElementCount(arr,startIndex,endIndex,arr[startIndex]);
					elementCount=elementCount*funElementCount(arr,startIndex,endIndex,arr[endIndex]);
					countPairs=countPairs+elementCount;
				}
				startIndex++;
				endIndex--;
			}
		}

		return countPairs;
	}

	public static int funElementCount(int[] arr, int i,int j,int num){

		int elementCount=0;
        boolean ifElse=false;
        System.out.println(i+" "+" "+j+" "+arr[i]+" "+arr[j]);
		while(i<=j){
            ifElse=false;
            // System.out.println("hsbdkj"+arr[i]+" "+arr[j]+ " "+i+" "+j);
			if(arr[i]==num && i!=j){
                // System.out.println(arr[i]);
				elementCount+=1;
				i++;
                ifElse=true;
			}
			if(arr[j]==num){
                // System.out.println(arr[j]);
				elementCount+=1;
				j--;  
                ifElse=true;  
                }            
           
            if(ifElse)
                continue;
            
            i++;j--;

		}
         System.out.println("complete "+ elementCount);
		return elementCount;
	}
}
