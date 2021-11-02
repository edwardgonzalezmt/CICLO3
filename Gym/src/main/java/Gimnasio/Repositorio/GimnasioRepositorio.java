/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gimnasio.Repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Gimnasio.Modelo.Gimnasio;
import Gimnasio.Interface.InterfaceGimnasio;

/**
 *
 * @author USUARIO
 */
@Repository
public class GimnasioRepositorio {
      @Autowired
    private InterfaceGimnasio crud;
    

    public List<Gimnasio> getAll(){
        return (List<Gimnasio>) crud.findAll();       
    }
    
    public Optional <Gimnasio> getGimnasio(int id){
        return crud.findById(id);
    }
    
    public Gimnasio save(Gimnasio gimnasio){
        return crud.save(gimnasio);
    }
     public void delete(Gimnasio gimnasio){
        crud.delete(gimnasio);
    }
    
}
