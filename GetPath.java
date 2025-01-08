import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class GetPath {
	
	public static void main(String[] args)  throws NumberFormatException, IOException{
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
		 Scanner sc=new Scanner(System.in);
		 int vertices=sc.nextInt();
		 int edges=sc.nextInt();

		 if(vertices==0 && edges==0)
		 	return ;

	

		int[][] adjmatrix=new int[vertices][vertices];

		 for(int i=0;i<edges;i++){
			 int v1=sc.nextInt();
			 int v2=sc.nextInt();

			 adjmatrix[v1][v2]=1;
			 adjmatrix[v2][v1]=1;
		 }


		int sourcevertex=sc.nextInt();
		int targetvertex=sc.nextInt();
		boolean[] visited=new boolean[vertices];
		visited[sourcevertex]=true;

		HashMap<Integer,Integer> hm=bftTraersal(vertices, edges, adjmatrix, sourcevertex, targetvertex, visited);
		int temp=targetvertex;
		while(hm.containsKey(temp)){
			System.out.print(temp+" ");
			temp=hm.get(temp);
		}
	}
	private static HashMap<Integer,Integer> bftTraersal(int vertices,int edges,int[][] adjmatrix,int sourcevertex,int targetvertex,boolean[] visited){
		Queue<Integer> q=new LinkedList<>();
		HashMap<Integer,Integer> hm=new HashMap<>();
		 q.add(sourcevertex);
		 hm.put(sourcevertex,-1);
		 visited[sourcevertex]=true;

		 while(!q.isEmpty()){
			 int frontVertex=q.poll();
			 for(int i=0;i<vertices;i++){
				 if(adjmatrix[frontVertex][i]==1 && !visited[i]){
					 if(i==targetvertex){
						 hm.put(i,frontVertex);
						 return hm;
					 }
					 else{
						hm.put(i,frontVertex);
						q.add(i);
						visited[i]=true;
					 }
				 }
			 }
		 }

		 return hm;
	}
}