import java.awt.Color;
import java.util.Random;

public class Rectangle  {

	private int height;
	private int width;
	private Color color;
	
	public Rectangle() {
		height =0;
		width = 0;
		generateRandomColor();
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
	
	public Color getColor(){
		return this.color;
	}
	
	private void generateRandomColor(){
		Random rand = new Random();
		
		// Java 'Color' class takes 3 floats, from 0 to 1.
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		
		this.color = new Color(r, g, b);
	}
}
