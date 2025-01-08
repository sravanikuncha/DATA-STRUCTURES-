public class SumOfDiagEdges {
    public static void main(String[] args) {
        int[][] mat ={{6, 9, 8, 5,9},{2,4,1,8,3 },{9,3,8,7,8},{6,8,9,4,1} ,{1,7,6,1,5}};
        int index=mat.length-2, rowIndex=1;
        System.out.println();
        int sum=0;
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat.length;j++){
				if(i==0 || i==mat.length-1 || j==0 || j==mat.length-1)
					sum+=mat[i][j];
              
				if(i!=0 && i!=mat.length-1){
                    if(i==rowIndex && j==index){
                        sum+=mat[i][j];
                        rowIndex++;
                        index--;
                    }
                  else if(i==j)
                        sum+=mat[i][j];
                }
				
			}
		}

		System.out.println(sum);
    }
}
