/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 *
 * @author Owner
 */
public class ThreadAssignment {
private static Client[] clients;
	
	private static Server[] servers;
	
	private static int messagesPerClient;
	
	private static Buffer buffer;
    
    public static void main(String[] args) {
    	
    	File config = new File("./docs/config.txt");
		try {
			FileReader fr = new FileReader(config);
			BufferedReader br = new BufferedReader(fr);
			int numClients = Integer.parseInt(br.readLine().split("=")[1]);
			messagesPerClient = Integer.parseInt(br.readLine().split("=")[1]);
			int numServers = Integer.parseInt(br.readLine().split("=")[1]);
			int bufferSize = Integer.parseInt(br.readLine().split("=")[1]);
			br.close();
			buffer = new Buffer(bufferSize, numClients);
			clients = new Client[numClients];
			servers = new Server[numServers];
			for (int i = 0; i < clients.length; i++) {
				Client c = new Client(i, messagesPerClient, buffer);
				clients[i]=c;
			}
			for (int i = 0; i < servers.length; i++) {
				Server s = new Server(i, buffer);
				servers[i]=s;
			}
			for (int i = 0; i < servers.length; i++) {
				servers[i].start();
			}
			for (int i = 0; i < clients.length; i++) {
				clients[i].start();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
    }
    
}
