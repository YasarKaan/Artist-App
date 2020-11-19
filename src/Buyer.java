import java.util.ArrayList;

public class Buyer {
    private double Balance=5000000;
    private ArrayList<ArtWork> privateCollections = new ArrayList<ArtWork>();

    public ArrayList<ArtWork> getPrivateCollections() {
        return privateCollections;
    }

    public void setPrivateCollections(ArrayList privateCollections) {
        this.privateCollections = privateCollections;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }
}