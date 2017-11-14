import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int x=3, y=3, z=3;
        Storage s=Storage.getInstance(x,y,z);
        s.randomizeStorage();

        if(s.findPackageById(3)){
            System.out.print("Found");
        }else             System.out.print("NOT found");

     //   System.out.print(s.toString());
    }
}
