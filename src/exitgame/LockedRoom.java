
package exitgame;

import java.util.Scanner;

/**
 *
 * @author Andreas
 */
public class LockedRoom extends Room {
    private String puzzleQuestion;
    private String puzzleAnswer;
    private boolean locked;

    public LockedRoom(String name, String description, String puzzleQuestion, String puzzleAnswer) {
        super(name, description);
        this.puzzleQuestion = puzzleQuestion;
        this.puzzleAnswer = puzzleAnswer;
        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }
    
    @Override
    public Room enter() {
        Scanner scanner = new Scanner(System.in);
        if (isLocked()) {
            System.out.println(puzzleQuestion);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(puzzleAnswer)) {
                
                locked = false;
                return super.enter();
            }
            else
            {
                System.out.println("Incorrect answer. You cannot enter " + getName() + " until you solve the puzzle.");
                return null;
            }
        }
        
        return super.enter();
    }    
}
