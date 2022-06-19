package mainpackage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReaderWriter {
    /**
     * Diese Methode erstellt neue Einträge in der Textdatei
     */
    public static void write(int count) {

        try {

            FileWriter myWriter = new FileWriter("C:\\Users\\DELL\\Documents\\Semester 2\\SE2\\src\\main\\resources\\counter.txt", true);
            // Die Einträge werden in einer Datei gespeichert.
            myWriter.write(String.valueOf(count));
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
    public static List<String> read() {

        List<String> entries = new ArrayList<>();
        try {
            BufferedReader newReader = new BufferedReader(new FileReader("C:\\Users\\DELL\\Documents\\Semester 2\\SE2\\src\\main\\resources\\counter.txt"));
            String line;
            while ((line = newReader.readLine()) != null) {
                entries.add(line+",");
            }
            newReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(entries.size());
        return entries;
    }

    public static void removeEntries() {
        try {
            FileWriter fw = new FileWriter("counter.txt");
            fw.write("");
            fw.close();
        } catch ( IOException ioex ) {
            System.out.println("Fehler");
        }
    }
}

