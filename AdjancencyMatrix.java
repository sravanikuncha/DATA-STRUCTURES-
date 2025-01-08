import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjancencyMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();

        int[][] adjMatrix=new int[n][n];
        for(int i=0;i<e;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            adjMatrix[v1][v2]=1;
            adjMatrix[v2][v1]=1;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
        
        boolean[] visited =new boolean[n];
        System.out.println("DFT traversal ");
        dftTraversal(adjMatrix,0,visited);
        System.out.println("\nBFT Traversal ");
        visited =new boolean[n];
        bftTraversal(adjMatrix,0,visited);
    }

    private static void bftTraversal(int[][] adjMatrix,int currentvertex,boolean[] visited){
        Queue<Integer> q=new LinkedList<>(); 
        System.out.print(currentvertex+" ");
        q.add(currentvertex);
        visited[currentvertex]=true;

        while(!q.isEmpty()){
            int front=q.poll();
            for(int i=0;i<adjMatrix.length;i++){
                if(adjMatrix[front][i]==1 && !visited[i]){
                    q.add(i);
                    System.out.print(i+" ");                    
                    visited[i]=true;
                }
            }
        }
    }

    private static void dftTraversal(int[][] adjMatrix,int currentvertex,boolean[] visited){
        visited[currentvertex]=true;
        System.out.print(currentvertex+" ");
        for(int i=0;i<adjMatrix.length;i++){
            if(adjMatrix[currentvertex][i]==1 && !visited[i]){
                dftTraversal(adjMatrix, i,visited);
            }
        }
    }
}
