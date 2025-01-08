import java.util.Scanner;

public class ControlFlows {
    public static void main(String[] args) {
        	// Scanner sc = new Scanner(System.in);
            // System.out.println("Enter GPA and stars and scholarshipmarks");
            // char a='A';
            // switch(a){
            //     case 'A':System.out.println("A it is");
            // }
            // boolean b=false;
            // // switch(b){

            // // }
            // int x = 2;
            // switch (x + 1) {
            //     case 1:
            //         System.out.println(1);
            //         break;
            //     case 1 + 1:
            //         System.out.println(2);
            //         break;
            //     case 2 + 1:
            //         System.out.println(3);
            //         break;
            //     default:
            //         System.out.println("Default");
            // }
	        // sc.close();

            // /FLows
            // int i=0;
            // for(;i<=5;){
            //     System.out.println(i);
            //     i++;
            // }

            // int j,sum=0;
            // System.out.println(i+" "+sum);
            int n=109878;
            while(n!=0){
                int rem=n%10;
                if(rem !=0){
                    System.out.print(rem);
                }
                n=n/10;
            }
    }
}
