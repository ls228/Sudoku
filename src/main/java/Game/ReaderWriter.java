package Game;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReaderWriter {

    private static final Logger log = LogManager.getLogger(ReaderWriter.class);

    /**
     * Creates new entry in counter.txt
     */

    public void write(int gameSolved, String url) {

        try {
            FileWriter myWriter = new FileWriter(url, true);
            // Die Einträge werden in einer Datei gespeichert.
            myWriter.write(gameSolved+"\n");
            myWriter.close();

        } catch (IOException ioe) {
            log.error("Error. Data not found.");
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
            log.error("Error. Data not found.");
        }
        log.info("Count solved levels is " +entries.size());
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