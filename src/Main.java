import java.util.List;

public class Main {

    public static void main(String[] args) {


        // Create an instance of your car rental agency
        Agence agence = new Agence("My Rental Agency");

        // Create some cars and clients
        Voiture voiture1 = new Voiture(1, "Toyota", 50.0f);
        Voiture voiture2 = new Voiture(2, "Honda", 60.0f);
        Client client1 = new Client(101, "John", "Doe");
        Client client2 = new Client(102, "Alice", "Smith");

        // Add cars to the parking lot
        agence.parking.ajouterVoiture(voiture1);
        agence.parking.ajouterVoiture(voiture2);

        // Rent a car to a client
        agence.louerVoiture(client2, voiture1);

        // Return a car
        agence.retournerVoiture(client1, voiture1);

        // Get a list of cars based on criteria (e.g., by brand)
        Critere critereMarque = new CritereMarque("Toyota");
        List<Voiture> carsByBrand = agence.getVoitures(critereMarque);

        // Display the cars in the parking lot
        List<Voiture> carsInParking = agence.parking.getVoitures();
        System.out.println("Cars in Parking:");
        for (Voiture car : carsInParking) {
            System.out.println(car);
        }

        // Display the clients
        List<Client> clients = agence.getClients();
        System.out.println("Clients:");
        for (Client client : clients) {
            System.out.println(client);
        }

        // Display the cars currently in rental
        List<Voiture> carsInRental = agence.getVoituresActuellementEnLocation();
        System.out.println("Cars in Rental:");
        for (Voiture car : carsInRental) {
            System.out.println(car);
        }
    }
}
