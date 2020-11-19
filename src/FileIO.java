import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    //Create static ArrayLists different type
    static ArrayList<Painting> paintings = new ArrayList<>();
    static ArrayList<Sculpture> sculptures = new ArrayList<>();
    static ArrayList<Architecture> architectures = new ArrayList<>();
    static ArrayList<Artist> artists = new ArrayList<>();
    static ArrayList<Architect> architects = new ArrayList<>();
    static ArrayList<ArtWork> allArtworks = new ArrayList<>();
    public static void read(){
        File file = new File("CENG211_HW2_ArtVaultData.csv");
        try{
            Scanner data = new Scanner(file);
            while(data.hasNextLine()){
                String twpdata = data.nextLine();
                String[] artData =twpdata.split(",");
                int type = Integer.parseInt(artData[0]);
                if (type==1){
                    //Change variables string to double
                    double dimension1 = Double.parseDouble(artData[4]);
                    double dimension2 = Double.parseDouble(artData[5]);
                    Painting paint = new Painting(artData[1],artData[2],artData[3],dimension1,dimension2);
                    paintings.add(paint);
                    allArtworks.add(paint);
                }
                else if (type==2){
                    //Change variables string to double
                    double weight = Double.parseDouble(artData[5]);
                    Sculpture sculpture = new Sculpture(artData[1],artData[2],artData[3],artData[4],weight);
                    sculptures.add(sculpture);
                    allArtworks.add(sculpture);
                }
                else if (type==3){
                    //Change variables string to double
                    double dimension1 = Double.parseDouble(artData[3]);
                    double dimension2 = Double.parseDouble(artData[4]);
                    double dimension3 = Double.parseDouble(artData[5]);
                    String[] twpArray = new String[artData.length-6];//-6 because we wanna take only periods
                    int j=0;
                    for (int i = 6 ; i<artData.length;i++){

                        twpArray[j]=artData[i];
                        j++;
                    }
                    Architecture architecture = new Architecture(artData[1],artData[2],dimension1,dimension2,dimension3,twpArray);
                    architectures.add(architecture);
                    allArtworks.add(architecture);
                }
                else if (type==4){
                    String[] twpArray= new String[artData.length-5];//-5 because we wanna take only periods
                    int j=0;
                    for (int i=5;i<artData.length;i++){
                        twpArray[j]=artData[i];
                        j++;
                    }
                    Artist artist = new Artist(artData[1],artData[2],artData[3],artData[4],twpArray);
                    artists.add(artist);
                }
                else if (type==5){
                    Architect architect = new Architect(artData[1],artData[2],artData[3],artData[4]);
                    architects.add(architect);
                }
            }
            data.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (NumberFormatException e){
            //skip
        }
    }
}

