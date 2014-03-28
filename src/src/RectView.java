import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class RectView extends JPanel{
	//TODO use linked list instead of list
	private List<Rectangle> rects;
	
	public RectView(){
		rects = new ArrayList(); 
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int x = 0;
		for (Rectangle rect : rects) {
			g.drawRect(x, 100 - rect.getHeight() , rect.getWidth(), rect.getHeight());
			x += rect.getWidth();			
		}
	}
	
	public void add(Rectangle rect){
		rects.add(rect);
		repaint();
	}
	
	public List<Rectangle> getRects(){
		return rects;
	}
}
