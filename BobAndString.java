import java.util.HashMap;
import java.util.Scanner;

public class BobAndString {

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here

		Scanner sc=new Scanner(System.in);
		int testCases=sc.nextInt();
		for(int i=0;i<testCases;i++){
			String s=sc.next();
			int count=-1;
			HashMap<Character,Integer> hm=new HashMap<>();
			for(int c=0;c<s.length();c++){
				if(hm.containsKey(s.charAt(c))){
					int getIndex=hm.get(s.charAt(c));
					// System.out.println(s.charAt(c)+" "+getIndex);
					if(count==-1){
						count=c-getIndex-1;
					}
					else{
						int tempCount=c-getIndex-1;
						if(tempCount>count)
							count=tempCount;
					}
				}
				else{
					hm.put(s.charAt(c),c);
				}
			}
			System.out.println(count);
		}

	}

}