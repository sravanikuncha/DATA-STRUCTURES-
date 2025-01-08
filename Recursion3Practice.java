import java.util.ArrayList;
import java.util.Scanner;

public class Recursion3Practice {

    private static String[] getKeypadCode(int n){
        if(n==0){
            String[] baseCase=new String[1];
            baseCase[0]="";
            return baseCase;
        }

        String[] smallOutput=getKeypadCode(n/10);
        int lasDigit=n%10;
        String getAlphaCode=getCode(lasDigit);
        String[] finalOutput=new String[smallOutput.length*getAlphaCode.length()];

        //form teh combinations 
        int k=0;
        for(int i=0;i<smallOutput.length;i++){
            for(int j=0;j<getAlphaCode.length();j++){
                finalOutput[k++]=smallOutput[i]+getAlphaCode.charAt(j);
            }
        }

        return finalOutput;
    }

    private static void subsetSumToKPractice(int[] arr,int k){

       int[] arr2=new int[0];
        subsetSumToKPracticeHelper(arr,arr2, k);

    }

    private static void subsetSumToKPracticeHelper(int[] input,int[] subsetArray,int k){
        if(input.length==0 && k==0){
            for(int i:subsetArray){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        if(input.length==0 || k<0){
            return;
        }

        int arr1[]=new int[input.length-1];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=input[i+1];
        }

       int[] arr2=new  int[subsetArray.length+1];
       for(int i=0;i<subsetArray.length;i++){
        arr2[i]=subsetArray[i];
       }
       arr2[arr2.length-1]=input[0];

        subsetSumToKPracticeHelper(arr1, arr2, k-input[0]);
        subsetSumToKPracticeHelper(arr1, subsetArray, k);
    }

    private static String getCode(int n){
        switch(n){
            case 2:return "abc";
            case 3:return "def";
            case 4:return "ghi";
            case 5:return "jkl";
            case 6:return "mno";
            case 7:return "pqrs";
            case 8:return "tuv";
            case 9: return "wxyz";
            default:return "";
        }
    }

    private static int fact(int n){
        if(n==1 || n==0){
            return 1;
        }

        return n*fact(n-1);
    }

    private static String[] permutationReturn(String inp){
        if(inp.length()==1){
            String[] oneChar=new String[1];
            oneChar[0]=""+inp.charAt(0);
            return oneChar;
        }

        String finalOutput[]=new String[fact(inp.length())];
        int k=0;

        for(int i=0;i<inp.length();i++){
            String remString="";
            if(i>0){
                remString=inp.substring(0, i);
            }
            remString+=inp.substring(i+1, inp.length());
            String[] smallOutput=permutationReturn(remString);
            for(int j=0;j<smallOutput.length;j++){
                finalOutput[k++]=inp.charAt(i)+smallOutput[j];
            }
        }
        return finalOutput;
    }

    private static void permutationPrint(String str1){
        permutationPrintHelper(str1,"");
    }

    private static void permutationPrintHelper(String str1, String str2){
        if(str1.length()==0){
            System.out.println(str2);
            return;
        }

        char c=str1.charAt(0);
        permutationPrintHelper(str1.substring(1, str1.length()), c+str2);
        for(int i=0;i<str2.length();i++){
            String newString=str2.substring(0, i+1)+c+str2.substring(i+1, str2.length());
            permutationPrintHelper(str1.substring(1, str1.length()), newString);
        }
    }

    private static int[][] subsetsArrayReturn(int[] inp){
        int[] helperArr=new int[0];
        return subsetsArrayReturnHelper(inp,helperArr);
    }

    private static int[][] subsetsArrayReturnHelper(int[] inp,int[] helperArr){

        if(inp.length==0){
            int[][] output=new int[1][helperArr.length];
            for(int i=0;i<helperArr.length;i++){
                output[0][i]=helperArr[i];
            }
            return output;
        }

        int[] arr1=new int[inp.length-1];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=inp[i+1];
        }

        int[] arr2=new int[helperArr.length+1];
        for(int i=0;i<helperArr.length;i++){
            arr2[i]=helperArr[i];
        }
        arr2[arr2.length-1]=inp[0];

        int[][] smalloutput1=subsetsArrayReturnHelper(arr1, arr2);//include
        int[][] smalloutput2=subsetsArrayReturnHelper(arr1,helperArr);//exclude 

        int[][] finalOutput=new int[smalloutput1.length+smalloutput2.length][];
        //jagged arrays 

        int k=0;

        for(int i=0;i<smalloutput1.length;i++){
            finalOutput[k]=new int[smalloutput1[i].length];
            for(int j=0;j<smalloutput1[i].length;j++){
                finalOutput[k][j]=smalloutput1[i][j];
            }
            k++;
        }

        for(int i=0;i<smalloutput2.length;i++){
            finalOutput[k]=new int[smalloutput2[i].length];
            for(int j=0;j<smalloutput2[i].length;j++){
                finalOutput[k][j]=smalloutput2[i][j];
            }
            k++;
        }

        return  finalOutput;

    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // System.out.println("Print Keypad code enter  value");
        // int n=sc.nextInt();
        // String[] combinations=getKeypadCode(n);
        // for(String res:combinations){
        //     System.out.println(res);
        // }

        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int kSum=sc.nextInt();
        // subsetSumToKPractice(arr,kSum);

        //return permutations of String
        // String permutationString=sc.nextLine();
        // String[] possiblePermutations=permutationReturn(permutationString);
        // for(String eachPerm: possiblePermutations){
        //     System.out.println(eachPerm);
        // }

        // permutationPrint(permutationString);

        // int[][] subsets=subsetsArrayReturn(arr);
        // for(int i=0;i<subsets.length;i++){
        //     for(int j=0;j<subsets[i].length;j++){
        //         System.out.print(subsets[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        

        sc.close();
    }
}
