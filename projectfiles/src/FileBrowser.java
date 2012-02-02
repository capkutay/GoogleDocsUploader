import java.io.File;

public class FileBrowser {
	// FileBrowser class contains main logic for file browsing program.

	// private data member to store list containing documents
	private DocumentList dl;

	// private data member to store a reference to object that performs 
	// document upload
	private DocUploader du;

	public FileBrowser() {
		// Constructor takes no input and will create a new DocumentList 
		// object and a new DocUploader object.
		dl = new DocumentList();
		du = new DocUploader();
	}

	public boolean buildList(String path) {
		// Top-level method called from Driver. Method takes as input a 
		// String representing a directory and will invoke the private, 
		// recursive buildList method passing in a File object 
		// representing the specified path.
		File f = new File(path);
		if(!f.exists()){
			System.out.println("File does not exist.");
			return false;
		}
		return buildList(f);			
		
	}

	private boolean buildList(File f) {
		// Recursive method that will traverse a directory. For each 
		// file found, a Document object will be instantiated and added 
		// to the DocumentList data member.
		if (f.isFile()) {
			dl.add(new Document(f));
			return true;
		}
		File[] files = f.listFiles();
		for (int i = 0; i < files.length; ++i) {
			buildList(files[i]);
		}
		return true;
	}
    public void viewDocs() {
        // Main logic of the program.
        // Algorithm:
        // 1. create UI object
        // 2. use UI object to get a selection from the user
        // 3. as long as the user does not select exit, execute the choice and get
        // another selection from the user Hint: invoke methods on
        // DocumentList object to execute most tasks
    	UI u = new UI(dl);
    	int choice = u.getChoice();
    	while(choice != 5){
    		switch(choice){
    		case 1: 
    			dl.sortByDate(); 
    			dl.print();
    			break;
    		case 2: 
    			dl.sortByName();
    			dl.print();
    			break;
    		case 3:
    			dl.printMatches(u.getPattern()); 
    			break;
    		case 4: 
    			du.uploadDoc(u.getUploadInfo());
    			break;
    		default: break;
    		}
    		choice = u.getChoice();
    		}	
    }
}
