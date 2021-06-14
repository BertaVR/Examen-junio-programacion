package edu.pingpong.examen;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public List <Orden> cargaOrden(String name){
        Optional<Usuaria> persona = Usuaria.find("nombre", name).firstResultOptional();
        if (persona.isPresent()) {
            Usuaria usuaria = persona.get();
         return Orden.list("user", usuaria);}

         else {
            return  new ArrayList<Orden>();

        }
    }
}



