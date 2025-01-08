

public class maximumProfit {
    public static void main(String[] args) {

        printRe(0,99999,1000000);
        }

        public static void printRe(int start,int end,int n){
            if(start>end)
                return;
                       
            printRe(start+1,end-1,n);
            
        }
    }