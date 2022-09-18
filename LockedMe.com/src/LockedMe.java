import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {
	
	static Scanner sc = new Scanner(System.in);
	static int choice;

	public static void main(String[] args) {
	
		System.out.println("!!-----LockedMe.com-----!!");
		System.out.println("Developed by Zainab Mohiuddin");
		do {
		System.out.println("\n\nMain Menu");
		System.out.println("Enter 1 to Retreiving A Files");
		System.out.println("Enter 2 to Business Level Operations");
		System.out.println("Enter 3 to Close The Application");
		
		choice = sc.nextInt();
		
		
		switch(choice) {
		case 1 :
			retriveFiles();
			break;
		case 2:
			businessLogicOperations();
			break;
		case 3:
			System.out.println("Good Bye!!");
			System.exit(0);
			
			
		default:
			System.out.println("you have enter the wrong choice\n");
				
		}
		}while(choice <'1' || choice > '3');
	}
	
	private static void businessLogicOperations() {
		
		int ch=0;
		
		while(ch<'1'||ch>4) {
			System.out.println("---Busines Logic Operations---");
			System.out.println("Enter 1 to Add a New File To Application");
			System.out.println("Enter 2 to delete a  File From  Application");
			System.out.println("Enter 3 to Search a File From Application");
			System.out.println("Enter 4 to Return to Main Menu");
			ch=sc.nextInt();
			switch(ch) {
			case 1 :
				addFile();
				break;
			case 2: 
				deleteFile();
				break;
			case 3 :
				searchFile();
				break;
			case 4:
				return  ;
				
			default:
				System.out.println("you have enter the wrong choice\n");
			}
		}
	}

	

	private static void searchFile() {
		String fname;
		String path = "C:\\Users\\pc\\Desktop\\New folder\\";
		System.out.println("Enter the file name to search from the application");
		fname=sc.next();
		File f = new File(path);
		String[] list = f.list();
		int flag =0;
		if(list==null) {
			System.out.println("folder is empty");
		}
		else {
			for(int i=0;i<list.length;i++) {
				String fileName = list[i];
				if(fileName.equalsIgnoreCase(fname)) {
					System.out.println(fileName+" found");
					flag = 1;
				}
				
			}
		}
		if(flag == 0) {
			System.out.println("File "+fname+ " not found");
		}
		
	}

	private static void deleteFile() {
		String fname;
		String path = "C:\\Users\\pc\\Desktop\\New folder\\";
		System.out.println("Enter the file name to delete from the application");
		fname=sc.next();
		File f = new File(path+fname);
		if(f.exists()) {
			char c;
			System.out.println("please enter y to delete a file and n to cancel");
			c=sc.next().charAt(0);
			if(c=='Y' ||c== 'y') {
				if(f.delete()) {
				System.out.println("Deleted the file "+f.getName()+" successfully");
				}
			}
		}
		else
		{
			System.out.println("Error Deleting File");
		}
		
	}

	private static void addFile() {
		try {
			String fname;
			String path = "C:\\Users\\pc\\Desktop\\New folder\\";
			System.out.println("Enter the file name to add in to application");
			fname=sc.next();
			File f = new File(path+fname);
			if(f.createNewFile()) {
				System.out.println("File added successfully ");
			}
			else {
				System.out.println("Error while creating a file");
			}
		
		}catch(Exception io) {
			io.printStackTrace();
		}
		
		
	}

	private static void retriveFiles() {
		System.out.println("Retrive a file from folder");
		
		File f = new File("C:\\Users\\pc\\Desktop\\New folder");
		File[] listoffiles = f.listFiles();
		Arrays.sort(listoffiles);
		for(int i = 0; i< listoffiles.length ; i++) {
			if(listoffiles[i].isFile()) {
				System.out.println(listoffiles[i].getName());
			}
			else if(listoffiles[i].isDirectory()) {
				System.out.println(listoffiles[i].getName());
			}
		}
		
	
		
	}

}
