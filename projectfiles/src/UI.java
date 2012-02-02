import java.io.InputStreamReader;
import java.util.Scanner;


public class UI {
	//Class and method descriptions provided by CS112 JavaDoc for Project 3
	//UI class handles most of the user interaction (input/output). 
	
	private DocumentList list;
	
	public UI(DocumentList list){
		this.list = list;
		//Constructor accepts a reference to the DocumentList.
	}
	
	public int getChoice(){
		//Primary method that prompts for a selection from the user and 
		//returns the selection. Verify that the selection is between 1 and 5. 
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int  choice = 0;
		while(choice < 1 || choice > 5){
			System.out.println("Enter Choice: ");	
			System.out.println("[1] List all sorted by date");
			System.out.println("[2] List all sorted by name");
			System.out.println("[3] List all containing pattern");
			System.out.println("[4] Upload to Google Docs (only txt files supported)");
			System.out.println("[5] Exit");
			choice = sc.nextInt();
		}
		return choice;
	}
	
	public String getPattern(){
		//Method called if selection is 3. Prompt for a pattern and
		//return the pattern to the caller. 
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		String pattern = "";
		if(getChoice() == 3){
			System.out.println("List containing pattern: ");
			pattern = sc.next();
		}
		return pattern;
	}
	
	public UploadInfo getUploadInfo(){
		//Method called if selection is 4. Prompt for a username and password. 
		//Next, display only txt files and prompt for numerical ID of selected file. 
		//Create and return an UploadInfo object. 
		//DocumentList dl = new DocumentList();
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		System.out.println("Username: ");
		String username = sc.next();
		System.out.println("Password: ");
		String password = sc.next();
		list.printEndsWith(".txt");
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		String filepath = list.getAbsolutePath(id - 1);
		UploadInfo upload = new UploadInfo(filepath, username, password);
		return upload;
	}
}
