import java.util.LinkedList;

public class Restaurant {
    public static final int MAX_CAPACITY = 24;
    public static final int MAX_TABLES = 4;
    private String name;
    private LinkedList<Table> tables = new LinkedList<Table>();

    public Restaurant(String name) {
        this.name = name;
    }

    public void addTaula(int numClients) throws Exception {
        if(!this.checkCapacity(numClients)) throw new Exception("Aquesta quantitat supera la capacitat maxima!");

        // Calculem les taules necessaries per afegir tots els clients
        int tablesToAdd = (int)Math.ceil(numClients/Table.MAX_CAPACITY);

        // Afegim totes les taules plenes menys la ultima
        for(int i = 0; i < tablesToAdd-1; i++) {
            this.tables.add(new Table(this.getNextNum(), Table.MAX_CAPACITY));
        }

        // Calculem els clients que falten per posar i afegim la ultima taula
        int numClientsLastTable = numClients - Table.MAX_CAPACITY*(tablesToAdd-1);
        this.tables.add(new Table(this.getNextNum(), numClientsLastTable));
    }

    public void removeTaula(int n) throws Exception {
        for(Table t : this.tables) {
            if(t.getNumber() == n) {
                this.tables.remove(t);
                return;
            }
        }
        throw new Exception("La taula no existeix!");
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for(Table t : this.tables) {
            res.append("Taula ").append(t.getNumber()).append(": ").append(t.getNumClients()).append(" persones\n");
        }
        return res.toString();
    }

    private boolean checkCapacity(int n) {
        int taules = (int) Math.ceil((double)n/ Table.MAX_CAPACITY);
        return this.tables.size()+taules <= MAX_TABLES;
    }

    public int getFreeSpace() {
        return MAX_CAPACITY - this.getNumClients();
    }

    public int getNumClients() {
        int count = 0;
        for(Table t : tables) {
            count++;
        }
        return count;
    }

    public int getNextNum() {
        return this.tables.stream().max((t1, t2) -> t2.getNumber() - t1.getNumber()).get().getNumber()+1;
    }
}
