package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Je suis un client pas encore connecté...");
            
            Socket socket = new Socket("192.168.56.1", 5000);
            System.out.println("Je suis un client connecté !");
            
            // Fermeture de la socket
            socket.close();
            System.out.println("Connexion fermée.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
