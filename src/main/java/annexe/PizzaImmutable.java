package annexe;

import java.util.ArrayList;
import java.util.List;

public final class PizzaImmutable { // empecher l'héritage

    // rendre tous les champs constants
    private final int diametre;
    private final double price;
    private final String name; // n'utiliser que des objets immutables
    // private final ArrayList<String> ingredients;
    // ATTENTION il est préférable de s'assurer qu'on n'utilise que des objets immutable

    public PizzaImmutable(int diametre, double price, String name/*, ArrayList<String> list*/) {
        this.diametre = diametre;
        this.price = price;
        this.name = name;
        // this.ingredients = list;
    }

    public int getDiametre() {
        return diametre;
    }

//    public List<String> getIngredients() {
//        return (List<String>) ingredients.clone();
//    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
