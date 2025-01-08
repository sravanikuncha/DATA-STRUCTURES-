import java.util.Scanner;
import java.lang.String;

public record CharacterArrayStrings() {
    public static void main(String args[]){
        // Scanner sc=new Scanner(System.in);
       

        // char ch[]={'c','c'};
        // char ch1[]={'d'};
        // System.out.println(ch);
        
        // String s1="helo";
        // String s2=new String("Coding");
        // System.out.println(s1);
        // System.out.println(s2);

        // System.out.println("abc".compareTo("abcd"));


        Scanner sc1=new Scanner(System.in);
        // String s1=sc1.nextLine();
        // System.out.println(s1);
        // s1=sc1.nextLine();
        // System.out.println(s1);
        sc1.close();

    //     String inputString="this is my nam e fesfd";
    //     int count=0;
    //     for(int i=0;i<inputString.length();i++){
    //         char c=inputString.charAt(i);
    //         if (c==' ')
    //             count++;
    //     }
    //     count++;
    //     System.out.println(count);

    //     inputString="this, nasnk, ouoasn, jbskj";
    //    String[] strArray= inputString.split(", ");
    //     System.out.println(strArray[1]);

    //     String inputString1="hello";
    //     String x="";
    //     for(int i=inputString1.length()-1;i>=0;i--){
    //         x=x+inputString1.charAt(i);
    //     }
    //     System.out.println(x);


        // String str="racecar kayak refer";
        // String[] str1Array=str.split(" ");
		// String rev="";
		// for(int i=0;i<str1Array.length;i++){
		// 	rev=rev+stringReverse(str1Array[i])+" ";
		// 	// rev=rev+" ";
		// }
        // System.out.println(rev);

        // ----------
        String str="let us code";
        String finalString="";
        while(true){
            int j=str.indexOf(" ");
            finalString+=stringReverse(str.substring(0,j==-1?str.length():j ))+" ";
            if(j==-1)
                break;
            str=str.substring(++j);
        }
        System.out.println(finalString);

        str="let us code";
        finalString="";
         int start=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ' || i==str.length()-1){
                int end=i==str.length()-1?i:i-1;
                finalString+=stringReverse2(str,start,end)+" ";
                start=i+1;
            }

        }
        System.out.println(finalString+" 2");
        // -----------

        String[] s1={"ajjk","kjdnjk","wbjdb"};
        System.out.println(s1[0]+" "+s1);
        s1[0]="sdbkjbq";
        System.out.println(s1[0]+" "+s1);

        StringBuffer sb=new StringBuffer();
        sb.append("lneklnkldbdkjbk777");
        System.out.println(sb.length());
        System.out.println(sb.capacity());


        System.out.println("SuBstrings solution");
        String strings="mango";
        int i=0;
        while(i<strings.length()){
            int j=i+1;
            // System.out.println(j);
            while(j<=strings.length()){
                System.out.println(strings.substring(i,j));
                j++;
            }
            i++;
        }

      System.out.println("\n\n\n\nsubsringstype2"); 
        i=1;
        while(i<=strings.length()){
            int j=0;
            while(j+i<=strings.length()){
                System.out.println(strings.substring(j,i+j));
                j++;
            }
            i++;
        }        
    }
    public static String stringReverse(String str) {
        // Write your code here.
        String rev="";
          for(int i=str.length()-1;i>=0;i--){
            rev=rev+str.charAt(i);
          }
          return rev;
      }

      public static String stringReverse2(String str,int start,int end) {
        // Write your code here.
        String rev="";
          for(int i=end;i>=start;i--){
            rev=rev+str.charAt(i);
          }
          return rev;
      }
}
