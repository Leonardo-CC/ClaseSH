package socketsHilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

// Clase que maneja la conexión de un cliente individual
public class ClientHandler implements Runnable {
    private Socket clientSocket;

    // Constructor: recibe el socket del cliente
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override public void run() {
        try ( // Flujo de entrada para leer lo que el cliente envia
              DataInputStream input = new DataInputStream(clientSocket.getInputStream());
              // Flujo de salida para enviar mensajes al cliente
              DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
            ) {
            // Leer los datos del cliente
            String message = input.readUTF();
            System.out.println("Mensaje recibido " + message);

            // Enviar una respuesta al cliente
            output.writeUTF("Hola, cliente . Recibi tu mensaje: \"" + message + "\"");
        } catch (IOException i) {
            System.out.println("Error con el cliente: " + i.getMessage());
        } finally {
            try {
                clientSocket.close(); // Cerramos el socket del cliente

            } catch (IOException i) {
                System.out.println("Error al cerrar el socket: " + i.getMessage());
            }
        }
    }
}
