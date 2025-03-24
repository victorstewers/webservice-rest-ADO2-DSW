package br.senac.tads.dsw.webservice_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/dados")
public class DadosRestController {
    
    @Autowired
    private DadosService service;


    @GetMapping
    public String findAll() {
    return service.findAll();

    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Integer id) {
    return service.findById(id);
    }
}