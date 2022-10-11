/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FunG
 */
public class SocketHandle implements Runnable{
    private BufferedWriter os;
    private BufferedReader is;
    private Socket socketClient;
    private int ID_Server;
    
    @Override
    public void run() {
        try {
            // Gửi yêu cầu kết nối tới Server đang lắng nghe
            socketClient = new Socket("192.168.0.122",7777);
            System.out.println("Kết nối thành công!");
            // Tạo luồng đầu ra tại client (Gửi dữ liệu tới server)
            os = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            // Luồng đầu vào tại Client (Nhận dữ liệu từ server).
            is = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            String message;
            while(true){
                message = is.readLine();
                if (message == null){
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
