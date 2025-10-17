package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 5000);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			Scanner sc = new Scanner(System.in)) {
			System.out.println("Client connecté. Entrez un entier : ");
			int x = sc.nextInt();
			// Envoi de l'entier au serveur
			out.writeInt(x);
			// Réception du résultat
			int resultat = in.readInt();
			System.out.println("Résultat reçu du serveur : " + resultat);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}