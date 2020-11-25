package bstrom.akimts.demoRestSpring.constraints;


import bstrom.akimts.demoRestSpring.model.Voiture;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VoitureValidator implements ConstraintValidator<VoitureConstraint, Voiture> {
    @Override
    public boolean isValid(Voiture voiture, ConstraintValidatorContext context) {

        if(voiture.getNbrPorte() == 3 && voiture.getPuissanceMoteur() < 60){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("pour une voiture à 3 porte, la puissance minimum est de 60")
                .addConstraintViolation();
            return false;
        }

        if(voiture.getNbrPorte() == 5 && voiture.getPuissanceMoteur() < 80){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("pour une voiture à 5 porte, la puissance minimum est de 80")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
