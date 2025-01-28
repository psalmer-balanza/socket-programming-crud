package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("Server is running.");
            while(true) {
                Socket s = ss.accept();
                InputStreamReader isr = new InputStreamReader(s.getInputStream());
                OutputStreamWriter osr = new OutputStreamWriter(s.getOutputStream());
                BufferedReader br = new BufferedReader(isr);
                BufferedWriter bw = new BufferedWriter(osr);

                while(true) {
                    System.out.println("Client: " + br.readLine());
                    bw.write("Message received.");
                    bw.newLine();
                    bw.flush();
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}
