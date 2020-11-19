import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileIO.read();
        int input = -1;
        while (input != 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("1) Print the lists");
            System.out.println("2) Search the vault");
            System.out.println("3) Trade");
            System.out.println("0) Exit");
            input = scan.nextInt();
            if (input == 0) {
                System.out.println("Have a good day!");
                break;
            }
            if (input == 1) {
                System.out.println("Please choose the list:");
                System.out.println("1) Print the list of artists");
                System.out.println("2) Print the list of architects");
                System.out.println("3) Print the list of paintings");
                System.out.println("4) Print the list of sculptures");
                System.out.println("5) Print the list of architectures");
                System.out.println("0) Exit");
                int input2 = scan.nextInt();
                if (input2 == 0) {
                    break;
                }
                if (input2 == 1) {
                    ArrayList<Artist> artistArrayList = FileIO.artists;
                    System.out.println("Please choose the sorting method");
                    System.out.println("1) Sort by name");
                    System.out.println("2) Sort by birthday");
                    System.out.println("3) Sort by nationality");
                    System.out.println("0) Exit");
                    int inputsort = scan.nextInt();
                    if(inputsort==0){
                        break;
                    }
                    //Take with arrayList type
                    artistArrayList = FileIO.artists.get(1).sort(FileIO.artists, inputsort);
                    for (int i = 0; i < artistArrayList.size(); i++) {
                        System.out.println("\nArtist:\n");
                        System.out.println("Name:" + " " + artistArrayList.get(i).getName());
                        System.out.println("Birthday:" + " " + artistArrayList.get(i).getBorn());
                        System.out.println("Dead:" + " " + artistArrayList.get(i).getDied());
                        System.out.println("Nationality:" + " " + artistArrayList.get(i).getNationality());
                        String[] periods = artistArrayList.get(i).getPeriods();
                        System.out.print("Periods:");
                        for (String j : periods) {
                            System.out.print(" "+ j + ",");
                        }System.out.println("\n");
                    }
                } else if (input2 == 2) {
                    System.out.println("Please choose the sorting method");
                    System.out.println("1) Sort by name");
                    System.out.println("2) Sort by birthday");
                    System.out.println("3) Sort by nationality");
                    System.out.println("0) Exit");
                    //Take arrayList with architect type
                    ArrayList<Architect> architectArrayList = FileIO.architects;
                    int inputsort = scan.nextInt();
                    if(inputsort==0){
                        break;
                    }

                    architectArrayList = FileIO.architects.get(1).sort(FileIO.architects, inputsort);
                    for (int i = 0; i < architectArrayList.size(); i++) {
                        System.out.println("\nArchitects:\n");
                        System.out.println("Name:" + " " + architectArrayList.get(i).getName());
                        System.out.println("Birthday:" + " " + architectArrayList.get(i).getBorn());
                        System.out.println("Dead:" + " " + architectArrayList.get(i).getDied());
                        System.out.println("Nationality:" + " " + architectArrayList.get(i).getNationality());
                    }
                } else if (input2 == 3) {
                    System.out.println("Please choose the sorting method");
                    System.out.println("1) Sort by name");
                    System.out.println("2) Sort by style");
                    System.out.println("3) Sort by artist");
                    System.out.println("0) Exit");
                    ArrayList<Painting> paintingArrayList = FileIO.paintings;
                    int inputsort = scan.nextInt();
                    if(inputsort==0){
                        break;
                    }
                    paintingArrayList = FileIO.paintings.get(1).sort(FileIO.paintings, inputsort);
                    for (int i = 0; i < paintingArrayList.size(); i++) {
                        System.out.println("\nPainting:\n");
                        System.out.println("Name:" + " " + paintingArrayList.get(i).getName());
                        System.out.println("Artist:" + " " + paintingArrayList.get(i).getArtist());
                        System.out.println("Style:" + " " + paintingArrayList.get(i).getStyle());
                        System.out.println("Dimensions:" + " " + paintingArrayList.get(i).getDimension1() + "cm x" + paintingArrayList.get(i).getDimension2() + "cm");
                    }
                } else if (input2 == 4) {
                    System.out.println("Please choose the sorting method");
                    System.out.println("1) Sort by name");
                    System.out.println("2) Sort by style");
                    System.out.println("3) Sort by artist");
                    System.out.println("4) Sort by material");
                    System.out.println("0) Exit");
                    ArrayList<Sculpture> sculptureArrayList = FileIO.sculptures;
                    int inputsort = scan.nextInt();
                    if(inputsort==0){
                        break;
                    }
                    sculptureArrayList = FileIO.sculptures.get(1).sort(FileIO.sculptures, inputsort);
                    for (int i = 0; i < sculptureArrayList.size(); i++) {
                        System.out.println("\nSculpture:\n");
                        System.out.println("Name:" + " " + sculptureArrayList.get(i).getName());
                        System.out.println("Artist:" + " " + sculptureArrayList.get(i).getArtist());
                        System.out.println("Style:" + " " + sculptureArrayList.get(i).getStyle());
                        System.out.println("Material:" + " " + sculptureArrayList.get(i).getMaterial());
                        System.out.println("Weight:" + sculptureArrayList.get(i).getWeight());
                    }

                } else if (input2 == 5) {
                    System.out.println("Please choose the sorting method");
                    System.out.println("1) Sort by name");
                    System.out.println("2) Sort by style");
                    System.out.println("0) Exit");
                    ArrayList<Architecture> architectureArrayList = FileIO.architectures;
                    int inputsort = scan.nextInt();
                    if(inputsort==0){
                        break;
                    }
                    architectureArrayList = FileIO.architectures.get(1).sort(FileIO.architectures, inputsort);
                    for (int i = 0; i < architectureArrayList.size(); i++) {
                        System.out.println("\nArchitecture:\n");
                        System.out.println("Name:" + " " + architectureArrayList.get(i).getName());
                        System.out.println("Style:" + " " + architectureArrayList.get(i).getStyle());
                        String[] artists = architectureArrayList.get(i).getArchitect();
                        System.out.println("Artists:");
                        for (String j : artists) { System.out.print(" "+j + ",");
                        }System.out.println("\n");
                        System.out.println("Dimensions:" + architectureArrayList.get(i).getDimension1() + "m x " + architectureArrayList.get(i).getDimension2() + "m x " + architectureArrayList.get(i).getDimension3()+"m");
                    }
                }
            }
            else if(input==2){
                Scanner scanning = new Scanner(System.in);
                System.out.println("Enter the keyword: ");
                String scanned = scanning.nextLine();
                ArrayList<Artist> artists=FileIO.artists.get(0).search(FileIO.artists,scanned);
                if(artists.size()!=0) {
                    ArrayList<Artist> artist1=artists.get(0).sort(artists,1);

                    for(int i=0; i<artist1.size();i++){
                        System.out.println("Artist: ");
                        System.out.println("Name: " + artist1.get(i).getName());
                        System.out.println("Born: " + artist1.get(i).getBorn());
                        System.out.println("Died: " + artist1.get(i).getDied());
                        System.out.println("Nationality: "+ artist1.get(i).getNationality());
                        System.out.print("Periods:");
                        for (String j : artist1.get(i).periods) {
                            System.out.print(" " + j + ",");
                        }
                        System.out.println("\n");
                        System.out.println(" ");
                    }
                }
                ArrayList<Architect>architects =FileIO.architects.get(0).search(FileIO.architects,scanned);
                if(architects.size()!=0) {
                    ArrayList<Architect> architect1 = architects.get(0).sort(architects, 1);
                    for (int i = 0; i < architect1.size(); i++) {
                        System.out.println("Architect");
                        System.out.println("Name: " + architect1.get(i).getName());
                        System.out.println("Born: " + architect1.get(i).getBorn());
                        System.out.println("Died: " + architect1.get(i).getDied());
                        System.out.println("Nationality: " + architect1.get(i).getNationality());
                    }
                }
                ArrayList<Painting> paintings=FileIO.paintings.get(0).search(FileIO.paintings,scanned);
                if(paintings.size()!=0) {
                    ArrayList<Painting> painting1 = paintings.get(0).sort(paintings, 1);
                    for (int i = 0; i < painting1.size(); i++) {
                        System.out.println("Painting: ");
                        System.out.println("Name:      " + painting1.get(i).getName());
                        System.out.println("Style:     " + painting1.get(i).getStyle());
                        System.out.println("Artist:    " + painting1.get(i).getArtist());
                        System.out.println("Dimension: " + painting1.get(i).getDimension1() + "cm " + "x" + painting1.get(i).getDimension2() + "cm");
                        System.out.println(" ");
                    }
                }
                ArrayList<Sculpture> sculptures=FileIO.sculptures.get(0).search(FileIO.sculptures,scanned);
                if(sculptures.size()!=0){
                    ArrayList<Sculpture> sculpture1=sculptures.get(0).sort(sculptures,1);
                    for(int i=0; i<sculpture1.size();i++) {
                        System.out.println("Sculpture: ");
                        System.out.println("Name:     " + sculpture1.get(i).getName());
                        System.out.println("Artist:   " + sculpture1.get(i).getArtist());
                        System.out.println("Style:    " + sculpture1.get(i).getStyle());
                        System.out.println("Material: " + sculpture1.get(i).getMaterial());
                        System.out.println("Weight:   " + sculpture1.get(i).getWeight());
                        System.out.println(" ");
                    }
                }
                ArrayList<Architecture> architectures=FileIO.architectures.get(0).search(FileIO.architectures,scanned);
                if(architectures.size()!=0) {
                    ArrayList<Architecture> architecture1 = architectures.get(0).sort(architectures, 1);
                    for (int i = 0; i < architecture1.size(); i++) {
                        System.out.println("\nArchitecture: ");
                        System.out.println("Name:   " + architecture1.get(i).getName());
                        System.out.print("Artist:");
                        for (String j : architecture1.get(i).getArchitect()) {
                            System.out.print(" " + j + ",");
                        }
                        System.out.println("");
                        System.out.println("Style: " + architecture1.get(i).getStyle());
                        System.out.println("Dimensions: " + architecture1.get(i).getDimension1() + " m x " + architecture1.get(i).getDimension2() + " m x " + architecture1.get(i).getDimension3() + " m ");
                        System.out.println(" ");
                    }
                }
            }
            else if(input==3){
                Seller seller = new Seller();
                Buyer  buyer1 = new Buyer() ;
                Buyer  buyer2 = new Buyer() ;
                Buyer  buyer3 = new Buyer() ;
                Buyer  buyer4 = new Buyer() ;
                seller.setPrivateCollections(FileIO.allArtworks);
                System.out.println( "Seller's money : " + seller.getBalance());
                System.out.println( "Buyer 1's money: " + buyer1.getBalance());
                System.out.println( "Buyer 2's money: " + buyer2.getBalance());
                System.out.println( "Buyer 3's money: " + buyer3.getBalance());
                System.out.println( "Buyer 4's money: " + buyer4.getBalance());
                System.out.println(" ");
                System.out.println("Trade started");
                int b = 1;
                double price;
                while (b<5) {
                    Random random  = new Random();
                    //HW want take artworks randomly
                    int a = random.nextInt(seller.getPrivateCollections().size()-1);

                    if (b == 1) {
                        price = seller.getPrivateCollections().get(a).calculateCost();
                        if (!(seller.getPrivateCollections().get(a).isTradeable())) {

                            continue;
                        } else {
                            seller.getPrivateCollections().get(a).tradeToBuyer(buyer1, seller, seller.getPrivateCollections().get(a));
                            System.out.println("               ");
                            System.out.println("               ");
                            System.out.println("Buyer 1 bought:");
                            System.out.println(buyer1.getPrivateCollections().get(0).getClass());
                            System.out.println("Name : " + buyer1.getPrivateCollections().get(0).getName());
                            System.out.println("Price: " + price);
                            b++;
                        }
                    }
                    else if (b == 2) {
                        price = seller.getPrivateCollections().get(a).calculateCost();
                        if(!(seller.getPrivateCollections().get(a).isTradeable())){

                            continue;
                        }
                        else {
                            seller.getPrivateCollections().get(a).tradeToBuyer(buyer2, seller, seller.getPrivateCollections().get(a));
                            System.out.println("               ");
                            System.out.println("               ");
                            System.out.println("Buyer 2 bought:");
                            System.out.println(buyer2.getPrivateCollections().get(0).getClass());
                            System.out.println("Name : " + buyer2.getPrivateCollections().get(0).getName());
                            System.out.println("Price: " + price);
                            b++;
                        }
                    }
                    else if (b == 3) {
                        price = seller.getPrivateCollections().get(a).calculateCost();
                        if(!(seller.getPrivateCollections().get(a).isTradeable())){

                            continue;
                        }
                        else {
                            seller.getPrivateCollections().get(a).tradeToBuyer(buyer3, seller, seller.getPrivateCollections().get(a));
                            System.out.println("               ");
                            System.out.println("               ");
                            System.out.println("Buyer 3 bought:");
                            System.out.println(buyer3.getPrivateCollections().get(0).getClass());
                            System.out.println("Name : " + buyer3.getPrivateCollections().get(0).getName());
                            System.out.println("Price: " + price);
                            b++;
                        }
                    }
                    else if (b == 4) {
                        price = seller.getPrivateCollections().get(a).calculateCost();
                        if(!(seller.getPrivateCollections().get(a).isTradeable())){

                            continue;
                        }
                        else {
                            seller.getPrivateCollections().get(a).tradeToBuyer(buyer4, seller, seller.getPrivateCollections().get(a));
                            System.out.println("               ");
                            System.out.println("               ");
                            System.out.println("Buyer 4 bought:");
                            System.out.println(buyer4.getPrivateCollections().get(0).getClass());
                            System.out.println("Name : " + buyer4.getPrivateCollections().get(0).getName());
                            System.out.println("Price: " + price);
                            b++;
                        }
                    }
                }
                System.out.println("                  ");
                System.out.println("                  ");
                System.out.println("Trade completed:  ");
                System.out.println("                  ");
                System.out.println( "Seller's money : " + seller.getBalance());
                System.out.println( "Buyer 1's money: " + buyer1.getBalance());
                System.out.println( "Buyer 2's money: " + buyer2.getBalance());
                System.out.println( "Buyer 3's money: " + buyer3.getBalance());
                System.out.println( "Buyer 4's money: " + buyer4.getBalance());
            }
        }
    }
}