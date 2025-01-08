import java.util.Scanner;

public class RecursionPractice {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		// int x = s.nextInt();
		// int n = s.nextInt();
		
		// System.out.println(RecursionPractice.power(x, n));

        // int n=s.nextInt();
        // System.out.println(digits(n));

        // int n=s.nextInt();
        // display1ton(n);

        int size=s.nextInt();
        int[] sumArray=new int[size];
        for(int i=0;i<sumArray.length;i++){
            sumArray[i]=s.nextInt();
        }

        // mergeSort(sumArray);

        quickSort(sumArray,0,sumArray.length-1);
        for(int i:sumArray){
            System.out.print(i+" ");
        }
        // int res=sumArrayRecursive(sumArray,0);
        // System.out.println(res);

        // int nrTobePresent=s.nextInt();
        // boolean presnet=presentArrayRecursive(sumArray,nrTobePresent,0);
        // System.out.println(presnet);

        // int firstOccurence=firstOccurenceRecursive(sumArray,nrTobePresent,0);
        // System.out.println(firstOccurence);

        // int lastOccurence=lastOccurenceRecursive(sumArray,nrTobePresent,sumArray.length-1);
        // System.out.println(lastOccurence);

        // String inp=s.nextLine();
        // System.out.println(removeX(inp,0));

        // System.out.println(duplicateX(inp,0));
	}

    private static void quickSort(int[] arr,int startIndex,int endIndex){
        if(startIndex>=endIndex){
            return;
        }

        int pivotIndex=doUpfrontWork(arr,startIndex,endIndex);
        quickSort(arr, startIndex, pivotIndex-1);
        quickSort(arr, pivotIndex+1, endIndex);
    }

    private static int doUpfrontWork(int[] arr, int startIndex,int endIndex){
        int pivotEle=arr[startIndex];

        int nroFEle=0;
        for(int i=startIndex+1;i<=endIndex;i++){
            if(arr[i]<=pivotEle){
                nroFEle++;
            }
        }

        //swap ele prent in 
        arr[startIndex]=arr[nroFEle+startIndex];
        arr[nroFEle+startIndex]=pivotEle;

        int pivotIndex=nroFEle+startIndex;

        int i=startIndex;
        int j=pivotIndex+1;
        while(i<pivotIndex && j<=endIndex){
            if(arr[i]<=pivotEle){
                i++;
            }
            else if(arr[j]>pivotEle){
                j++;
            }
            else{
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
        }

        return nroFEle+startIndex;
    }

    private static void mergeSort(int[] arr){
         mergerHelper(arr);
    }


    private static void mergerHelper(int[] arr){
       if(arr.length==1){
        return ;
       }
       
       int i=0;
       int j=arr.length;

        int mid=(i+j)/2;

        int []b =new int[mid];
        int []c=new int[j-b.length];
        

        for(int m=0;m<b.length;m++){
            b[m]=arr[m];
        }
        
        int k=mid;
        for(int n=0;n<c.length;n++){
            c[n]=arr[k++];
        }

        mergerHelper(b);
        mergerHelper(c);

        mergeTwoSortedArrays(b,c,arr);
    }

    private static void mergeTwoSortedArrays(int[] b,int []c,int []arr){
        int i=0,j=0,k=0;
        
        while(i<b.length && j<c.length){
            if(b[i]<c[j]){
                arr[k++]=b[i];
                i++;
            }
            else{
                arr[k++]=c[j];
                j++;
            }
        }

        while(i<b.length){
            arr[k++]=b[i];
            i++;
        }

        while(j<c.length){
            arr[k++]=c[j];
            j++;
        }

    }


    private static String duplicateX(String inp,int i){
        if(i==inp.length()){
            return "";
        }

        String smallAns=duplicateX(inp, i+1);
        if(smallAns!="" && smallAns.charAt(0)==inp.charAt(i)){
            return smallAns;
        }
        else{
            return inp.charAt(i)+smallAns;
        }
    }

    private static String removeX(String inp,int i){
        if(i==inp.length()){
            return "";
        }

        if(inp.charAt(i)=='x'){
            return removeX(inp, i+1);
        }
        else{
            return inp.charAt(i)+removeX(inp, i+1);
        }
    }

    private static int lastOccurenceRecursive(int[] sumArray,int nrTobePresent,int i){
        if(i<0){
            return -1;
        }

        if(sumArray[i]==nrTobePresent){
            return i;
        }

        return lastOccurenceRecursive(sumArray, nrTobePresent, i-1);
    }
    private static int firstOccurenceRecursive(int[] sumArray,int nrTobePresent,int i){
        if(i==sumArray.length){
            return -1;
        }

        if(sumArray[i]==nrTobePresent){
            return i;
        }

        return firstOccurenceRecursive(sumArray, nrTobePresent, i+1);
    }

    private static boolean presentArrayRecursive(int[] sumArray,int nrTobePresent,int i){
        if(i==sumArray.length){
            return false;
        }

        if(sumArray[i]==nrTobePresent){
            return true;
        }

        return presentArrayRecursive(sumArray, nrTobePresent, i+1);
    }

    private static int sumArrayRecursive(int[] sumArray,int i){
        if(i==sumArray.length){
            return 0;
        }

        int smallAns=sumArrayRecursive(sumArray, i+1);
        return smallAns+sumArray[i];

    }

    private static void display1ton(int n){
        if(n==0){
            return;
        }
        display1ton(n-1);
        System.out.print(n+" ");
    }

    private static int digits(int n){
        if(n==0)
            return 0;
        
        int smallAns=digits(n/10);
        return 1+smallAns;
    }
    
    public static int power(int x, int n) {
        return pow(x,n);
    }

    private static int pow(int x,int n){
        if(n==0)
            return 1;
        
        int smallAns=pow(x,n-1);
        return x* smallAns;
    }
}
