package Server;

import java.io.IOException;
import java.sql.Connection;
import java.util.Observable;
import java.util.Observer;

import DBconnection.mysqlConnection;
import Entity.Phase;
import Entity.RequestPhase;
import ocsf.server.ConnectionToClient;

public class SeverGetExtensionDataObsaerver implements Observer {
	public SeverGetExtensionDataObsaerver(Observable server) {
		server.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Object[]) {
			Object[] arg2 = (Object[]) arg1;
			ConnectionToClient client = (ConnectionToClient) arg2[0];
			if (arg2[1] instanceof Object[]) {
				Object[] arg3 = (Object[]) arg2[1];
				String keymessage = (String) arg3[0];
				if (keymessage.equals("get extension data")) {
					int id = (int) arg3[1];
					String phase = (String) arg3[2];
					String myjob = (String) arg3[3];
					Connection con = mysqlConnection.makeAndReturnConnection();
					String[] data = mysqlConnection.getExtension(con, id, phase.toString());
					if (myjob.equals("admen")) {
						Object[] msg = { "get extension data admen", data };

						try {
							client.sendToClient(msg);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (myjob.equals("inspector")) {
						Object[] msg = { "get extension data inspector", data };

						try {
							client.sendToClient(msg);
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
