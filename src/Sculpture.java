import java.util.ArrayList;
import java.util.Scanner;

public class Sculpture extends ArtWork {
    private String artist;
    private String material;
    private double weight;

    public Sculpture(String name, String style, String artist, String material, double weight) {
        this.name = name;
        this.style = style;
        this.artist = artist;
        this.material = material;
        this.weight = weight;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double calculateCost() {
        double cost = 0;
        if (material.equals("Marble")) {
            cost = weight * 15;
        } else if (material.equals("Bronze")) {
            cost = weight * 180;
        }
        return cost;
    }

    @Override
    public boolean isTradeable() {
        if (style.equals("Baroque")) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void tradeToBuyer(Buyer buyer, Seller seller,ArtWork artWork) {
        double cost = calculateCost();
        if ((isTradeable()) && (buyer.getBalance() > cost)) {
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
            else if(input==1) {
                return compareName(artWork1);
            }
            else if(input==2){
                return compareStyle(artWork1);
            }
            else if(input==3){
                return compareArtist(artWork1);
            }
            else if(input==4){
                return compareMaterial(artWork1);
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
        Sculpture sculpture =(Sculpture) artWork1;
        String string1 = this.artist;
        String string2 = sculpture.artist;
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
    private int compareMaterial (ArtWork artWork1){
        Sculpture sculpture = (Sculpture) artWork1;
        String string1 = this.material;
        String string2 = sculpture.getMaterial();
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
    public ArrayList search(ArrayList arrayList,String str){
        ArrayList<Sculpture> arrayList1 = new ArrayList<>(arrayList);
        ArrayList<Sculpture> sculpture = new ArrayList();
        for(int i=0;i<arrayList1.size();i++){
            if(arrayList1.get(i).getName().equals(str) || (arrayList1.get(i).getStyle()).equals(str) || (arrayList1.get(i).getArtist().equals(str)) ){
                sculpture.add(arrayList1.get(i));
            }
        }
        return sculpture;
    }
    private String secondQuestionInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the keyword:");
        String scanned = scan.next();
        return scanned;
    }
}


























































































































