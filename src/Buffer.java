/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */

public class Buffer {

	private int size;
	private LinkedList<Message> messages;
        private int numberClients;
	
	public Buffer(int size, int numberClients) {
            this.size = size;
            messages = new LinkedList<>();	
            this.numberClients = numberClients;
        }
	
	public void saveToBuffer(Message m){
            synchronized (messages){
                while (messages.size() >= size){
                
                    Thread.yield();
                }
                messages.add(m);
                System.out.println("Query "+ m.getMessage() +" sent to buffer");
            }
        }
	public synchronized Message obtainQuery() {
            while(messages.isEmpty()){
                Thread.yield();
                if (numberClients == 0)
                    break;
            }
            
            if (numberClients != 0)
            {
                Message m = messages.removeFirst();
                return m;
            }
            return null;
            
	}
        public void clientLeaving(){
            numberClients--;
            System.out.println("Number of Clients: "+numberClients);
        }
        public int getNumberClient(){
            return numberClients; 
        }
}

	


    

