public class Wave {
    public static void main(String[] args) {
        int[][] mat ={{6, 9, 8, 5,9},{2,4,1,8,3 },{9,3,8,7,8},{6,8,9,4,1} ,{1,7,6,1,5}};

        if(mat.length>0){
            int rowsStart=0;
			for(int i=0;i<mat[0].length;i++){
                rowsStart=0;
                if(i%2!=0){
                    rowsStart=mat.length-1;
                    for(int r=rowsStart;r>=0;r--){
                    System.out.print(mat[r][i]+" ");
                }
                }
                else{
                    for(int r=rowsStart;r<mat.length;r++){
                        System.out.print(mat[r][i]+" ");
                    }
                }
			}
		}
    }
}
