package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Je suis un serveur en attente de la connexion d'un client...");
            
            Socket clientSocket = serverSocket.accept();
            System.out.println("Un client est connecté !");
            
            // Fermeture des sockets
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connexion fermée.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
