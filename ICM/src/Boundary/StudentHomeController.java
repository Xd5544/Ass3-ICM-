package Boundary;

import Entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class StudentHomeController {

	@FXML
	private Button Homebtn;
	@FXML
	private Button RequestWorkedOnbtn;
	@FXML
	private Button RequestSubmissionbtn;
	@FXML
	private Button ProfileSettingbtn;
	@FXML
	private Button AboutICMbtn;
	@FXML
	private ComboBox Usercombobtn;	

	public static Stage primaryStage;
	private Student student;
	public void start(Student student) {
		this.student=student;
		primaryStage=LoginController.primaryStage;
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/Boundary/Student-Home.fxml"));			
			Scene scene = new Scene(root);		
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("ICM-Home");			
			primaryStage.show();
			primaryStage.setOnCloseRequest( event ->
		    {
		        System.out.println("EXIT ICM");
		        System.exit(0);	
		    });			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
public Stage getPrimaryStage() {
		return primaryStage;
	}

public void GoToHome(ActionEvent event) throws Exception {
	this.start();
}

public void RequestWorkedOnAction(ActionEvent event) throws Exception {
	//RequestWorkedOnController 
}

public void RequestSubmissionAction(ActionEvent event) throws Exception {
	RequestSubmissionController Submit=new RequestSubmissionController();
	Submit.start();
}

public void ProfileSettingAction(ActionEvent event) throws Exception {
	ProfileSettingController Submit=new ProfileSettingController();
	Submit.start();
}

public void AboutICMAction(ActionEvent event) throws Exception {
	AboutICMController about=new AboutICMController();
	about.start();
}

}
