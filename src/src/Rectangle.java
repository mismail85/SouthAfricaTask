public class Rectangle  {

	private int height;
	private int width;

	public Rectangle() {
		height =0;
		width = 0;
	}


	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return this.width;
	}
	
	public int area(){
		return width * height;
	}
}
