package navalwar.server.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import navalwar.server.gameengine.IGameEngineModule;

/**
 * Created with IntelliJ IDEA.
 * User: Omar
 * Date: 16-12-13
 * Time: 08:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClientThread extends Thread{


    private Socket connection;
    private IGameEngineModule igem;
    private BufferedReader inClient;
    private String message = "";
    
    

    public ClientThread(Socket socket, IGameEngineModule ig) throws IOException {
        try {
            connection = socket;
            igem = ig;

        } catch (Exception e) {
            System.out.println("Error inicializando el socket: " + e.getMessage());

        } 
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            try{
            	inClient = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
               message = inClient.readLine();
               
               System.out.println(message);             

            }catch (IOException e){
               System.out.println("Error al recibir datos " + e.getMessage());
            }
        }
    }
}
