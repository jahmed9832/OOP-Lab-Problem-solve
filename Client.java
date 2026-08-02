import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket("localhost", 6666);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            System.out.print("Enter operation (e.g., ADD 10 20 or MUL 5 4): ");
            String input = sc.nextLine();

            dos.writeUTF(input);

            String response = dis.readUTF();
            System.out.println("Server Response -> " + response);

            dis.close();
            dos.close();
            s.close();
            sc.close();
        } catch (IOException e) {
            
        }
    }
}