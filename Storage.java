import java.awt.*;
import java.util.*;
import pack.Package;
import pack.TypesOfPackage;
import pack.coordinates.Coordinates;

/*
 * Storage class:
    -only one instance of Storage
    -attributes width, length and height are defining size of our Storage
    -attribute map (HashMap<Point,ArrayList<Package>>) contains List of Package objects where Point is key
 */
public class Storage {
    private static Storage instance= null;
    private int width;
    private int length;
    private int height;
    public Map<Point, ArrayList<Package>> map;
    private Random random = new Random();

    /*
     * Constructor
     */
    private Storage(int x,int y, int z) {
            this.width =x;
            this.length =y;
            this.height =z;
            this.map=new HashMap<>();
    }

    /*
     *method getInstance provides that there is only one instance of our Storage
     */
    static Storage getInstance(int x, int y, int z){
        if (instance==null){
            instance=new Storage(x,y,z);
            for(int i=1;i<=x;i++){
                for(int j=1;j<=y;j++)
                {
                    instance.map.put(new Point(i,j),new ArrayList<>(z));
                } } }return instance;
    }

    /*
     *method putPackage:
        -tries to put package in our Storage
        -parameter p is Package we want to put
        -a and b params defining position where we want to put our Package, we use them as Point(a,b) key to map
        -checks if ArrayList<Package> in Point(a,b) isn't full already or Package in the top of list doesn't have higher priority than package we want to put
        -returns true if we successfully put Package, if otherwise returns false
     */
    public boolean putPackage(int a, int b, Package p) {
        boolean result= false;
       if ( (map.get(new Point(a, b)).isEmpty()) || (this.map.get(new Point(a,b)).size()<this.height && map.get(new Point(a,b)).get(this.map.get(new Point(a,b)).size()-1).getPriority()<= p.getPriority()) ){
            p.setCoordinates(a,b,this.map.get(new Point(a,b)).size());
            p.setMoves(p.getMoves()+1);
            map.get(new Point(a,b)).add(p);
            result=true;
       }
          return result;
    }

    /*
     *method findPackageByNumber:
        -parameter (n) is the number of Package we want to get
        -search through all map to find Package with number equals to n
        -if it finds one, returns its Coordinates
        -if not, returns Coordinates -1,-1,-1
     */
    private Coordinates findPackageByNumber(int n) {
        Coordinates found = new Coordinates(-1,-1,-1);
        for(int i = 1; i<=this.width; i++){
            for(int j = 1; j<=this.length; j++) {
                for(int k=0;k<this.map.get(new Point(i, j)).size();k++){
                    if(this.map.get(new Point(i, j)).get(k).getNumber()==n){
                        found.setCoordinatesWLH(i,j,k);
                        break;
                 }
                }}}
                return found;
    }

    /*
     *parameter c defines Coordinates of our Package in Storage
     *this method checks if there are some packages above our Package:
        -variable result is number that tells us how many packages lies above our Package in current ArrayList
            +e.g.  our Package is on top of ArrayList -> result=0
            +e.g.  our Package is under two other packages ->result=2
        -if there are some packages above, we grab them one by one (always from the top) and move to random place in our Storage
        -while moving them we use putPackage method so we know Package we are moving wont be put above Package with higher priority
        -if our Package is on top of ArrayList method does nothing
     */
    private void moveWhatIsAbove(Coordinates c){
        int result = ((this.map.get(new Point(c.getW(),c.getL())).size())-((c.getH())+1));
        int ran1=-1, ran2=-1;
        while(result>0){
            Package p =this.map.get(new Point(c.getW(),c.getL())).get(((c.getH())+result));
            this.map.get(new Point(c.getW(),c.getL())).remove(p.getCoordniates().getH());
            do {
                 ran1 = random.nextInt(this.width) + 1;
                 ran2 = random.nextInt(this.length) + 1;
            }while((p.getCoordniates().getW()!=ran1 || p.getCoordniates().getL()!=ran2) && !this.putPackage(ran1, ran2, p));
            result--;
        }
    }

    /*
     *parameter n defines number of Package we want to get
     *to variable c we assign Coordinates we get from method findPackageByNumber(n)
     *if Coordinates == {-1,-1,-1} that means Package with number n does not exist
     *otherwise we use method moveWhatIsAbove to get rid of packages that are above our Package
     *now we can assign Package with number n to variable p
     *remove Package with number n from ArrayList
     *method returns Package we are looking for or null if Package does not exist
     */
    public Package getPackageByNumber(int n) {
        Package p=null;
        Coordinates c= this.findPackageByNumber(n);
        if(c.areCordsProper()) {
            this.moveWhatIsAbove(c);
            p = this.map.get(new Point(c.getW(), c.getL())).get(this.map.get(new Point(c.getW(), c.getL())).size() - 1);
            this.map.get(new Point(c.getW(), c.getL())).remove((this.map.get(new Point(c.getW(), c.getL())).size() - 1));
        }
        return p;
    }

    /*
     *this method returns history of Coordinates of our Package
     */
    public void getHistoryOfOnePackage(int n){
        Coordinates c= this.findPackageByNumber(n);
        System.out.print("\nHISTORY OF MOVES OF PACKAGE NR"+n+": ");
        System.out.print(this.map.get(new Point(c.getW(), c.getL())).get(c.getH()).getHistoryOfMoves().toString());
    }


    /*
     *this method fills our Storage with some random packages
     */
    public void randomizeStorage() {
        int counter=0;
        while(counter <((this.width *this.length *this.height)*2/3)){
           if((this.putPackage(random.nextInt(this.width) + 1, random.nextInt(this.length) + 1, new Package(TypesOfPackage.guns, "lolololololo" + counter, counter, random.nextInt(5) + 1)))){
               counter++;
           }
        }
    }

    @Override
    public String toString() {
        return "\nStorage{" +
                "\nmap=" + map +
                '}';
    }

    public void getStatusOfStorage(){
        System.out.print(this.toString());
    }
}