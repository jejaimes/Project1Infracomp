/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;

/**
 *
 * @author Owner
 */

public class Message {

    private int message;

    public Message(int i){
        message = i;
    }

    public void setMessage(int i){
        message = i;
    }
    public int getMessage(){
        return message;
    }
}