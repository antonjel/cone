import java.util.List;

public class Board {
	private Square [][] board;
	
	public Board(List<Square> list){
		this.board = new Square[4][4];
		populateBoard(list);
	}
	
	public Square[][] getBoard(){
		return board;
	}
	
	public void populateBoard(List<Square> list){
		int squares = 0;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if((i == 0 & j == 0) | (i == 3 & j == 0) | (i == 0 & j == 3) | (i == 3 & j == 3)){
					continue;
				}
				board[i][j] = list.get(squares);
				squares++;
			}
		}
		
		System.out.println(squares);
	}
	
	public void analyse(){
		int boardSize = board.length;
		int success = 0;
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				int topLeft = 0;
				int topRight = 0;
				int bottomLeft = 0;
				int bottomRight = 0;
				int cornersA = 1;
				int cornersB = 1;
				int cornersC = 1;
				int cornersD = 1;

				if(board[i][j] != null){
					topLeft = board[i][j].getTopLeft();
					topRight = board[i][j].getTopRight();
					bottomLeft = board[i][j].getBottomLeft();
					bottomRight = board[i][j].getBottomRight();
					
					if((0 <= (j-1)) && board[i][j-1] != null){
						topLeft += board[i][j-1].getTopRight();
						bottomLeft += board[i][j-1].getBottomRight();
						
						cornersA++;
						cornersC++;
					} 
					
					if((0 <= (j+1)) && (boardSize > (j+1)) && board[i][j+1] != null){
						topRight += board[i][j+1].getTopLeft();
						bottomRight += board[i][j+1].getBottomLeft();
						
						cornersB++;
						cornersD++;
					}
					
					if((0 <= (i-1)) && board[i-1][j] != null){
						topLeft += board[i-1][j].getBottomLeft();
						topRight += board[i-1][j].getBottomRight();
						
						cornersA++;
						cornersB++;
					}
					
					if((0 <= (i+1)) && (boardSize > (i+1)) && board[i+1][j] != null){
						bottomLeft += board[i+1][j].getTopLeft();
						bottomRight += board[i+1][j].getTopRight();
						
						cornersC++;
						cornersD++;
					}
					
					if((0 <= (i-1)) && (0 <= (j-1)) && board[i-1][j-1] != null){
						topLeft += board[i-1][j-1].getBottomRight();
						
						cornersA++;
					}
					
					if((0 <= (i-1)) && (0 <= (j+1)) && (boardSize > (j+1)) && board[i-1][j+1] != null){
						topRight += board[i-1][j+1].getBottomLeft();
						
						cornersB++;
					}

					if((0 <= (i+1)) && (0 <= (j-1)) && (boardSize > (i+1)) && board[i+1][j-1] != null){
						bottomLeft += board[i+1][j-1].getTopRight();
						
						cornersC++;
					}
					
					if((0 <= (i+1)) && (0 <= (j+1)) && (boardSize > (i+1)) && (boardSize > (j+1)) && board[i+1][j+1] != null){
						bottomRight += board[i+1][j+1].getTopLeft();
						
						cornersD++;
					}
					
					if((cornersA == 4 & topLeft != 10) | (cornersB == 4 & topRight != 10) | (cornersC == 4 & bottomLeft != 10) | (cornersD == 4 & bottomRight != 10)){
						break;
					} else if(((topLeft > 10) && (cornersA > 1)) | ((topRight > 10) && (cornersB > 1)) | ((bottomLeft > 10) && (cornersC > 1)) | ((bottomRight > 10) && (cornersD > 1))){
						break;
					} else {
						success++;
					}
				}
			}
		}
		
		if(success == 12){
			System.out.println("SUCCESS!!");
			for(int i = 0; i<board.length; i++){
				for(int y = 0; y<board[i].length; y++){
					if(board[i][y] != null){
						System.out.print(board[i][y].getTopLeft() + " ");
						System.out.print(board[i][y].getTopRight() + " ");
						System.out.print(board[i][y].getBottomLeft() + " ");
						System.out.print(board[i][y].getBottomRight());
						System.out.println();
					}
				}
			}
			System.out.println();
		}
	}
}
