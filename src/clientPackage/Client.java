package clientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Client connecté au serveur !");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            boolean continuer = true;
            while (continuer) {
                System.out.print("Entrez un entier : ");
                int x = sc.nextInt();
                
                System.out.println("Choisissez l'opération :");
                System.out.println("1 - Addition (+10)");
                System.out.println("2 - Soustraction (-10)");
                System.out.println("3 - Multiplication (*5)");
                System.out.println("4 - Division (/2)");
                int choix = sc.nextInt();
                
                out.writeInt(x);
                out.writeInt(choix);
                out.flush();
                
                double resultat = in.readDouble();
                System.out.println("Résultat reçu du serveur : " + resultat);
                System.out.print("Voulez-vous continuer ? (oui:1 / non:0) : ");
                int rep = sc.nextInt();
                if (rep == 0) {
                    continuer = false;
                }
            }out.close();
            in.close();
            socket.close();
            sc.close();
            System.out.println("Client terminé.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
