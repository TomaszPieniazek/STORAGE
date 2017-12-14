import Storage.pack.Package;
import Storage.Storage;
import java.util.ArrayList;
import java.util.Random;

import static Storage.pack.TypesOfPackage.*;


public class Main {

    public static void main(String[] args) {
        int x = 5, y = 5, z = 5;
        Storage s = Storage.getInstance(x, y, z);


        // TESTING
        // MANUALLY ADDING 5 PACKAGES TO STORAGE
            Package a = new Package(food, "aaaaaaa", 1, 1);
            Package b = new Package(food, "bbbbbbb", 2, 3);
            Package c = new Package(toys, "ccccccc", 3, 3);
            Package d = new Package(cloths, "ddddddd", 4, 3);
            Package e = new Package(toys, "eeeeeee", 5, 3);

            s.putPackage(1, 1, a);
            s.putPackage(1, 1, b);
            s.putPackage(1, 1, c);
            s.putPackage(1, 1, d);
            s.putPackage(1, 1, e);

         // s.randomizeStorage();


        s.getStatusOfStorage();

        //TESTING METHOD getPackageByNumber
            Package p = s.getPackageByNumber(1);
            System.out.print("\n" + p.toString());
       // p = s.getPackageByNumber(2);
        //System.out.print("\n" + p.toString());
            s.getStatusOfStorage();

        //TESTING METHOD getHistoryOfPackage
           // s.getHistoryOfOnePackage(44);

        //TESTING METHOD getPackagesByType
         //   ArrayList<Package> alp = s.getPackagesByType(guns);
         //   System.out.print("\n*********************\n" + alp.toString()+"\n**************\n");

        //TESTING METHOD getStatusOfStorage;
        //    s.getStatusOfStorage();

        }




}
