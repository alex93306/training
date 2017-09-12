package thinkInJava.generics;

import java.awt.*;

/**
 * Created by ALEX on 18.07.2016.
 */

interface HasColor {
    Color getColor();
}
class Colored<T extends HasColor> {
    T item;
    Colored(T item) {
        this.item=item;
    }
    T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }
}

class Dimension {
    public int x, y, z;
}

class ColoredDimension<T extends Dimension & HasColor> {
    T item;

    public ColoredDimension(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    Color getColor() {
        return item.getColor();
    }
    int getX() {
        return item.x;
    }
}

interface Weight {
    int weight();
}

class Solid<T extends Dimension & HasColor & Weight> {

}
public class BasicBound {
}
