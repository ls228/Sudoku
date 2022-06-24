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

        } catch (IOException e) {
            log.error(e.getStackTrace() + "Error. Data not found.");
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
                log.info("Added new count of solved games");
            }
            newReader.close();
        } catch (IOException e) {
            log.error(e.getStackTrace() + "File " + url + "could not found.");
        }
        log.info("Count solved levels is " +entries.size());
        return entries;
    }

    public void removeEntries(String url) {
        try {
            FileWriter fw = new FileWriter(url);
            fw.write("");
            fw.close();
        } catch ( IOException e ) {
            log.error(e.getStackTrace()+" File could not be found");
        }
    }
}