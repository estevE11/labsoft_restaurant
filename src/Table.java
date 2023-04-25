public class Table {
    public static final int MAX_CAPACITY = 6;
    private int number;
    private int numClients;

    public Table(int number, int numClients) throws Exception {
        if(number > MAX_CAPACITY) throw new Exception("El Numero de clients maxim per taula es " + MAX_CAPACITY);
        this.number = number;
        this.numClients = numClients;
    }

    public int getNumber() {
        return this.number;
    }

    public int getNumClients() {
        return this.numClients;
    }
}
