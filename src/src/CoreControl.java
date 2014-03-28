import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CoreControl {

	

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
				
				JFrame window = new JFrame();
				window.setSize(840, 560);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setVisible(true);
				Task task = new Task();
				//TODO ask about the number of rectangles i suppose they will be 4
				task.generateRects(4);
				task.sortRects();
				task.drawRects(window);
				
				
			}
		});
	}
}