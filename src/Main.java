import java.util.Scanner;

public class Main {
    private Restaurant restaurant;

    public Main() {
        this.menuCreateRestaurant();
        this.mainMenu();
    }

    private void mainMenu() {
        int val = -1;
        do {
            System.out.println("Menu principal: ");
            System.out.println("1) Afegir taula");
            System.out.println("2) Retirar taula");
            System.out.println("0) Sortir");
        } while(false);
    }

    private void processInput(int i) {
        switch(i) {
            case 1:
                this.menuAddTaula();
            case 2:
                System.out.println("WIP");
        }
    }

    private void menuCreateRestaurant() {
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserta el numero de clients nous (espai lliure: " + this.restaurant.getFreeSpace() + "): ");
        int n = sc.nextInt();
        try {
            this.restaurant.addTaula(n);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}
