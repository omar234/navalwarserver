package navalwar.server.network;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import navalwar.server.gameengine.GameEngineModule;
import navalwar.server.gameengine.IGameEngineModule;
import navalwar.server.gameengine.War;

public class ServerNetworkModule implements IServerNetworkModule {


	IGameEngineModule game = null;


	//--------------------------------------------
	// Constructors & singleton pattern
	//--------------------------------------------

    private ServerSocket server = null;
    
    private int puerto = 5000;
    private Map players = new HashMap();
    

	private ServerNetworkModule() {
        
                try {
                    server = new ServerSocket(puerto);
                    while(true) {
                        Socket nextClient = server.accept();
                        new ClientThread(nextClient,game).start();
                        //System.out.println("Conectado desde: ");
                        players.put(nextClient.getInetAddress(), nextClient.getPort());
                        
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
     }
        


	


	private static ServerNetworkModule instance = null;
	public static ServerNetworkModule getInstance() {
		if (instance == null) instance = new ServerNetworkModule();
		return instance;
	}

	//--------------------------------------------
	// IServerNetworkModule methods
	//--------------------------------------------

	public void bindGameEngineModule(IGameEngineModule game) {
		this.game = game;
	}

	public int startWar(int warID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int turnArmy(int warID, int armyID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int turnArmyTimeout(int warID, int armyID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int armyKicked(int warID, int armyID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int endWar(int warID, int winnerArmyID) {
		// TODO Auto-generated method stub
		return 0;
	}



}
