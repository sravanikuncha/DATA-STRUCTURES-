public class Loops {
    public static void main(String[] args) {    

        int previous=0,second=1,third;
        while(previous<=50){
            System.out.print(previous+" ");
            third=previous+second;
            previous=second;
            second=third;
        }
         previous=0;
         second=1;
         third=0;
System.out.println();
        for(;previous<=50;){
             System.out.print(previous+" ");
            third=previous+second;
            previous=second;
            second=third;
        }

        double x=0;
        System.out.println(x);
    }
}
