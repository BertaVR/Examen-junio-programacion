package edu.pingpong.examen;

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

}



