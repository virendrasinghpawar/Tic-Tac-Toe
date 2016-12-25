
public class Board {
	public static final int ROWS=3;
	public static final int COLUMNS=3;
	Cell[][]cells;
	int currentRow, currentCol;
	
	public Board() {
		cells=new Cell[ROWS][COLUMNS];
		for(int row=0;row<ROWS;row++)
			for(int col=0;col<COLUMNS;col++)
			{
				cells[row][col]=new Cell(row, col);
			}
	}
	
	public void init()
	{
		for(int row=0;row<ROWS;row++)
			for(int col=0;col<COLUMNS;col++)
				cells[row][col].clear();
	}
	
	public boolean isDraw()
	{
		for(int row=0;row<ROWS;row++)
			for(int col=0;col<COLUMNS;col++)
			{
				if(cells[row][col].content==Seed.EMPTY)
				{
					return false;
				}
			}
		return true;
	}
	
	public boolean hasWon(Seed theSeed)
	{
		return ((cells[currentRow][0].content== theSeed && cells[currentRow][1].content== theSeed && cells[currentRow][2].content== theSeed) 
				|| (cells[0][currentCol].content==theSeed && cells[1][currentCol].content== theSeed && cells[2][currentCol].content== theSeed) 
				|| (currentRow==currentCol && cells[0][0].content== theSeed && cells[1][1].content== theSeed && cells[2][2].content== theSeed) 
				|| (currentRow+currentCol==2 && cells[0][2].content== theSeed && cells[1][1].content== theSeed && cells[2][0].content== theSeed)
				);
	}
	
	public void paint()
	{
		for(int row=0;row<ROWS;++row){
			for(int col=0;col<COLUMNS;++col)
			{
				cells[row][col].paint();
				if(col<COLUMNS-1)
					System.out.print("|");
			}
		System.out.println();
		if(row<ROWS-1)
			System.out.println("-------------");
		}
	}
}
