package Server;

import java.io.IOException;
import java.sql.Connection;
import java.util.Observable;
import java.util.Observer;

import DBconnection.mysqlConnection;
import Entity.Employee;
import Entity.User;
import ocsf.server.ConnectionToClient;

public class ServerAdminActiveRequestObserver implements Observer {
	public ServerAdminActiveRequestObserver(Observable server) {
		server.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg) {
		// TODO Auto-generated method stub
		if(arg instanceof Object[]) {
			Object[] arg1=(Object[])arg;
			ConnectionToClient client=(ConnectionToClient)arg1[0];
			if(arg1[1] instanceof Object[]) {
				Object[] arg2=(Object[])arg1[1];
				if(arg2[0] instanceof String) {
					String keymessage=(String)arg2[0];
					if(keymessage.equals("Admin changed status to Active")) {
						System.out.println("serverobserver");
						int id=(int)arg2[1];
						Employee administrator = (Employee)arg2[2];
						String explain=(String)arg2[3];					
						Connection con=mysqlConnection.makeAndReturnConnection();
						boolean state=mysqlConnection.ActiveRequest(con, id);
						if(state)
							mysqlConnection.EnterActiveToDBUpdateTable(con, administrator,id,explain);
						try {
							Object[] send=new Object[2];
							send[0]=keymessage;
							send[1]=state;
							client.sendToClient(send);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
	}
}
}






