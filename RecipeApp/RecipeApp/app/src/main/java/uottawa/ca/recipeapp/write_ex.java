package uottawa.ca.recipeapp;

import android.content.Context;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class write_ex {

   public static void write(Recipe recipe, Context context) {
      // TODO Auto-generated method stub
      ObjectMapper mapper = new ObjectMapper();
       mapper.enable(SerializationFeature.INDENT_OUTPUT);
       String jsonString;
      try {
          jsonString = mapper.writeValueAsString(recipe);
          FileOutputStream os = context.openFileOutput((recipe.get_name() + ".json"), context.MODE_PRIVATE);
          os.write(jsonString.getBytes());
          os.close();
      } catch (Exception e){
         System.out.println("Exception" + e);
      }
   }
}
