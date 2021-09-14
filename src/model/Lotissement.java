package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Lotissement {
    private String description;
    private int nbrDroitPassage;
    private int nbService;
    private double superficie;
    private Date dateMesure;
    private Terrain terrain;

    public Lotissement(String description, int nbrDroitPassage, int nbService, double superficie, String dateMesure, Terrain terrain) {
        this.description = description;
        this.nbrDroitPassage = nbrDroitPassage;
        this.nbService = nbService;
        this.superficie = superficie;
        try {
            this.dateMesure = new SimpleDateFormat("yyyy-MM-dd").parse(dateMesure);
        } catch (ParseException ex) {
            Logger.getLogger(Lotissement.class.getName()).log(Level.SEVERE, null, ex);
        }
;
        this.terrain = terrain;
    }

    public int getNbService() {
        return nbService;
    }

    public void setNbService(int nbService) {
        this.nbService = nbService;
    }

   

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    

    public Lotissement() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbrDroitPassage() {
        return nbrDroitPassage;
    }

    public void setNbrDroitPassage(int nbrDroitPassage) {
        this.nbrDroitPassage = nbrDroitPassage;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public Date getDateMesure() {
        return dateMesure;
    }

    public void setDateMesure(Date dateMesure) {
        this.dateMesure = dateMesure;
    }

    @Override
    public String toString() {
        return "Lotissement{" + "description=" + description + ", nbrDroitPassage=" + nbrDroitPassage + ", superficie=" + superficie + ", dateMesure=" + dateMesure + '}';
    }
    
    public double montantParSurface()
    {
        
        if(terrain.getTypeTerrain()==0)
        {return superficie*terrain.getPrixMin();}
        else {if (terrain.getTypeTerrain()==1)
        {return superficie*terrain.prixMoyen();}
        else
        {return superficie*terrain.getPrixMax();}}
         
    
    
    }
    public  double montantParService()
            {
              double montantParService=0;
                
            if (this.terrain.getTypeTerrain()==0)
            {
               return 0;
            }
            else{ 
                    if (this.terrain.getTypeTerrain() == 1) {
                                    if ((this.montantParSurface() > 500) && (this.montantParSurface() < 10000)) {
                                        montantParService=500 * (this.nbService+2);
                                
                                    } else {
                                    if (this.montantParSurface() > 10000) {
                                        montantParService=1000 * (this.nbService+2);
                                    }
                                            }

                    } else {
                        if (this.terrain.getTypeTerrain() == 2) {
                            if (this.montantParSurface() <= 500) 
                            {montantParService=500 * (this.nbService+2); }
                            else{montantParService=1500 * (this.nbService+2);}
                        }

                    }
            }
           
            if(montantParService>5000)
            {return 5000;}
            else
            {return montantParService;}
            }
    
    public  double montantParDroitPassage(){
        double montantDP=0;
                    if (this.terrain.getTypeTerrain() == 0) {
                        montantDP=500-(this.nbrDroitPassage*(0.05*this.montantParSurface()));
                    }else
                        if(this.terrain.getTypeTerrain() == 1){
                        montantDP=500-(this.nbrDroitPassage*(0.10*this.montantParSurface()));
                        
                        }else
                            if(this.terrain.getTypeTerrain() == 2){
                            
                             montantDP= 500-(this.nbrDroitPassage*(0.15*this.montantParSurface()));
                            }
                    
    
    
    
    return  montantDP;
    }
    
   public  double montantTotalParLot() {
   double montantTotalParLot= this.montantParSurface()+this.montantParDroitPassage()+this.montantParService();
   
   return Math.round(montantTotalParLot/0.05)*0.05;
    
   }
}
