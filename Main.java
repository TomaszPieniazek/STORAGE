import pack.Package;

import java.awt.*;

import static pack.TypesOfPackage.toys;

public class Main {

    public static void main(String[] args) {
        int x=10, y=10, z=10;
        Storage s=Storage.getInstance(x,y,z);

        s.randomizeStorage();
/*
        if(s.findPackageById(25)){
            System.out.print("Found");
            s.getHistoryOfOnePackage(25);
        }else             System.out.print("NOT found");

     */


/*
        Package a=new Package(toys,"aaaaaaa",1,1);
        Package b=new Package(toys,"bbbbbbb",2,2);
        Package c=new Package(toys,"ccccccc",3,3);
        Package d=new Package(toys,"ddddddd",4,4);
        Package e=new Package(toys,"eeeeeee",5,5);
        s.putPackage(1,1,a);
        s.putPackage(1,1,b);
        s.putPackage(1,1,c);
        s.setPackage(1,1,d);
        s.setPackage(1,1,e);
*/

        //System.out.print(s.findPackageById(2).toString());
        //System.out.print(s.toString());
       // System.out.print("\n*******************************************\n");

        Package dejta= s.getPackageByNumber(1);

         //dejta= s.getPackageByNumber(3);
        //System.out.print(s.toString());
       // System.out.print(dejta.toString());
       // s.getHistoryOfOnePackage(33);
         s.getStatusOfStorage();
        System.out.print("\n"+dejta.toString());

    }
}
