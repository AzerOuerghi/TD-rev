public class Main {
    public static void main(String[] args) {
        Agence agence = new Agence("My Car Rental Agency");

        // Create some Voitures
        Voiture voiture1 = new Voiture(1, "Toyota", 50.0f);
        Voiture voiture2 = new Voiture(2, "Honda", 60.0f);

        // Create some Clients
        Client client1 = new Client(101, "John", "Doe");
        Client client2 = new Client(102, "Alice", "Smith");

        try {
            // Add Voitures to the parking lot
            agence.ajoutVoiture(voiture1);
            agence.ajoutVoiture(voiture2);

            // Rent Voitures to Clients
            agence.loueClientVoiture(client1, voiture1);
            agence.loueClientVoiture(client2, voiture2);

            // Display Clients and their rented Voitures
            agence.afficheLesClientsEtLeursListesVoitures();
        } catch (VoitureException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }
}
