import java.util.Scanner;
public class BrowserHistoryInput {
    


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		String input = scn.next();

		BrowserHistory obj = new BrowserHistory (input);


		int i = scn.nextInt();
		while(true){
			switch(i){
            			case 1: input=scn.next();
                    			obj.visit(input);
                    			break;
            			case 2: int k = scn.nextInt();
                    			input=obj.back(k);
                    			System.out.println(input);
                    			break;
            			case 3: k = scn.nextInt();
                    			input=obj.forward(k);
                    			System.out.println(input);
                    			break;
            			default: return;
        		}
        		i = scn.nextInt();
		}
	}
}


