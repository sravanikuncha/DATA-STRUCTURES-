import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BackTrackingPractice {

    private static boolean ratInaMazePath(int[][] maze,int n, int i,int j){
        //base case
        if(i==n-1 && j==n-1){
            return true;
        }

        maze[i][j]=0;
        boolean right=false, left=false,top=false,bottom=false;
        if(j+1<n && maze[i][j+1]==1){
            //right
            right=ratInaMazePath(maze, n, i, j+1);
        }

        if(j-1>=0 && maze[i][j-1]==1){
            //left
            left=ratInaMazePath(maze, n, i, j-1);
        }

        if(i+1<n && maze[i+1][j]==1){
            //bottom
            left=ratInaMazePath(maze, n, i+1, j);
        }

        if(i-1>=0 && maze[i-1][j]==1){
            //top
            left=ratInaMazePath(maze, n, i-1, j);
        }

        return top || left || right || bottom;
    }

    private static void printMaze(int[][] path,int n){
        path[0][0]=1;
        path[n-1][n-1]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(path[i][j]+" ");
            }
        }
        System.out.println();
    }

    private static void ratInaMazePathPrint(int[][] maze,int[][] path, int n , int i, int j){
         //base case
         if(i==n-1 && j==n-1){
           printMaze(path,n);
            return ;
        }

        maze[i][j]=0;
        path[i][j]=1;
        
        if(j-1>=0 && maze[i][j-1]==1){
            //left
           ratInaMazePathPrint(maze,path, n, i, j-1);
        }

        if(j+1<n && maze[i][j+1]==1){
            //right
           ratInaMazePathPrint(maze,path, n, i, j+1);
        }

        if(i-1>=0 && maze[i-1][j]==1){
            //top
         ratInaMazePathPrint(maze,path, n, i-1, j);
        }

        if(i+1<n && maze[i+1][j]==1){
            //bottom
          ratInaMazePathPrint(maze,path, n, i+1, j);
        }

        path[i][j]=0;
        maze[i][j]=1;

    }

    private static boolean validPlaceToKeepQueen(int[][] queens , int row, int col, int n){


        //row check 
        // for(int j=0;j<n;j++){
        //     if(j!=col && queens[row][j]!=0){
        //         return false;
        //     }
        // }

         //col check 
         for(int i=0;i<row;i++){
            if(queens[i][col]!=0){
                return false;
            }
        }

        //diagnol check
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(queens[i][j]!=0){
                return false;
            }
        }

        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(queens[i][j]!=0){
                return false;
            }
        }

        queens[row][col]=1;
        return true;
    }

    private static void placeAndPrintQueens(int[][] queens, int n){

        for(int r=1;r<n;r++){
            boolean queenPlaced=false;
            for(int c=0;c<n;c++){
                if(validPlaceToKeepQueen(queens,r,c,n)){
                    queenPlaced=true;
                    break;
                }
            }
            if(!queenPlaced){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        queens[i][j]=0;
                    }
                }
                return;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(queens[i][j]+" ");
                queens[i][j]=0;
            }
        }
        System.out.println();

        return ;
    }

    //brute force approach
    private static void placeQueens(int[][] queens, int n){

        for(int c=0;c<n;c++){
            queens[0][c]=1;
            placeAndPrintQueens(queens,n);
            queens[0][c]=0;
        }
    }

    //
    private static void placeQueensRecursive(int[][] queens,int n,int r){
        //base case--placed all n queens and came out of matrix
        if(r==n){
            for(int m=0;m<n;m++){
                for(int j=0;j<n;j++){
                    System.out.print(queens[m][j]+" ");
                }
            }
            System.out.println();
            return;
        }


        for(int c=0;c<n;c++){
            if(validPlaceToKeepQueen(queens, r, c, n)){
                queens[r][c]=1;
                placeQueensRecursive(queens,n,r+1);
                queens[r][c]=0;
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // System.out.println("size of maze");
        // int n=sc.nextInt();
        // System.out.println("Enter maze details");
        // int[][] maze=new int[n][n];
        // for(int i=0;i<n;i++){
        //     for (int j=0;j<n;j++){
        //         maze[i][j]=sc.nextInt();
        //     }
        // }

        // boolean isPathPresent=ratInaMazePath(maze,n,0,0);

        // if(!isPathPresent){
        //     System.out.println("Path not  Present");
        //     return;
        // }
        // System.out.println("Path  present");
        // int[][] path=new int[n][n];
        // ratInaMazePathPrint(maze,path,n,0,0);

        System.out.println("N Queens");
        int n=sc.nextInt();
        int[][] queens =new int[n][n];
        // placeQueens(queens,n);
        placeQueensRecursive(queens,n,0);
        sc.close();
    }
}
