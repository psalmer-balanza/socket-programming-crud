package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 9999);
            System.out.println("Client is running.");
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            OutputStreamWriter osr = new OutputStreamWriter(s.getOutputStream());

            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(osr);

            Scanner sc = new Scanner(System.in);

            while(true) {
                bw.write(sc.nextLine());
                bw.newLine();
                bw.flush();

                System.out.println("Server: " + br.readLine());
            }
        } catch (Exception e){
            System.out.println("Error: " + e);
        }

    }
}
