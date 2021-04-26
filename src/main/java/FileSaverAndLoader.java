import java.io.*;
import java.util.ArrayList;

public class FileSaverAndLoader{

    public static void savePlayer(Player p){
        String filename = "player.txt";

        //Serialization
        try {
            // Saving of object in a file
            System.out.println("Saving Player");
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            System.out.println("Set up save file");
            // Method for serialization of object
            out.writeObject(p);
            System.out.println("Save successful");
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    public static Player loadPlayer(){
        String filename = "player.txt";
        boolean cont = true;
        ArrayList<Player> player= new ArrayList<Player>();
        // Deserialization
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            // Reading the object from a file
            // Method for deserialization of object
            Player p = (Player)in.readObject();
            if (p != null) {
                player.add(p);
                System.out.println("Player loaded");
            }
            in.close();
            file.close();
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + " is caught");
        }
        Player player1 = player.get(0);
        return player1;
    }

    public static void saveWildEngimons(ArrayList<WildEngimon> listOfWildEngimon){
        String filename = "wildEngimon.txt";

        //Serialization
        try {
            // Saving of object in a file
            System.out.println("Saving Wild Engimons");
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            System.out.println("Set up save file");
            // Method for serialization of object
            for (WildEngimon engimon: listOfWildEngimon) {
                out.writeObject(engimon);
            }
            System.out.println("Save successful");
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    public static ArrayList<WildEngimon> loadWildEngimons(){
        String filename = "wildEngimon.txt";
        ArrayList<WildEngimon> engimonList = new ArrayList<WildEngimon>();
        boolean cont = true;
        // Deserialization
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            while (cont) {
                // Reading the object from a file
                // Method for deserialization of object
                WildEngimon engimon = (WildEngimon) in.readObject();
                if (engimon != null) {
                    engimonList.add(engimon);
                } else {
                    cont = false;
                }
            }
            in.close();
            file.close();
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + " is caught");
        }

        System.out.println("Wild Engimons Loaded");
        return engimonList;
    }

    /*public static void main(String[] args){
        Player player = new Player();
        WildEngimon e1 = new WildEngimon();
        ArrayList<Skill> lskill = new ArrayList<Skill>();
        lskill.add(new Skill());
        WildEngimon object2 = new WildEngimon("Aloha", Species.Charizard, "Aloha Papa", "Aloha Mama", lskill, 0, 0);
        ArrayList<WildEngimon> listWild = new ArrayList<WildEngimon>();
        listWild.add(e1);
        listWild.add(object2);
        //saveEngimon();
        //loadEngimon();
        savePlayer(player);
        Player player1 = loadPlayer();
        player1.stringListEngimon();
        player1.stringActiveEngimon();
        saveWildEngimons(listWild);
        ArrayList<WildEngimon> listWildLoad = loadWildEngimons();

        for(WildEngimon engi : listWildLoad){
            engi.printInfo();
        }
    }*/
}