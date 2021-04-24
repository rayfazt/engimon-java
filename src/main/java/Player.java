import java.util.*;
import java.util.stream.Collectors;
import javafx.util.Pair;


public class Player {
    private Point location;
    private char icon;
    private Engimon activeEngimon;
    private Inventory<SkillItem> listSkill;
    private Inventory<Engimon> listEngimon;

    public Player() {
        // default constructor
        location = new Point();
        icon = 'P';
        activeEngimon = new Engimon();
        listSkill = new Inventory<SkillItem>();
        listEngimon = new Inventory<Engimon>();
    }

    // Getter & Setter location
    public Point getPlayerLocation() {
        return this.location;
    }
    public void setPlayerLocation(int x, int y) throws OutOfMapException{
        if (x < 0 || x > 9 || y < 0 || y > 11) // NOTE : angkanya nyesuain map
        {
            throw new OutOfMapException("Tidak bisa keluar dari map"); // ini kyknya diganti sama kelas exception
        }
        this.location.setX(x);
        this.location.setY(y);
    }

    // Getter & Setter icon
    public char getIcon() {
        return this.icon;
    }
    public void setIcon(char icon) {
        this.icon = icon;
    }

    public void move(char dir) {
        if (dir == 'w') {
            try
            {
                int x = getPlayerLocation().getX();
                int y = getPlayerLocation().getY() - 1;
                setPlayerLocation(x, y); // Kalo ga valid dia throw
            }
            catch(OutOfMapException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else if (dir == 'a') {
            try
            {
                int x = getPlayerLocation().getX() - 1;
                int y = getPlayerLocation().getY();
                setPlayerLocation(x, y);
            }
            catch(OutOfMapException e)
            {
                System.out.println(e.getMessage());
            }      
        }
        else if (dir == 's') {
            try
            {
                int x = getPlayerLocation().getX();
                int y = getPlayerLocation().getY() + 1;
                setPlayerLocation(x, y);          
            }
            catch(OutOfMapException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else if (dir == 'd') {
            try
            {
                int x = getPlayerLocation().getX() + 1;
                int y = getPlayerLocation().getY();
                setPlayerLocation(x, y);          
            }
            catch(OutOfMapException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public Engimon getActiveEngimon() {
        return this.activeEngimon;
    }

    public void setActiveEngimon(Engimon engi) {
        // Cari engimon
        boolean found = false;
        ArrayList<Engimon> listEngimon = this.getEngimonInventory();
        
        for (Engimon engimon : listEngimon) {
            if (engimon.getName().equals(engi.getName())){
                found = true;
            }
        }
        if (!found) {
            System.out.println("Engimon pilihan tidak ada di dalam inventory");
        }
        else {
            // tambahin current active engimon ke inventory
            listEngimon.addItem(this.getActiveEngimon());
            // remove active engimon yang baru dari inventory
            listEngimon.
            // set active engimon baru
            this.activeEngimon = engi;
        }
    }

    public void breed(Engimon e1, Engimon e2) throws BreedException {
        if (e1.getLevel() < 4 || e2.getLevel() < 4){
            throw new BreedException("Level parent tidak cukup untuk melakukan breeding");
        }

        e1.setLevel(e1.getLevel() - 3);
        e2.setLevel(e2.getLevel() - 3);

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama Engimon anak: ");
        String namaAnak = sc.nextLine();

        ArrayList<Element> elAnak = new ArrayList<Element>();
        ArrayList<Skill> candidateSkill = new ArrayList<Skill>();
        ArrayList<Skill> skillAnak = new ArrayList<Skill>();
        
        // Penentuan elemen dan spesies anak
        if(e1.getElements().get(0).getElementName() == e2.getElements().get(0).getElementName()){
            elAnak.add(e1.getElements().get(0));
            Species spAnak = e1.getSpeciesName();
            
        }
        else{
            if(e1.getElements().get(0).getElementAdvantage(e2.getElements().get(0)) > 1){
                elAnak.add(e1.getElements().get(0));
                Species spAnak = e1.getSpeciesName();
            }
            else{
                if(e1.getElements().get(0).getElementAdvantage(e2.getElements().get(0)) == 1){
                    elAnak.add(e1.getElements().get(0));
                    elAnak.add(e2.getElements().get(0));
                    Species spAnak = e1.findDualSpecies(e2.getElements().get(0));
                }
                else{
                    elAnak.add(e2.getElements().get(0));
                    Species spAnak = e2.getSpeciesName();
                }
            }
        }

        //Inherit skill
        for(int i=0; i<e1.getSkills.size()+e2.getSkills.size(); i++){
            // candidate skill berisi skill parent A
            if(i<e1.getSkills().size){
                candidateSkill.add(e1.getSkills().get(i));
            }

            else{
                // Pemilihan candidate skill dari parent B
                for (int j = 0; j < candidateSkill.size(); j++){
                    // Skill sama
                    if (e2.getSkills().get(i-e1.getSkills.size()).getSkillName() == candidateSkill.get(j).getSkillName()){
                        // Mastery level sama
                        
                        if(e2.getSkills().get(i-e1.getSkills.size()).getMasteryLvl() == candidateSkill.get(j).getMasteryLvl()){
                            Skill updatedSkill = candidateSkill.get(j);
                            updatedSkill.setMasteryLevel(candidateSkill.get(j).getMasteryLvl() + 1);
                            candidateSkill.set(j, updatedSkill);
                        }
                        //Mastery level berbeda
                        else{
                            if(e2.getSkills().get(i-e1.getSkills.size()).getMasteryLvl() > candidateSkill.get(j).getMasteryLvl()){
                                Skill updatedSkill = candidateSkill.get(j);
                                updatedSkill.setMasteryLevel(e2.getSkills().get(i-e1.getSkills.size()).getMasteryLvl());
                                candidateSkill.set(j, updatedSkill);
                            }
                        }
                    }
                    else{
                        candidateSkill.add(e2.getSkills().get(i-e1.getSkills.size()));
                    }
                }
            }
        }
        List<Pair<int, int>> masteryAndIndex = new ArrayList<Pair<int, int>>();
        
        for(int j=0; j<candidateSkill.size(); j++){
            Pair<int, int> pairMasteryIndex = new Pair<int, int>(candidateSkill.get(j).getMasteryLvl(), j);
            masteryAndIndex.add(pairMasteryIndex);
        }

        Collections.sort(masteryAndIndex, Comparator.comparing(p -> -p.getKey()));

        for(int i=0; i<4; i++){
            skillAnak.add(candidateSkill.get(masteryAndIndex.get(i).getValue()));
        }

        char iconAnak;
        if(elAnak.size()>1){
            if((elAnak.get(0).getElementName()==Fire && elAnak.get(1).getElementName()==Electric) || (elAnak.get(1).getElementName()==Fire && elAnak.get(0).getElementName()==Electric)){
                iconAnak = 'l';
            }
            else{
                if((elAnak.get(0).getElementName()==Water && elAnak.get(1).getElementName()==Ice)){
                    iconAnak = 's';
                }
                else{
                    iconAnak = 'n';
                }
            }
        }
        else{
            switch (elAnak.get(0).getElementName())
            {
            case Fire:
                iconAnak = 'f';
                break;
            case Water:
                iconAnak = 'w';
                break;
            case Electric:
                iconAnak = 'e';
                break;
            case Ice:
                iconAnak = 'i';
                break;
            case Ground:
                iconAnak = 'g';
                break;
            }
        }
        Point loc = e1.getEngimonLocation();
        Engimon anak = new Engimon(namaAnak, spAnak, e1.getEngimonName(), e2.getEngimonName(), e1.getSpeciesName(), e2.getSpeciesName(), skillAnak[0], elAnak, 0 , loc);
        anak.setEngimonSkill(skillAnak);
        anak.setIcon(iconAnak);
        this.listEngimon.addItem(anak);
    }
    
    public ArrayList<SkillItem> getSkillItemInventory() {
        return this.listSkill.getInventoryList();
    }
    public ArrayList<Engimon> getEngimonInventory() {
        return this.listEngimon.getInventoryList();
    }

    public void addSkillItem(SkillItem sk) {
        getSkillItemInventory().add(sk);
    }
    public void addEngimon(Engimon engi) {
        getEngimonInventory().add(engi);
    }

    public void printListEngimon() {
        listEngimon.printInventory();
    }
    public void printDataEngimon(Engimon engi) {
        engi.printInfo();
    }
    public void printListSkillItem() {
        listSkill.printInventory();
    }
    public void printActiveEngimon() {
        this.getActiveEngimon().printInfo();
    }
    public void interact() {
        System.out.println(this.getActiveEngimon().getName()+": "+this.getActiveEngimon().getTeksUnik());
    }

    public void replaceSkillEngimon(Engimon engi, Skill skillLama, Skill skillBaru) {
        if (engi.isSkillFull()) {
            engi.replace(skillLama, skillBaru);
        }
        else {
            cout << "Skill slot belum penuh" << endl;
        }
    }

    // TODO useSkillItem
    public void useSkillItem(Engimon engi, SkillItem s) {
        listSkill.delItem(s);
        // engimon learn skill
        // remove dari Inventory terus pake ke engimonnya
        // listSkill.removeItem(s);
        // e.learnSkill(s);
    }

    public void sortSkillItem() {
        listSkill.inventoryList.sort(SkillItem.skillItemComparator);
    }

    public void sortEngimon() {
        // belom dites
        listEngimon.inventoryList.sort(Engimon.engimonComparator);
        Map<Integer,List<Engimon>> groupEngimonByElement = listEngimon.inventoryList.stream(Collectors.groupingBy(Engimon::getFirstElement));

    }

    // TODO delXSkillItem
    public void delXSkillItem(Skill s, int x) {

    }
    
    public void delEngimon(Engimon engi) {
        listEngimon.delItem(engi);
    }
    
    public void printCommands() {
        System.out.println("Command yang tersedia: ");
        System.out.println("w: bergerak satu petak ke atas");
        System.out.println("a: bergerak satu petak ke kiri");
        System.out.println("s: bergerak satu petak ke bawah");
        System.out.println("d: bergerak satu petak ke kanan");
        System.out.println("1: Menampilkan list engimon yang dimiliki");
        System.out.println("2: Menampilkan data lengkap suatu engimon");
        System.out.println("3: Mengecek active engimon");
        System.out.println("4: Mengganti active engimon");
        System.out.println("5: Menggunakan skill item pada suatu engimon");
        System.out.println("6: Melaksanakan breeding antara dua engimon");
        System.out.println("7: Membuang X amount dari suatu skill item atau melepaskan engimon inventory");
        System.out.println("8: Mengganti nama dari suatu engimon yang ada di inventory");
        System.out.println("9: Save game");

    }
}