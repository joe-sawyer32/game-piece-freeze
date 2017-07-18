/**
 * Created by Joe on 7/18/17.
 */
public class GamePiece {
    // FIELDS
    private int positionX;
    private int positionY;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private boolean frozen;
    private String name;
    private String color;

    // CONSTRUCTORS
    // empty
    public GamePiece() {
        this.positionX = 0;
        this.positionY = 0;
        this.minX = 0;
        this.minY = 0;
        this.maxX = 7;
        this.maxY = 7;
        this.frozen = false;
    }

    // METHODS
    // getters
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public boolean getFrozen() {
        return frozen;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // custom
    public void move(int newPositionX, int newPositionY) {
        if (this.frozen == false) {
            if (newPositionX > this.maxX) {
                this.positionX = this.maxX;
            } else if (newPositionX < this.minX) {
                this.positionX = this.minX;
            } else {
                this.positionX = newPositionX;
            }

            if (newPositionY > this.maxY) {
                this.positionY = this.maxY;
            } else if (newPositionY < this.minY) {
                this.positionY = this.minY;
            } else {
                this.positionY = newPositionY;
            }
        }
    }

    public void freeze() {
        this.frozen = true;
    }

    public void unfreeze() {
        this.frozen = false;
    }

    public void printInfo() {
        System.out.println("------------------------------");
        System.out.println("OBJECT INFO");
        System.out.println("Position X: " + this.getPositionX());
        System.out.println("Position Y: " + this.getPositionY());
        System.out.println("Frozen: " + this.getFrozen());
        System.out.println("Name: " + this.getName());
        System.out.println("Color: " + this.getColor() + "\n");
    }
}
