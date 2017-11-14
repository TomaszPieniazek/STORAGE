package pack.coordinates;

public class Coordinates {
    private int w;
    private int l;
    private int h;

    public Coordinates(int w, int l, int h) {
        this.w=w;
        this.l = l;
        this.h = h;
    }

    public void setCoordinatesWLH(int w,int l, int h){
        this.w = w;
        this.l = l;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "w=" + w +
                ", l=" + l +
                ", h=" + h +
                '}';
    }

    public int getW() {
        return w;
    }

    public int getL() {
        return l;
    }

    public int getH() {
        return h;
    }
    public void textCoordinates(){
        System.out.print(this.getW()+","+this.getL()+","+this.getH());
    }
}
