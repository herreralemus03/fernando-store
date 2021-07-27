package com.herreralemus.store.controllers;

import com.herreralemus.store.models.Orden;
import com.herreralemus.store.services.OrdenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "api/ordenes")
public class OrdenesController {

    @Autowired
    OrdenesService ordenesService;

    @GetMapping(path = "/")
    public Page<Orden> getAll(@RequestParam(required = false) Map<String, String> params){
        return ordenesService.getAll(params);
    }

    @PostMapping(path = "add")
    public Orden add(@RequestBody Orden orden){
        return ordenesService.add(orden);
    }

    @PostMapping(path = "update")
    public Orden update(@RequestBody Orden orden){
        return ordenesService.update(orden);
    }

    @GetMapping(path = "delete/{uuid}")
    public void delete(@PathVariable(value = "uuid") String uuid){
        ordenesService.delete(uuid);
    }
}