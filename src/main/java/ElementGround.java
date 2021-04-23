public class ElementGround implements Element {
    private ElementType type;

    public ElementGround() {
        this.type = ElementType.GROUND;
    }

    @Override
    public ElementType getType() {
        return type;
    }

    @Override
    public double getAdvantage(ElementType enemyType) {
        if (enemyType == enemyType.ELECTRIC) {
            return 2;
        }
        else if (enemyType == enemyType.ICE) {
            return 0;
        }
        else if (enemyType == enemyType.FIRE) {
            return 1.5;
        }
        else {
            return 1;
        }
    }
}
