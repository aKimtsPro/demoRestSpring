package bstrom.akimts.demoRestSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
public class Personne {

    @NotEmpty // @NotBlank
    @Size(min = 2, max = 20)
    private String nom;
    @Max(120) // @Min(0)
    @PositiveOrZero // @Positive // @Negative // @NegativeOrZero
    private int age;
//    @AssertFalse //@AssertTrue
//    private boolean isTall;
//    @NotNull
//    @Past // @PastOrPresent // @Future // @FutureOrPresent
//    private LocalDate dateNaiss;
//    // @Pattern("regex")
//    @Email
//    private String email;


    @Override
    public String toString() {
        return "Personne:" +
                "\n\t- nom : " + this.getNom() +
                "\n\t- age : " + this.getAge();
    }
}
