package edu.pingpong.examen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="t_ordenes")
public class Orden extends PanacheEntityBase{
    
    @Id
    @Column(name="ord_id")
    public long id;


    @OneToOne
    @JoinColumn(name="ord_user")
    public Usuaria user;

    @OneToOne
    @JoinColumn(name="ord_item")
    public Item item;

    public Orden() {
    }

    public Orden(Usuaria user, Item item) {
        this.user = user;
        this.item = item;
    }

    public Usuaria getUser() {
        return user;
    }


    public Item getItem() {
        return item;
    }


    
}
