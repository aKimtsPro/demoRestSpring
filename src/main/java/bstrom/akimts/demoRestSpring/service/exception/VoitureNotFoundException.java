package bstrom.akimts.demoRestSpring.service.exception;

public final class VoitureNotFoundException extends RuntimeException {

    public final int index;

    public VoitureNotFoundException(int index) {
        super("Aucune voiture n'a été trouvé à l'index : " + index);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
