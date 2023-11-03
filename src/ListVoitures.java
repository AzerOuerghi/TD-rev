import java.util.ArrayList;
import java.util.List;

public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures() {
        voitures = new ArrayList<>();
    }
    public List<Voiture> getVoitures() {
        return voitures;
    }


    public void ajouterVoiture(Voiture voiture) {
        voitures.add(voiture);
    }

    public void supprimerVoiture(Voiture voiture) {
        voitures.remove(voiture);
    }

    public List<Voiture> getListeVoitures() {
        return voitures;
    }
}
