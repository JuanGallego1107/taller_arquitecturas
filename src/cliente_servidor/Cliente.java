// Cliente.java
import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

            String mensaje;
            while (true) {
                System.out.print("Ingrese un mensaje: ");
                mensaje = lector.readLine();
                salida.println(mensaje);
                System.out.println("Mensaje enviado al servidor: " + mensaje);
                String respuesta = entrada.readLine();
                System.out.println("Respuesta del servidor: " + respuesta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
