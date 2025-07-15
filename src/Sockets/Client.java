package Sockets;

import java.io.*;
import java.net.*;

public class Client {
    // Declaramos socket y los streams
    private Socket s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    // Constructor del cliente que recibe dirección IP y puerto
    public Client(String addr, int port) {
        try {
            // Se crea el socket y se conecta al servidor
            s = new Socket(addr, port);
            System.out.println("Conectado al servidor");

            // Entrada de datos desde la terminal
            in = new DataInputStream(System.in);

            // Salida de datos hacia el servidor
            out = new DataOutputStream(s.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println("Error de host: " + u);
            return;
        } catch (IOException i) {
            System.out.println("Error de E/S: " + i);
            return;
        }

        String mensaje = "";

        // Bucle que sigue enviando datos hasta que el usuario escriba "Over"
        while (!mensaje.equals("Over")) {
            try {
                mensaje = in.readLine();      // Lee desde teclado
                out.writeUTF(mensaje);        // Envia al servidor
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        // Cierre de conexión
        try {
            in.close();
            out.close();
            s.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Client("127.0.0.1", 5000);
    }
}