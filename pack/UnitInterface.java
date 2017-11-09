package pack;
import java.util.Date;

public interface UnitInterface {
    public void setDescription(String d);
    public void setPriority(int p);
    public void setMoves(int p);
    public void setDate(Date d);
    public void setNumber(int n);
    public String getDescription();
    public int getMoves();
    public Date getDate();
    public int getNumber();
    public int getPriority();
    public TypesOfPackage getType();
    void setType(TypesOfPackage e);
     public void textPackageInfo();
}
