import java.util.ArrayList;
import java.util.Scanner;

public class JavaBasics {

    public static void main(String[] args) {

        
        int n=101;
        int reversenumber=0;
        while(n!=0){
            int rem =n%10;
            reversenumber=reversenumber*10+rem;
            n=n/10;
        }
        if(reversenumber==n)
             System.out.println("true");
        System.out.println("false");


//         int lower=10, upper=30;
//         ArrayList<Integer> arr2 = new ArrayList<Integer>();
//         for(int num=lower ;num<=upper;num++){
//             int presenTnr=num;
//             boolean flag=true;
//             while(presenTnr!=0){
//                 int rem=presenTnr%10;
//                 if(rem!=0 && num%rem==0){
//                     presenTnr=presenTnr/10;
//                     continue;
//                 }
//                 else{
//                     flag=false;
//                     break;
//                 }
//             }
//             if(flag)
//                 arr2.add(num);
//         }
// System.out.println(arr2);
    }
}
