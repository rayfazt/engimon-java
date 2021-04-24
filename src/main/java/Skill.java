import java.util.ArrayList;

public class Skill {
    private String skillName;
    private int basePower;
    private int masteryLevel;
    private ArrayList<ElementType> learnableElements;

    public Skill() {
        this.skillName = "defaultSkill";
        this.basePower = 0;
        this.masteryLevel = 1;
        this.learnableElements = new ArrayList<ElementType>();
    }

    public Skill(String name, int bp, int ml, ElementType type) {
        this.skillName = name;
        this.basePower = bp;
        this.masteryLevel = ml;
        this.learnableElements = new ArrayList<ElementType>();
        this.learnableElements.add(type);
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

}
