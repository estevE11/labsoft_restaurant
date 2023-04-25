import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private Restaurant restaurant;

    public Main() {
        this.menuCreateRestaurant();
        this.mainMenu();
    }

    private void mainMenu() {
        int in;
        do {
            System.out.println("Menu principal: ");
            System.out.println("1) Afegir taula");
            System.out.println("2) Retirar taula");
            System.out.println("0) Sortir");
            in = sc.nextInt();
            this.processInput(in);
        } while(in != 0);
    }

    private void processInput(int i) {
        switch (i) {
            case 1 -> this.menuAddTaula();
            case 2 -> this.menuRemoveTaula();
        }
    }

    private void menuCreateRestaurant() {
        String name = "";
        while(!verifyRestaurantName(name)) {
            System.out.print("Nom del restaurant: ");
            name = sc.next();
        }
        this.restaurant = new Restaurant(name);
    }

    private boolean verifyRestaurantName(String name) {
        return name.length() != 0;
    }

    private void menuAddTaula() {
        System.out.print("Inserta el numero de clients nous (espai lliure: " + this.restaurant.getFreeSpace() + "): ");
        int n = sc.nextInt();
        try {
            this.restaurant.addTaula(n);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(this.restaurant.toString());
    }

    private void menuRemoveTaula() {
        System.out.println("Escull la taula que marxa:");
        System.out.println(this.restaurant.toString());
        System.out.println("Num de taula: ");
        int n = sc.nextInt();
        try {
            this.restaurant.removeTaula(n);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}
