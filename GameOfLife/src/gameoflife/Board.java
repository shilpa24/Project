package gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Board 
{
	private Cell[][] cells;
	private int rows;
	private int cols;
		
	public Board(int totalRows, int totalCols)
	{
		this.rows = totalRows;
		this.cols = totalCols;
		this.cells = new Cell[totalRows][totalCols];
	}
	
	public Board(int totalRows, int totalCols, CellState[] cellStates)throws IllegalArgumentException
	{	
		if(cellStates.length!= totalRows * totalCols)
		{
			throw new IllegalArgumentException("The array size does not match the size of the matrix.");
		}
		
		this.rows = totalRows;
		this.cols = totalCols;
		this.cells = new Cell[totalRows][totalCols];
		int k = 0;
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				cells[i][j] = new Cell(i, j, cellStates[k++]); 
			}
		}
	}
	
	public int getTotalRows()
	{
		return rows;
	}
	
	public int getTotalCols()
	{
		return cols;
	}
	
	public Cell getCell(int row, int col)
	{
		return this.cells[row][col];
	}
		
	public void setCell(int row, int col, CellState s)
	{
		cells[row][col] = new Cell(row, col, s);
	}
	
	private List<Cell> getAllNeighbors(Cell c)
	{
		List<Cell> neighbors =  new ArrayList<Cell>();
		
		neighbors.add(this.getLeftNeighbor(c));
		neighbors.add(this.getRightNeighbor(c));
		neighbors.add(this.getTopNeighbor(c));
		neighbors.add(this.getBottomNeighbor(c));
		neighbors.add(this.getTopLeftNeighbor(c));
		neighbors.add(this.getTopRightNeighbor(c));
		neighbors.add(this.getBottomLeftNeighbor(c));
		neighbors.add(this.getBottomRightNeighbor(c));
		
		return (neighbors.isEmpty()) ? null : neighbors;
	}
	
	private Cell getTopNeighbor(Cell c)
	{
		int newIndex = c.getRowIndex()-1;
		
		if(newIndex >= 0)
		{
			return cells[newIndex][c.getColIndex()];
		}
		return null;
	}
	
	private Cell getBottomNeighbor(Cell c)
	{
		int newIndex = c.getRowIndex()+1;
		
		if(newIndex < this.rows)
		{
			return cells[newIndex][c.getColIndex()];
		}
		return null;
	}
	
	private Cell getLeftNeighbor(Cell c)
	{
		int newIndex = c.getColIndex()-1;
		
		if(newIndex >= 0)
		{
			return cells[c.getRowIndex()][newIndex];
		}
		return null;
	}
	
	private Cell getRightNeighbor(Cell c)
	{
		int newIndex = c.getColIndex()+1;
		
		if(newIndex < this.cols)
		{
			return cells[c.getRowIndex()][newIndex];
		}
		return null;
	}

	private Cell getTopLeftNeighbor(Cell c)
	{
		int newColIndex = c.getColIndex()-1;
		int newRowIndex = c.getRowIndex()-1;
		
		if(newRowIndex >=0 && newColIndex >=0)
		{
			return cells[newRowIndex][newColIndex];
		}
		return null;
	}
	
	private Cell getTopRightNeighbor(Cell c)
	{
		int newColIndex = c.getColIndex()+1;
		int newRowIndex = c.getRowIndex()-1;
		
		if(newRowIndex >=0 && newColIndex < this.cols)
		{
			return cells[newRowIndex][newColIndex];
		}
		return null;
	}
	
	private Cell getBottomLeftNeighbor(Cell c)
	{
		int newColIndex = c.getColIndex()-1;
		int newRowIndex = c.getRowIndex()+1;
		
		if(newRowIndex < this.rows && newColIndex >=0)
		{
			return cells[newRowIndex][newColIndex];
		}
		return null;
	}
	
	private Cell getBottomRightNeighbor(Cell c)
	{
		int newColIndex = c.getColIndex()+1;
		int newRowIndex = c.getRowIndex()+1;
		
		if(newRowIndex < this.rows && newColIndex < this.cols)
		{
			return cells[newRowIndex][newColIndex];
		}
		return null;
	}
		
	public int countAliveNeighbors(Cell c)
	{	
		List<Cell> neighbors = this.getAllNeighbors(c);
		int count = 0;		
		for(int i = 0; i < neighbors.size(); i++)
		{
			Cell cell = neighbors.get(i);
			
			if(cell!= null)
			{
				if(cell.getCurrentState() == CellState.Alive)
				{
					count++;
				}
			}
		}
		return count;
	}
	
	public void print()
	{
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				System.out.print(cells[i][j].getCurrentState().getCellValue() + " ");
			}
			System.out.println();
		}
	}
	
}
