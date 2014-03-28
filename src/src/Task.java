import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;


public class Task {

	private List<Rectangle> rects;

	public Task(){
		rects = new ArrayList(); 
	}
	
	public void generateRects(int count){
		for(int i = 0; i < 4; i++){
			Rectangle rect = new Rectangle();
			
			rect.setHeight(getRandom());
			rect.setWidth(getRandom());
			
			rects.add(rect);
		}
	}

	public void drawRects(JFrame window){
		int x = 0;
		for (Rectangle rect : rects) {
			rect.setX(x);
			window.add(rect);
			
			x += rect.getWidth();
		}
	}
	
	public void sortRects(){
		
	}
	
	private int getRandom(){
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(100);
	}
}
