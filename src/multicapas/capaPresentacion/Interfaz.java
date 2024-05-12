package multicapas.capaPresentacion;// Main.java
import multicapas.capaDatos.Estudiante;
import multicapas.capaLogica.EstudiantesService;

import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {
        EstudiantesService estudiantesService = new EstudiantesService();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- Menú -----");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Mostrar todos los estudiantes");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después del número

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el ID del estudiante: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea después del número
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la edad del estudiante: ");
                    int edad = scanner.nextInt();
                    estudiantesService.agregarEstudiante(new Estudiante(id, nombre, edad));
                    System.out.println("Estudiante agregado correctamente.");
                }
                case 2 -> {
                    System.out.print("Ingrese el ID del estudiante a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    estudiantesService.eliminarEstudiante(idEliminar);
                    System.out.println("Estudiante eliminado correctamente.");
                }
                case 3 -> {
                    System.out.println("Lista de estudiantes:");
                    for (Estudiante estudiante : estudiantesService.obtenerListaEstudiantes()) {
                        System.out.println("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad());
                    }
                }
                case 4 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
