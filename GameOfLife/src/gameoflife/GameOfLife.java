package gameoflife;

public class GameOfLife 
{
	//default constructor
	public GameOfLife(){}
	
	// This method takes the board, creates a new board for the next generation based on each cell's current
	// state and its neighbors state.
	public Board findNextGeneration(Board gameBoard)
	{
			Board nextGen = new Board(gameBoard.getTotalRows(), gameBoard.getTotalCols());
			
			for(int i = 0; i < gameBoard.getTotalRows(); i++)
			{
				for(int j = 0; j < gameBoard.getTotalCols(); j++)
				{
					 Cell c = gameBoard.getCell(i,j);
					 int liveNeighbors = gameBoard.countAliveNeighbors(c);
					 
					 switch(c.getCurrentState())
					 {
						 case Alive:
							 if(liveNeighbors < 2 || liveNeighbors > 3)
							 {
								 // under-populated or over-crowded
								 nextGen.setCell(i,j, CellState.Dead);
							 }
							 else
							 {
								 // survival
								 nextGen.setCell(i,j, CellState.Alive);
							 }
							 break;
							 
						 case Dead:
							 if(liveNeighbors == 3)
							 {
								 // reproduction
								 nextGen.setCell(i,j, CellState.Alive);
							 }
							 else
							 {
								 nextGen.setCell(i,j, CellState.Dead);
							 }
							 
							 break;
					 }
				}
			}
			return nextGen;
	}
	

	public static void main(String[] arg)
	{
			GameOfLife game = new GameOfLife();
			
			Board b = new Board(5,5, new CellState[] { CellState.Dead, CellState.Alive, CellState.Dead, CellState.Dead, CellState.Dead,
								CellState.Alive, CellState.Dead, CellState.Dead, CellState.Alive, CellState.Alive,
								CellState.Alive, CellState.Alive, CellState.Dead, CellState.Dead, CellState.Alive,
								CellState.Dead,CellState.Alive, CellState.Dead, CellState.Dead, CellState.Dead,
								CellState.Alive, CellState.Dead, CellState.Dead, CellState.Dead, CellState.Alive});
			b.print();
			
			Board b1 = game.findNextGeneration(b);
			System.out.println();
			b1.print();
	}
	
}
