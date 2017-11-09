import pack.TypesOfPackage;
import pack.Package;

public class Main {

    public static void main(String[] args) {
        //Tworze magazyn
        Storage s=Storage.getInstance(3,3,3);

        //Tworze dwie paczki
        Package a= new Package(TypesOfPackage.toys, "aaaaaa",1,1 );
        Package b= new Package(TypesOfPackage.guns, "bbbbbbbbb",2,3 );

        //Wstawiam dwie paczki do magazynu
        s.setPackage(1,1,a);
        s.setPackage(1,1,b);

        //Wypisuje dwie paczki po ich numerach
        s.getPackageById(1);
        System.out.print("\n*************************");
        s.getPackageById(2);
        System.out.print("\n******************");


        //Zmieniam koordynaty paczki a, sprawdzam czy sie zaktualizowaly one oraz historia
        a.setCoordinates(1,2,1);
        s.getPackageById(1);
        System.out.print("\n******************");
        s.getHistoryOfOnePackage(1);
        System.out.print("\n*************************");
        s.getPackageById(2);
    }
}
