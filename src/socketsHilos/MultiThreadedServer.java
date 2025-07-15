package socketsHilos;

import java.io.*;
import java.net.*;

// Esta es la clase principal del servidor
public class MultiThreadedServer {
    public static void main(String[] args) {
        int port = 6666; //Este es el que el servidor escuchara
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor escuchando en el puerto: " + port);

            while (true) {
                // Esperando a que el cliente se conecte
                Socket clienSocket = serverSocket.accept();

                // Mostramos la ip del cliente conectado
                System.out.println("Nuevo cliente conectado: " + clienSocket.getInetAddress());

                // Se crea un hilo para manejar la conexion del cliente
                ClientHandler handler = new ClientHandler(clienSocket);
                        new Thread(handler).start(); // Iniciamos el hilo

            }
        } catch (IOException i) {
            System.out.println("Error en el servidor " + i.getMessage());
        }
    }
}
