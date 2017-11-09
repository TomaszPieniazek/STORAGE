import pack.TypesOfPackage;
import pack.Package;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Tworze magazyn
        Storage s=Storage.getInstance(3,3,6);

        //Tworze  paczki
        Package a= new Package(TypesOfPackage.toys, "aaaaaaaaa",1,1 );
        Package b= new Package(TypesOfPackage.guns, "bbbbbbbbb",2,2 );
        Package c= new Package(TypesOfPackage.cloths, "ccccccccc",3,3 );
        Package d= new Package(TypesOfPackage.guns, "ddddddddd",4,4 );
        Package e= new Package(TypesOfPackage.food, "eeeeeeeee",5,5 );

        //Wstawiam  paczki do magazynu
        s.setPackage(1,1,c);
        s.setPackage(1,1,b);
        s.setPackage(1,1,e);
        s.setPackage(1,1,a);
        s.setPackage(1,1,d);

        /*
        //Wypisuje dwie paczki po ich numerach
        s.getPackageById(1);
        System.out.print("\n*************************");
        s.getPackageById(2);
        System.out.print("\n******************");
        */

        /*
        //Zmieniam koordynaty paczki a, sprawdzam czy sie zaktualizowaly one oraz historia
        a.setCoordinates(1,2,1);
        s.getPackageById(1);
        System.out.print("\n******************");
        s.getHistoryOfOnePackage(1);
        System.out.print("\n*************************");
        s.getPackageById(2);
        */
        ArrayList<Package> lol= s.getListFromPoint(1,1);
        for(int i=0;i<lol.size();i++)
        {
            System.out.print("\n"+lol.get(i).getNumber());
        }
    }
}
