package service.com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.com.demo.Entidades.Producto;
import service.com.demo.Repositorios.RepositoryProducto;

@Service
public class ProductoService {

    @Autowired
    private RepositoryProducto repositorio;

    // Obtener todos los productos
    public List<Producto> obtenerProducto() {
        return repositorio.findAll();
    }

    // Obtener por Id
    public Producto obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    // Crear Producto
    public Producto crearProducto(Producto producto) {
        return repositorio.save(producto);
    }

    // Delete Producto
    public String eliminarProducto(Long id) {
         repositorio.deleteById(id);
        return "Borrado";
    }

    // Actualizar Producto
    public Producto ActualizarProducto(Producto productoActualizado, Long id) {
        // Guardando en variable si encuentra
        Producto producto = repositorio.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro"));

        // Actualizando Valores

        producto.setNombre(productoActualizado.getNombre());
        producto.setPrecio(productoActualizado.getPrecio());

        return repositorio.save(producto);




    }
}
