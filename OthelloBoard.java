import java.util.Scanner;

class OthelloBoard1 {

	private int board[][];
	final static int player1Symbol = 1;
	final static int player2Symbol = 2;

	private static int xDir[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int yDir[] = {0, 1, 1, 1, 0, -1, -1, -1};


	public OthelloBoard1() {
		board = new int[8][8];
		board[3][3] = player1Symbol;
		board[3][4] = player2Symbol;
		board[4][3] = player2Symbol;
		board[4][4] = player1Symbol;
	}

	public void print() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean move(int symbol, int x, int y){
		// Complete this function
		/* Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		//valid range and not occupied 

		if(x<0 || x>=8 || y<0 || y>=8 || board[x][y]!=0){
			return false;
		}

		boolean isMovePossible=false;

		for(int i=0;i<8;i++){
			int xChange=xDir[i];
			int yChange=yDir[i];

			int currentX=x+xChange;
			int currentY=y+yChange;

			int countnoofPieces=0;//this is because in diagnol what if only blue bleu is there then ini else when we track back we odnt change anything 
			while(currentX>=0 && currentX<8 && currentY>=0 && currentY<8){
				if(board[currentX][currentY]==0)
					break;
				
				else if(board[currentX][currentY]!=symbol){
					currentX=currentX+xChange;
					currentY=currentY+yChange;		
					countnoofPieces++;			
				}
				else{
					if(countnoofPieces>0){
						currentX=currentX-xChange;
						currentY=currentY-yChange;

						while(currentX!=x && currentY!=y){
							board[currentX][currentY]=symbol;
							isMovePossible=true;
							currentX=currentX-xChange;
							currentY=currentY-yChange;
						}
					}
					break;			
				}
			}
		}

		if(isMovePossible)
			board[x][y]=symbol;
		
		return isMovePossible;
	}
}

public class OthelloBoard {

	static Scanner s = new Scanner(System.in);

	final static int player1Symbol = 1;
	final static int player2Symbol = 2;

	public static void main(String[] args) {
		OthelloBoard1 b = new OthelloBoard1();
		int n = s.nextInt();
		boolean p1Turn = true;
		while(n > 0) {
			int x = s.nextInt();
			int y = s.nextInt();
			boolean ans = false;
			if(p1Turn) {
				ans = b.move(player1Symbol, x, y);
			}
			else {
				ans = b.move(player2Symbol, x, y);
			}
			if(ans) {
				b.print();
				p1Turn = !p1Turn;
				n--;
			}
			else {
				System.out.println(ans);
			}
		}
	}
}