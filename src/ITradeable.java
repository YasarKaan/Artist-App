public interface ITradeable {
    boolean isTradeable();
    void tradeToBuyer(Buyer buyer, Seller seller,ArtWork artWork);
}
