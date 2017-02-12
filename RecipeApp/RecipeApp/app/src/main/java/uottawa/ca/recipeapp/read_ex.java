package uottawa.ca.recipeapp;

import android.content.Context;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class read_ex {

   public static Recipe read(String name, Context context) {

      ObjectMapper mapper = new ObjectMapper();
          try {
              int n;
              FileInputStream fis;
              fis = context.openFileInput(name);
              StringBuffer fileContent = new StringBuffer("");

              byte[] buffer = new byte[1024];

              while ((n = fis.read(buffer)) != -1)
              {
                  fileContent.append(new String(buffer, 0, n));
              }
              return mapper.readValue(fileContent.toString(), Recipe.class);
          } catch (IOException e) {
              Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
              e.printStackTrace();
          }
       return null;
   }

}
