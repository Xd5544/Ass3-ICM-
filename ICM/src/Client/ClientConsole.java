package Client;
import java.io.*;


import java.net.InetAddress;
import java.net.UnknownHostException;

import Boundary.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;


/**
 * This class constructs the UI for a chat client.  It implements the
 * chat interface in order to activate the display() method.
 * Warning: Some of the code here is cloned in ServerConsole 
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge  
 * @author Dr Robert Lagani&egrave;re
 * @version July 2000
 */
public class ClientConsole 
{
  /**
   * The default port to connect on.
   */
	private static Stage connectstage;
  final public static int DEFAULT_PORT = 5555;
  
  //Instance variables **********************************************
  
  /**
   * The instance of the client that created this ConsoleChat.
   */
  ICMClient client;

  
  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  public ClientConsole(String host)
  {
    try 
    {
    	/**
    	 * this is the class is our client class that inherit AbstractClient
    	 */
      client= new ICMClient(host,DEFAULT_PORT,this);
    } 
    catch(IOException exception) 
    {
      System.out.println("Error: Can't setup connection!"
                + " Terminating client.");
      System.exit(1);
    }
  }
  public ICMClient getICMClient() {
	  return client;
  }
  /**
   * 
   * @param IP this is the IP that the Client entered.
   * @param stage this is the main stage.
   * This function will be called when the client pressed Connect button and want to connect to the server.
   */
  public static void connecttoIP(String IP,Stage stage) {/*in case the ip inserted was correct the clientConsole and ICM client that will be created successfully*/
	    String host = "";
	    int port = 0;  //The port number
	    connectstage=stage;
	    try
	    {	    
	      host = IP;
	    }
	    catch(ArrayIndexOutOfBoundsException e)
	    {
	      System.out.println("error connected");
	      host = "localhost";
	    }
	 ClientConsole cc = new ClientConsole(host);
	
  }
  public Stage getstage() {
	  return connectstage;
  }

  public void Serverdisconnected() {
	  System.exit(0);
  }
  //Instance methods ************************************************

  
  /**
   * This method waits for input from the console.  Once it is 
   * received, it sends it to the client's message handler.
   */
  /**
   * This method overrides the method in the ChatIF interface.  It
   * displays a message onto the screen.
   *
   * @param message The string to be displayed.
   */
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of the Client UI.
   *
   * @param args[0] The host to connect to.
   */
}
//End of ConsoleChat class