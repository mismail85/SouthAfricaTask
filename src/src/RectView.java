import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class RectView extends JPanel{
	private List<Rectangle> rects;
	
	private static final String COORDINATES_FILE = "coordinatesFile.txt";

	public RectView(){
		rects = new ArrayList<Rectangle>();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int x = 0;
		List<Point> points = new ArrayList<Point>();
		
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
		
		saveCoordinatesIntoFile(points);
	}

	public void add(Rectangle rect){
		rects.add(rect);
		repaint();
	}

	public List<Rectangle> getRects(){
		return rects;
	}

	public void saveCoordinatesIntoFile(List<Point> points){
		//Converting the Points array into Json & save it in a file

		JsonFile file = new JsonFile(COORDINATES_FILE);
		file.save(points);
	}
}
