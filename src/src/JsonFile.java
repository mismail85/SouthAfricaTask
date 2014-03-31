import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


public class JsonFile {
	private String fileName;
	private Gson gson = new Gson();

	public JsonFile(final String fileName){
		this.fileName = fileName;	
	}

	public void save(Object object){
		//Converting the object into Json & save it in a file
		
		PrintWriter out;
		try {
			out = new PrintWriter(fileName);
			out.println(gson.toJson(object));
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Object read(Type type){
		
		JsonReader reader;
		Object object = new Object();
		try {
			reader = new JsonReader(new FileReader(fileName));

			object = gson.fromJson(reader, type);

			reader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;
	}
}
