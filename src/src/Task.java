import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


public class Task {

	private List<Rectangle> rectangles;

	private static final String JSON_FILE = "jsonFile.txt";
	private static final int MAX = 100;
	private static final int MIN  = 5;

	public void generateRects(int count){
		rectangles = new ArrayList<Rectangle>();

		for(int i = 0; i < count; i++){
			Rectangle rect = new Rectangle();

			rect.setHeight(getRandom());
			rect.setWidth(getRandom());

			rectangles.add(rect);
		}
	}

	public void saveRectsIntoFile(){
		//Converting the rectangles array into Json & save it in a file
		Gson gson = new Gson();
		PrintWriter out;
		try {
			out = new PrintWriter(JSON_FILE);
			out.println(gson.toJson(rectangles));
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readRectsFromFile(){
		Gson gson = new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(JSON_FILE));
			Type listType = new TypeToken<ArrayList<Rectangle>>() {
			}.getType();
			rectangles =  new ArrayList<Rectangle>((List<Rectangle>)gson.fromJson(reader, listType));

			reader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RectView getRectsView(){

		RectView view = new RectView();
		for(Rectangle rect : rectangles){
			view.add(rect);
		}
		return view;
	}

	public void sortRects(){

		if(rectangles.size() > 0)
			quicksort(rectangles, 0, rectangles.size()-1);
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

	private int getRandom(){
		Random randomGenerator = new Random();
		return randomGenerator.nextInt((MAX-MIN) + 1) + MIN;
	}
}
