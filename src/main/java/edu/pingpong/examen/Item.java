package edu.pingpong.examen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="t_items")
public class Item extends PanacheEntityBase{
    @Id
    @Column(name="item_nom")
    public String nombre;

    @Column(name="item_prop")
    public int quality;

    @Column(name="item_tipo")
    public String tipo;

    

    public Item() {
    }


    public Item(String nombre, int quality, String tipo) {
        this.nombre = nombre;
        this.quality = quality;
        this.tipo = tipo;
    }


    public String getNombre() {
        return nombre;
    }

 
    public int getQuality() {
        return quality;
    }



    public String getTipo() {
        return tipo;
    }



    
}
