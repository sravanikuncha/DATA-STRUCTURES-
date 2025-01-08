
import java.util.HashMap;
import java.util.Scanner;

// abababba
// 2
// 3 5 1 3
// 1 2 7 8

public class HelpAroma {

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int kqueries=sc.nextInt();
		for(int j=0;j<kqueries;j++){
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

		

            int i=0;

            while(i<wxString.length()){
                char p=wxString.charAt(i);
                char q=yzString.charAt(i);

                if(hm.containsKey(p)){
                    hm.remove(p);
                }
                else{
                    hm.put(p, 1);
                }
                if(hm.containsKey(q)){
                    hm.remove(q);
                }
                else{
                    hm.put(q, 1);
                }
                
            }


            if(hm.size()==0)
			System.out.println("true");
            else{
                System.out.println("false");
            }
		}
		sc.close();
	}

}

	// for(int i=0;i<wxString.length();i++){
			// 	if(hm.containsKey(wxString.charAt(i))){
			// 		int count=hm.get(wxString.charAt(i));
			// 		hm.put(wxString.charAt(i),count+1);
			// 	}	
			// 	else{
			// 		hm.put(wxString.charAt(i),1);
			// 	}
			// }


			// for(int i=0;i<yzString.length();i++){
			// 	if(hm.containsKey(yzString.charAt(i))){
            //     System.out.println(yzString.charAt(i));
            //         int count=hm.get(yzString.charAt(i));
            //         if(count==1)
			// 		hm.remove(yzString.charAt(i));
            //         else{
            //             hm.put(yzString.charAt(i),count-1);
            //         }
			// 	}
			// 	else{
			// 		System.out.println("false");
			// 		break;
			// 	}
			// }