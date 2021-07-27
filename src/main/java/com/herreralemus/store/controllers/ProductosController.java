package com.herreralemus.store.controllers;

import com.herreralemus.store.models.Orden;
import com.herreralemus.store.models.Producto;
import com.herreralemus.store.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "productos")
public class ProductosController {

    @Autowired
    ProductosService productosService;

    @GetMapping(path = "/")
    public Page<Producto> getAll(@RequestParam(required = false) Map<String, String> params){
        return productosService.getAll(params);
    }

    @PostMapping(path = "add")
    public Producto add(@RequestBody Producto producto){
        return productosService.add(producto);
    }

    @PostMapping(path = "update")
    public Producto update(@RequestBody Producto producto){
        return productosService.update(producto);
    }

    @GetMapping(path = "delete/{uuid}")
    public void delete(@PathVariable(value = "uuid") String uuid){
        productosService.delete(uuid);
    }
}
