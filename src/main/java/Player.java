import java.util.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javafx.util.Pair;
public class Player {
    private Point location;
    private char icon;
    private PlayerEngimon activeEngimon;
    private Inventory<SkillItem> listSkill;
    private Inventory<Engimon> listEngimon;
    private int maxCapacity;

    public Player() {
        // default constructor
        location = new Point();
        icon = 'P';
        activeEngimon = new PlayerEngimon();
        listSkill = new Inventory<SkillItem>();
        listEngimon = new Inventory<Engimon>();
        maxCapacity = 20;
    }

    // Getter & Setter location
    public Point getPlayerLocation() {
        return this.location;
    }
    public void setPlayerLocation(int x, int y) {
        this.location.setX(x);
        this.location.setY(y);
    }

    // Getter & Setter activeEngimon location
    public Point getActiveEngimonLocation() {
        return this.activeEngimon.location;
    }
    public void setActiveEngimonLocation(Point p) {
        this.activeEngimon.location = p;
    }
    // Getter & Setter icon
    public char getIcon() {
        return this.icon;
    }
    public void setIcon(char icon) {
        this.icon = icon;
    }

    /*
    public void move(char dir) {
        Point prev = getPlayerLocation();
        if (dir == 'w') {
            try
            {
                int x = getPlayerLocation().getX();
                int y = getPlayerLocation().getY() - 1;
                setPlayerLocation(x, y); // Kalo ga valid dia throw
                // setActiveEngimonLocation(prev);
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
                // setActiveEngimonLocation(prev);

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
                // setActiveEngimonLocation(prev);
       
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
                // setActiveEngimonLocation(prev);

            }
            catch(OutOfMapException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

     */

    /* ACTIVE ENGIMON */
    public PlayerEngimon getActiveEngimon() {
        return this.activeEngimon;
    }

