public class ElementIce implements Element {
    private ElementType type;

    public ElementIce() {
        this.type = ElementType.ICE;
    }

    @Override
    public ElementType getType() {
        return type;
    }

    @Override
    public double getAdvantage(ElementType enemyType) {
        if (enemyType == enemyType.GROUND) {
            return 2;
        }
        else if (enemyType == enemyType.FIRE) {
            return 0;
        }
        else if (enemyType == enemyType.ELECTRIC) {
            return 0.5;
        }
        else {
            return 1;
        }
    }
}
