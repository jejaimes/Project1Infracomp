/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadassignment;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class Client extends Thread {

	private Buffer buffer;
        private int id;
	private int numberMessages;
	private LinkedList<Message> messages;
	
	public Client(int id, int numberMessages, Buffer buffer) {
            this.numberMessages = numberMessages;
            this.buffer = buffer;
            this.id = id;
            messages = new LinkedList<Message>();
	}
	
	public void run() {
            //initialize message
            for(int i = 0; i < numberMessages; i++) {
                Random rand = new Random();
                int q = rand.nextInt(10) + 1;
                Message m = new Message(q);
                messages.add(m);
                System.out.println("Client"+id+" Creating Query: "+m.getMessage());
            }
            
            for(int i = 0; i < numberMessages; i++ ){
                Message m = messages.removeFirst();
                buffer.saveToBuffer(m);
                
                synchronized(m){
                    System.out.println("Client"+id+" is waiting.");
                    try {
                        m.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                System.out.println("Client "+id+" has "+messages.size()+"remaining");
            }
            
            System.out.println("Bleh");
            buffer.clientLeaving();
            System.out.println("Number "+id+" is leaving");
        }
}


