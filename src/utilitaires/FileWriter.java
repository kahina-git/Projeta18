/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaires;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lotissement;
import model.Terrain;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Utilisateur
 */
public class FileWriter {
    
   public static void saveStringintoFile(String contentToSave, String filePath) 
   {
   File file=new File(filePath);
       try {
           FileUtils.writeStringToFile(file, contentToSave, "utf-8");
       } catch (IOException ex) {
           Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   
   }

}
