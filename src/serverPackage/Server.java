package serverPackage;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Serveur en attente de connexion...");
            
            try (Socket clientSocket = serverSocket.accept();
                 DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                 DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {
                 
                System.out.println("Client connecté !");
                
                // Réception de l'entier envoyé par le client
                int x = in.readInt();
                System.out.println("Valeur reçue du client : " + x);
                
                // Calcul côté serveur
                int resultat = x * 5;
                System.out.println("Résultat calculé : " + resultat);
                
                // Envoi du résultat au client
                out.writeInt(resultat);
                
            }
            System.out.println("Connexion terminée.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
