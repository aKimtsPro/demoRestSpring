package bstrom.akimts.demoRestSpring.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class NbrPorteValidator implements ConstraintValidator<NbrPorteConstraint, Integer> {

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext context) {
        if( integer == null ){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("le nombre de porte ne devrait pas être null")
                    .addConstraintViolation();
            return false;
        }


        if(  integer != 3 && integer != 5 ){
            // desactive la violation contrainte de base
            context.disableDefaultConstraintViolation();
            // ajouter des violation de contrainte :
            context.buildConstraintViolationWithTemplate("Le nombre de porte ne peut pas être différent de 3 ou de 5")
                    .addConstraintViolation();
            // retourn le resultat de la validation
            return false;
        }

        return true;
    }

}
