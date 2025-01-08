import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicProgramming {
    public static void main(String[] args) throws IOException {
        // int n=10;
        // int[] arr=new int[n+1];
        // for(int i=0;i<arr.length;i++)
        //     arr[i]=-1;
        // int ans=fibonaciDP(n,arr);
        // int ans2=iterativefibonaciDP(n,arr);
        // System.out.println(ans+"   itervative ="+ans2);


        // //staircase 
        // n=2;
        // long[] arr1=new long[n+1];
		// for(int i=0;i<=n;i++)
		// 	arr1[i]=-1;
		// System.out.println(stairCaseMemoization(n,arr1));

        //loot houses
        
        int[] arr = takeInput();
            System.out.println(maxMoneyLooted(arr));

    }
    
    public static int[] takeInput() throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());

		if (n == 0) {
			return new int[0];
		}

		String[] strNums = br.readLine().trim().split("\\s");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strNums[i]);
        }

        return arr;
	}

    public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
		if(houses.length==0)
			return 0;


		return maxMoneyLootedHelperRecursive(houses,0);

		// int[] housesDPMemoisation=new int[houses.length+2];
		// for(int i=0;i<housesDPMemoisation.length;i++){
		// 	housesDPMemoisation[i]=-1;
		// }

		// return maxMoneyLootedHelperMemoisation(houses, 0, housesDPMemoisation);
	}

	private static int maxMoneyLootedHelperMemoisation(int[] houses,int index,int[] housesDPMemoisation){

	return 0;
	}
	private static int maxMoneyLootedHelperRecursive(int[] houses,int index)
	{

		if(index>houses.length)
			return 0;
		
		int myAns=0;
		for(int i=index;i<houses.length;i++){
			int finalAns=0;
			for(int j=i+2;j<houses.length;j++){
					int smallAns=maxMoneyLootedHelperRecursive(houses,j);
					finalAns=Math.max(finalAns,smallAns);
			}
			finalAns=finalAns+houses[i];
			myAns=Math.max(myAns,finalAns);
		}

		return myAns;
	}


    public static long stairCaseMemoization(int n , long[] dp){
		if(n<0)
			return 0;
		
		if(n==0)
			return 1;
		
		long x=0,y=0,z=0;
		if(n-1>=0 && dp[n-1]==-1){
			x=stairCaseMemoization(n-1, dp);
			dp[n-1]=x;
		}
        else if(n-1>=0){
            x=dp[n-1];
        }

		if(n-2>=0 && dp[n-2]==-1){
			y=stairCaseMemoization(n-2, dp);
			dp[n-2]=y;
		}   
        else if(n-2>=0){
            y=dp[n-2];
        }
	
		if(n-3>=0 && dp[n-3]==-1){
			z=stairCaseMemoization(n-3, dp);
			dp[n-3]=z;
		}
        else if(n-3>=0){
            z=dp[n-3];
        }

		return x+y+z;

		
	}

    public static int iterativefibonaciDP(int n,int[] dp){

        if(n==0 || n==1){
            return n;
        }

        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    public static int fibonaciDP(int n, int[] dp){
        if(n==0 || n==1){
            return n;
        }

        if(dp[n-1]==-1){
            dp[n-1]=fibonaciDP(n-1, dp);
        }

        if(dp[n-2]==-1){
            dp[n-2]=fibonaciDP(n-2, dp);
        }

        return dp[n-1]+dp[n-2];
    }
}
