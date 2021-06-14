package edu.pingpong.examen;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
public class ServiceOlli {

    @Transactional
    public Usuaria cargaUsuaria(String name){
        Optional<Usuaria> persona = Usuaria.find("nombre", name).firstResultOptional();
        if (persona.isPresent()) {
           Usuaria usuaria = persona.get();
           return usuaria;

        } else {
            Usuaria usuaria = new Usuaria("", 0);
            usuaria.persist();
            usuaria.delete();
            return usuaria;

        }
    }

    @Transactional
    public Item cargaItem(String name){
        Optional<Item> objeto = Item.find("nombre", name).firstResultOptional();
        if (objeto.isPresent()) {
           Item item = objeto.get();
           return item;

        } else {
            Item item = new Item("", 0, "");
            item.persist();
            return item;

        }
        
    }

    public List <Orden> cargaOrden(String name){
        List<Orden> listaordnees = Orden.listAll();

        return listaordnees.stream().filter(e->e.user.nombre.equals(name)).collect(Collectors.toList());
    }

    public Orden comanda(String nombre_usuaria, String nombre_item){
        Optional<Usuaria> persona = Usuaria.findByIdOptional( nombre_usuaria);

        Optional<Item> objeto = Item.findByIdOptional(nombre_item);

        if(persona.isPresent() && objeto.isPresent()){
            Orden orden = new Orden (persona.get(), objeto.get());
            orden.persist(); 
            return orden;
            }
        else{
            return null;
        }

    }
}



