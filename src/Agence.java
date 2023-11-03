import java.util.*;

public class Agence {
    public ListVoitures parking;
    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> clientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        vs = new ListVoitures();
        clientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        if (v == null) {
            throw new VoitureException("Voiture cannot be null");
        }
        vs.ajouterVoiture(v);
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        if (v == null) {
            throw new VoitureException("Voiture cannot be null");
        }
        vs.supprimerVoiture(v);
    }

    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (cl == null || v == null) {
            throw new VoitureException("Client and Voiture cannot be null");
        }
        ListVoitures listVoitures = clientVoitureLoue.get(cl);
        if (listVoitures == null) {
            listVoitures = new ListVoitures();
            clientVoitureLoue.put(cl, listVoitures);
        }
        listVoitures.ajouterVoiture(v);
    }

    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (cl == null || v == null) {
            throw new VoitureException("Client and Voiture cannot be null");
        }
        ListVoitures listVoitures = clientVoitureLoue.get(cl);
        if (listVoitures != null) {
            listVoitures.supprimerVoiture(v);
        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> resultats = new ArrayList<>();
        for (Voiture voiture : vs.getListeVoitures()) {
            if (c.estSatisfaitPar(voiture)) {
                resultats.add(voiture);
            }
        }
        return resultats;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return clientVoitureLoue.keySet();
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        return clientVoitureLoue.values();
    }

    public List<Voiture> afficheLesClientsEtLeursListesVoitures() {
        for (Map.Entry<Client, ListVoitures> entry : clientVoitureLoue.entrySet()) {
            System.out.println("Client: " + entry.getKey());
            System.out.println("Voitures louées: " + entry.getValue().getListeVoitures());
        }
        return null;
    }

    public Map<Client, ListVoitures> triCodeCroissant() {
        Map<Client, ListVoitures> sortedMap = new TreeMap<>(new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return Integer.compare(c1.getCode(), c2.getCode());
            }
        });
        sortedMap.putAll(clientVoitureLoue);
        return sortedMap;
    }

    public Map<Client, ListVoitures> triNomCroissant() {
        Map<Client, ListVoitures> sortedMap = new TreeMap<>(new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return c1.getNom().compareTo(c2.getNom());
            }
        });
        sortedMap.putAll(clientVoitureLoue);
        return sortedMap;
    }
}
