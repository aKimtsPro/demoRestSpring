package annexe.builder;

import java.util.ArrayList;

public class PizzaBuilder extends AbstractPizzaBuilder {

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
