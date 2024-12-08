package service.com.demo.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.com.demo.Entidades.Producto;
import service.com.demo.Service.ProductoService;

@RestController
@RequestMapping("/productos")

public class ControladorProducto {


    @Autowired
    private ProductoService servicio;

    @GetMapping
    public List<Producto> obtenerProductos() {
        return servicio.obtenerProducto();
    }

    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping("/{id}")
    public Producto crearProducto(@RequestBody Producto producto) {
        return servicio.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        return servicio.ActualizarProducto(productoActualizado, id);
    }

    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable Long id) {
        return servicio.eliminarProducto(id);
    }
}
