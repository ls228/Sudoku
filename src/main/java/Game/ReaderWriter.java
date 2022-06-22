package Game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReaderWriter {

    /**
     * Diese Methode erstellt neue Einträge in der Textdatei
     */

    public void write(int gameSolved, String url) {

        try {
            FileWriter myWriter = new FileWriter(url, true);
            System.out.println("hier");
            // Die Einträge werden in einer Datei gespeichert.
            myWriter.write(gameSolved+"\n");
            myWriter.close();

        } catch (IOException ioe) {
            System.out.println("Error. Data not found.");
            ioe.printStackTrace();
        }
    }

    /**
     * Diese Methode ermöglicht das lesen der Einträge innerhalb der Textdatei
     * @return Textdatei Einträge
     */
    public List<String> read(String url) {

        List<String> entries = new ArrayList<>();
        try {
            BufferedReader newReader = new BufferedReader(new FileReader(url));
            String line;
            while ((line = newReader.readLine()) != null) {
                entries.add(line);
            }
            newReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(entries.size());
        return entries;
    }

    /*
    public void removeEntries() {
        try {
            FileWriter fw = new FileWriter("counter.txt");
            fw.write("");
            fw.close();
        } catch ( IOException ioex ) {
            System.out.println("Fehler");
        }
    }*/
}
