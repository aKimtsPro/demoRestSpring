package annexe.builder;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPizzaBuilder {

    private int diametre = 10;
    private List<String> ingredients = new ArrayList<>();
    private double price = 10;
    private String name = "-";

    private boolean built = false;

    public int getDiametre() {
        return diametre;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isBuilt() {
        return built;
    }

    public void setBuilt(boolean built) {
        this.built = built;
    }

    public AbstractPizzaBuilder setDiametre(int diametre) {
        if(built)
            throw new RuntimeException("pizza already built");

        this.diametre = diametre;
        return this;
    }

    public AbstractPizzaBuilder setName(String name) {
        if(built)
            throw new RuntimeException("pizza already built");

        this.name = name;
        return this;
    }

    public AbstractPizzaBuilder setPrice(double price) {
        if(built)
            throw new RuntimeException("pizza already built");

        this.price = price;
        return this;
    }

    public AbstractPizzaBuilder addIng(String ing){
        if(built)
            throw new RuntimeException("pizza already built");

        this.ingredients.add(ing);
        return this;
    }

    public abstract Pizza build();
}
