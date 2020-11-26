package bstrom.akimts.demoRestSpring.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VoitureNotFoundReport {

    private String message;
    private int index;
    private String methodUsed;
    private String forRequest;

    public VoitureNotFoundReport(int index, String methodUsed, String forRequest) {
        this.message = "La voiture n'a pas été trouvée à l'index : " + index;
        this.index = index;
        this.methodUsed = methodUsed;
        this.forRequest = forRequest;

    }
}
