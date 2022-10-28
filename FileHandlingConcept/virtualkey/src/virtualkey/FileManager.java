package virtualkey;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileManager extends WelcomeScreen {
	static final String folderPath = "E:\\Simplilearn\\VirtualKeyProject\\FileHandlingConcept\\Directory\\";

	private ArrayList<String> fileoptions = new ArrayList<String>();

	public FileManager() {
		this.fileoptions.add("1. Add a new file");
		this.fileoptions.add("2. Delete a file");
		this.fileoptions.add("3. Search a file");
		this.fileoptions.add("4. Back to application Main Context");

	}

	public void details() {
		Iterator I1 = fileoptions.iterator();
		System.out.println("Please select : ");
		while (I1.hasNext()) {
			System.out.println(I1.next());
		}
	}

	@Override
	public void getUserChoice() {
		// TODO Auto-generated method stub
		int ch = scan.nextInt();
		try {
			fileOptions(ch);

		} catch (InputMismatchException ime) {
			System.out.println("Wrong Choice type : Expected choice should be of Integer type");
		}
	}

	@Override
	public List<String> showFiles() {
		// TODO Auto-generated method stub
		return super.showFiles();
	}

	Scanner sc = new Scanner(System.in);

	public void AddFile() {
		System.out.println("Please Enter the Filename:");
		String fileName = sc.nextLine();
		System.out.println("You are adding a file named: " + fileName);

		try {

			File file1 = new File(folderPath + fileName);
			if (file1.createNewFile()) {
				System.out.println("File created: " + file1.getName());
				showFiles().add(fileName);
			} else {
				System.out.println("This File Already Exists, no need to add another");
			}
		} catch (IOException var4) {
			System.out.println(var4);
		}

	}

	// code to delete a file from the list.
	public void DeleteFile() {
		System.out.println("Please Enter the Filename:");
		String fileName = sc.nextLine();
		System.out.println("You are deleting a file named: " + fileName);

		File file2 = new File(folderPath + fileName);
		if (file2.delete()) {
			System.out.println("Deleted File: " + file2.getName());
			showFiles().remove(file2);
		} else {
			System.out.println("Failed to delete file:" + fileName + ", file was not found.");
		}

	}

	// code to search a file
	public void searchFile() {

		// code for deleting file
		String fileName;

		System.out.println("Please Enter the Filename:");
		fileName = sc.nextLine();
		System.out.println("You are searching for a file named: " + fileName);

		File file3 = new File(folderPath + fileName);
		if (file3.exists()) {
			System.out.println("Found " + fileName);
		} else {
			System.out.println("File not found");
		}
	}

	public void fileOptions(int ch) {
		// TODO Auto-generated method stub
		switch (ch) {
		case 1:
			// Choice 1 : if user wants to add a particular file from the folder.
			AddFile();
			System.out.println("\n");
			this.details();
			this.getUserChoice();

			break;
		case 2:
			// Choice 2 : if user wants to delete a particular file from the folder.
			DeleteFile();
			System.out.println("\n");

			this.details();
			this.getUserChoice();

			break;
		case 3:
			// Choice 3 : if user wants to search a particular file from the folder.
			searchFile();
			System.out.println("\n");
			this.details();
			this.getUserChoice();

			break;
		case 4:
			// Choice 4 : If user wants to go back to main context menu

			super.showFileDetails();
			super.getUserChoice();
			break;

		default:
			System.out.println("Invalid Option");

		}
	}

}
