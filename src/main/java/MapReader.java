import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapReader {
    /* 
    Format File txt
    m --> Mountains
    s --> Sea
    g --> Grassland
    t --> Tundra
    */

    private File txtFile;
    private String separator;
    
    public MapReader(String filename, String separator){
        this.txtFile = new File(filename);
        this.separator = separator;
    }

    public List<String[]> read() throws IOException {
        String line;
        FileReader fileReader = new FileReader(this.txtFile);
        BufferedReader br = new BufferedReader(fileReader);
        ArrayList<String[]> list = new ArrayList<String[]>();

        while ((line = br.readLine()) != null) {
            String[] row = line.split(this.separator);
            for (int i = 0; i < row.length; i++) {
                String val = row[i];
                if (val.length() >= 2 && val.charAt(0) == '"' && val.charAt(val.length() - 1) == '"') {
                    row[i] = val.substring(1, val.length() - 1);
                }
            }
            list.add(row);
        }
        return list;
    }
}