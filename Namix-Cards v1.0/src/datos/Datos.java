package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import modelos.Carta;

/**
 * @author Jose
 *
 */
public class Datos {

    public ArrayList<Carta> cargarDatos(String nombre) {

        BufferedReader buffer = null;
        ArrayList<Carta> mazo = new ArrayList<Carta>();

        if (nombre == null) {
            nombre = "mazo1.csv";
        }

        try {
            
            String line;
            buffer = new BufferedReader(new FileReader(nombre));

            boolean firstLine = false;
            while ((line = buffer.readLine()) != null) {
                //Nos saltiamos la primera del archivo ya que son los nombres de las columna
                if (firstLine) {
                    firstLine = true;
                } else {
                    mazo.add(csvToCarta(line));
                }
            }

            return mazo;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    // Convertir CSV a ArrayList utilizando el metodo Split
    private Carta csvToCarta(String csvLine) {
        Carta carta = new Carta();

        if (csvLine != null) {
            String[] splitData = csvLine.split("\\s*,\\s*");
            //if(splitData[1].compareTo("criatura")){
                
            //}
        }

        return carta;
    }

}
