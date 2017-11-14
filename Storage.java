import java.awt.*;
import java.util.*;
import pack.Package;
import pack.TypesOfPackage;


import static pack.TypesOfPackage.toys;


public class Storage {
    private static Storage instance= null;
    private int x;
    private int y;
    private int z;
    private Map<Point, ArrayList<Package>> map;

    private Storage(int x,int y, int z) {
            this.x=x;
            this.y=y;
            this.z=z;
            this.map=new HashMap<>();
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

    private  boolean setPackage(int a, int b, Package p) {
        boolean result= false;
       if ( map.get(new Point(a, b)).isEmpty() || (this.map.get(new Point(a,b)).size()<this.z  & map.get(new Point(a,b)).get(this.map.get(new Point(a,b)).size()-1).getPriority()<= p.getPriority()) ){
            p.setCoordinates(a,b,this.map.get(new Point(a,b)).size());
            map.get(new Point(a,b)).add(p);
            result=true;
       }
          return result;
    }

    public void updateCords(int a,int b){
        for(int i=0;i<map.get(new Point(a,b)).size();i++){
            map.get(new Point(a,b)).get(i).setCoordinates(a,b,i);
        }
    }



    public boolean findPackageById(int n) {
        boolean found = false;
        for(int i=1;i<=instance.x;i++){
            for(int j=1;j<=instance.y;j++) {
                for(int k=0;k<instance.map.get(new Point(i, j)).size();k++){
                    if(instance.map.get(new Point(i, j)).get(k).getNumber()==n){
                        found = true;
                        break;
                 }
                }}}
                return found;
    }

    public Package returnPackageById(int n) {
        Package p=null;
        for(int i=1;i<=instance.x;i++){
            for(int j=1;j<instance.y;j++) {
                for(int k=0;k<instance.map.get(new Point(i, j)).size();k++){
                    if(instance.map.get(new Point(i, j)).get(k).getNumber()==n){
                        p= instance.map.get(new Point(i, j)).get(k);
                    }
                }}} return p;}

    public void getHistoryOfOnePackage(int n){
        Package p=returnPackageById(n);
        System.out.print("\nHISTORY OF MOVES OF PACKAGE NR"+n+": ");
        for(int i=0;i<p.getHistoryOfMoves().size();i++) {
           System.out.print("\n "+i+": ");
            p.getHistoryOfMoves().get(i).textCoordinates();
        }
    }


    public void randomizeStorage() {
        Random random = new Random();
        int counter=0;
        while(counter <((this.x *this.y *this.z)/2)){
           if((this.setPackage(random.nextInt(this.x) + 1, random.nextInt(this.y) + 1, new Package(TypesOfPackage.guns, "lolololololo" + counter, counter, random.nextInt(5) + 1)))){
               counter++;
           }
        }
    }

    @Override
    public String toString() {
        return "Storage{" +
                "map=" + map +
                '}';
    }
}
