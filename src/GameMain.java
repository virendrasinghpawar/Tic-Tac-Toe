import java.util.*;
public class GameMain {
	private Board board;
	private GameState currentState;
	private Seed currentPlayer;
	
	private static Scanner in= new Scanner(System.in);
	public GameMain() {
		board= new Board();
		initGame();
		do
		{
		PlayerMove(currentPlayer);
		board.paint();
		updateGame(currentPlayer);
		if(currentState == GameState.CROSS_WON)
			System.out.println("Player X wins, Bye !");
		else if(currentState == GameState.NAUGHT_WON)
			System.out.println("Player O wins, Bye !");
		else if(currentState == GameState.DRAW)
			System.out.println("It's Draw, Bye !");
		
		currentPlayer = ( currentPlayer == Seed.CROSS)? Seed.NAUGHT : Seed.CROSS; 
		}while(currentState == GameState.PLAYING);

	}
	public void initGame()
	{
		board.init();
		currentPlayer=Seed.CROSS;
		currentState=GameState.PLAYING;
	}
	
	public void PlayerMove(Seed theSeed)
	{
		boolean validInput=false;
		do
		{
			if(theSeed==Seed.CROSS)
			{
				System.out.println("Player 'X', enter your move (Row [1-3] Column[1-3]) : ");
			}
			else
			{				
				System.out.println("Player 'O', enter your move (Row [1-3] Column[1-3]) : ");
			}
			int row=in.nextInt()-1;
			int col=in.nextInt()-1;
			
			if(row>=0 && row < Board.ROWS && col>=0 && col<Board.COLUMNS && board.cells[row][col].content==Seed.EMPTY )
			{
				board.cells[row][col].content= theSeed;
				board.currentRow=row;
				board.currentCol=col;
				validInput=true;
			}
			else
			{
				System.out.println("This move at ( "+(row+1)+" , "+(col+1)+") is not valid ! Please try again...");
			}
		}while(!validInput);
	}
	
	public void updateGame(Seed theSeed)
	{
		if(board.hasWon(theSeed))
		{
			currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NAUGHT_WON;
		}
		else if(board.isDraw())
		{
			currentState=GameState.DRAW;
		}
	}
	public static void main(String[] args) {
		new GameMain();
	}
}
