import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class RottenOranges {


	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/
		// dfs approach 
	
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();

		int[][] mainA=new int[n][m];
		// int[][] copyOfmainA=new int[n][m];

		int[] twoDIndex;

		Queue<int[]> queue=new LinkedList<>();

		int onesCount=0;


		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				mainA[i][j]=sc.nextInt();
				// copyOfmainA[i][j]=mainA[i][j];
				if(mainA[i][j]==2)
				{	
					twoDIndex=new int[]{i,j};
					queue.add(twoDIndex);
				}
				else if(mainA[i][j]==1)
					onesCount++;

			}
		}

		int timeframe=0;

		while(!queue.isEmpty()){
		int size=queue.size();
		while(size!=0) {

			twoDIndex=queue.poll();
			int r=twoDIndex[0];
			int c=twoDIndex[1];

			if(r-1>=0 && mainA[r-1][c]==1){
				mainA[r-1][c]=2;
				onesCount--;
				twoDIndex=new int[]{r-1,c};
				queue.add(twoDIndex);
			}
			if(r+1<n && mainA[r+1][c]==1){
				mainA[r+1][c]=2;
				onesCount--;
				twoDIndex=new int[]{r+1,c};
				queue.add(twoDIndex);
			}
			if(c-1>0  && mainA[r][c-1]==1){
				mainA[r][c-1]=2;
				onesCount--;
				twoDIndex=new int[]{r,c-1};
				queue.add(twoDIndex);
			}
			if( c+1<m  && mainA[r][c+1]==1){
				mainA[r][c+1]=2;
				onesCount--;
				twoDIndex=new int[]{r,c+1};
				queue.add(twoDIndex);
			}

			size--;

			if(onesCount==0)
				break;
		}
		timeframe++;
		if(onesCount==0)
				break;
		}

		if(queue.isEmpty() && onesCount>0 )
			System.out.println("-1");
		else{
			System.out.println(timeframe);
		}

		//brute force 
	// 	Scanner sc=new Scanner(System.in);
	// 	int n=sc.nextInt();
	// 	int m=sc.nextInt();

	// 	int[][] mainA=new int[n][m];
	// 	int[][] copyOfmainA=new int[n][m];

	// 	for(int i=0;i<n;i++){
	// 		for(int j=0;j<m;j++){
	// 			mainA[i][j]=sc.nextInt();
	// 			copyOfmainA[i][j]=mainA[i][j];
	// 		}
	// 	}
    //     // 2 1 0 2 1
    //     // 1 0 1 0 1
    //     // 1 0 0 0 2
    //     for(int i=0;i<n;i++){
	// 		for(int j=0;j<m;j++){
    //             System.out.print(mainA[i][j]+" ");
	// 		}
    //         System.out.println();
	// 	}

	// 	boolean swapped=true;
	// 	int count=0;

	// while(swapped){
	// 	for(int i=0;i<n;i++){
	// 		for(int j=0;j<m;j++){
	// 			if(mainA[i][j]==2){
	// 				if(i-1>=0)
	// 				copyOfmainA[i-1][j]=mainA[i-1][j]!=0?2:0;
	// 				if(i+1<n)
	// 				copyOfmainA[i+1][j]=mainA[i+1][j]!=0?2:0;
	// 				if(j-1>0)
	// 				copyOfmainA[i][j-1]=mainA[i][j-1]!=0?2:0;
	// 				if( j+1<m)
	// 				copyOfmainA[i][j+1]=mainA[i][j+1]!=0?2:0;
	// 			}

	// 			else if(mainA[i][j]==1){
	// 				boolean chanceofrotten=false;
	// 				if(i-1>=0 && !chanceofrotten)
	// 					chanceofrotten=mainA[i-1][j]==0?false:true;
	// 				if(i+1<n && !chanceofrotten)
	// 						chanceofrotten=mainA[i+1][j]==0?false:true;
	// 				if(j-1>=0 && !chanceofrotten)
	// 				chanceofrotten=mainA[i][j-1]==0?false:true;
	// 				if( j+1<m && !chanceofrotten)
	// 				chanceofrotten=mainA[i][j+1]==0?false:true;

	// 				if(!chanceofrotten)
	// 					count=-1;
	// 			}
	// 		}
	// 	}	

	// 	if(count==-1)
	// 		break;
		

	// 	 swapped=swap(copyOfmainA,mainA,n,m);
	// 	 if(swapped)
	// 	 	count++;
		
	// 	}
	// 	// Write your code here

	// 	System.out.println(count);

	}

	public static boolean swap(int[][] copy,int[][] main,int n,int m){

		boolean swapped=false;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(copy[i][j]!=main[i][j]){
					int temp=copy[i][j];
					copy[i][j]=main[i][j];
					main[i][j]=temp;
					swapped=true;
				}
			}
		}

		return swapped;
	}

}


// 2 1 0 2 1
// 1 0 1 2 1
// 1 0 0 2 1