package bstrom.akimts.demoRestSpring.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { DemoContrainteValidator.class })
public @interface DemoContrainteConstraint {

    String message() default "personne wrong";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
