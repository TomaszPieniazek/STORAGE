package pack.packagesImplementation;

import pack.TypesOfPackage;
import pack.UnitInterface;
import pack.Package;
import java.util.Date;

public class ClothsPackage implements UnitInterface {
    @Override
    public void setDescription(String d) {
        Package.description="This package contains cloths\n"+d;
    }

    @Override
    public void setPriority(int p) {
        Package.priority=p;
    }

    @Override
    public void setMoves(int p) {
        Package.countOfMoves=p;
    }

    @Override
    public void setDate(Date d) {
        Package.addedDate=d;
    }

    @Override
    public void setNumber(int n) {
        Package.number=n;
    }

    @Override
    public String getDescription() {
        return Package.description;
    }

    @Override
    public int getMoves() {
        return Package.countOfMoves;
    }

    @Override
    public Date getDate() {
        return Package.addedDate;
    }

    @Override
    public int getNumber() {
        return Package.number;
    }

    @Override
    public int getPriority() {
        return Package.priority;
    }

    @Override
    public TypesOfPackage getType() { return Package.type; }

    @Override
    public void setType(TypesOfPackage e) {
        Package.type=e;
    }

    @Override
    public void textPackageInfo() {
        System.out.print("\nType: "+this.getType()+"\nNumber: "+this.getNumber()+
                         "\nDescription: "+this.getDescription()+"\nPriority: "+this.getPriority()+
                         "\nCreate date: "+this.getDate()+"\nCount of moves: "+this.getMoves());

    }
}
