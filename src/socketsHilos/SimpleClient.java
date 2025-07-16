package socketsHilos;

import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        String host = "localhost"; //Direccion del servidor
        int port = 6666; // Puerto a conectarse

        try (
                Socket socket = new Socket(host, port); // Conectado con el servidor
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); //enviamos el mensaje
                DataInputStream in = new DataInputStream(socket.getInputStream()); // recibimos la respuesta
        ) {
            out.writeUTF("¡Hola servidor ! soy un cliente");

            //imprime la respuesta del servidor
            String response = in.readUTF();
            System.out.println("Respuesta del servidor: " + response);
        } catch (IOException i) {
            System.out.println("Error en el cliente: "+ i.getMessage());
        }
    }
}