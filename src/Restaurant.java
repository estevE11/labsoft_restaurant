import java.util.LinkedList;

public class Restaurant {
    public static final int MAX_CAPACITY = 24;
    private String name;
    private int nClients;

    private LinkedList<Taula> taules = new LinkedList<Taula>();

    public Restaurant(String name) {
        this.name = name;
    }

    public void addTaula(int nClients) throws Exception {
        if(!this.checkCapacity(nClients)) throw new Exception("Aquesta quantitat supera la capacitat maxima!");
        taules.add(new Taula(taules.size()+1, nClients));
        this.nClients += nClients;
    }

    public void printTaules() {
        System.out.println("");
        System.out.println("Taules: ");
        for(Taula t : this.taules) {
            System.out.println("Taula " + t.getNumero() + ": " + t.getNClients() + " persones");
        }
    }

    private boolean checkCapacity(int n) {
        return this.nClients + n <= MAX_CAPACITY;
    }

    public int getFreeSpace() {
        return MAX_CAPACITY - this.nClients;
    }
}
