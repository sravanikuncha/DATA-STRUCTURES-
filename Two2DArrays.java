import java.util.Scanner;

public class Two2DArrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        int columns=sc.nextInt();
        int twoD[][]=new int[rows][columns];

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                twoD[i][j]=sc.nextInt();
            }
        }

        for(int[] i:twoD){
            for(int j:i){
                System.out.print(j+" ");
            }
        }
        sc.close();

    }
}
