package edu.pingpong.examen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity(name = "t_users")
public class Usuaria extends PanacheEntityBase {
    @Id
    @Column(name = "user_nom")
    public String nombre;

    @Column(name = "user_prop")
    public int destreza;

    public Usuaria() {
    }

    public Usuaria(String nombre, int destreza) {
        this.nombre = nombre;
        this.destreza = destreza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDestreza() {
        return destreza;
    }

}
