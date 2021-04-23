public class ElementFire implements Element {
    private ElementType type;

    public ElementFire() {
        this.type = ElementType.FIRE;
    }

    @Override
    public ElementType getType() {
        return type;
    }

    @Override
    public double getAdvantage(ElementType enemyType) {
        if (enemyType == enemyType.ICE) {
            return 2;
        }
        else if (enemyType == enemyType.WATER) {
            return 0;
        }
        else if (enemyType == enemyType.GROUND) {
            return 0.5;
        }
        else {
            return 1;
        }
    }
}
