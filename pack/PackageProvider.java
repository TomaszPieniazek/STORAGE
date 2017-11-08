package pack;

import pack.packagesImplementation.ClothsPackage;
import pack.packagesImplementation.ToysPackage;

import java.util.Date;

public class PackageProvider implements  UnitInterface{
    private static UnitInterface instance=null;

    private PackageProvider() {
    }

    public static UnitInterface setPackageType(TypesOfPackage e){
        if(e.equals(TypesOfPackage.toys))
        {
            instance=new ToysPackage();
            instance.setMoves(0);
            instance.setType(e);
        }else if(e.equals(TypesOfPackage.cloths))
        {
            instance =new ClothsPackage();
            instance.setMoves(0);
            instance.setType(e);
        }
        return instance;
    }


    @Override
    public void setDescription(String d) {
        instance.setDescription(d);
    }

    @Override
    public void setPriority(int p) {
        instance.setPriority(p);
    }

    @Override
    public void setMoves(int p) {
        instance.setMoves(p);
    }

    @Override
    public void setDate(Date d) {
        instance.setDate(d);
    }

    @Override
    public void setNumber(int n) {
        instance.setNumber(n);
    }

    @Override
    public String getDescription() {
        return instance.getDescription();
    }

    @Override
    public int getMoves() {
        return instance.getMoves();
    }

    @Override
    public Date getDate() {
        return instance.getDate();
    }

    @Override
    public int getNumber() {
        return instance.getNumber();
    }

    @Override
    public int getPriority() {
        return instance.getPriority();
    }

    @Override
    public TypesOfPackage getType() { return instance.getType(); }

    @Override
    public void setType(TypesOfPackage e) {
        instance.setType(e);
    }

    @Override
    public void textPackageInfo() {
        System.out.print("\nType: "+instance.getType()+"\nNumber: "+instance.getNumber()+
                "\nDescription: "+instance.getDescription()+"\nPriority: "+instance.getPriority()+
                "\nCreate date: "+instance.getDate()+"\nCount of moves: "+instance.getMoves());

    }


}
