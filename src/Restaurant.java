import java.util.LinkedList;

public class Restaurant {
    public static final int MAX_CAPACITY = 24;
    public static final int MAX_TAULES = 4;
    private String name;
    private int nClients;

    private LinkedList<Taula> taules = new LinkedList<Taula>();

    public Restaurant(String name) {
        this.name = name;
    }

    public void addTaula(int nClients) throws Exception {
        if(!this.checkCapacity(nClients)) throw new Exception("Aquesta quantitat supera la capacitat maxima!");
        int taules = (int) Math.ceil((double)nClients/Taula.MAX_CAPACITY);
        for(int i = 0; i < taules-1; i++) {
            this.taules.add(new Taula(this.taules.size(), Taula.MAX_CAPACITY));
        }
        this.taules.add(new Taula(this.taules.size(), nClients - Taula.MAX_CAPACITY*(taules-1)));
        this.nClients += nClients;
    }

    public void removeTaula(int n) throws Exception {
        for(Taula t : this.taules) {
            if(t.getNumero() == n) {
                this.taules.remove(t);
                this.nClients -= t.getNClients();
                return;
            }
        }
        throw new Exception("La taula no existeix!");
    }

    public void printTaules() {
        System.out.println("");
        System.out.println("Taules: ");
        for(Taula t : this.taules) {
            System.out.println("Taula " + t.getNumero() + ": " + t.getNClients() + " persones");
        }
    }

    private boolean checkCapacity(int n) {
        int taules = (int) Math.ceil((double)n/Taula.MAX_CAPACITY);
        return this.taules.size()+taules <= MAX_TAULES;
    }

    public int getFreeSpace() {
        return MAX_CAPACITY - this.nClients;
    }
}
