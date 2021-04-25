import java.util.*;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Pair;
public class Engimon {
    protected String name;
    protected Species speciesName;
    protected String teksUnik;
    protected ArrayList<Pair<String, Species>> parent;
    protected ArrayList<Skill> skills;
    protected ArrayList<ElementType> elements;
    protected Species speciesPapa;
    protected Species speciesMama;
    protected int level;
    protected int currExp;
    protected int maxExp;
    protected Point location;
    protected char icon;
    protected String imagePath;
//    protected ImageView photo;

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
        this.imagePath = "main/resources/pikachu.png";
//        this.photo = new ImageView(new Image(imagePath));
    }

    public Engimon(String name_, Species speciesName_, String namaPapa, String namaMama,
                   ArrayList<Skill> skill_, int X_, int Y_){
        String path = "main/resources/";
        String png = ".png";
        this.name = name_;
        this.speciesName = speciesName_;
        this.parent = new ArrayList<Pair<String, Species>>();
        this.skills = skill_;
        this.level = 1;
        this.currExp = 0;
        this.maxExp = 100;
        this.location = new Point();
        this.location.setX(X_);
        this.location.setY(Y_);
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
            this.imagePath = path+"charizard"+png;
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
            this.imagePath = path+"squirtle"+png;

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
            this.imagePath = path+"pikachu"+png;

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
            this.imagePath = path+"mudkip"+png;

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
            this.imagePath = path+"gabumon"+png;
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
            this.imagePath = path+"charkachu"+png;

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
            this.imagePath = path+"squirmon"+png;

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
            this.imagePath = path+"mudtle"+png;

        }
