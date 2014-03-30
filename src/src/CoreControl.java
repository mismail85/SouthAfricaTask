import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CoreControl extends JFrame implements ActionListener{

	private JSpinner spinner;
	private JPanel panel;
	public JPanel mainPanel = new JPanel();

	public CoreControl(){
		SpinnerModel model =
				new SpinnerNumberModel(4, //initial value
						3, //min
						30, //max
						1);      
		spinner = new JSpinner(model);
		spinner.setMaximumSize(new Dimension(60, 20));

		JButton button = new JButton("Generate");
		button.addActionListener(CoreControl.this);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setMaximumSize(new Dimension(150, 60));
		panel.add(spinner);
		panel.add(Box.createRigidArea(new Dimension(10,0)));
		panel.add(button);

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.add(panel);

		setSize(840, 560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(mainPanel);
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
					ex.printStackTrace();
				}
				catch(IllegalAccessException ex){
					ex.printStackTrace();
				}
				catch(UnsupportedLookAndFeelException ex){
					ex.printStackTrace();
				}
				new CoreControl();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Task task = new Task();

		//1st step generating the requested number of rectangles
		task.generateRects(Integer.parseInt(spinner.getValue().toString()));

		// saving rectangles into file as JSON (the file will be in the same path of the jar)
		task.saveRectsIntoFile();

		//read rectangles from file
		task.readRectsFromFile();

		//draw the unsorted rectangles
		drawRects(task);

		//sort the rectangles using quick sort algorithm
		task.sortRects();

		//draw the sorted rectangles & save coordinates to file
		drawRects(task);
	}

	private void drawRects(Task task){
		JPanel container  = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		container.add(task.getRectsView());

		cleanView();

		mainPanel.add(container);
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	private void cleanView(){
		if(mainPanel.getComponentCount() > 2)
			for(int i = 0; i < 2; i++)
				mainPanel.remove(1);
	}
}