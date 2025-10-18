package serverPackage;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            int port = 5000;
            InetAddress ip = InetAddress.getByName("0.0.0.0");
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(ip, port));

            System.out.println("Serveur en attente sur " + InetAddress.getLocalHost().getHostAddress() + ":" + port);

            try (Socket clientSocket = serverSocket.accept();
                 DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                 DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

                System.out.println("Client connecté !");

                boolean continuer = true;
                while (continuer) {
                    int x;
                    try {
                        x = in.readInt();
                    } catch (EOFException e) {
                        System.out.println("Client a fermé la connexion.");
                        break;
                    }

                    int choix = in.readInt();

                    double resultat = 0;
                    switch (choix) {
                        case 1:
                            resultat = x + 10;
                            break;
                        case 2:
                            resultat = x - 10;
                            break;
                        case 3:
                            resultat = x * 5;
                            break;
                        case 4:
                            if (x != 0)
                                resultat = x / 2.0;
                            else
                                System.out.println("Erreur : division par zéro !");
                            break;
                        default:
                            System.out.println("Opération non reconnue !");
                            break;
                    }

                    out.writeDouble(resultat);
                    out.flush();

                    System.out.println("Requête traitée → x = " + x + ", choix = " + choix + ", résultat = " + resultat);
                }

            }

            System.out.println("Connexion terminée.");
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
