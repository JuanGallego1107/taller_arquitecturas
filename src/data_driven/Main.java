// Producto.java
public class Producto {
    private String nombre;
    private int cantidadDisponible;

    public Producto(String nombre, int cantidadDisponible) {
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
}

// Inventario.java
import java.util.HashMap;
        import java.util.Map;

public class Inventario {
    private Map<String, Producto> productos;

    public Inventario() {
        this.productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto) {
        productos.put(producto.getNombre(), producto);
    }

    public Producto obtenerProducto(String nombre) {
        return productos.get(nombre);
    }

    public void actualizarCantidad(String nombre, int nuevaCantidad) {
        Producto producto = productos.get(nombre);
        if (producto != null) {
            producto.setCantidadDisponible(nuevaCantidad);
        } else {
            System.out.println("El producto '" + nombre + "' no existe en el inventario.");
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        // Crear un inventario
        Inventario inventario = new Inventario();

        // Agregar productos al inventario
        Producto producto1 = new Producto("Camisa", 50);
        Producto producto2 = new Producto("Pantalón", 30);
        inventario.agregarProducto(producto1);
        inventario.agregarProducto(producto2);

        // Obtener un producto por su nombre
        Producto productoEncontrado = inventario.obtenerProducto("Camisa");
        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado.getNombre() + ", Cantidad disponible: " + productoEncontrado.getCantidadDisponible());
        } else {
            System.out.println("Producto no encontrado.");
        }

        // Actualizar la cantidad disponible de un producto
        inventario.actualizarCantidad("Camisa", 40);

        // Verificar la nueva cantidad disponible del producto actualizado
        productoEncontrado = inventario.obtenerProducto("Camisa");
        if (productoEncontrado != null) {
            System.out.println("Producto actualizado - Cantidad disponible: " + productoEncontrado.getCantidadDisponible());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
