package services_architecture;

import java.util.*;

// Clase Vuelo
class Vuelo {
    private String origen;
    private String destino;
    private Date fecha;

    public Vuelo(String origen, String destino, Date fecha) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Date getFecha() {
        return fecha;
    }
}

// Clase Asiento
class Asiento {
    private int numero;
    private String clase;

    public Asiento(int numero, String clase) {
        this.numero = numero;
        this.clase = clase;
    }

    public int getNumero() {
        return numero;
    }

    public String getClase() {
        return clase;
    }
}

// ServicioBusquedaVuelos
class ServicioBusquedaVuelos {
    public List<Vuelo> buscarVuelos(String origen, String destino, Date fecha) {
        // Simulación de búsqueda de vuelos
        List<Vuelo> vuelos = new ArrayList<>();
        vuelos.add(new Vuelo("Ciudad de Origen", "Ciudad de Destino", new Date()));
        return vuelos;
    }
}

// ServicioReservaAsientos
class ServicioReservaAsientos {
    public boolean reservarAsientos(Vuelo vuelo, List<Asiento> asientos) {
        // Simulación de reserva de asientos
        return true; // Suponiendo que la reserva siempre es exitosa en esta implementación básica
    }
}

// ServicioProcesamientoPagos
class ServicioProcesamientoPagos {
    public boolean procesarPago(double monto, String tarjetaCredito) {
        // Simulación de procesamiento de pago
        return true; // Suponiendo que el pago siempre es exitoso en esta implementación básica
    }
}

// ServicioNotificacion
class ServicioNotificacion {
    public void enviarNotificacionConfirmacion(String correo, String mensaje) {
        // Simulación de envío de notificación
        System.out.println("Enviando correo de confirmación a " + correo + ": " + mensaje);
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear instancias de los servicios
        ServicioBusquedaVuelos servicioBusquedaVuelos = new ServicioBusquedaVuelos();
        ServicioReservaAsientos servicioReservaAsientos = new ServicioReservaAsientos();
        ServicioProcesamientoPagos servicioProcesamientoPagos = new ServicioProcesamientoPagos();
        ServicioNotificacion servicioNotificacion = new ServicioNotificacion();

        // Simular una búsqueda de vuelos
        List<Vuelo> vuelosDisponibles = servicioBusquedaVuelos.buscarVuelos("Ciudad de Origen", "Ciudad de Destino", new Date());
        System.out.println("Vuelos disponibles:");
        for (Vuelo vuelo : vuelosDisponibles) {
            System.out.println("Origen: " + vuelo.getOrigen() + ", Destino: " + vuelo.getDestino() + ", Fecha: " + vuelo.getFecha());
        }

        // Simular reserva de asientos
        Vuelo vueloSeleccionado = vuelosDisponibles.get(0);
        List<Asiento> asientosSeleccionados = new ArrayList<>();
        asientosSeleccionados.add(new Asiento(1, "Económica"));
        asientosSeleccionados.add(new Asiento(2, "Económica"));
        boolean reservaExitosa = servicioReservaAsientos.reservarAsientos(vueloSeleccionado, asientosSeleccionados);
        if (reservaExitosa) {
            System.out.println("Reserva de asientos exitosa.");

            // Simular procesamiento de pago
            double monto = 500.0; // Supongamos que el monto es $500
            String tarjetaCredito = "1234-5678-9012-3456"; // Número de tarjeta de crédito
            boolean pagoExitoso = servicioProcesamientoPagos.procesarPago(monto, tarjetaCredito);
            if (pagoExitoso) {
                System.out.println("Pago exitoso.");

                // Simular envío de notificación
                String correo = "usuario@example.com";
                String mensaje = "Su reserva de vuelo ha sido confirmada.";
                servicioNotificacion.enviarNotificacionConfirmacion(correo, mensaje);
            } else {
                System.out.println("Error en el procesamiento del pago.");
            }
        } else {
            System.out.println("Error en la reserva de asientos.");
        }
    }
}
