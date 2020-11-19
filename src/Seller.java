import java.util.ArrayList;

public class Seller {
    private double Balance = 0;
    private ArrayList<ArtWork> privateCollections;

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