package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Parser {

	public enum Separator {
		TAP("	");
		private String separator;
		Separator (String separator) {
			this.separator = separator;
		}
		public String get() {
			return separator;
		}
	}
	
	private String docPath;
	private Parser.Separator separator;
	private BufferedReader bufferedReader = null;
	private List objects = null;
	private int presentLine = 0;
	
	
	// protected constructor
	protected Parser (String docPath, Parser.Separator separator) {
		this.docPath = docPath;
		this.separator = separator;
		parseDoc();
	}
	
	protected abstract Object createObject(String[] split);
	protected abstract List createList(String[] split);
	
	public List getCreations () {
		return objects;
	}
	protected int getPresentLine() {
		return presentLine;
	}
	
	private void parseDoc() {	
		try {
			String line;
			Object object;
			List list;
			
			objects = new ArrayList();
			bufferedReader = new BufferedReader (new FileReader(docPath));
			
			while ( (line = bufferedReader.readLine()) != null ) {
				String[] split = line.split(separator.get());
				
				// abstract method
				object = createObject(split);
				if (object != null) objects.add(object);
				
				list = createList(split);
				if (list != null) objects.addAll(list);
				
				presentLine++;
			}
		}
		catch (IOException ioe) { ioe.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }
		finally {
			closeReader();
		}
	}
	private void closeReader() {
		if ( bufferedReader != null ) {
			try { bufferedReader.close(); }
			catch (IOException ioe) { ioe.printStackTrace(); }
		}
	}
}
