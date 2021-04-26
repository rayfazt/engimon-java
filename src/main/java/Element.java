public class Element implements java.io.Serializable{
    private ElementType type;

    public Element(ElementType type) {
        this.type = type;
    }

    public ElementType getType() {
        return this.type;
    }

    public double getAdvantage(ElementType enemyType) {
        switch (enemyType) {
            case FIRE:
                if (this.type == ElementType.WATER) {
                    return 2;
                } else if (this.type == ElementType.GROUND) {
                    return 1.5;
                } else if (this.type == ElementType.ICE) {
                    return 0;
                } else {
                    return 1;
                }

            case ICE:
                if (this.type == ElementType.FIRE) {
                    return 2;
                } else if (this.type == ElementType.ELECTRIC) {
                    return 1.5;
                } else if (this.type == ElementType.GROUND) {
                    return 0;
                } else {
                    return 1;
                }

            case WATER:
                if (this.type == ElementType.ELECTRIC) {
                    return 2;
                } else if (this.type == ElementType.FIRE) {
                    return 0;
                } else {
                    return 1;
                }

            case ELECTRIC:
                if (this.type == ElementType.GROUND) {
                    return 2;
                } else if (this.type == ElementType.ICE) {
                    return 0.5;
                } else if (this.type == ElementType.WATER) {
                    return 0;
                } else {
                    return 0;
                }

            case GROUND:
                if (this.type == ElementType.ICE) {
                    return 2;
                } else if (this.type == ElementType.FIRE) {
                    return 0.5;
                } else if (this.type == ElementType.ELECTRIC) {
                    return 0;
                } else {
                    return 1;
                }

            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Element{" +
                "type=" + type +
                '}';
    }
}
