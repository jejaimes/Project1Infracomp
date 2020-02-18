/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadassignment;

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
        Buffer buffer = new Buffer(10, 2);
        Server server1 = new Server(1, buffer);
        Server server2 = new Server(2, buffer);
        Client client1 = new Client(1,2, buffer);
        Client client2 = new Client(2,2, buffer);
        
        client1.start();
        client2.start();
        server1.start();
        server2.start();
        
    }
    
}
