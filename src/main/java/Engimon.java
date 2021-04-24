import javafx.util.Pair;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class Engimon {
    protected String name;
    protected Species speciesName;
    protected String teksUnik;
    protected List<Pair<String, Species>> parent;
    protected List<Skill> skills;
    protected List<ElementType> elements;
    protected Species speciesPapa;
    protected Species speciesMama;
    protected int level;
    protected int currExp;
    protected int maxExp;
    protected Point location;
    protected char icon;

    public Engimon(){
        this.name = "Engimomon";
        this.speciesName = Species.Charizard;
        this.teksUnik = "EngimomonChar";
        this.parent = new ArrayList<Pair<String, Species>>();
        this.speciesPapa = Species.Charizard;
        this.speciesMama = Species.Charizard;
        this.parent.add(new Pair<String, Species>("Daddy", this.speciesPapa));
        this.parent.add(new Pair<String, Species>("Mommy", this.speciesMama));
        this.skills = new ArrayList<Skill>();
        Skill defaultSkill = new Skill();
        this.skills.add(defaultSkill);
        this.elements = new ArrayList<ElementType>();
        this.elements.add(ElementType.FIRE);
        this.level = 1;
        this.currExp = 0;
        this.maxExp = 100;
        this.location = new Point();
        this.icon = 'f';
    }

    public Engimon(String name_, Species speciesName_, String namaPapa, String namaMama,
                   Skill skill_, int X_, int Y_){
        this.name = name_;
        this.speciesName = speciesName_;
        this.parent = new ArrayList<Pair<String, Species>>();
        this.skills = new ArrayList<Skill>();
        this.skills.add(skill_);
        this.level = 1;
        this.currExp = 0;
        this.maxExp = 100;
        this.location = new Point();
        if (this.speciesName == Species.Charizard)
        {
            this.icon = 'f';
            this.teksUnik = "charrrizard_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.FIRE);
            this.speciesPapa = Species.Charizard;
            this.speciesMama = Species.Charizard;
            this.parent.add(new Pair<String, Species>(namaPapa, this.speciesPapa));
            this.parent.add(new Pair<String, Species>(namaMama, this.speciesMama));
        }
        else if (this.speciesName == Species.Squirtle)
        {
            this.icon = 'w';
            this.teksUnik = "squirtle_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.WATER);
            this.speciesPapa = Species.Squirtle;
            this.speciesMama = Species.Squirtle;
            this.parent.add(new Pair<String, Species>(namaPapa, this.speciesPapa));
            this.parent.add(new Pair<String, Species>(namaMama, this.speciesMama));
        }
        else if (this.speciesName == Species.Pikachu)
        {
            this.icon = 'e';
            this.teksUnik = "pikachu_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.ELECTRIC);
            this.speciesPapa = Species.Pikachu;
            this.speciesMama = Species.Pikachu;
            this.parent.add(new Pair<String, Species>(namaPapa, this.speciesPapa));
            this.parent.add(new Pair<String, Species>(namaMama, this.speciesMama));
        }
        else if (this.speciesName == Species.Mudkip)
        {
            this.icon = 'g';
            this.teksUnik = "mudkip_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.GROUND);
            this.speciesPapa = Species.Mudkip;
            this.speciesMama = Species.Mudkip;
            this.parent.add(new Pair<String, Species>(namaPapa, this.speciesPapa));
            this.parent.add(new Pair<String, Species>(namaMama, this.speciesMama));
        }
        else if (this.speciesName == Species.Gabumon)
        {
            this.icon = 'i';
            this.teksUnik = "gabumon_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.ICE);
            this.speciesPapa = Species.Gabumon;
            this.speciesMama = Species.Gabumon;
            this.parent.add(new Pair<String, Species>(namaPapa, this.speciesPapa));
            this.parent.add(new Pair<String, Species>(namaMama, this.speciesMama));
        }
        else if (this.speciesName == Species.Charkachu)
        {
            this.icon = 'l';
            this.teksUnik = "charkachu_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.FIRE);
            this.elements.add(ElementType.ELECTRIC);
            this.speciesPapa = Species.Charizard;
            this.speciesMama = Species.Pikachu;
            this.parent.add(new Pair<String, Species>(namaPapa, this.speciesPapa));
        }
        else if (this.speciesName == Species.Squirmon)
        {
            this.icon = 's';
            this.teksUnik = "squirmon_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.WATER);
            this.elements.add(ElementType.ICE);
            this.speciesPapa = Species.Squirtle;
            this.speciesMama = Species.Gabumon;
            this.parent.add(new Pair<String, Species>(namaPapa, this.speciesPapa));
            this.parent.add(new Pair<String, Species>(namaMama, this.speciesMama));
        }
        else if (this.speciesName == Species.Mudtle)
        {
            this.icon = 'n';
            this.teksUnik = "mudtle_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.WATER);
            this.elements.add(ElementType.GROUND);
            this.speciesPapa = Species.Mudkip;
            this.speciesMama = Species.Squirtle;
            this.parent.add(new Pair<String, Species>(namaPapa, this.speciesPapa));
            this.parent.add(new Pair<String, Species>(namaMama, this.speciesMama));
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
    public void setSpeciesName(Species newSpecies){
        this.speciesName = newSpecies;
    }
    public Species getSpeciesName() {
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
        this.parent.set(0, new Pair<String, Species>(newNamaPapa, this.parent.get(0).getValue()));
    }
    public String getNamaPapa(){
        return this.parent.get(0).getKey();
    }

    // Setter & Getter Mama
    public void setNamaMama(String newNamaMama){
        this.parent.set(1, new Pair<String, Species>(newNamaMama, this.parent.get(1).getValue()));
    }
    public String getNamaMama(){
        return this.parent.get(1).getKey();
    }

    // Setter & Getter Species Papa
    public void setSpeciesPapa(Species newSpeciesPapa){
        this.parent.set(0, new Pair<String, Species>(this.parent.get(0).getKey(), newSpeciesPapa));
    }
    public Species getSpeciesPapa(){
        return this.parent.get(0).getValue();
    }

    // Setter & Getter Species Mama
    public void setSpeciesMama(Species newSpeciesMama){
        this.parent.set(0, new Pair<String, Species>(this.parent.get(1).getKey(), newSpeciesMama));
    }
    public Species getSpeciesMama(){
        return this.parent.get(1).getValue();
    }

    // Setter & Getter Skills
    public void setSkills(Skill newSkill){
        this.skills.add(newSkill);
    }
    public List<Skill> getSkills(){
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
        this.location.setX(newX);
    }
    public int getX(){
        return this.location.getX();
    }

    // Setter & Getter Y
    public void setY(int newY){
        this.location.setY(newY);
    }
    public int getY(){
        return this.location.getY();
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
        System.out.println("Skill(s): " + this.skills.get(0).getSkillName());
        System.out.println("Element(s): " + this.elements);
        System.out.println("Level: " + this.level);
        System.out.println("Current EXP: " + this.currExp);
        System.out.println("Max EXP: " + this.maxExp);
        System.out.println("X: " + this.location.getX());
        System.out.println("Y: " + this.location.getY());
        System.out.println("Icon: " + this.icon);
    }

//    public static void main(String args[]){
//        Engimon A = new Engimon();
//        A.printInfo();
//        A.setX(3);
//        A.printInfo();
//        Skill defSkill = new Skill();
//        System.out.println("NEW ENGIMON");
//        Engimon B = new Engimon("Haihai", Species.Mudtle, "New Daddy", "New Mommy",
//                defSkill,1, 1);
//        B.printInfo();
////        B.printInfo();
////        B.setCurrExp(102);
////        B.updateEngimonLevel();
////        System.out.println("AFTER LEVEL UP");
////        B.printInfo();
    }
//}
