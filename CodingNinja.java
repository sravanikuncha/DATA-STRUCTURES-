import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingNinja {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String[] takeInput() throws IOException {
		String[] strNums;
        strNums = br.readLine().split("\\s");
        int size = 2;
        int[] input = new int[size];
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }


		String[] Graph = new String[input[0]];
		
        for (int i = 0; i < input[0]; ++i) {
            Graph[i] = br.readLine();
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String[] Graph = takeInput();
        System.out.println(new CodingNinja().solve(Graph,Graph.length,Graph[0].length()));

    }
	
	int solve(String[] Graph , int N, int M)
	{
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
		int[][] graphMatrix=new int[26][26];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				int presentCell=Graph[i].charAt(j)-65;
				if(i-1>=0){
					int aboveCell=Graph[i-1].charAt(j)-65;
                        graphMatrix[presentCell][aboveCell]=1;
                        graphMatrix[aboveCell][presentCell]=1;
				}
				if(i+1<N){
					int aboveCell=Graph[i+1].charAt(j)-65;
					    graphMatrix[presentCell][aboveCell]=1;
					    graphMatrix[aboveCell][presentCell]=1;
				}
				if(j-1>=0){
					int aboveCell=Graph[i].charAt(j-1)-65;
					    graphMatrix[presentCell][aboveCell]=1;
					    graphMatrix[aboveCell][presentCell]=1;
				}

				if(j+1<M){
					int aboveCell=Graph[i].charAt(j+1)-65;
					    graphMatrix[presentCell][aboveCell]=1;
					    graphMatrix[aboveCell][presentCell]=1;
				}
                if(i+1<N && j+1<M){
					int aboveCell=Graph[i+1].charAt(j+1)-65;
                    if(presentCell<=7 && aboveCell<=7){
					    graphMatrix[presentCell][aboveCell]=1;
					    graphMatrix[aboveCell][presentCell]=1;
                    }
                }
                if(i-1>=0 && j-1>=0){
					int aboveCell=Graph[i-1].charAt(j-1)-65;
					    graphMatrix[presentCell][aboveCell]=1;
					    graphMatrix[aboveCell][presentCell]=1;
                }
                if(i+1<N && j-1>=0){
					int aboveCell=Graph[i+1].charAt(j-1)-65;
					    graphMatrix[presentCell][aboveCell]=1;
					    graphMatrix[aboveCell][presentCell]=1;
                }

                if(i-1>=0 && j+1<M){
					int aboveCell=Graph[i-1].charAt(j+1)-65;
					    graphMatrix[presentCell][aboveCell]=1;
					    graphMatrix[aboveCell][presentCell]=1;
                }
			}
		}


		String s="CODINGNINJA";
		for(int i=1;i<s.length();i++){
			int row=s.charAt(i)-65;
			int column=s.charAt(i-1)-65;
			if(graphMatrix[row][column]!=1){
				return 0;
			}
		}

		return 1;

	}

	
	
	
}