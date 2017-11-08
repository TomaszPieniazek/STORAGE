
import pack.UnitInterface;
import java.awt.*;
import java.util.*;


public class Storage {
    private static Storage instance= null;
    private int x;
    private int y;
    private int z;
    private Map<Point, ArrayList<UnitInterface>> map= new HashMap<>();



    private Storage(int x,int y, int z) {
            this.x=x;
            this.y=y;
            this.z=z;
    }

    public static Storage getInstance(int x, int y, int z){
        if (instance==null){
            instance=new Storage(x,y,z);
            for(int i=1;i<=x;i++){
                for(int j=1;j<=y;j++)
                {
                    instance.map.put(new Point(i,j),new ArrayList<>(z));
                } } }return instance;
    }

    public  void setPackage(int a, int b, UnitInterface p)
    {
        p.setDate(new Date());
        map.get(new Point(a,b)).add(p);
    }


    public void getPackageById(int n) {
        boolean found = false;
        for(int i=1;i<=instance.x;i++){
            for(int j=1;j<instance.y;j++) {
                for(int k=0;k<instance.map.get(new Point(i, j)).size();k++){
                   if(instance.map.get(new Point(i, j)).get(k).getNumber()==n){
                       instance.map.get(new Point(i, j)).get(k).textPackageInfo();
                       found=true;
                   }
                }}} if(found==false)System.out.print("\nNie znaleziono paczki o podanym id");}

}
