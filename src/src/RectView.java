import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
			
			int y = 100 - rect.getHeight();
			
			g.setColor(rect.getColor());
            g.fillRect(x, y, rect.getWidth(), rect.getHeight());
            
            g.setColor(Color.BLACK);
			g.drawRect(x,  y, rect.getWidth(), rect.getHeight());
			
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
