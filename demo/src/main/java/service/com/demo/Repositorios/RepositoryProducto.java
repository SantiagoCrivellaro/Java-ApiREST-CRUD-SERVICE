package service.com.demo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import service.com.demo.Entidades.Producto;

public interface RepositoryProducto extends JpaRepository<Producto, Long>{

}
