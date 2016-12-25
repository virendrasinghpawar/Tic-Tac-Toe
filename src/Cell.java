
public class Cell {

	Seed content;
	int row,col;
	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		clear();
	}
	public void clear()
	{
		content=Seed.EMPTY;
	}
	public void paint()
	{
		switch(content)
		{
		case CROSS:System.out.print(" X ");break;
		case EMPTY:System.out.print("   ");break;
		case NAUGHT:System.out.print(" O ");break;
		}
	}
}
