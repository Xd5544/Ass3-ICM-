package Boundary;

import javafx.collections.FXCollections;
import java.net.URL;
import java.text.SimpleDateFormat;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.scene.layout.Pane;
import Client.ClientConsole;
import Entity.Request;

public class AllRequestsController implements Initializable {
	public static Stage primaryStage;
	private static ClientConsole cc;
	private AnchorPane lowerAnchorPane;
	@FXML
	private TableView<Request> tableRequests;	
	@FXML 
	private TableColumn colID;
	@FXML
	private TableColumn colName;
	@FXML
	private TableColumn colStatus;
	@FXML
	private TableColumn colPriflig;
	@FXML
	private TableColumn colSubDate;
	@FXML
	private Button RequestInfo;
	@FXML
	private static SplitPane splitpane;
	@FXML
	private ComboBox Groupby;
	private static ObservableList<Request> list;
	ObservableList<String> statuslist=FXCollections.observableArrayList("Active","Frozen","Closed");
	public void start(SplitPane splitpane,String path) {
		primaryStage=LoginController.primaryStage;
		this.cc=LoginController.cc;
		try{	
			FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
			lowerAnchorPane = loader.load();
			splitpane.getItems().set(1, lowerAnchorPane);
			this.splitpane=splitpane;	
			System.out.println("wwwwwwss");
			String AllRequests="All Requests";
			cc.getClient().sendToServer(AllRequests);
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	public void fillTable(ArrayList<Request> arr1) {
			// TODO Auto-generated method stub
		
		System.out.println(arr1.get(0));

			list=FXCollections.observableArrayList(arr1);
			colID.setStyle("-fx-alignment: CENTER;");			
			colName.setStyle("-fx-alignment: CENTER;");
			colID.setCellValueFactory(new PropertyValueFactory<Request,String>("id"));
			System.out.print("mmmmmmm");
			colName.setCellValueFactory(new PropertyValueFactory<Request,String>("nameInitiator"));
			colStatus.setCellValueFactory(new PropertyValueFactory<Request,String>("status"));		
			colPriflig.setCellValueFactory(new PropertyValueFactory<Request,String>("privilegedInfoSys"));
			colSubDate.setCellValueFactory(new PropertyValueFactory<Request,String>("date"));
			//tableRequests.setStyle("-fx-alignment: CENTER;");
           // colName.set
			tableRequests.setItems(list);
		}
	public void RequestInfoAction() {
		RequestInfoController info = new RequestInfoController();
		info.start(splitpane);
	}
	
	public void RequestTreatmentAction() {
		RequestTreatmentAction Treatment = new RequestTreatmentAction();
		Treatment.start(splitpane);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Groupby.setItems(statuslist);
	}	
}