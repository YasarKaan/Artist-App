import java.util.ArrayList;
import java.util.Scanner;

public class Architect extends Person {
    public Architect(String name,String born,String died,String nationality){
        this.name= name;
        this.born= born;
        this.died= died;
        this.nationality= nationality;
    }
    public int compareTo(Object object,int input) {
        if(isPerson(object)){
            Person object1 = (Person) object;
            if (input==0){
                return -99;
            }
            if(input==1) {
                return compareName(object1);
            }
            if(input==2){
                return compareBirthday(object1);
            }
            if(input==3){
                return compareNationality(object1);
            }
        }
        return 0;
    }
    private int compareName(Person object1){

        String string1 = this.name;
        String string2 = object1.getName();
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
    private int compareBirthday(Person object1){
        String string1 = this.born;
        String string2 = object1.getBorn();
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
    private int compareNationality(Person person){
        String string1 = this.nationality;
        String string2 = person.getNationality();
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



    public boolean isPerson(Object name){
        if(name == null ){
            return false;
        }else if (!(name instanceof Person)){
            return false;
        }else{
            return true;
        }
    }
    public ArrayList sort(ArrayList stringArrayList,int input){
        ArrayList<Person> personArrayList= new ArrayList<Person>(stringArrayList);
        String twp=null;
        Person person = null;
        for(int i=0;i<stringArrayList.size();i++){
            for(int j=i+1;j<stringArrayList.size();j++){
                int compare =personArrayList.get(i).compareTo(personArrayList.get(j),input);
                if (compare==-99){
                    break;
                }
                if(personArrayList.get(i).compareTo(personArrayList.get(j),input)<0){
                    person=personArrayList.get(i);
                    personArrayList.set(i,personArrayList.get(j));
                    personArrayList.set(j,person);
                }
            }
        }
        return personArrayList;
    }
    public ArrayList search(ArrayList arrayList,String str){
        ArrayList<Architect> arrayList1 = new ArrayList<>(arrayList);
        ArrayList<Architect> architects = new ArrayList();
        for(int i=0;i<arrayList.size();i++){
            if(arrayList1.get(i).getName().equals(str) || (arrayList1.get(i).getNationality()).equals(str) || (arrayList1.get(i).getBorn().equals(str)) || (arrayList1.get(i).getDied().equals(str)) ){
                architects.add(arrayList1.get(i));
            }
        }
        return architects;
    }
}
