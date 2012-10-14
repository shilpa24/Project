package gameoflife;

public class Cell 
{	
	private CellState cellState;
	private int rowIndex;
	private int colIndex;
	
	public Cell(int x, int y, CellState cellstate)
	{
		this.rowIndex = x;
		this.colIndex = y;
		this.cellState = cellstate;
	}
	
	public CellState getCurrentState()
	{
		return this.cellState;
	}
	
	public int getRowIndex()
	{
		return this.rowIndex;
	}
	
	public int getColIndex()
	{
		return this.colIndex;
	}
	
	public void setColIndex(int val)
	{
		this.colIndex = val;
	}
	
	public void setRowndex(int val)
	{
		this.rowIndex = val;
	}
		
	public void setState(CellState s)
	{
		this.cellState = s;
	}
}
