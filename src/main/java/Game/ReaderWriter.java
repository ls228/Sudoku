package Game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReaderWriter {
    /**
     * Creates new entry in counter.text
     */
    public void write(int gameSolved) {

        try {

            FileWriter myWriter = new FileWriter("src/main/resources/counter.txt", true);
            // Die Einträge werden in einer Datei gespeichert.
            myWriter.write(gameSolved+"\n");
            myWriter.close();

        } catch (IOException e) {
            System.out.println("Error. Data not found.");
            e.printStackTrace();
        }
    }

    /**
     * Diese Methode ermöglicht das lesen der Einträge innerhalb der Textdatei
     * @return Textdatei Einträge
     */
    public List<String> read() {

        List<String> entries = new ArrayList<>();
        try {
            BufferedReader newReader = new BufferedReader(new FileReader("src/main/resources/counter.txt"));
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

    public void removeEntries() {
        try {
            FileWriter fw = new FileWriter("counter.txt");
            fw.write("");
            fw.close();
        } catch ( IOException ioex ) {
            System.out.println("Fehler");
        }
    }
}
