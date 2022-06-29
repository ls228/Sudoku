package de.sudoku.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
            // count is saved in text file
            myWriter.write(gameSolved+"\n");
            myWriter.close();

        } catch (IOException e) {
            log.error(e.getStackTrace() + "Error. Data not found.");
        }
    }


    /**
     * This method enables reading all entries in the counter file
     * @param url counter.txt
     * @return array with all entries
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
            log.error(e.getStackTrace() + "File " + url + " not found.");
        }
        log.info("'Solved levels'-Counter is " +entries.size());
        return entries;
    }

    /**
     * This method enables removing all entries of the counter file
     * We use it for resetting the game score
     * @param url counter.txt
     */
    public void removeEntries(String url) {
        try {
            FileWriter fw = new FileWriter(url);
            fw.write("");
            fw.close();
            log.info("Reset game");
        } catch (IOException e) {
            log.error(e.getStackTrace()+" File could not be found");
        }
    }
}