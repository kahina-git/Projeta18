
package model;

import java.util.ArrayList;

public class Terrain {
    private int typeTerrain;
    private double prixMin;
    private double prixMax;
    private ArrayList <Lotissement> lotissements;

    public Terrain(int typeTerrain, double prixMin, double prixMax, ArrayList<Lotissement> lotissements) {
        this.typeTerrain = typeTerrain;
        this.prixMin = prixMin;
        this.prixMax = prixMax;
        this.lotissements = lotissements;
    }

    public Terrain() {
       
    }

    public ArrayList <Lotissement> getLotissements() {
        return lotissements;
    }

    public void setLotissements(ArrayList <Lotissement> lotissements) {
        this.lotissements = lotissements;
    }

    public int getTypeTerrain() {
        return typeTerrain;
    }

    public void setTypeTerrain(int typeTerrain) {
        this.typeTerrain = typeTerrain;
    }

    public double getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(double prixMin) {
        this.prixMin = prixMin;
    }

    public double getPrixMax() {
        return prixMax;
    }

    public void setPrixMax(double prixMax) {
        this.prixMax = prixMax;
    }

    @Override
    public String toString() {
        return "Terrain{" + "typeTerrain=" + typeTerrain + ", prixMin=" + prixMin + ", prixMax=" + prixMax + ", lotissements=" + lotissements + '}';
    }
    
    //A COMPLÉTER
    public  double prixMoyen()
    {return (this.prixMax+this.prixMin)/2;}
    
    
  
    //A COMPLÉTER       
     public double valFonciereTotale()
   {
       
   return 0;
   }
           
    //A COMPLÉTER       
public double taxeScolaire()
{

return 0;


}
public double taxeMunicipale()
{
    
return 0;
}

}
