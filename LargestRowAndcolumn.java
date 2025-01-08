public class LargestRowAndcolumn {
    public static void main(String[] args) {
        int[][] mat={{6,9},{8,5},{9,2}};
        int rows=mat.length,sum=0,sumr=Integer.MIN_VALUE,sumc=Integer.MIN_VALUE;
		int columnIndex=0,rowIndex=0,columns=0;
		if(rows>0)
		 columns=mat[0].length;


		for(int i=0;i<rows;i++){
            sum=0;
			for(int j=0;j<columns;j++){
				sum+=mat[i][j];
			}
			if(sum>sumr){
				sumr=sum;
				rowIndex=i;
			}
		}
	

	for(int i=0;i<columns;i++){
        sum=0;
		for(int j=0;j<rows;j++){
			sum+=mat[j][i];
		}
		if(sum>sumc){
			sumc=sum;
			columnIndex=i;
		}
	}

	if(sumr>=sumc)
		System.out.println("row "+rowIndex+" "+sumr);
	else
		System.out.println("column "+columnIndex+" "+sumc);
    }
}
