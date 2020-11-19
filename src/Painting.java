import java.util.ArrayList;
import java.util.Scanner;

public class Painting extends ArtWork {
    private String artist;
    private double dimension1;
    private double dimension2;

    public Painting(String name, String style, String artist, double dimension1, double dimension2) {
        this.name = name;
        this.style = style;
        this.artist = artist;
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getDimension1() {
        return dimension1;
    }

    public void setDimension1(double dimension1) {
        this.dimension1 = dimension1;
    }

    public double getDimension2() {
        return dimension2;
    }

    public void setDimension2(double dimension2) {
        this.dimension2 = dimension2;
    }

    @Override
    public double calculateCost() {
        double cost;
        double square = dimension1 * dimension2;
        if (style.equals("Renaissance")) {
            cost = square * 7;
        } else if (style.equals("Baroque")) {
            cost = square * 5.5;
        } else {
            cost = square * 4.5;
        }
        return cost;
    }

    @Override
    public boolean isTradeable() {
        if (style.equals("Gothic")) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void tradeToBuyer(Buyer buyer, Seller seller,ArtWork artWork) {
        double cost = calculateCost();
        if ((isTradeable() == true) && (buyer.getBalance() > cost)) {
            double transferAmount = buyer.getBalance() - cost;
            buyer.setBalance(transferAmount);
            double sellerMoney = cost + seller.getBalance();
            seller.setBalance(sellerMoney);
            seller.getPrivateCollections().remove(artWork);
            buyer.getPrivateCollections().add(artWork);
        }
        else{
            System.out.println("We could not do this transfer");
        }
    }
    public int compareTo(Object artWork,int input) {
        if(isArtwork(artWork)){
            ArtWork artWork1 = (ArtWork) artWork;
            if (input==0){
                return -99;
            }
            if(input==1) {
                return compareName(artWork1);
            }
            if(input==2){
                return compareStyle(artWork1);
            }
            if(input==3){
                return compareArtist(artWork1);
            }
        }
        return 0;
    }
    private int compareName(ArtWork artWork1){

        String string1 = this.name;
        String string2 = artWork1.getName();
        if (string1.equals(string2)){
            return 0;
        }
        char[] firstchar = string1.toCharArray();
        char[] secondchar = string2.toCharArray();
        boolean check = true;
        int i = 0;
        while (check) {
            if (firstchar[i] < secondchar[i]) {
                return 1;
            } else if (firstchar[i] > secondchar[i]) {
                return -1;
            } else {
                i++;
            }
        }
        return 0;
    }
    private int compareArtist(ArtWork artWork1){
        Painting painting =(Painting) artWork1;
        String string1 = this.artist;
        String string2 = painting.artist;
        if (string1.equals(string2)){
            return 0;
        }
        char[] firstchar = string1.toCharArray();
        char[] secondchar = string2.toCharArray();
        boolean check = true;
        int i = 0;
        while (check) {
            if (firstchar[i] < secondchar[i]) {
                return 1;
            } else if (firstchar[i] > secondchar[i]) {
                return -1;
            } else {
                i++;
            }
        }
        return 0;

    }
    private int compareStyle (ArtWork artWork1){
        String string1 = this.style;
        String string2 = artWork1.getStyle();
        if (string1.equals(string2)){
            return 0;
        }
        char[] firstchar = string1.toCharArray();
        char[] secondchar = string2.toCharArray();
        boolean check = true;
        int i = 0;
        while (check) {
            if (firstchar[i] < secondchar[i]) {
                return 1;
            } else if (firstchar[i] > secondchar[i]) {
                return -1;
            } else {
                i++;
            }
        }
        return 0;
    }

    public boolean isArtwork(Object name){
        if(name == null ){
            return false;
        }else if (!(name instanceof ArtWork)){
            return false;
        }else{
            return true;
        }
    }
    public ArrayList sort(ArrayList stringArrayList1,int input){
        ArrayList<ArtWork> stringArrayList= new ArrayList<>(stringArrayList1);
        String twp=null;
        ArtWork art = null;
        for(int i=0;i<stringArrayList.size();i++){
            for(int j=i+1;j<stringArrayList.size();j++){
                int compare =stringArrayList.get(i).compareTo(stringArrayList.get(j),input);
                if (compare==-99){
                    break;
                }
                if(stringArrayList.get(i).compareTo(stringArrayList.get(j),input)<0){
                    art=stringArrayList.get(i);
                    stringArrayList.set(i,stringArrayList.get(j));
                    stringArrayList.set(j,art);
                }
            }
        }
        return stringArrayList;
    }
    private String secondQuestionInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the keyword:");
        String scanned = scan.next();
        return scanned;
    }
    public ArrayList search(ArrayList arrayList,String str){
        ArrayList<Painting> arrayList1 = new ArrayList<>(arrayList);
        ArrayList<Painting> painting = new ArrayList();
        for(int i=0;i<arrayList.size();i++){
            if(arrayList1.get(i).getName().equals(str) || (arrayList1.get(i).getStyle()).equals(str) || (arrayList1.get(i).getArtist().equals(str)) ){
                painting.add(arrayList1.get(i));
            }
        }
        return painting;
    }
}
