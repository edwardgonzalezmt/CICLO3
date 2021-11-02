/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gimnasio.Servicios;

import Gimnasio.Modelo.Gimnasio;
import Gimnasio.Repositorio.GimnasioRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosGimnasio {
        @Autowired
    private GimnasioRepositorio metodosCrud;
    
    public List<Gimnasio> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Gimnasio> getGimnasio(int idGimnasio){
        return metodosCrud.getGimnasio(idGimnasio);
    }
    
    public Gimnasio save(Gimnasio gimnasio){
        if(gimnasio.getId()==null){
            return metodosCrud.save(gimnasio);
        }else{
            Optional<Gimnasio> evt=metodosCrud.getGimnasio(gimnasio.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(gimnasio);
            }else{
                return gimnasio;
            }
        }
    }
    public Gimnasio update(Gimnasio gimnasio){
        if(gimnasio.getId()!=null){
            Optional<Gimnasio> e=metodosCrud.getGimnasio(gimnasio.getId());
            if(!e.isEmpty()){
                if(gimnasio.getName()!=null){
                    e.get().setName(gimnasio.getName());
                }
                if(gimnasio.getBrand()!=null){
                    e.get().setBrand(gimnasio.getBrand());
                }
                if(gimnasio.getYear()!=null){
                    e.get().setYear(gimnasio.getYear());
                }
                if(gimnasio.getDescription()!=null){
                    e.get().setDescription(gimnasio.getDescription());
                }
                if(gimnasio.getCategory()!=null){
                    e.get().setCategory(gimnasio.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return gimnasio;
            }
        }else{
            return gimnasio;
        }
    }


    public boolean deleteGimnasio(int gimnasioId) {
        Boolean aBoolean = getGimnasio(gimnasioId).map(gimnasio -> {
            metodosCrud.delete(gimnasio);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
