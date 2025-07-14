package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    // Declaramos los sockets y los streams
    private Socket s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    // Constructor del cliente que recibe la dirección IP
    public Client(String addr, int port) {
        try {
            // Creamos el socket que se conecta al servidor
            s = new Socket(addr, port);
            System.out.println("Conectado al servidor");

            // Entrada de datos por terminal
            in = new DataInputStream(System.in);

            // Salida de datos hacia el servidor
            out = new DataOutputStream(s.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println("Error de Host" + u);
            return;
        } catch (IOException i) {
            System.out.println("Error de E/S" + i);
            return;
        }

        String mensaje = "Hola";

        // Bucle que seguira enviando datos hasta que el usuario escriva Over

        while (!mensaje.equals("Over")) {
            try {
                mensaje = in.readLine(); // Lee los datos del teclado
                out.writeUTF(mensaje); // envia al servidor
            } catch (IOException i) {
                System.out.println(i);
            }

            // cierre la conexion

            try {
                in.close();
                out.close();
            } catch (IOException i) {
                System.out.println(i);
            }

            public static void main(String[] args) {
                new Client("127.0.0.1", 5000);
            }
        }
    }
}
