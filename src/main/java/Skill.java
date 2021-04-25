import java.util.ArrayList;

public class Skill {
    private String skillName;
    private int basePower;
    private int masteryLevel;
    private ArrayList<ElementType> learnableElements;
    private String imagePath;
    public Skill() {
        this.skillName = "defaultSkill";
        this.basePower = 0;
        this.masteryLevel = 1;
        this.learnableElements = new ArrayList<ElementType>();
        this.imagePath = "1.png";
    }

    public Skill(String name, int bp, int ml, ElementType type) {
        this.skillName = name;
        this.basePower = bp;
        this.masteryLevel = ml;
        this.learnableElements = new ArrayList<ElementType>();
        this.learnableElements.add(type);
        this.imagePath = bp + ".png";
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

    public String getImagePath() {
        return this.imagePath;
    }
    public ArrayList<ElementType> getLearnableElements() {
        return this.learnableElements;
    }

    public void setMasteryLevel(int level) {
        this.masteryLevel = level;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public static void main(String[] args) {
        Skill a = new Skill();
        System.out.println(a.toString());
    }
}
