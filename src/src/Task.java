import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Task {

	private RectView rectView;
	private RectView sortedRectView;

	public Task(){
		rectView = new RectView();
		sortedRectView = new RectView();
	}

	public void generateRects(int count){
		for(int i = 0; i < count; i++){
			Rectangle rect = new Rectangle();

			rect.setHeight(getRandom());
			rect.setWidth(getRandom());

			rectView.add(rect);
		}
	}

	public void drawRects(JFrame window){
		JPanel container  = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		container.add(rectView);
		container.add(sortedRectView);
		
		window.add(container);
	}

	public void sortRects(){
		List<Rectangle> rects = new ArrayList<Rectangle>(rectView.getRects());
		quicksort(rects, 0, rects.size()-1);

		for(Rectangle rect : rects){
			System.out.println(rect.area());
			sortedRectView.add(rect);
		}		
	}

	private int getRandom(){
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(100);
	}

	private void quicksort(List<Rectangle> rects, int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = rects.get(low + (high-low)/2).area();

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (rects.get(i).area() < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (rects.get(j).area() > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				Rectangle rect = rects.get(i);

				rects.set(i, rects.get(j));

				rects.set(j, rect);

				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(rects, low, j);
		if (i < high)
			quicksort(rects, i, high);
	}
}
