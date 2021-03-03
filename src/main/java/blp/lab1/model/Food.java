package blp.lab1.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "orderedFood")
    Set<Order> ordered;

    @ManyToMany(mappedBy = "havingFood")
    Set<Restaurant> having;

    public Food setName(String name) {
        this.name = name;
        return this;
    }
}
