/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaires;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lotissement;
import model.Terrain;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Utilisateur
 */
public class ConvertDATA {

    public static Terrain objectJsonIntObjectClass(String mainJSON) {
        Terrain terrain = new Terrain();
        JSONObject terrainJSON = JSONObject.fromObject(mainJSON);
        int typeTerrain;
        int i;
        String test="CECI EST UN TEST";
        double prixMin;
        String prix_m2_min;
        String prix_m2_max;
        double prixMax;
        ArrayList<Lotissement> lotissements = new ArrayList<>();
        typeTerrain = terrainJSON.getInt("type_terrain");
        System.out.println("");
        prix_m2_min = terrainJSON.getString("prix_m2_min").trim();
        prixMin = Double.parseDouble(prix_m2_min.substring(0, prix_m2_min.length() - 1));
        prix_m2_max = terrainJSON.getString("prix_m2_max").trim();
        prixMax = Double.parseDouble(prix_m2_max.substring(0, prix_m2_max.length() - 1));
        JSONArray listLotissements = terrainJSON.getJSONArray("lotissements");
        JSONObject lot;
        String description;
        int nbrDroitPassage;
        int nbService;
        double superficie;
        String date;
        Date dateMesure;
        for (i = 0; i < listLotissements.size(); i++) {
            lot = listLotissements.getJSONObject(i);
            description = lot.getString("description");
            nbrDroitPassage = lot.getInt("nombre_droits_passage");
            nbService = lot.getInt("nombre_services");
            superficie = lot.getDouble("superficie");
            date = lot.getString("date_mesure");
            try {
                dateMesure = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            } catch (ParseException ex) {
                Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
            }
            Lotissement lot1 = new Lotissement(description, nbrDroitPassage, nbService, superficie, date, terrain);
            lotissements.add(lot1);
        }
        terrain.setTypeTerrain(typeTerrain);
        terrain.setPrixMin(prixMin);
        terrain.setPrixMax(prixMax);
        terrain.setLotissements(lotissements);
        return terrain;
    }

  // À COMPLÉTER
  public static JSONObject ResultIntobjectJSON(Terrain terrain) {

      JSONObject result = new JSONObject();

      return result;
  }
    
    
}
