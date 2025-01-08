import java.util.ArrayList;
import java.util.Scanner;

public class TeamSelection {
    public static void main(String[] args) {
        	Scanner sc=new Scanner(System.in);
		int arrlen=sc.nextInt();
		int[] arr=new int[arrlen];
		for(int i=0;i<arrlen;i++){
			arr[i]=sc.nextInt();
		}
		
		ArrayList<Integer> team=new ArrayList<>();
		helper(arr,team);

	}

	private static void helper(int[] arr,ArrayList<Integer> team){
		if(arr.length==0 ){
            if(team.size()==12){
                for(int i=0;i<team.size();i++){
                    System.out.print(team.get(i)+" ");
                }
			System.out.println();
            }
            return;
		}

		//donotinclude;
		int[] arr1=new int[arr.length-1];
		for(int i=0;i<arr1.length;i++){
			arr1[i]=arr[i+1];
		}

      
		helper(arr1, team);

        ArrayList<Integer> tempteam=new ArrayList<>();
        for(int i=0;i<team.size();i++){
            tempteam.add(team.get(i));
        }
        tempteam.add(arr[0]);
		//include 

		helper(arr1, tempteam);
    }
}


import java.util.HashMap;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int kqueries=sc.nextInt();
		for(int i=0;i<kqueries;i++){
			int w=sc.nextInt();
			int x=sc.nextInt();
			int y=sc.nextInt();
			int z=sc.nextInt();

			String wxString=s.substring(w-1,x);
			String yzString=s.substring(y-1,z);

			HashMap<Character,Integer> hm=new HashMap<>();
			if(wxString.length()!=yzString.length()){
				System.out.println("false");
				break;
			}

			for(int i=0;i<wxString.length();i++){
				if(hm.containsKey(wxString.charAt(i))){
					int count=hm.containsKey(wxString.charAt(i));
					hm.put(wxString.charAt(i),count+1);
				}	
				else{
					hm.put(wxString.charAt(i),0);
				}
			}

			for(int i=0;i<yzString.length();i++){
				if(hm.containsKey(yzString.charAt(i))){
					hm.remove(yzString.charAt(i));
				}
				else{
					System.out.println("false");
					break;
				}
			}

			System.out.println("true");
		}
		sc.close();
	}

}