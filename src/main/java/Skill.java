import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Skill implements java.io.Serializable{
    private String skillName;
    private int basePower;
    private int masteryLevel;
    private ArrayList<ElementType> learnableElements;
//    private String imagePath;
//    private ImageView photo;
    public Skill() {
        this.skillName = "defaultSkill";
        this.basePower = 0;
        this.masteryLevel = 1;
        this.learnableElements = new ArrayList<ElementType>();
//        this.imagePath = "1.png";
//        this.photo = new ImageView(new Image(this.getClass().getResourceAsStream(getImagePath())));
    }

    public Skill(String name, int bp, int ml, ElementType type) {
        this.skillName = name;
        this.basePower = bp;
        this.masteryLevel = ml;
        this.learnableElements = new ArrayList<ElementType>();
        this.learnableElements.add(type);
//        this.imagePath = ml + ".png";
//        this.photo = new ImageView(new Image(this.getClass().getResourceAsStream(getImagePath())));

    }

    public String getSkillName() {
        return this.skillName;
    }

    public int getBasePower() {
        return this.basePower;
    }

    public int getMasteryLevel() {
        return this.masteryLevel;
    }

    public ArrayList<ElementType> getLearnableElements() {
        return this.learnableElements;
    }

    public void setMasteryLevel(int level) {
        this.masteryLevel = level;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillName='" + skillName + '\'' +
                ", basePower=" + basePower +
                ", masteryLevel=" + masteryLevel +
                ", learnableElements=" + learnableElements +
                '}';
    }

//    public static void main(String[] args) {
//        Skill a = new Skill();
//        System.out.println(a.toString());
//    }
}
