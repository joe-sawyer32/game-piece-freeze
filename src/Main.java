import java.util.Random;

/**
 * Created by Joe on 7/18/17.
 */
public class Main {
    public static void main(String[] args) {
        GamePiece redChecker = new GamePiece();
        redChecker.setName("checker");
        redChecker.setColor("red");

        redChecker.printInfo();
        testFreezing(redChecker);
        testUnfreezing(redChecker);
        testUnfrozenMove(redChecker, getRandomNum(), getRandomNum());
        testFrozenMove(redChecker, getRandomNum(), getRandomNum());

    }

    public static int getRandomNum() {
        Random random = new Random();
        int randomNum = random.nextInt(30);
        System.out.println(randomNum);
        return randomNum;
    }

    public static void testFrozenMove(GamePiece redChecker, int attemptedX, int attemptedY) {
        // test move method does not change positions if piece is frozen
        System.out.println("FROZEN MOVE TEST");
        int initialX = redChecker.getPositionX();
        int initialY = redChecker.getPositionY();
        printPosition("Initial", initialX, initialY);
        redChecker.freeze();
        if (redChecker.getFrozen()) {
            redChecker.move(attemptedX, attemptedY);
            if ((redChecker.getPositionX() == initialX) && (redChecker.getPositionY() == initialY)) {
                System.out.println("Silly frozen guy, you can't move" + "\n");
                printPosition("Final", redChecker.getPositionX(), redChecker.getPositionY());
            } else {
                System.out.println("WHITE WALKERRR!!! (you're frozen but moving?)" + "\n");
                printPosition("Final", redChecker.getPositionX(), redChecker.getPositionY());
                throw new AssertionError(); // CRASH
            }
        }
    }

    public static void testUnfrozenMove(GamePiece redChecker, int attemptedX, int attemptedY) {
        // test move method changes positions if piece is not frozen
        System.out.println("UNFROZEN MOVE TEST");
        printPosition("Initial", redChecker.getPositionX(), redChecker.getPositionY());
        if (!redChecker.getFrozen()) {
            redChecker.move(attemptedX, attemptedY);
            if ((redChecker.getPositionX() == attemptedX) && (redChecker.getPositionY() == attemptedY)) {
                System.out.println("Your piece be movinggg" + "\n");
                printPosition("Final", redChecker.getPositionX(), redChecker.getPositionY());
            } else {
                System.out.println("That move you just tried...FAILL!" + "\n");
                printPosition("Final", redChecker.getPositionX(), redChecker.getPositionY());
                throw new AssertionError(); // CRASH
            }
        }
    }

    public static void printPosition(String state, int x, int y) {
        System.out.println(state + "Position");
        System.out.println("Position X: " + x);
        System.out.println("Position Y: " + y + "\n");
    }

    public static void testUnfreezing(GamePiece redChecker) {
        // test unfreeze method changes frozen to false if already frozen
        System.out.println("UNFREEZE TEST");
        if (redChecker.getFrozen()) {
            redChecker.unfreeze();
            if (!redChecker.getFrozen()) {
                System.out.println("You finally thawed out" + "\n");
                System.out.println("Frozen: " + redChecker.getFrozen() + "\n");
            } else {
                System.out.println("Ha, it's like in freeze tag when someone tags you to unfreeze you so you think " +
                        "you're getting unfrozen, but then like they actually got frozen before they tagged you so " +
                        "you didn't really get unfrozen... Yeah, like that" + "\n");
                System.out.println("Frozen: " + redChecker.getFrozen() + "\n");
                throw new AssertionError(); // CRASH
            }
        }
    }

    public static void testFreezing(GamePiece redChecker) {
        // test freeze method changes frozen to true if not already frozen
        System.out.println("FREEZE TEST");
        if (!redChecker.getFrozen()) {
            redChecker.freeze();
            if (redChecker.getFrozen()) {
                System.out.println("Your piece is frozen (let it go bro)" + "\n");
                System.out.println("Frozen: " + redChecker.getFrozen() + "\n");
            } else {
                System.out.println("How are you not frozen?!?" + "\n");
                System.out.println("Frozen: " + redChecker.getFrozen() + "\n");
                throw new AssertionError(); // CRASH
            }
        }
    }
}