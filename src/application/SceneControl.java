package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;
import java.util.Optional;
import java.lang.String;
import java.io.File;
import java.util.Scanner;

public class SceneControl  {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	TextField usernameTextFieldR;
	@FXML
	TextField passwordTextFieldR;
	@FXML
	TextField firstNameTextFieldR;
	@FXML
	TextField lastNameTextFieldR;
	@FXML
	TextField addressTextFieldR;
	@FXML
	TextField cellphoneTextFieldR;
	@FXML
	TextField emailTextFieldR;
	
	@FXML
	TextField codeL;
	@FXML
	TextField usernameTextFieldL;
	@FXML
	TextField passwordTextFieldL;
	@FXML
	TextField firstNameTextFieldL;
	@FXML
	TextField lastNameTextFieldL;
	@FXML
	TextField addressTextFieldL;
	@FXML
	TextField cellphoneTextFieldL;
	@FXML
	TextField emailTextFieldL;
	
	@FXML
	TextField logUsername;
	@FXML
	TextField logPassword;
	@FXML
	TextField nameb;
	@FXML
	TextField Authorb;
	@FXML
	TextField search_name;
	
	public void switchToSignUpReader (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("signUpReaderPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void switchToSignUpLibrarian (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("signUpLibrarian.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void switchToLogin (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	public void switchToMain (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void signUpReader(ActionEvent event) throws IOException {
		
		boolean isMatch = false;
		
	    String username = usernameTextFieldR.getText();
	    String password = passwordTextFieldR.getText();
	    String firstName = firstNameTextFieldR.getText();
	    String lastName = lastNameTextFieldR.getText();
	    String address = addressTextFieldR.getText();
	    String email = emailTextFieldR.getText();
	    String cellphone = cellphoneTextFieldR.getText();
	    
	    try (Scanner scanner = new Scanner(new File("Readers.txt"))) {
	        scanner.nextLine(); // Skip empty line at the beginning of file
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            if (line.startsWith("Username:")) {
	                String storedUsername = line.substring(10).trim();
	                String storedPassword = scanner.nextLine().substring(10).trim();
	                String storedFirstName = scanner.nextLine().substring(12).trim();
	                String storedLastName = scanner.nextLine().substring(11).trim();
	                String storedAddress = scanner.nextLine().substring(9).trim();
	                String storedEmail = scanner.nextLine().substring(7).trim();
	                String storedCellphone = scanner.nextLine().substring(11).trim();
	                String storedIsBlocked = scanner.nextLine().substring(11).trim();
	                if (username.equals(storedUsername)) {
	                    isMatch = true;
	                    break;
	                }
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    // Checking if the username is already taken or not.
	    
	    try (Scanner scanner = new Scanner(new File("Librarians.txt"))) {
	        scanner.nextLine(); // Skip empty line at the beginning of file
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            if (line.startsWith("Username:")) {
	                String storedUsername = line.substring(10).trim();
	                String storedPassword = scanner.nextLine().substring(10).trim();
	                String storedFirstName = scanner.nextLine().substring(12).trim();
	                String storedLastName = scanner.nextLine().substring(11).trim();
	                String storedAddress = scanner.nextLine().substring(9).trim();
	                String storedEmail = scanner.nextLine().substring(7).trim();
	                String storedCellphone = scanner.nextLine().substring(11).trim();
	                String storedIsBlocked = scanner.nextLine().substring(11).trim();
	                if (username.equals(storedUsername)) {
	                    isMatch = true;
	                    break;
	                }
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }

	    

	    if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || email.isEmpty() || cellphone.isEmpty()) {
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText("Please fill out all fields.");
	        alert.showAndWait();
	    }
	    else if (isMatch){
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText("Username taken");
	        alert.showAndWait();
	    	
	    }
	    
	    // Writing the data entered into the Readers.txt file.
	    
	    else {
	        Person reader = new Person("Reader", username, password, firstName, lastName, address, cellphone, email, "No");

	        FileWriter writer = new FileWriter("Readers.txt", true);
	        writer.write("Type: Reader" + "\n" + "Username: " + username + "\n" + "Password: " + password + "\n" + "First Name: " + firstName + "\n" + "Last Name: " + lastName + "\n" + "Address: " + address + "\n" + "Email: " + email + "\n" + "Cellphone: " + cellphone + "\n" + "IsBlocked: No" + "\n" + "\n");
	        writer.close();

	        Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
	        Scene homeReader = new Scene(homeParent);
	        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        window.setScene(homeReader);
	        window.show();
	    }
	    Reader reader = new Reader ("Reader", username, password, firstName, lastName, address, cellphone, email, "No");
	    
	}
	
	public void signUpLibrarian(ActionEvent event) throws IOException {
	    String code = codeL.getText();
		String username = usernameTextFieldL.getText();
	    String password = passwordTextFieldL.getText();
	    String firstName = firstNameTextFieldL.getText();
	    String lastName = lastNameTextFieldL.getText();
	    String address = addressTextFieldL.getText();
	    String email = emailTextFieldL.getText();
	    String cellphone = cellphoneTextFieldL.getText();
	    
	    boolean isMatch = false;
	    
	    // Checking if username is already taken or not.
	    
	    try (Scanner scanner = new Scanner(new File("Readers.txt"))) {
	        scanner.nextLine(); // Skip empty line at the beginning of file
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            if (line.startsWith("Username:")) {
	                String storedUsername = line.substring(10).trim();
	                String storedPassword = scanner.nextLine().substring(10).trim();
	                String storedFirstName = scanner.nextLine().substring(12).trim();
	                String storedLastName = scanner.nextLine().substring(11).trim();
	                String storedAddress = scanner.nextLine().substring(9).trim();
	                String storedEmail = scanner.nextLine().substring(7).trim();
	                String storedCellphone = scanner.nextLine().substring(11).trim();
	                String storedIsBlocked = scanner.nextLine().substring(11).trim();
	                if (username.equals(storedUsername)) {
	                    isMatch = true;
	                    break;
	                }
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    try (Scanner scanner = new Scanner(new File("Librarians.txt"))) {
	        scanner.nextLine(); // Skip empty line at the beginning of file
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            if (line.startsWith("Username:")) {
	                String storedUsername = line.substring(10).trim();
	                String storedPassword = scanner.nextLine().substring(10).trim();
	                String storedFirstName = scanner.nextLine().substring(12).trim();
	                String storedLastName = scanner.nextLine().substring(11).trim();
	                String storedAddress = scanner.nextLine().substring(9).trim();
	                String storedEmail = scanner.nextLine().substring(7).trim();
	                String storedCellphone = scanner.nextLine().substring(11).trim();
	                String storedIsBlocked = scanner.nextLine().substring(11).trim();
	                if (username.equals(storedUsername)) {
	                    isMatch = true;
	                    break;
	                }
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }

	    if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || email.isEmpty() || cellphone.isEmpty()) {
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText("Please fill out all fields.");
	        alert.showAndWait();
	    }
	    
	    // A code that only librarians can know is maybe given by the employer to the employee to prevent readers to sign up as librarians.
	    
	    else if (!code.equals("3333")) {
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText("Code is wrong");
	        alert.showAndWait();
	    }
	    else if (isMatch) {
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText("Username taken");
	        alert.showAndWait();
	    }
	    
	    // Writing the data entered into the Librarians.txt file.
	    
	    else {
	        Person librarian = new Person("Librarian", username, password, firstName, lastName, address, cellphone, email, "No");

	        FileWriter writer = new FileWriter("Librarians.txt", true);
	        writer.write("Type: Librarian" + "\n" + "Username: " + username + "\n" + "Password: " + password + "\n" + "First Name: " + firstName + "\n" + "Last Name: " + lastName + "\n" + "Address: " + address + "\n" + "Email: " + email + "\n" + "Cellphone: " + cellphone + "\n" + "IsBlocked: No" + "\n" + "\n");
	        writer.close();

	        Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
	        Scene homeReader = new Scene(homeParent);
	        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        window.setScene(homeReader);
	        window.show();
	    }
	}
	public void login(ActionEvent event) throws IOException {
	    String username = logUsername.getText();
	    String password = logPassword.getText();
	    
	    boolean isMatch = false;
	    boolean blocked = false;
	    
	    // Reader or Librarian.
	    String RorL = "un";

	    // First file
	    try (Scanner scanner = new Scanner(new File("Readers.txt"))) {
	        scanner.nextLine(); // Skip empty line at the beginning of file
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            if (line.startsWith("Username:")) {
	                String storedUsername = line.substring(10).trim();
	                String storedPassword = scanner.nextLine().substring(10).trim();
	                String storedFirstName = scanner.nextLine().substring(12).trim();
	                String storedLastName = scanner.nextLine().substring(11).trim();
	                String storedAddress = scanner.nextLine().substring(9).trim();
	                String storedEmail = scanner.nextLine().substring(7).trim();
	                String storedCellphone = scanner.nextLine().substring(11).trim();
	                String storedIsBlocked = scanner.nextLine().substring(11).trim();
	                if (storedUsername.equals(username) && storedPassword.equals(password)) {
	                    isMatch = true;
	                    RorL = "R";
	                    System.out.println("Match");
	                    if (storedIsBlocked.equals("Yes")) {
	                        System.out.println("blocked");
	                        blocked = true;
	                    }
	                }

	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }

	    // Second file
	    try (Scanner scanner = new Scanner(new File("Librarians.txt"))) {
	        scanner.nextLine(); // Skip empty line at the beginning of file
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            if (line.startsWith("Username:")) {
	                String storedUsername = line.substring(10).trim();
	                String storedPassword = scanner.nextLine().substring(10).trim();
	                String storedFirstName = scanner.nextLine().substring(12).trim();
	                String storedLastName = scanner.nextLine().substring(11).trim();
	                String storedAddress = scanner.nextLine().substring(9).trim();
	                String storedEmail = scanner.nextLine().substring(7).trim();
	                String storedCellphone = scanner.nextLine().substring(11).trim();
	                String storedIsBlocked = scanner.nextLine().substring(11).trim();
	                if (storedUsername.equals(username) && storedPassword.equals(password)) {
	                    isMatch = true;
	                    RorL = "L";
	                    System.out.println("Match");
	                    if (storedIsBlocked.equals("Yes")) {
	                        System.out.println("blocked");
	                        blocked = true;
	                    }
	                }

	            }
	        }
	    }  catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }

	    if (isMatch == true && blocked == false) {
	        // Login successful
	    	if (RorL.equals("R")) {
	        Parent homeParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
	        Scene homeReader = new Scene(homeParent);
	        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        window.setScene(homeReader);
	        window.show();
	    	}
	    	else {
	    		Parent homeLParent = FXMLLoader.load(getClass().getResource("HomeL.fxml"));
		        Scene homeLibrarian = new Scene(homeLParent);
		        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        window.setScene(homeLibrarian);
		        window.show();
	    	}
	    }
	    if (isMatch == false && blocked == false) {
	        // Login failed
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText("Wrong Username or Password");
	        alert.showAndWait();
	    }
	    if (blocked == true && isMatch == true) {
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText("You are Blocked");
	        alert.showAndWait();
	    }
	    if (isMatch == false && blocked == true) {
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText(null);
	        alert.setContentText("You are Blocked");
	        alert.showAndWait();
	    }
	}
	

	
public void switchToAddBook (ActionEvent event) throws IOException {
try {	Parent root = FXMLLoader.load(getClass().getResource("Add_book.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}catch (Exception e) {
	e.getMessage();}
}
public void backtohomel (ActionEvent event) throws IOException {
try {	Parent root = FXMLLoader.load(getClass().getResource("Homel.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
catch (Exception e) {
	e.getMessage();
}

	
}



public void storebook (ActionEvent event) throws IOException {
	try {

	book b=new book(nameb.getText(),Authorb.getText());
	  FileWriter writer = new FileWriter("BOOK.txt", true);
      writer.write("BookName:"+b.getName()+"\n"+"AuthorName:"+b.getAuthor()+"\n"+"\n");
      writer.close();
       
Alert alert=new Alert(AlertType.CONFIRMATION);
alert.setTitle("saved");
alert.setContentText("your book saved successfully");
alert.setHeaderText("saved");
if(alert.showAndWait().get()==ButtonType.OK) {
	alert.close();}
}  catch (FileNotFoundException e) {
	 e.printStackTrace();  }        
}


public void switchTosearchbook (ActionEvent event) throws IOException {
	Parent root = FXMLLoader.load(getClass().getResource("serch.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}

public void searchbook (ActionEvent event) throws IOException {
	ArrayList <book> books2 = new ArrayList<>();
	int k=0;
	try {
		
		 File file1 = new File("BOOK.txt");
		Scanner scanner2 = new Scanner(file1);
		 
		  if (scanner2.hasNextLine()) {
		         scanner2.nextLine();
		     }

	     while (scanner2.hasNextLine()) {
	     	if (scanner2.hasNextLine()) {
		            scanner2.nextLine();
	     	}
	     	String nbook = "";
	     	if (scanner2.hasNextLine()) {
	     		nbook = scanner2.nextLine().substring(9).trim();
	     	 
	     	}
	     	String Abook = "";
	     	if (scanner2.hasNextLine()) {
	     		Abook = scanner2.nextLine().substring(11).trim();
	     	}
	     	book b1=new book(nbook,Abook);
	     	books2.add(b1);
	     }
	     System.out.println(books2.get(0).getName());
	     System.out.println(books2.get(1).getName());
	     
	     scanner2.close();
	     for (int i=0;i<books2.size();i++) {
	     if(books2.get(i).getName().trim().equals(search_name.getText().trim())){
	    	 k++;
	    	 Alert alert=new Alert(AlertType.CONFIRMATION);
	    	 alert.setTitle("search result");
	    	 alert.setContentText("the book Name:"+books2.get(i).getName()+"\n"+"the book Author:"+books2.get(i).getAuthor());
	    	 alert.setHeaderText("founded");
	    	 if(alert.showAndWait().get()==ButtonType.OK) {
	    	 	alert.close();
	     }
	    	 
	     }
	     
	}
	     if (k==0) {
	    	 Alert alert=new Alert(AlertType.CONFIRMATION);
	    	 alert.setTitle("search result");
	    	 alert.setContentText("the book is not exist");
	    	 alert.setHeaderText(" not founded");
	    	 if(alert.showAndWait().get()==ButtonType.OK) {
	    	 	alert.close();
	     }
	    	 
	     }
	     
	     } catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}

public void displayallbook (ActionEvent event) throws IOException {
	
	ArrayList <book> books2 = new ArrayList<>();
	
		
		 File file1 = new File("BOOK.txt");
		Scanner scanner2 = new Scanner(file1);
		 
		  if (scanner2.hasNextLine()) {
		         scanner2.nextLine();
		     }

	     while (scanner2.hasNextLine()) {
	     	if (scanner2.hasNextLine()) {
		            scanner2.nextLine();
	     	}
	     	String nbook = "";
	     	if (scanner2.hasNextLine()) {
	     		nbook = scanner2.nextLine().substring(9).trim();
	     	 
	     	}
	     	String Abook = "";
	     	if (scanner2.hasNextLine()) {
	     		Abook = scanner2.nextLine().substring(11).trim();
	     	}
	     	book b1=new book(nbook,Abook);
	     	books2.add(b1);
	     }
	     System.out.println(books2.get(0).getName());
	     System.out.println(books2.get(1).getName());
	     
	     scanner2.close();
	     String temp="";
	     for (int i=0;i<books2.size()-1;i++) {
	    	
	    	 temp= temp+"the booknumber"+(i+1)+":"+"\n"+books2.get(i).getName()+"\n"+"------"+"\n";
	     }
	    	 Alert alert=new Alert(AlertType.CONFIRMATION);
	    	 alert.setTitle("Dispaly result");
	    	 alert.setContentText(temp);
	    	 alert.setHeaderText("ALL books");
	    	 if(alert.showAndWait().get()==ButtonType.OK) {
	    	 	alert.close();
	     }     
	}
public void backtohome (ActionEvent event) throws IOException {
try {	Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
catch (Exception e) {
	e.getMessage();
}

	
}
public void switchTosearchbookreaders (ActionEvent event) throws IOException {
	Parent root = FXMLLoader.load(getClass().getResource("search_reader.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
	
}


	



	
	

