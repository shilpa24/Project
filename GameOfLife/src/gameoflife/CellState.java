package gameoflife;

/**
 * An enumeration for Cell State
 */
public enum CellState 
{
	Alive(1),
	Dead(0);
	
	private int cellValue;
	
	 CellState(int value)
	{
		this.cellValue = value;
	}
	
	public int getCellValue()
	{
		return this.cellValue;
	}

}
