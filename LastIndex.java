package DSA;

public class LastIndex {
    public static void main(String[] args) {
        int[] input={};
        int x=61;
        return lastIndexRecursionFromFirst(input,x,0);
    }


    public static int lastIndexRecursionFromFirst(int[] input,int x, int si){
		if(si==input.length)
			return -1;

		int smallOutput=lastIndexRecursionFromFirst(input, x, si+1);
		if(smallOutput!=-1)
			return smallOutput;
		else{
			if(input[si]==x)
				return si;
			else
				return -1;
		}
	}

}

//approach 2 : from SI , we will create small arrays until it is 0 and check one by one from back 
//i.e., arr[0] for each small array divided 