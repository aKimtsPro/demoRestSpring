package bstrom.akimts.demoRestSpring.constraints;

import bstrom.akimts.demoRestSpring.model.DemoContrainte;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DemoContrainteValidator implements ConstraintValidator<DemoContrainteConstraint, DemoContrainte> {

    @Override
    public boolean isValid(DemoContrainte test, ConstraintValidatorContext context) {
        // enleve le message par défaut
        context.disableDefaultConstraintViolation();
        // ajoute des violations de contraintes
        context.buildConstraintViolationWithTemplate("{ error 1 }").addConstraintViolation();
        context.buildConstraintViolationWithTemplate("{ error 2 }").addConstraintViolation();
        // retourne le resultat de la validation
        return false;
    }
}
