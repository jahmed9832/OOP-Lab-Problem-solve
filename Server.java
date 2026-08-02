
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server started. Waiting for client...");

            Socket s = ss.accept();
            System.out.println("Client connected!");

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received operation: " + request);

            String[] parts = request.split(" ");
            String operation = parts[0];
            double num1 = Double.parseDouble(parts[1]);
            double num2 = Double.parseDouble(parts[2]);
            double result = 0;

            if (operation.equalsIgnoreCase("ADD")) {
                result = num1 + num2;
            } else if (operation.equalsIgnoreCase("SUB")) {
                result = num1 - num2;
            } else if (operation.equalsIgnoreCase("MUL")) {
                result = num1 * num2;
            } else if (operation.equalsIgnoreCase("DIV")) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    dos.writeUTF("Error: Division by zero");
                    s.close();
                    ss.close();
                    return;
                }
            }

            dos.writeUTF("Result: " + result);

            dis.close();
            dos.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            
        }
    }
}