import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agence {
    private String nom;
    public ListVoitures parking;
    private Map<Client, ListVoitures> clientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        parking = new ListVoitures();
        clientVoitureLoue = new HashMap<>();
    }

    public void louerVoiture(Client client, Voiture voiture) {
        parking.supprimerVoiture(voiture);
        ListVoitures listVoitures = clientVoitureLoue.get(client);
        if (listVoitures == null) {
            listVoitures = new ListVoitures();
            clientVoitureLoue.put(client, listVoitures);
        }
        listVoitures.ajouterVoiture(voiture);
    }

    public void retournerVoiture(Client client, Voiture voiture) {
        ListVoitures listVoitures = clientVoitureLoue.get(client);
        if (listVoitures != null) {
            listVoitures.supprimerVoiture(voiture);
            parking.ajouterVoiture(voiture);
        }
    }

    public List<Voiture> getVoitures(Critere critere) {
        List<Voiture> resultats = new ArrayList<>();
        for (Voiture voiture : parking.getVoitures()) {
            if (critere.estSatisfaitPar(voiture)) {
                resultats.add(voiture);
            }
        }
        return resultats;
    }

    public List<Client> getClients() {
        return new ArrayList<>(clientVoitureLoue.keySet());
    }
    public ListVoitures getParking() {
        return parking;
    }

    public List<Voiture> getVoituresActuellementEnLocation() {
        List<Voiture> resultats = new ArrayList<>();
        for (ListVoitures listVoitures : clientVoitureLoue.values()) {
            resultats.addAll(listVoitures.getVoitures());
        }
        return resultats;
    }
}