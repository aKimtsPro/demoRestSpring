package bstrom.akimts.demoRestSpring.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint( validatedBy = NbrPorteValidator.class )
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NbrPorteConstraint {

    String message() default "{ Nombre de porte devrait être 3 ou 5 et pas null }";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
