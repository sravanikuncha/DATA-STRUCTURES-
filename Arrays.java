import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Arrays {
    public static void main(String[] args) {
        /* 
        int[] arr1=new int[10];
        System.out.println(arr1[0]);
        int bracket[]={1,2,3};
        // bracket={1,2,3,4}; no new keyword 
        System.out.println("hi"+'\u0000');

        System.out.println((int)'A');
        int arr[]={1 ,2, 3};
        int l=0,r=1;
        int size=r-l+1;
        int reverseArray[]=new int[size];

        for(int i=r,j=0;i>=l&& j<size;i--,j++){
            reverseArray[j]=arr[i];
            System.out.println(reverseArray[j]+" "+j+"  "+i);
        }

        for(int i=l,j=0;i<=r && j<size;i++,j++){
            arr[i]=reverseArray[j];
            System.out.println("arr "+arr[i]);
        }
        int []a={-23, 48, -13, 31, -12, 6 ,-42 ,23 ,14, 33, -33 ,-21, 0, 25, -39 ,-31};
        int end=a.length-1;

        for(int i=0;i<a.length;){
            if(i>=end)
                break;
            else if(a[i]>0 && a[end]<=0){
                int swap=a[i];
        a[i]=a[end];
        a[end]=swap;
                i++;
                end--;
            }
            else if(a[i]<0 && a[end]<0){
                i++;
            }
            else{
                end--;
            }
        }
        for(int i:a){
            System.out.print(i+" ");
        }


        System.out.println("sum of two arrays start");
        int arr1Number=0,arr2Number=0;
        
       
        int arrs1[]={6 ,9, 8 };
        int arrs2[]={5, 9 ,2}; 
        int powerValue=arrs1.length;

         for(int i=0;i<arrs1.length;i++){
            arr1Number+=arrs1[i]*((int)Math.pow(10,--powerValue));
        }
        powerValue=arrs2.length;
         for(int i=0;i<arrs2.length;i++){
            arr2Number+=arrs2[i]*((int)Math.pow(10,--powerValue));
        }
        int finalValue=arr1Number+arr2Number;
        System.out.println(finalValue);
        int[] output=new int[4];
        for(int j=output.length-1;j>=0;j--){
            
            if(finalValue>0){
                output[j]=finalValue%10;
                finalValue=finalValue/10;
            }
            else
                output[j]=0;
            
        }
        for(int i:output){
            System.out.print(i+" ");
        }

        System.out.println("prefx sum");

        int arrprefix[]={1,2,3,4,5};
         output=new int[arrprefix.length];
        int sum=0;

        for(int i=0,j=0;i<arrprefix.length;i++,j++){
            sum+=arrprefix[i];
            output[j]=sum;
            
        }
        arrprefix=output;
        for(int i:arrprefix)
            System.out.print(i);



        System.out.println("\ntriplets start");
        int []tripletarr={8 ,9, 9 ,1, 7, 5, 5, 10 ,1, 0, 7  };
        arr=tripletarr;
        int tripletcount=0;
        int x=16;
        for(int firstNumber=0;firstNumber<arr.length ;firstNumber++){
            for(int secondNumber=firstNumber+1;secondNumber<arr.length;secondNumber++){
                for(int thirdNumber=secondNumber+1;thirdNumber<arr.length;thirdNumber++){
                    // System.out.println(firstNumber+" "+secondNumber+" "+thirdNumber);
                    if(arr[firstNumber]+arr[secondNumber]+arr[thirdNumber]==16){
                                            System.out.println(firstNumber+" "+secondNumber+" "+thirdNumber);

                        // System.err.println(arr[firstNumber]+" "+arr[secondNumber]+" "+arr[thirdNumber]);
                        tripletcount++;
                        // break;
                    }
                }
            }
        }
        System.out.println(tripletcount);*/
//         int n=4830;
//         List<Integer> list = new ArrayList<Integer>(); 
//         int[] coins={1,2,5,10,20,50,100,500,1000};
//         int j=0;
//         for(int i=0;i<coins.length;i++){
//             if(n==coins[i])
//                 list.add(n);
//             else if(n<coins[i]){
//                 j=i-1;
//                 break;
//             }
//             else if(i==coins.length-1){
//                 j=i;
//             }
//         }
//         System.out.println(coins[j]);
       
//        while(n!=0){
//            if(n>=coins[j]){
//             n=n-coins[j];
//             list.add(coins[j]);
//            }
//            else{
//            j--;
//            }
//        }
//        Collections.sort(list,Collections.reverseOrder());
//        System.out.println(list);

//  List<String> a = new ArrayList<String>(); 
//  a.add("John");
//  a.add("Tim");
//  a.add("John");
//  a.add("Marry");
// Collections.sort(a);
// System.out.println(a);
      
int[] A={9,7,6,6};
int[] B={9,5,7};
int i=A.length-1,j=B.length-1;
int[] sum=new int[5];
int k=sum.length-1,carry=0;
while(k>=0){
    if(i<0 && j>=0){
       sum[k]= value(0,B[j],0,carry);
       carry=value(0,B[j],1,carry);
       k--;
       j--;
    }
    else if(i>=0 && j<0){
       sum[k]= value(A[i],0,0,carry);   
       carry=value(A[i],0,1,carry);
       k--;
       i--; 
    }
    else if(i<0 && j<0){
        sum[k]=value(0,0,0,carry);
        carry=value(0,0,1,carry);
        k--;
    }
    else{
        sum[k]= value(A[i],B[j],0,carry);
       carry=value(A[i],B[j],1,carry);
       k--;
       i--; 
       j--;
    }
}
    for(int i1:sum){
        System.out.print(i1+" ");
    }
    }
    public static int value(int a, int b,int c,int carry){
        if(c==0)
            return (a+b+carry)%10;
        return (a+b+carry)/10;

    }
}
