import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import com.google.gson.Gson;


public class RectView extends JPanel{
	//TODO use linked list instead of list
	private List<Rectangle> rects;
	private List<Point> points;
	
	private static final String COORDINATES_FILE = "coordinatesFile.txt";
	
	public RectView(){
		rects = new ArrayList<Rectangle>();
		points = new ArrayList<Point>();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int x = 0;
		
		for (Rectangle rect : rects) {
			Point point = new Point();
			
			int y = 100 - rect.getHeight();
			
			point.setX(x);
			point.setY(y);
			points.add(point);
			
			g.setColor(rect.getColor());
            g.fillRect(x, y, rect.getWidth(), rect.getHeight());
            
            g.setColor(Color.BLACK);
			g.drawRect(x,  y, rect.getWidth(), rect.getHeight());
			
			x += rect.getWidth();
		}
		setPreferredSize(new Dimension(x, 100));
		revalidate();
		repaint();
		saveCoordinatesIntoFile();
	}
	
	public void add(Rectangle rect){
		rects.add(rect);
		repaint();
	}
	
	public List<Rectangle> getRects(){
		return rects;
	}
	
	public void saveCoordinatesIntoFile(){
		//Converting the Points array into Json & save it in a file
	
		Gson gson = new Gson();
		PrintWriter out;
		try {
			out = new PrintWriter(COORDINATES_FILE);
			out.println(gson.toJson(points));
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
