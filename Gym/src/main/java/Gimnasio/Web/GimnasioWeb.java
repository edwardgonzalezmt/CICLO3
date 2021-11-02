/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gimnasio.Web;

import Gimnasio.Modelo.Gimnasio;
import Gimnasio.Servicios.ServiciosGimnasio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class GimnasioWeb {
     @GetMapping("/holaMundo")
    public String saluda(){
    return "Hola Mundo";
    }

    @Autowired
    private ServiciosGimnasio servicio;
    @GetMapping("/all")
    public List <Gimnasio> getGimnasio(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Gimnasio> getOrthesis(@PathVariable("id") int idGimnasio) {
        return servicio.getGimnasio(idGimnasio);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gimnasio save(@RequestBody Gimnasio gimnasio) {
        return servicio.save(gimnasio);
    }
    
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gimnasio update(@RequestBody Gimnasio gimnasio) {
        return servicio.update(gimnasio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int gimnasioId) {
        return servicio.deleteGimnasio(gimnasioId);
    }
}
