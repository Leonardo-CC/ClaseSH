package Sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket s = null;
    private ServerSocket ss = null;
    private DataInputStream in = null;

    // Contructor que recibe el puerto a escuchar
    public Server (int port) {
        try {
            // Se inicia el servidor en el puerto dato
            ss = new ServerSocket(port);
            System.out.println("Servicdor iniciado");
            System.out.println("Esperando al cliente");

            // Acepta la conexion del cliente
            s = ss.accept();
            System.out.println("Cliente esta conectado");

            // Nos preparamos para recibir los datos del cliente
            in = new DataInputStream(s.getInputStream());

            String mensaje = "";

            // Seguimos leyendo hasta que el cliente nos envie un Over

            while (!mensaje.equals("Over")) {
                try {
                    mensaje = in.readUTF(); // Recibe los datos
                    System.out.println(mensaje);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }

            System.out.println("Cerrando la conexion");

            // Cierre de conexion
            s.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Server(5000); // Ejecutamos el servidor en el puerto 5000
    }
}