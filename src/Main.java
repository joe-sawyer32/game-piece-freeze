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
        testUnfrozenMove(redChecker);
        testFrozenMove(redChecker);


    }

    public static void testFrozenMove(GamePiece redChecker) {
        // test move method does not change positions if piece is frozen
        System.out.println("FROZEN MOVE TEST");
        int initialX = redChecker.getPositionX();
        int initialY = redChecker.getPositionY();
        System.out.println("Initial Position");
        System.out.println("Position X: " + initialX);
        System.out.println("Position Y: " + initialY);
        redChecker.freeze();
        if (redChecker.getFrozen()) {
            redChecker.move(2, 2);
            if ((redChecker.getPositionX() == initialX) && (redChecker.getPositionY() == initialY)) {
                System.out.println("Silly frozen guy, you can't move");
                System.out.println("Final Position");
                System.out.println("Position X: " + redChecker.getPositionX());
                System.out.println("Position Y: " + redChecker.getPositionY() + "\n");
            } else {
                System.out.println("WHITE WALKERRR!!! (you're frozen but moving?)");
                System.out.println("Final Position");
                System.out.println("Position X: " + redChecker.getPositionX());
                System.out.println("Position Y: " + redChecker.getPositionY() + "\n");
                throw new AssertionError(); // CRASH
            }
        }
    }

    public static void testUnfrozenMove(GamePiece redChecker) {
        // test move method changes positions if piece is not frozen
        System.out.println("UNFROZEN MOVE TEST");
        System.out.println("Initial Position");
        System.out.println("Position X: " + redChecker.getPositionX());
        System.out.println("Position Y: " + redChecker.getPositionY());
        if (!redChecker.getFrozen()) {
            redChecker.move(1, 1);
            if ((redChecker.getPositionX() == 1) && (redChecker.getPositionY() == 1)) {
                System.out.println("Your piece be movinggg");
                System.out.println("Final Position");
                System.out.println("Position X: " + redChecker.getPositionX());
                System.out.println("Position Y: " + redChecker.getPositionY() + "\n");
            } else {
                System.out.println("That move you just tried...FAILL!");
                System.out.println("Final Position");
                System.out.println("Position X: " + redChecker.getPositionX());
                System.out.println("Position Y: " + redChecker.getPositionY() + "\n");
                throw new AssertionError(); // CRASH
            }
        }
    }

    public static void testUnfreezing(GamePiece redChecker) {
        // test unfreeze method changes frozen to false if already frozen
        System.out.println("UNFREEZE TEST");
        if (redChecker.getFrozen()) {
            redChecker.unfreeze();
            if (!redChecker.getFrozen()) {
                System.out.println("You finally thawed out");
                System.out.println("Frozen: " + redChecker.getFrozen() + "\n");
            } else {
                System.out.println("Ha, it's like in freeze tag when someone tags you to unfreeze you so you think " +
                        "you're getting unfrozen, but then like they actually got frozen before they tagged you so " +
                        "you didn't really get unfrozen... Yeah, like that");
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
                System.out.println("Your piece is frozen (let it go bro)");
                System.out.println("Frozen: " + redChecker.getFrozen() + "\n");
            } else {
                System.out.println("How are you not frozen?!?");
                System.out.println("Frozen: " + redChecker.getFrozen() + "\n");
                throw new AssertionError(); // CRASH
            }
        }
    }
}