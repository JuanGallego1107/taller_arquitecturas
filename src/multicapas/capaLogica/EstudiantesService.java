package multicapas.capaLogica;// EstudiantesService.java
import multicapas.capaDatos.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudiantesService {
    private final List<Estudiante> listaEstudiantesService;

    // Constructor
    public EstudiantesService() {
        this.listaEstudiantesService = new ArrayList<>();
    }

    // Método para agregar un estudiante
    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantesService.add(estudiante);
    }

    // Método para eliminar un estudiante por ID
    public void eliminarEstudiante(int id) {
        for (Estudiante estudiante : listaEstudiantesService) {
            if (estudiante.getId() == id) {
                listaEstudiantesService.remove(estudiante);
                break;
            }
        }
    }

    // Método para obtener todos los estudiantesService
    public List<Estudiante> obtenerTodosEstudiantesService() {
        return listaEstudiantesService;
    }

}
