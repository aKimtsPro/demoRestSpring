package bstrom.akimts.demoRestSpring.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint( validatedBy = VoitureValidator.class )
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface VoitureConstraint {

    String message() default "si nbrPorte = 3, puiss min = 60; si nbrPorte = 5, puiss min 80";

    Class<?>[] groups() default {}; // groupSequence

    Class<? extends Payload>[] payload() default {}; // categorisation

}
