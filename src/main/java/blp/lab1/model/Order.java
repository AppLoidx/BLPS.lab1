package blp.lab1.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data //посмотреть что с сеттарами
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean paid;

    @ManyToOne
    private User user;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToMany
    @JoinTable(
            name = "ordered_food_food",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id"))
    Set<Food> orderedFood;

    public Order setPaid (Boolean paid) {
        this.paid = paid;
        return this;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public Order setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
        return this;
    }

    public Order setOrderedFood(Set<Food> orderedFood){
        this.orderedFood = orderedFood;
        return this;
    }
}
