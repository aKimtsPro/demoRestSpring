package annexe.builder;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Pizza {

    private int diametre;
    private List<String> ingredients; // tab for immutable
    private double price;
    private String name;

    public Pizza() {
    }

    private Pizza(int diametre, double price, String name) {
        this.diametre = diametre;
        this.price = price;
        this.name = name;
    }

    // 16 constructeurs différents pour prendre en compte la presence/absence de spec des
    // différents champs !

    public static class Builder extends AbstractPizzaBuilder { // pas le choix si le constructeur est en private

        @Override
        public Pizza build(){
            if(isBuilt())
                throw new RuntimeException("pizza already built");

            Pizza pizza = new Pizza();
            pizza.setDiametre(getDiametre());
            pizza.setName(getName());
            pizza.setPrice(getPrice());
            pizza.setIngredients(new ArrayList<>());

            for (String ingredient : getIngredients()) {
                pizza.getIngredients().add(ingredient);
            }

            setBuilt( true );

            return pizza;
        }

    }
}
