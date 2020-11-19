import java.util.ArrayList;
import java.util.Scanner;

public class Architecture extends ArtWork {
    double dimension1;
    double dimension2;
    double dimension3;
    String[] architect;
    public Architecture(String name,String style,double dimension1,double dimension2,double dimension3,String... architectures){
        this.name = name;
        this.style = style;
        this.dimension1= dimension1;
        this.dimension2 = dimension2;
        this.dimension3 = dimension3;
        this.architect = architectures;
    }

    public Architecture() {

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

    public double getDimension3() {
        return dimension3;
    }

    public void setDimension3(double dimension3) {
        this.dimension3 = dimension3;
    }

    public String[] getArchitect() {
        return architect;
    }

    public void setArchitect(String[] architect) {
        this.architect = architect;
    }

    @Override
    public double calculateCost() {
        double cost;
        double cube = dimension1*dimension2*dimension3;
        if (style.equals("Gothic")){
            cost = cube * 1;
        }
        else if(style.equals("Baroque")){
            cost = cube *0.8;
        }
        else{
            cost = cube*0.6;
        }
        return cost;
    }

    @Override
    public boolean isTradeable() {
        if(style.equals("Renaissance")){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void tradeToBuyer(Buyer buyer,Seller seller,ArtWork artWork) {
        double cost=calculateCost();
        if((isTradeable())&&(buyer.getBalance()>cost)){
            double transferAmount = buyer.getBalance()-cost;
            buyer.setBalance(transferAmount);
            double sellerMoney=cost+seller.getBalance();
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
        ArrayList<Architecture> arrayList1 = new ArrayList<>(arrayList);
        ArrayList<Architecture> architectures = new ArrayList();
        for(int i=0;i<arrayList.size();i++) {
            if ((arrayList1.get(i).getName().equals(str)) || ((arrayList1.get(i).getStyle()).equals(str))) {
                architectures.add(arrayList1.get(i));}
            for (int j = 0; j < arrayList1.get(i).getArchitect().length; j++) {
                    if (arrayList1.get(i).getArchitect()[j].equals(str)) {
                        architectures.add(arrayList1.get(i));
                    }
                }
            }

        return architectures;
    }
}

