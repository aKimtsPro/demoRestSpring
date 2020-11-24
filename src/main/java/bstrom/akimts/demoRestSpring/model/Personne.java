package bstrom.akimts.demoRestSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Personne {

    private String nom;
    private int age;

    @Override
    public String toString() {
        return "Personne:" +
                "\n\t- nom : " + this.getNom() +
                "\n\t- age : " + this.getAge();
    }
}
