public class JaggedArrays {
    public static void main(String[] args) {
        int a[][]={{1,2,3},{2,3,4,5,5}};

        //System.out.println(a[0][3]);
        //array out of bound 
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++)
                System.out.print(a[i][j]+" ");
            System.out.println();
        }


        //second way
        int a1[][]=new int[1][];
        int x[]=new int[2];
        a1[0]=x;
        System.out.println(a1[0][0]);
    }
}
