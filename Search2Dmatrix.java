public class Search2Dmatrix {
    public static void main(String[] args) {
        int target=458;
        int[][] mat={{10, 20 ,70 ,102, 188},{214, 249, 276, 281, 372 },{383 ,400 ,420 ,449 ,458}};
        int rows=mat.length,columns=0;
        if(rows!=0){
            columns=mat[0].length;
        }
        
        int i=0;
        for(i=0;i<rows;i++){
            if(target<=mat[i][columns-1]){
                break;
            }

        }


        System.out.println(i);
        for(int j=0;j<columns;j++){
            if(mat[i][j] ==target){
                System.out.println("true");  
                    return;
            }
             }

System.out.println("false");    }
}
