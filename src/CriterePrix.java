public class CriterePrix implements Critere {
    private float prixMax;

    public CriterePrix(float prixMax) {
        this.prixMax = prixMax;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        return v.getPrixLocation() <= prixMax;
    }
}
