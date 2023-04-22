public class Taula {
    public static final int MAX_CAPACITY = 6;
    private int n;
    private int nClients;

    public Taula (int n, int nClients) throws Exception {
        if(n > MAX_CAPACITY) throw new Exception("El Numero de clients maxim per tauo es " + MAX_CAPACITY);
        this.n = n;
        this.nClients = nClients;
    }

    public int getNumero() {
        return this.n;
    }

    public int getNClients() {
        return this.nClients;
    }
}
