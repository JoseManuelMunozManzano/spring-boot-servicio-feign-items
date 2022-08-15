package com.jmunoz.springboot.app.item.clientes;

import com.jmunoz.springboot.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Con la anotación @FeignClient se indica que esta interface es un cliente Feign, e indicamos el nombre del servicio
// al que nos queremos conectar y la url con el puerto
@FeignClient(name="servicio-productos", url="localhost:8001")
public interface ProductoClienteRest {

    // Aquí en FeignClient se usa @GetMapping para consumir el servicio API REST, obtener los datos JSON convertidos
    // a objeto Producto.
    // Se indica la misma ruta que aparece en el @GetMapping del proyecto servicio productos
    @GetMapping("/listar")
    public List<Producto> listar();

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id);

}
