package br.com.bepupa.locadora.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bepupa.locadora.entity.Titulo;
import br.com.bepupa.locadora.repository.TituloRepository;

@RestController
public class TituloController {
    @Autowired
    private TituloRepository _tituloRepository;

    @RequestMapping(value = "/titulo", method = RequestMethod.GET)
    public List<Titulo> Get() {
        return _tituloRepository.findAll();
    }

    @RequestMapping(value = "/titulo/{id}", method = RequestMethod.GET)
    public ResponseEntity<Titulo> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Titulo> titulo = _tituloRepository.findById(id);
        if(titulo.isPresent())
            return new ResponseEntity<Titulo>(titulo.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/titulo", method =  RequestMethod.POST)
    public Titulo Post(@RequestBody Titulo titulo)
    {
        return _tituloRepository.save(titulo);
    }

    @RequestMapping(value = "/titulo/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Titulo> Put(@PathVariable(value = "id") long id, @RequestBody Titulo newTitulo)
    {
        Optional<Titulo> oldTitulo = _tituloRepository.findById(id);
        if(oldTitulo.isPresent()){
            Titulo titulo = oldTitulo.get();
            titulo.setNome(newTitulo.getNome());
            _tituloRepository.save(titulo);
            return new ResponseEntity<Titulo>(titulo, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/titulo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Titulo> titulo = _tituloRepository.findById(id);
        if(titulo.isPresent()){
            _tituloRepository.delete(titulo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}