//        this.photo = new ImageView(new Image(imagePath));

    }

    public Engimon(String name_, Species speciesName_, String namaPapa, String namaMama, 
    Species speciesPapa, Species speciesMama, ArrayList<Skill> skill_, int X_, int Y_){
        this.name = name_;
        this.speciesName = speciesName_;
        this.parent = new ArrayList<Pair<String, Species>>();
        this.skills = skill_;
        this.level = 1;
        this.currExp = 0;
        this.maxExp = 100;
        this.location = new Point();
        String path = "main/resources/";
        String png = ".png";
        if (this.speciesName == Species.Charizard)
        {
            this.icon = 'f';
            this.teksUnik = "charrrizard_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.FIRE);
            this.imagePath = path+"charizard"+png;

        }
        else if (this.speciesName == Species.Squirtle)
        {
            this.icon = 'w';
            this.teksUnik = "squirtle_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.WATER);
            this.imagePath = path+"squirtle"+png;

        }
        else if (this.speciesName == Species.Pikachu)
        {
            this.icon = 'e';
            this.teksUnik = "pikachu_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.ELECTRIC);
            this.imagePath = path+"pikachu"+png;

        }
        else if (this.speciesName == Species.Mudkip)
        {
            this.icon = 'g';
            this.teksUnik = "mudkip_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.GROUND);
            this.imagePath = path+"mudkip"+png;

        }
        else if (this.speciesName == Species.Gabumon)
        {
            this.icon = 'i';
            this.teksUnik = "gabumon_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.ICE);
            this.imagePath = path+"gabumon"+png;

        }
        else if (this.speciesName == Species.Charkachu)
        {
            this.icon = 'l';
            this.teksUnik = "charkachu_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.FIRE);
            this.elements.add(ElementType.ELECTRIC);
            this.imagePath = path+"charkachu"+png;

        }
        else if (this.speciesName == Species.Squirmon)
        {
            this.icon = 's';
            this.teksUnik = "squirmon_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.WATER);
            this.elements.add(ElementType.ICE);
            this.imagePath = path+"squirmon"+png;

        }
        else if (this.speciesName == Species.Mudtle)
        {
            this.icon = 'n';
            this.teksUnik = "mudtle_";
            this.elements = new ArrayList<ElementType>();
            this.elements.add(ElementType.WATER);
            this.elements.add(ElementType.GROUND);
            this.imagePath = path+"mudtle"+png;

        }
        this.parent.add(new Pair<String, Species>(namaPapa, speciesPapa));
        this.parent.add(new Pair<String, Species>(namaMama, speciesMama));
//        this.photo = new ImageView(new Image(imagePath));

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
    public ArrayList<Skill> getSkills(){
        return this.skills;
    }

    // Setter & Getter Element
    public void setElements(ElementType newElement){
        this.elements.add(newElement);
    }
    public ArrayList<ElementType> getElements(){
        return this.elements;
    }

    // Getter First Element
    public ElementType getFirstElement() {
        return this.getElements().get(0);
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

    // Setter & Getter Location
    public void setLocation(int x, int y){
        this.location = new Point();
        setY(y);
        setX(x);
    }

    public Point getLocation(){
        return this.location;
    }

    // Setter & Getter Icon
    public void setIcon(char newIcon){
        this.icon = newIcon;
    }

    public char getIcon(){
        return this.icon;
    }
    // Setter & Getter imagePath
    public void setImagePath(String path) {
        this.imagePath = path;
    }
    public String getImagePath() {
        return this.imagePath;
    }

    public void updateEngimonLevel(){
        if (this.currExp > this.maxExp){
            // int currExp_ = this.currExp % this.maxExp;
            // setCurrExp(currExp_);
            setLevel(getLevel() + 1);
            setMaxExp(getLevel()*100);
        }
    }
    public boolean isSkillFull() {
        return this.skills.size() == 4;
    }
    public void replace(Skill skillLama, Skill skillBaru) {
        for (Skill skill:this.skills) {
            if (skill.getSkillName().equals(skillLama.getSkillName())) {
                skillLama = skillBaru;
            }
        }
    }

    public static Comparator<Engimon> engimonLevelComparator = new Comparator<Engimon>() {

        @Override
        public int compare(Engimon e1, Engimon e2) {
            Integer level1 = e1.getLevel();
            Integer level2 = e2.getLevel();
            // descending order
            return level2.compareTo(level1);
        }};

//    public static Comparator<Engimon> engimonComparator = new Comparator<Engimon>() {
//
//        @Override
//        public int compare(Engimon e1, Engimon e2) {
//            Integer level1 = e1.getLevel();
//            Integer level2 = e2.getLevel();
//            // descending order
//            return level2.compareTo(level1);
//        }};
    public void learnSkill(Skill s){
        int count = 0;
        boolean found = false;
        boolean learned = false;
        boolean compatible = false;
        while (count < this.skills.size() && !learned){
            if (this.skills.get(count).getSkillName() == s.getSkillName()){
                learned = true;
            }
            count++;
        }

        if (!learned){
            for (int i = 0; i < s.getLearnableElements().size(); i++){
                for (int j = 0; j < this.elements.size(); j++){
                    if (this.elements.get(j) == s.getLearnableElements().get(i)){
                        compatible = true;
                    }
                }
            }
        }

        if (!learned){
            if (compatible == true){
                learned = true;
                s.setMasteryLevel(1);
                setSkills(s);
                System.out.println("Skill dipelajari");
            }
            else{
                System.out.println("Elemen tidak kompatibel");
            }
        }
        else{
            System.out.println("Skill sudah dipelajari");
        }

    }

    @Override
    public String toString() {
        return "Engimon{" +
                "name='" + name + '\'' +
                ", speciesName=" + speciesName +
                ", teksUnik='" + teksUnik + '\'' +
                ", parent=" + parent +
                ", skills=" + skills +
                ", elements=" + elements +
                ", speciesPapa=" + speciesPapa +
                ", speciesMama=" + speciesMama +
                ", level=" + level +
                ", currExp=" + currExp +
                ", maxExp=" + maxExp +
//                ", location=" + location +
//                ", icon=" + icon +
//                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public void printInfo() {
        System.out.println("Engimon Name: " + this.name);
        System.out.println("Species: " + this.speciesName);
        System.out.println("TeksUnik: " + this.teksUnik);
        System.out.println("Parent: " + this.parent);
        System.out.print("Skill(s): ");
        for (int i = 0; i < this.skills.size(); i++){
            if (i != this.skills.size()-1){
                System.out.print(this.skills.get(i).getSkillName()+" (lv. " + this.skills.get(i).getMasteryLevel() + ")" +", ");
            }
            else{
                System.out.print(this.skills.get(i).getSkillName()+" (lv. " + this.skills.get(i).getMasteryLevel() + ")");
            }

        }
        System.out.println();

        System.out.print("Element(s): ");
        for (int i = 0; i < this.elements.size(); i++){
            if (i != this.elements.size()-1){
                System.out.print(this.elements.get(i)+", ");
            }
            else{
                System.out.print(this.elements.get(i));
            }

        }
        System.out.println();

        System.out.println("Level: " + this.level);
        System.out.println("Current EXP: " + this.currExp);
        System.out.println("Max EXP: " + this.maxExp);
        System.out.println("X: " + this.location.getX());
        System.out.println("Y: " + this.location.getY());
        System.out.println("Icon: " + this.icon);
    }

    public Species findDualSpecies(ElementType elType){
        switch (this.elements.get(0))
        {
            case FIRE:
                switch (elType)
                {
                case ELECTRIC:
                    return Species.Charkachu;
                
                default:
                    break;
                }
                break;
            
            case WATER:
                switch (elType)
                {
                case GROUND:
                    return Species.Mudtle;
                
                case ICE:
                    return Species.Squirmon;
    
                default:
                    break;
                }
            
            case ELECTRIC:
                switch (elType)
                {
                case FIRE:
                    return Species.Charkachu;
    
                default:
                    break;
                }
    
            case ICE:
                switch (elType)
                {
                case WATER:
                    return Species.Squirmon;
    
                default:
                    break;
                }
    
            case GROUND:
                switch (elType)
                {
                case WATER:
                    return Species.Mudtle;

                default:
                    break;
                }

            //default: return NULL; null gakebaca di spesies
            default: return Species.Charizard;
        }
        //default: return NULL
        return  Species.Charizard;
    }



    public static void main(String args[]){
//        Engimon A = new Engimon();
//        A.printInfo();
//        A.setX(3);
//        A.printInfo();
//        System.out.println();
        Skill fireSkill = new Skill("FireSkill", 100, 1, ElementType.FIRE);
//        A.learnSkill(fireSkill);
//        System.out.println();
//        A.printInfo();
//        System.out.println("NEW ENGIMON");
        Skill waterSkill = new Skill("WaterSkill", 100, 1, ElementType.WATER);
//        Engimon B = new Engimon("Haihai", Species.Mudtle, "New Daddy", "New Mommy", waterSkill,1, 1);
//        B.printInfo();
//        B.setCurrExp(102);
//        B.updateEngimonLevel();
//        B.learnSkill(fireSkill);
//        System.out.println("AFTER LEVEL UP & LEARN NEW SKILL");
//        B.printInfo();
    }
}
