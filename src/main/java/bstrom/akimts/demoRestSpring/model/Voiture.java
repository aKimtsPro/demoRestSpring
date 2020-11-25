package bstrom.akimts.demoRestSpring.model;

import bstrom.akimts.demoRestSpring.constraints.NbrPorteConstraint;
import bstrom.akimts.demoRestSpring.constraints.VoitureConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor
@VoitureConstraint
public class Voiture { // contrainte custom : si nbrPorte = 3, puiss min = 60; si nbrPorte = 5, puiss min 80

    @NotBlank
    private String model;
    @NotNull
    private Integer puissanceMoteur;
    @NotBlank
    private String couleur;
    @NbrPorteConstraint // validation custom : verif 3 ou 5 portes et non null
    private Integer nbrPorte;

    @Override
    public String toString() {
        return "Voiture : " +
                "\n\t- modele :" + getModel() +
                "\n\t- puissance :" + getPuissanceMoteur() +
                "\n\t- couleur :" + getCouleur() +
                "\n\t- nombre de porte :" + getNbrPorte();
    }
}
