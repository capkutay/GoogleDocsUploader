// Done
import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class Document {
	// File represented by this Document object.
	private File f;

	// Used for convenience. It is recommended a Calendar object
	// be instantiated and set using the last modified date of the File.
	private Calendar c;

	public Document(File f) {
		// Constructor for Document. In addition to saving the parameter
   	 	// f into a data member of the object, create a Calendar instance
   	 	// and set its time to the last modified time of the File.
		this.f = f;
		c = Calendar.getInstance();
		long last = f.lastModified();
		c.setTimeInMillis(last);
    }

    public long lastModified() {
		long last = f.lastModified();
   	 	return last;
	}

	public String getName() {
	    // Return the name of the File object.
   		String name = f.getName();
   	 	return name;
    }

	public String getAbsolutePath() {
		// Return the absolute path of the File object.
		 String path = f.getAbsolutePath();
   		 return path;
	}

	public String toString() {
		// Return a string representation of this document.
		// Use the string representation of the File object and the last
		// modified date.
		String s = f.toString() + " " + this.c.getTime();
   	 	return s;
	}
}
