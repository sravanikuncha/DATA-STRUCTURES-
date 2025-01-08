public class Patternmoderate {
    public static void main(String[] args) {

        int n=5;
        int count=0;
		int stop=(n%2)==0?(n/2):(n/2)+1;
		String[] output=new String[n];

		int k=0;
        System.out.println(stop);
		for(int i=0;i<stop;i++){
			int startnr=(n*count)+1;
			int j=0;
			output[k]="";
			while(j<n){
				output[k]+=Integer.toString(startnr)+" ";
				startnr++;
				j++;
			}
            System.out.println("k"+k);
			k++;
			count=count+2;
		}
        
        if(n%2==0)
            count=count-1;
        else
            count=count-2-1;
		count=stop;

		for(int i=stop;i<n;i++){
			int startnr=(n*count)+1;
			int j=0;
            System.out.println("k"+k);
			output[k]="";
			while(j<n){
				output[k]+=Integer.toString(startnr)+" ";
				startnr++;
				j++;
			}
			k++;
			count=count-2;
		}


        for(String i:output){
            System.out.println(i);

        }
    }
}
