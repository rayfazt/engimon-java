import javafx.util.Pair;
import java.util.*;
import java.util.List;

enum species {Charizard, Squirtle, Pikachu, Mudkip, Gabumon, Charkachu, Squirmon, Mudtle};

public class Engimon {
    protected String name;
    protected species speciesName;
    protected String teksUnik;
    protected List<Pair<String, species>> parent;
    protected List<String> skills;
    protected List<ElementType> elements;

    protected int level;
    protected int currExp;
    protected int maxExp;
    protected List<Integer> location;
    protected char icon;

    public Engimon(){
        this.name = "Engimomon";
        this.speciesName = species.Charizard;
        this.teksUnik = "EngimomonChar";
        this.parent = new ArrayList<Pair<String, species>>();
        this.parent.add(new Pair<String, species>("Daddy", species.Charizard));
        this.parent.add(new Pair<String, species>("Mommy", species.Charizard));
        this.skills = new ArrayList<String>();
        this.skills.add("Boom");
        this.elements = new ArrayList<ElementType>();
        this.elements.add(ElementType.FIRE);
        this.level = 1;
        this.currExp = 0;
        this.maxExp = 100;
        this.location = new ArrayList<Integer>();
        this.location.add(0);
        this.location.add(0);
        this.icon = 'f';
    }

    public Engimon(String name_, species speciesName_, String namaPapa, species speciesPapa, String namaMama, species speciesMama,
                   String skill_, ElementType elemen, int X_, int Y_){
        this.name = name_;
        this.speciesName = speciesName_;
        this.parent = new ArrayList<Pair<String, species>>();
        this.parent.add(new Pair<String, species>(namaPapa, speciesPapa));
        this.parent.add(new Pair<String, species>(namaMama, speciesMama));
        this.skills = new ArrayList<String>();
        this.skills.add(skill_);
        this.elements = new ArrayList<ElementType>();
        this.elements.add(elemen);
        this.level = 1;
        this.currExp = 0;
        this.maxExp = 100;
        this.location = new ArrayList<Integer>();
        this.location.add(X_);
        this.location.add(Y_);
        if (this.speciesName == species.Charizard)
        {
            this.icon = 'f';
            this.teksUnik = "charrrizard";
        }
        else if (this.speciesName == species.Squirtle)
        {
            this.icon = 'w';
            this.teksUnik = "squirtlelelelle";
        }
        else if (this.speciesName == species.Pikachu)
        {
            this.icon = 'e';
            this.teksUnik = "pikachuuu";
        }
        else if (this.speciesName == species.Mudkip)
        {
            this.icon = 'g';
            this.teksUnik = "mudkipipipip";
        }
        else if (this.speciesName == species.Gabumon)
        {
            this.icon = 'i';
            this.teksUnik = "Gabu gabu";
        }
        else if (this.speciesName == species.Charkachu)
        {
            this.icon = 'l';
            this.teksUnik = "charkachuuu";
        }
        else if (this.speciesName == species.Squirmon)
        {
            this.icon = 's';
            this.teksUnik = "squirmon mon mon";
        }
        else if (this.speciesName == species.Mudtle)
        {
            this.icon = 'n';
            this.teksUnik = "mudtlelelle";
        }
    }

    // Setter & Getter name
    public void setName(String newName){
        this.name = newName;
    }
    public String getName(){
        return this.name;
    }

    // Setter & Getter name
    public void setSpeciesName(species newSpecies){
        this.speciesName = newSpecies;
    }
    public species getSpeciesName() {
        return this.speciesName;
    }

    // Setter & Getter TeksUnik
    public void setTeksUnik(String newTeksUnik){
        this.teksUnik = newTeksUnik;
    }
    public String getTeksUnik(){
        return this.teksUnik;
    }

    // Setter & Getter Papa
    public void setNamaPapa(String newNamaPapa){
        this.parent.set(0, new Pair<String, species>(newNamaPapa, this.parent.get(0).getValue()));
    }
    public String getNamaPapa(){
        return this.parent.get(0).getKey();
    }

    // Setter & Getter Mama
    public void setNamaMama(String newNamaMama){
        this.parent.set(1, new Pair<String, species>(newNamaMama, this.parent.get(1).getValue()));
    }
    public String getNamaMama(){
        return this.parent.get(1).getKey();
    }

    // Setter & Getter Species Papa
    public void setElementPapa(species newSpeciesPapa){
        this.parent.set(0, new Pair<String, species>(this.parent.get(0).getKey(), newSpeciesPapa));
    }
    public species getElementPapa(){
        return this.parent.get(0).getValue();
    }

    // Setter & Getter Species Mama
    public void setElementMama(species newSpeciesMama){
        this.parent.set(0, new Pair<String, species>(this.parent.get(1).getKey(), newSpeciesMama));
    }
    public species getElementMama(){
        return this.parent.get(1).getValue();
    }

    // Setter & Getter Skills
    public void setSkills(String newSkill){
        this.skills.add(newSkill);
    }
    public List<String> getSkills(){
        return this.skills;
    }

    // Setter & Getter Element
    public void setElements(ElementType newElement){
        this.elements.add(newElement);
    }
    public List<ElementType> getElements(){
        return this.elements;
    }

    // Setter & Getter Level
    public void setLevel(int newLevel){
        this.level = newLevel;
    }

    public int getLevel(){
        return this.level;
    }

    // Setter & Getter currExp
    public void setCurrExp(int newCurrExp){
        this.currExp = newCurrExp;
    }
    public int getCurrExp(){
        return this.currExp;
    }

    // Setter & Getter maxExp
    public void setMaxExp(int newMaxExp){
        this.maxExp = newMaxExp;
    }
    public int getMaxExp(){
        return this.maxExp;
    }

    // Setter & Getter X
    public void setX(int newX){
        this.location.set(0, newX);
    }
    public int getX(){
        return this.location.get(0);
    }

    // Setter & Getter Y
    public void setY(int newY){
        this.location.set(1, newY);
    }
    public int getY(){
        return this.location.get(1);
    }

    // Setter & Getter Icon
    public void setIcon(char newIcon){
        this.icon = newIcon;
    }

    public char getIcon(){
        return this.icon;
    }

    public void updateEngimonLevel(){
        if (this.currExp > this.maxExp){
            int currExp_ = this.currExp % this.maxExp;
            setCurrExp(currExp_);
            setLevel(getLevel() + 1);
            setMaxExp(getLevel()*100);
        }
    }

    public void printInfo() {
        System.out.println("Engimon Name: " + this.name);
        System.out.println("Species: " + this.speciesName);
        System.out.println("TeksUnik: " + this.teksUnik);
        System.out.println("Parent: " + this.parent);
        System.out.println("Skill(s): " + this.skills);
        System.out.println("Element(s): " + this.elements);
        System.out.println("Level: " + this.level);
        System.out.println("Current EXP: " + this.currExp);
        System.out.println("Max EXP: " + this.maxExp);
        System.out.println("Location: " + this.location);
        System.out.println("Icon: " + this.icon);
    }

//    public static void main(String args[]){
//        Engimon A = new Engimon();
//        A.printInfo();
//        System.out.println("NEW ENGIMON");
//        Engimon B = new Engimon("Haihai", species.Charkachu, "New Daddy", species.Charkachu, "New Mommy", species.Charkachu,
//                "BoomyBoom", ElementType.ELECTRIC,1, 1);
//        B.printInfo();
//        B.setCurrExp(102);
//        B.updateEngimonLevel();
//        System.out.println("AFTER LEVEL UP");
//        B.printInfo();
//    }
}