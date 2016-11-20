package core.comparator;

import core.enums.CompOp;

public class Compare {

    public static boolean doIt(Comparable c1, Comparable c2, CompOp op) {
        if (op.isGT()) {
            return (c1.compareTo(c2)) > 0;
        }

        if (op.isLT()) {
            return (c1.compareTo(c2)) < 0;
        }

        if (op.isLTE()) {
            return (c1.compareTo(c2)) <= 0;
        }

        if (op.isGTE()) {
            return (c1.compareTo(c2)) >= 0;
        }
        if (op.isEQ()) {
            return (c1.compareTo(c2)) == 0;
        }
        return false;
    }
}
