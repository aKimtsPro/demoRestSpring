package annexe.builder;

public class DemoBuilder {

    public static void main(String[] args) {
        Pizza p = new PizzaBuilder()
                .setDiametre(15)
                .setName("vegetale")
                .build();

        // Grace au builder je peut prendre tout mon temps pour contruire mon Objet

        AbstractPizzaBuilder p2 = new Pizza.Builder()
                .setDiametre(15)
                .setPrice(15)
                .setName("cher");

        System.out.println("faire autre chose");

        p2.addIng("tomate")
                .addIng("fromage");

        System.out.println("faire encore autre chose");

        Pizza pBuilt = p2.addIng("oignon")
                .build();

    }
}
