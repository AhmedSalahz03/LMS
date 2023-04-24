package application;
	
import javafx.application.Application;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.lang.String;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
	   
		// Load the Sign up/Login page
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
		    stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		// Create an arraylist that will store Reader objects and another arraylist for Librarian objects.
		
		ArrayList<Reader> readers = new ArrayList <>();
		ArrayList <Librarian> librarians = new ArrayList<>();
		
		try {
			
			// Reading Readers.txt file to store the data field into a Reader object then adding this object to the 'readers' arraylist.
	        
			File file = new File("Readers.txt");
	        Scanner scanner = new Scanner(file);

	        // Skip empty line at the beginning of file
	        
	        if (scanner.hasNextLine()) {
	            scanner.nextLine();
	        }
	        

	        while (scanner.hasNextLine()) {
	        	if (scanner.hasNextLine()) {
		            scanner.nextLine();
	        	}
	        	String type = "";
	        	if (scanner.hasNextLine()) {
	        		type = scanner.nextLine().substring(6).trim();
	        	}
	        	String username = "";
	        	if (scanner.hasNextLine()) {
	        		username = scanner.nextLine().substring(10).trim();
	        	}
	        	String password = "";
	        	if (scanner.hasNextLine()) {	
	        		password = scanner.nextLine().substring(10).trim();
	        	}
	        	String firstName = "";
	        	if (scanner.hasNextLine()) {
	        		firstName = scanner.nextLine().substring(12).trim();
	        	}
	        	String lastName = "";
	        	if (scanner.hasNextLine()) {
	        		lastName = scanner.nextLine().substring(11).trim();
	        	}
	        	String address = "";
	        	if (scanner.hasNextLine()) {
	        		address = scanner.nextLine().substring(9).trim();
	        	}
	        	String email = "";
	        	if (scanner.hasNextLine()) {
	        		email = scanner.nextLine().substring(7).trim();
	        	}
	        	String cellphone = "";
	        	if (scanner.hasNextLine()) {
	        		cellphone = scanner.nextLine().substring(11).trim();
	        	}
	        	String isBlocked = "";
	        	if (scanner.hasNextLine()) {
	        		isBlocked = scanner.nextLine().substring(11).trim();
	        	}
	        	
	        	// Creating a Reader object with data that was stored in the txt file then adding the object to the arraylist that contains all Reader objects.
	            
	        	Reader reader = new Reader(type, username, password, firstName, lastName, address, email, cellphone, isBlocked);
	            readers.add(reader);
	            
	            System.out.println(reader.getType());
	            System.out.println(reader.getUsername());
	            System.out.println(reader.getPassword());
	            System.out.println(reader.getFirstName());
	            System.out.println(reader.getLastName());
	            System.out.println(reader.getAddress());
	            System.out.println(reader.getCellphone());
	            System.out.println(reader.getEmail());
	            System.out.println(reader.getIsBlocked());
	        }
	        

	        scanner.close();
		 }
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		try {
			// Reading Librarians.txt file to store the data field into a Librarian object then adding this Object to the 'librarians' arraylist.
	        File file = new File("Librarians.txt");
	        Scanner scanner = new Scanner(file);

	        // Skip empty line at the beginning of file
	        if (scanner.hasNextLine()) {
	            scanner.nextLine();
	        }
	        

	        while (scanner.hasNextLine()) {
	        	if (scanner.hasNextLine()) {
		            scanner.nextLine();
	        	}
	        	String type = "";
	        	if (scanner.hasNextLine()) {
	        		type = scanner.nextLine().substring(6).trim();
	        	}
	        	String username = "";
	        	if (scanner.hasNextLine()) {
	        		username = scanner.nextLine().substring(10).trim();
	        	}
	        	String password = "";
	        	if (scanner.hasNextLine()) {	
	        		password = scanner.nextLine().substring(10).trim();
	        	}
	        	String firstName = "";
	        	if (scanner.hasNextLine()) {
	        		firstName = scanner.nextLine().substring(12).trim();
	        	}
	        	String lastName = "";
	        	if (scanner.hasNextLine()) {
	        		lastName = scanner.nextLine().substring(11).trim();
	        	}
	        	String address = "";
	        	if (scanner.hasNextLine()) {
	        		address = scanner.nextLine().substring(9).trim();
	        	}
	        	String email = "";
	        	if (scanner.hasNextLine()) {
	        		email = scanner.nextLine().substring(7).trim();
	        	}
	        	String cellphone = "";
	        	if (scanner.hasNextLine()) {
	        		cellphone = scanner.nextLine().substring(11).trim();
	        	}
	        	String isBlocked = "";
	        	if (scanner.hasNextLine()) {
	        		isBlocked = scanner.nextLine().substring(11).trim();
	        	}
	        	
	        	// Creating a Librarian object with data that was stored in the txt file then adding the object to the arraylist that contains all Librarian objects.
	            
	        	Librarian librarian = new Librarian(type, username, password, firstName, lastName, address, email, cellphone, isBlocked);
	            librarians.add(librarian);
	            
	            System.out.println(librarian.getType());
	            System.out.println(librarian.getUsername());
	            System.out.println(librarian.getPassword());
	            System.out.println(librarian.getFirstName());
	            System.out.println(librarian.getLastName());
	            System.out.println(librarian.getAddress());
	            System.out.println(librarian.getCellphone());
	            System.out.println(librarian.getEmail());
	            System.out.println(librarian.getIsBlocked());
	        }
	        

	        scanner.close();
		 }
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		launch(args);
	}
}
