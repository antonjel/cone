
public class Square {
	private int topLeft, topRight, bottomLeft, bottomRight;
	
	public Square(int topLeft, int topRight, int bottomLeft, int bottomRight){
		this.topLeft = topLeft;
		this.topRight = topRight;
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
	}
	
	public int getTopLeft(){
		return this.topLeft;
	}
	public int getTopRight(){
		return this.topRight;
	}
	public int getBottomLeft(){
		return this.bottomLeft;
	}
	public int getBottomRight(){
		return this.bottomRight;
	}

}
