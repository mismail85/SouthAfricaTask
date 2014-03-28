import java.awt.Graphics;

import javax.swing.JPanel;


public class Rectangle extends JPanel {

		private int height;
		private int width;
		private int x;
		private int y;
		
		public Rectangle() {
			height =0;
			width = 0;
			y = 0;
			x = 0;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawRect(x,  y, height, width);
		}
		
		public void setHeight(int height){
			this.height = height;
			y = 100 - height;
		}
		
		public void setWidth(int width){
			this.width = width;
		}
		
		public int getWidth(){
			return this.width;
		}
		
		public void setX(int x){
			this.x = x;
		}
	}
