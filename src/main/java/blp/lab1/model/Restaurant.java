package blp.lab1.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Data
@Entity
public class Restaurant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "having_food_food",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id"))
    private Set<Food> havingFood;

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders;

    public Restaurant setName(String name) {
        this.name = name;
        return this;
    }

    public Restaurant setHavingFood(Set<Food> havingFood) {
        this.havingFood = havingFood;
        return this;
    }
}
