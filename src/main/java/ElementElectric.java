public class ElementElectric implements Element {
    private ElementType type;

    public ElementElectric() {
        this.type = ElementType.ELECTRIC;
    }

    @Override
    public ElementType getType() {
        return type;
    }

    @Override
    public double getAdvantage(ElementType enemyType) {
        if (enemyType == enemyType.WATER) {
            return 2;
        }
        else if (enemyType == enemyType.GROUND) {
            return 0;
        }
        else if (enemyType == enemyType.ICE) {
            return 1.5;
        }
        else {
            return 1;
        }
    }
}
