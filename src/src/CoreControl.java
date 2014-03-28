import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CoreControl {

	public static class Rectangle extends JPanel {

		private int height;
		private int width;

		public Rectangle() {
			height =0;
			width = 0;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawRect(0,  0, 100, 200);
		}
		
		public void setHeight(int height){
			this.height = height;
		}
		
		public void setWidth(int width){
			this.width = width;
		}
	}

	public static void main(String[] a) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException ex) {
				}
				catch(InstantiationException ex){

				}
				catch(IllegalAccessException ex){

				}
				catch(UnsupportedLookAndFeelException ex){

				}

				Rectangle grid = new Rectangle();
				JFrame window = new JFrame();
				window.setSize(840, 560);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.add(grid);
				window.setVisible(true);
			}
		});
	}
}