    public void setActiveEngimon(PlayerEngimon engi) {
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
            addEngimon(this.getActiveEngimon());
            // remove active engimon yang baru dari inventory
            delEngimon(engi);
            // set active engimon baru
            this.activeEngimon = engi;
        }
    }

    /* BREEDING */
    public void breed(Engimon e1, Engimon e2) throws BreedException {
        if (e1.getLevel() < 4 || e2.getLevel() < 4){
            throw new BreedException("Level parent tidak cukup untuk melakukan breeding");
        }

        e1.setLevel(e1.getLevel() - 3);
        e2.setLevel(e2.getLevel() - 3);

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama Engimon anak: ");
        String namaAnak = sc.nextLine();

        ArrayList<ElementType> elAnak = new ArrayList<ElementType>();
        ArrayList<Skill> candidateSkill = new ArrayList<Skill>();
        ArrayList<Skill> skillAnak = new ArrayList<Skill>();
        Species spAnak = Species.Charizard;

        // Penentuan elemen dan spesies anak
        if(e1.getElements().get(0) == e2.getElements().get(0)){
            elAnak.add(e1.getElements().get(0));
            spAnak = e1.getSpeciesName();

        }
       else{
           Element elmt1 = new Element(e1.getElements().get(0));
           if(elmt1.getAdvantage(e2.getElements().get(0)) > 1){
               elAnak.add(e1.getElements().get(0));
               spAnak = e1.getSpeciesName();
           }
           else{
               if(elmt1.getAdvantage(e2.getElements().get(0)) == 1){
                   elAnak.add(e1.getElements().get(0));
                   elAnak.add(e2.getElements().get(0));
                   spAnak = e1.findDualSpecies(e2.getElements().get(0));
               }
               else{
                   elAnak.add(e2.getElements().get(0));
                   spAnak = e2.getSpeciesName();
               }
           }
       }

        //Inherit skill
        for(int i=0; i<e1.getSkills().size()+e2.getSkills().size(); i++){
            // candidate skill berisi skill parent A
            if(i<e1.getSkills().size()){
                candidateSkill.add(e1.getSkills().get(i));
            }

            else{
                // Pemilihan candidate skill dari parent B
                for (int j = 0; j < candidateSkill.size(); j++){
                    // Skill sama
                    if (e2.getSkills().get(i-e1.getSkills().size()).getSkillName() == candidateSkill.get(j).getSkillName()){
                        // Mastery level sama

                        if(e2.getSkills().get(i-e1.getSkills().size()).getMasteryLevel() == candidateSkill.get(j).getMasteryLevel()){
                            Skill updatedSkill = candidateSkill.get(j);
                            updatedSkill.setMasteryLevel(candidateSkill.get(j).getMasteryLevel() + 1);
                            candidateSkill.set(j, updatedSkill);
                        }
                        //Mastery level berbeda
                        else{
                            if(e2.getSkills().get(i-e1.getSkills().size()).getMasteryLevel() > candidateSkill.get(j).getMasteryLevel()){
                                Skill updatedSkill = candidateSkill.get(j);
                                updatedSkill.setMasteryLevel(e2.getSkills().get(i-e1.getSkills().size()).getMasteryLevel());
                                candidateSkill.set(j, updatedSkill);
                            }
                        }
                    }
                    else{
                        candidateSkill.add(e2.getSkills().get(i-e1.getSkills().size()));
                    }
                }
            }
        }
        List<Pair<Integer, Integer>> masteryAndIndex = new ArrayList<Pair<Integer, Integer>>();

        for(int j=0; j<candidateSkill.size(); j++){
            Pair<Integer, Integer> pairMasteryIndex = new Pair<Integer, Integer>(candidateSkill.get(j).getMasteryLevel(), j);
            masteryAndIndex.add(pairMasteryIndex);
        }

        Collections.sort(masteryAndIndex, Comparator.comparing(p -> -p.getKey()));

        for(int i=0; i<4; i++){
            skillAnak.add(candidateSkill.get(masteryAndIndex.get(i).getValue()));
        }

        char iconAnak = ' ';
        if(elAnak.size()>1){
            if((elAnak.get(0)==ElementType.FIRE && elAnak.get(1)==ElementType.ELECTRIC) || (elAnak.get(1)==ElementType.FIRE && elAnak.get(0)==ElementType.ELECTRIC)){
                iconAnak = 'l';
            }
            else{
                if((elAnak.get(0)==ElementType.WATER && elAnak.get(1)==ElementType.ICE)){
                    iconAnak = 's';
                }
                else{
                    iconAnak = 'n';
                }
            }
        }
        else{
            switch (elAnak.get(0))
            {
            case FIRE:
                iconAnak = 'f';
                break;
            case WATER:
                iconAnak = 'w';
                break;
            case ELECTRIC:
                iconAnak = 'e';
                break;
            case ICE:
                iconAnak = 'i';
                break;
            case GROUND:
                iconAnak = 'g';
                break;
            }
        }
       int locX = e1.getX();
       int locY = e1.getY();
       Engimon anak = new Engimon(namaAnak, spAnak, e1.getName(), e2.getName(), e1.getSpeciesName(), e2.getSpeciesName(), skillAnak, locX, locY);
       anak.setIcon(iconAnak);
       this.listEngimon.addItem(anak);
    }
    
    public ArrayList<SkillItem> getSkillItemInventory() {
        return this.listSkill.getInventoryList();
    }
    public ArrayList<Engimon> getEngimonInventory() {
        return this.listEngimon.getInventoryList();
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

    public String stringListEngimon() {
        return listEngimon.toString();
    }
    public String stringDataEngimon(Engimon engi) {
        return engi.toString();
    }
    public String stringListSkillItem() {
        return listSkill.toString();
    }
    public String stringActiveEngimon() {
        return this.getActiveEngimon().toString();
    }
    // TODO getName() getTeksUnik() ga kedetect
    public String stringInteract() {
        return this.getActiveEngimon().getName()+ ": "+ this.getActiveEngimon().getTeksUnik();
    }

    public void replaceSkillEngimon(Engimon engi, Skill skillLama, Skill skillBaru) {
        if (engi.isSkillFull()) {
            engi.replace(skillLama, skillBaru);
        }
        else {
            System.out.println("Skill slot belum penuh");
        }
    }

    /* LIST ENGIMON */

    public Map<ArrayList<ElementType>,List<Engimon>> sortEngimon() {
        listEngimon.inventoryList.sort(Engimon.engimonLevelComparator);
        Map< ArrayList<ElementType>,List<Engimon>> byElement = listEngimon.inventoryList.stream().collect(Collectors.groupingBy(Engimon::getElements));
        return byElement;
    }
//    public void sortEngimonProc() {
//        listEngimon.inventoryList.sort(Engimon.engimonLevelComparator);
//        Map< ArrayList<ElementType>,List<Engimon>> byElement = listEngimon.inventoryList.stream().collect(Collectors.groupingBy(Engimon::getElements));
//        return byElement;
//    }

    public void printSortedEngimon() {
        Map<ArrayList<ElementType>,List<Engimon>> sortedEngimon = sortEngimon();
        sortedEngimon.forEach((key, value) -> System.out.println(key + ":" + value));
    }
    public String stringSortedEngimon() {
        String result = "";
        Map<ArrayList<ElementType>,List<Engimon>> sortedEngimon = sortEngimon();
        for (Map.Entry<ArrayList<ElementType>, List<Engimon>> entry : sortedEngimon.entrySet()) {
            String entryString = entry.toString();
            result += entryString+'\n';
        }
        return result;
    }
    public void addEngimon(Engimon engi) {
        listEngimon.addItem(engi);
    }
    public void delEngimon(Engimon engi) {
        listEngimon.delItem(engi);
    }

    public void changeEngimonName(Engimon engi, String newName) {
        engi.setName(newName);
    }

    public boolean isListEngimonEmpty() {
        return getEngimonInventory().isEmpty();
    }

    /* LIST SKILLITEM */
    // TODO masteryLevelnya juga disamain
    public int searchSkillIdx(Skill sk) {
        int i = 0;
        for (SkillItem skill : listSkill.getInventoryList()) {
            if (sk.getSkillName().equals(skill.getSkill().getSkillName()) && (sk.getMasteryLevel() == skill.getSkill().getMasteryLevel())) {
                i = listSkill.getInventoryList().indexOf(skill);
            }
        }
        return i;
    }
    public boolean searchSkill(Skill sk) {
        boolean found = false;
        for (SkillItem skill : listSkill.getInventoryList()) {
            if (sk.getSkillName().equals(skill.getSkill().getSkillName()) && (sk.getMasteryLevel() == skill.getSkill().getMasteryLevel()) ){
                found = true;
            }
        }
        return found;
    }
    public void addSkill(Skill sk) {
        // kalo udah ada
        if (!isCapacityFull()) {
            if (searchSkill(sk)) {
                int idx = searchSkillIdx(sk);
                SkillItem entry = listSkill.getInventoryList().get(idx);
                entry.addSkillAmount(1);
            }
            else {
                listSkill.addItem(new SkillItem(sk,1));
            }
        }
        else {
            System.out.println("Inventory sudah penuh");
        }

    }

    public void addSkillItem(Skill sk, int x) {
        if (!isCapacityFull()) {
            if (searchSkill(sk)) {
                int idx = searchSkillIdx(sk);
                SkillItem entry = listSkill.getInventoryList().get(idx);
                entry.addSkillAmount(x);
            }
            else {
                listSkill.addItem(new SkillItem(sk,x));
            }
        }
        else {
            System.out.println("Inventory sudah penuh");
        }
    }
    // Delete suatu skill sebanyak X amount
    public void delXSkillItem(Skill sk, int x) {
        if (searchSkill(sk)) {
            int idx = searchSkillIdx(sk);
            SkillItem entry = listSkill.getInventoryList().get(idx);
            System.out.println(entry.toString());
            if (entry.getSkillAmount() == x) {
                listSkill.getInventoryList().remove(idx);
            }
            else {
                entry.subSkillAmount(x);
            }
        }
        else {
            System.out.println("Tidak ada skill tersebut di dalam inventory.");
        }
    }

    public void useSkillItem(Engimon engi, SkillItem s) {
        // remove dari Inventory terus pake ke engimonnya
        delXSkillItem(s.getSkill(),1);
       // engimon learn skill
       engi.learnSkill(s.getSkill());
    }

    public void sortSkillItem() {
        listSkill.inventoryList.sort(SkillItem.skillItemComparator);
    }

    
    public boolean isCapacityFull() {
        int listSkillSize = 0;
        for (SkillItem skill : listSkill.getInventoryList()) {
            listSkillSize += skill.getSkillAmount();
        }
        int listEngimonSize = listEngimon.getInventoryList().size();
        return ((listEngimonSize + listSkillSize) >= this.maxCapacity);
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
    public String stringCommands() {
        String command = "Command yang tersedia: ";
        String commandW = "\nw/up: bergerak satu petak ke atas";
        String commandA = "\na/left: bergerak satu petak ke kiri";
        String commandS = "\ns/down: bergerak satu petak ke bawah";
        String commandD = "\nd/right: bergerak satu petak ke kanan";
        String command1 = "\n1: Menampilkan list engimon yang dimiliki";
        String command2 = "\n2: Menampilkan data lengkap suatu engimon";
        String command3 = "\n3: Mengecek active engimon";
        String command4 = "\n4: Mengganti active engimon";
        String command5 = "\n5: Menggunakan skill item pada suatu engimon";
        String command6 = "\n6: Melaksanakan breeding antara dua engimon";
        String command7 = "\n7: Membuang X amount dari suatu skill item atau melepaskan engimon inventory";
        String command8 = "\n8: Mengganti nama dari suatu engimon yang ada di inventory";
        String command9 = "\n9: Save game\n";
        return command+commandW+commandA+commandS+commandD+command1+command2+command3+command4
                +command5+command6+command7+command8+command9;
    }
    @Override
    public String toString() {
        return "Player{" +
                "location=" + location +
//                ", icon=" + icon +
                ", activeEngimon=" + activeEngimon +
                ", listSkill=" + listSkill +
                ", listEngimon=" + listEngimon +
                ", maxCapacity=" + maxCapacity +
                '}';
    }

    public static void main(String[] args) {
        Player pemain = new Player();
        Skill fireSkill = new Skill("FireSkill", 100, 1, ElementType.FIRE);
        Skill waterSkill = new Skill("WaterSkill", 50, 1, ElementType.WATER);
        Skill electricSkill = new Skill("electric",250,1, ElementType.ELECTRIC);
        SkillItem sk1 = new SkillItem(fireSkill,3);
        SkillItem sk2 = new SkillItem(waterSkill,5);
        SkillItem sk3 = new SkillItem(electricSkill,2);
//        Inventory<SkillItem> invSkill = new Inventory<>();
//        invSkill.addItem(sk1);
//        invSkill.addItem(sk2);
//        invSkill.addItem(sk3);
        pemain.addSkillItem(sk1.getSkill(),sk1.getSkillAmount());
        pemain.addSkillItem(sk2.getSkill(),sk2.getSkillAmount());
        pemain.addSkillItem(sk3.getSkill(),sk3.getSkillAmount());
        pemain.sortSkillItem();
        // pemain.printListSkillItem();
        System.out.println(pemain.stringListSkillItem());
        System.out.println("Capacity full? "+pemain.isCapacityFull());
        pemain.delXSkillItem(fireSkill,2);
        System.out.println("Setelah di delete dua FireSkill: ");
        // pemain.printListSkillItem();
        System.out.println(pemain.stringListSkillItem());
        // pemain.printCommands();
        //System.out.print(pemain.stringCommands());
        ArrayList<Skill> arrSkillWater = new ArrayList<>();
        arrSkillWater.add(waterSkill);
        ArrayList<Skill> arrSkillFire = new ArrayList<>();
        arrSkillWater.add(fireSkill);
        Engimon e1 = new Engimon("Haihai", Species.Mudtle, "New Daddy", "New Mommy", arrSkillWater,1, 1);
        Engimon e2 = new Engimon();
        Engimon e3 = new Engimon("e3",Species.Charizard,"daddy e3","mommy e3",arrSkillFire,5,1);
        Engimon e4 = new Engimon("e4",Species.Mudkip,"dad4","mom4",arrSkillWater,30,1);
        // e1.getSkills().add(waterSkill);
        e1.setLevel(10);
        e2.setLevel(3);
        e3.setLevel(20);
        e4.setLevel(100);
        pemain.changeEngimonName(e4,"eheheh");
        pemain.addEngimon(e1);
        pemain.addEngimon(e2);
        pemain.addEngimon(e3);
        pemain.addEngimon(e4);
        pemain.delEngimon(e2);
        pemain.stringDataEngimon(e1);
        System.out.println(pemain.stringSortedEngimon());
    }
}