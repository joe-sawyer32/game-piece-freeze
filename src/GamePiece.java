/**
 * Created by Joe on 7/18/17.
 */
public class GamePiece {
    // FIELDS
    private int positionX;
    private int positionY;
    private boolean frozen;
    private String name;
    private String color;

    // CONSTRUCTORS
    // empty
    public GamePiece() {
        this.positionX = 0;
        this.positionY = 0;
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
            this.positionX = newPositionX;
            this.positionY = newPositionY;
        }
    }

    public void freeze() {
        this.frozen = true;
    }

    public void unfreeze() {
        this.frozen = false;
    }
}
