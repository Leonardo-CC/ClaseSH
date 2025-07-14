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
    }
}
