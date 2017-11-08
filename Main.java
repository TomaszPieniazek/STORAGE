import pack.PackageProvider;
import pack.UnitInterface;
import static pack.TypesOfPackage.*;

public class Main {

    public static void main(String[] args) {

        UnitInterface a= PackageProvider.setPackageType(toys);
        a.setDescription("cossss tam jeszcze");
        a.setNumber(4);
        a.setPriority(3);
        a.setMoves(a.getMoves()+1);
       // System.out.println(a.getDescription()+"\nNumber: "+a.getNumber()+"\nPriority: "+a.getPriority()+"\nData dodania: "+a.getDate()+"\nLiczba ruchow: "+a.getMoves());

        Storage s=Storage.getInstance(3,3,3);
        s.setPackage(1,1,a);
        s.getPackageById(3);


    }
}
