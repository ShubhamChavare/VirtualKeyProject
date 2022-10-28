package virtualkey;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class WelcomeScreen {

	Scanner scan = new Scanner(System.in);

	private ArrayList<String> options = new ArrayList<String>();

	public WelcomeScreen() {
		options.add("1. Display all files");
		options.add("2. Show File Menus");
		options.add("3. Exit");

	}

//Basic details
	public void showFileDetails() {
		System.out.println("###########  Locked LockedMe.com  ###########\n");
		System.out.println("Developer Name : Shubham Chavare\n");

		Iterator f1 = options.iterator();
		System.out.println("Please select : ");
		while (f1.hasNext()) {
			System.out.println(f1.next());
		}

	}

//lets take user choice and perform the file handling operations on the basis of choice.

	public void getUserChoice() {

		int choice = scan.nextInt();
		try {
			fileValidOptions(choice);

		} catch (InputMismatchException ime) {
			System.out.println("Wrong Choice type : Expected choice should be of Integer type");
		}
	}

	public void fileValidOptions(int ch) {
		// switch case statements run according to user choice.
		switch (ch) {
		case 1:
			// Choice 1 : to get or to show all files in folder.
			List<String> fileNames = showFiles();

			for (String f : fileNames) {
				System.out.println(f);
			}
			System.out.println("\n");
			showFileDetails();
			getUserChoice();
			break;
		case 2:
			// Choice 2 : if user wants to see file menu options
			FileManager fl = new FileManager();
			fl.details();
			fl.getUserChoice();
		case 3:
			// Choice 3 : if user wants to exit from the application.
			System.exit(0);
			break;

		default:
			System.out.println("Invalid Option");
		}
	}

	// Below method show all files from the mentioned folder path.
	public List<String> showFiles() {
		// creating file object
		File fl = new File("E:\\Simplilearn\\VirtualKeyProject\\FileHandlingConcept\\Directory\\");

		// getting all files into file array
		File[] listOfFiles = fl.listFiles();

		// declare list to store file names
		List<String> fileNames = new ArrayList<String>();

		for (File f : listOfFiles)
			fileNames.add(f.getName());

		// return the list in sorting order ignore case sensitivity
		Collections.sort(fileNames, String.CASE_INSENSITIVE_ORDER);
		return fileNames;

	}

}
