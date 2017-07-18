import java.util.Random;

/**
 * Created by Joe on 7/18/17.
 */
public class Main {
    public static void main(String[] args) {
        GamePiece myPiece = new GamePiece();
        myPiece.setName("checker");
        myPiece.setColor("red");
        myPiece.printInfo();

        testFreezing(myPiece);
        testUnfreezing(myPiece);
        testUnfrozenMove(myPiece, getRandomNum(), getRandomNum());
        testFrozenMove(myPiece, getRandomNum(), getRandomNum());

    }

    public static int getRandomNum() {
        Random random = new Random();
        int randomNum = random.nextInt(10);
        return randomNum;
    }

    public static void testFrozenMove(GamePiece piece, int attemptedX, int attemptedY) {
        // test move method does not change positions if piece is frozen
        System.out.println("------------------------------");
        System.out.println("FROZEN MOVE TEST");
        int initialX = piece.getPositionX();
        int initialY = piece.getPositionY();
        printPosition("Initial", initialX, initialY);
        piece.freeze();
        if (piece.getFrozen()) {
            printPosition("Attempted", attemptedX, attemptedY);
            piece.move(attemptedX, attemptedY);
            int finalX = piece.getPositionX();
            int finalY = piece.getPositionY();
            if ((finalX == initialX) && (finalY == initialY)) {
                System.out.println("Silly frozen guy, you can't move" + "\n");
                printPosition("Final", finalX, finalY);
            } else {
                System.out.println("WHITE WALKERRR!!! (you're frozen but moving?)" + "\n");
                printPosition("Final", finalX, finalY);
                throw new AssertionError(); // CRASH
            }
        }
    }

    public static void testUnfrozenMove(GamePiece piece, int attemptedX, int attemptedY) {
        // test move method changes positions if piece is not frozen
        System.out.println("------------------------------");
        System.out.println("UNFROZEN MOVE TEST");
        printPosition("Initial", piece.getPositionX(), piece.getPositionY());
        if (!piece.getFrozen()) {
            printPosition("Attempted", attemptedX, attemptedY);
            piece.move(attemptedX, attemptedY);
            int finalX = piece.getPositionX();
            int finalY = piece.getPositionY();
            // piece should move to the attempted position or stop at the border
            if (((finalX == attemptedX) || (finalX == piece.getMaxX()) || (finalX == piece.getMinX())) &&
                ((finalY == attemptedY) || (finalY == piece.getMaxY()) || (finalY == piece.getMinY()))) {
                System.out.println("Your piece be movinggg" + "\n");
                printPosition("Final", finalX, finalY);
            } else {
                System.out.println("That move you just tried...FAILL!" + "\n");
                printPosition("Final", finalX, finalY);
                throw new AssertionError(); // CRASH
            }
        }
    }

    public static void printPosition(String state, int x, int y) {
        System.out.println(state + " Position");
        System.out.println("Position X: " + x);
        System.out.println("Position Y: " + y + "\n");
    }

    public static void testUnfreezing(GamePiece piece) {
        // test unfreeze method changes frozen to false if already frozen
        System.out.println("------------------------------");
        System.out.println("UNFREEZE TEST");
        if (piece.getFrozen()) {
            piece.unfreeze();
            if (!piece.getFrozen()) {
                System.out.println("You finally thawed out" + "\n");
                System.out.println("Frozen: " + piece.getFrozen() + "\n");
            } else {
                System.out.println("Ha, it's like in freeze tag when someone tags you to unfreeze you so you think " +
                        "you're getting unfrozen, but then like they actually got frozen before they tagged you so " +
                        "you didn't really get unfrozen... Yeah, like that" + "\n");
                System.out.println("Frozen: " + piece.getFrozen() + "\n");
                throw new AssertionError(); // CRASH
            }
        }
    }

    public static void testFreezing(GamePiece piece) {
        // test freeze method changes frozen to true if not already frozen
        System.out.println("------------------------------");
        System.out.println("FREEZE TEST");
        if (!piece.getFrozen()) {
            piece.freeze();
            if (piece.getFrozen()) {
                System.out.println("Your piece is frozen (let it go bro)" + "\n");
                System.out.println("Frozen: " + piece.getFrozen() + "\n");
            } else {
                System.out.println("How are you not frozen?!?" + "\n");
                System.out.println("Frozen: " + piece.getFrozen() + "\n");
                throw new AssertionError(); // CRASH
            }
        }
    }
}