public class ElementWater implements Element{
    private ElementType type;

    public ElementWater() {
        this.type = ElementType.WATER;
    }

    @Override
    public ElementType getType() {
        return this.type;
    }

    @Override
    public double getAdvantage(ElementType enemyType) {
        if (enemyType == enemyType.FIRE) {
            return 2;
        }
        else if (enemyType == enemyType.ELECTRIC) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
