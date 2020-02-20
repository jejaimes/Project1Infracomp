/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Owner
 */

public class Server extends Thread {

    private Buffer buffer;
    int id;
    
    public Server(int id, Buffer buffer){
        this.buffer = buffer;
        this.id = id;
    }
    public Message sendAnswer(Message m){
        return m;
    }
    public void run(){
        int noClient = buffer.getNumberClient();
        
        while(noClient > 0){
        Message m = buffer.obtainQuery();
        
        if (m != null)
        {
            int i = m.getMessage();
            i++;
            m.setMessage(i);
            synchronized(m){
                m.notify();
            }
            System.out.println("------------------\nAnswer to "+(i-1)+" is "+m.getMessage()+"\n------------------");
            
        }
        noClient = buffer.getNumberClient();
            //System.out.println(""+noClient);
            
        }
        this.yield();
    }
}

