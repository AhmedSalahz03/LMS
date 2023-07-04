package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Remove {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML 
	TextArea textarea;
	
	public void initialize() {
        try {
            // Read the contents of the text file and display it in the TextArea
            String content = Files.readString(Paths.get("Readers.txt"));
            textarea.setText(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void removeText() {
        // Remove the specified number of lines from the TextArea
        String content = textarea.getText();
        int index = 0;
        for (int i = 0; i < 10; i++) {
            index = content.indexOf("\n", index) + 1;
            if (index == 0) {
                break;
            }
        }
        if (index != 0) {
            content = content.substring(index);
            textarea.setText(content);

            // Write the updated content back to the text file
            try {
                Files.writeString(Paths.get("Readers.txt"), content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void ReturnToHomePage(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("HomeL.fxml"));
   		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   		scene = new Scene(root);
   		stage.setScene(scene);
   		stage.show();
    }



}

