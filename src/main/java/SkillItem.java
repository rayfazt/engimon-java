import java.awt.*;
import java.util.Comparator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SkillItem implements java.io.Serializable{
    private Skill skill;
    private int skillAmount;
    private String imagePath;
    private ImageView photo;
    public SkillItem() {
        Skill defaultSkill = new Skill();
        this.skill = defaultSkill;
        this.skillAmount = 1;
        this.imagePath = defaultSkill.getMasteryLevel() + ".png";
        this.photo = new ImageView(new Image(this.getClass().getResourceAsStream(getImagePath())));
    }
    public SkillItem(Skill skill, int amount) {
        this.skill = skill;
        this.skillAmount = amount;
        // this.imagePath = skill.getMasteryLevel() + ".png";
        this.imagePath = skill.getMasteryLevel() + ".png";
        this.photo = new ImageView(new Image(this.getClass().getResourceAsStream(getImagePath())));

    }
    public void addSkillItem(int amount) {
        this.skillAmount += amount;
    }
    public void delSkillItem(int amount) {
        this.skillAmount -= amount;
    }
    @Override
    public String toString() {
        return "Skill: " + this.getSkill().getSkillName() + "\nJumlah: "+this.getSkillAmount();
    }
    // public void printInfo() {
    //     System.out.println("Skill: "+ this.getSkill().getSkillName());
    //     System.out.println("Jumlah: "+ this.getSkillAmount());
    // }
    public Skill getSkill() {
        return this.skill;
    }
    public int getSkillAmount() {
        return this.skillAmount;
    }
    public void addSkillAmount(int x) {
        this.skillAmount += x;
    }
    public void subSkillAmount(int x) {
        this.skillAmount -= x;
    }

    public static Comparator<SkillItem> skillItemComparator = new Comparator<SkillItem>() {

        @Override
        public int compare(SkillItem s1, SkillItem s2) {
            Integer basePower1 = s1.getSkill().getBasePower();
            Integer basePower2 = s2.getSkill().getBasePower();
    
           // descending order
           return basePower2.compareTo(basePower1);
        }};
    public String getImagePath() {
        return this.imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public ImageView getPhoto() {
        return this.photo;
    }
//    public static void main(String[] args) {
//        SkillItem a = new SkillItem();
//        System.out.println(a.toString());
//
//    }
}