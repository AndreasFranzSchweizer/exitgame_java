
package exitgame;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Andreas
 */
public class ExitGame {
    
    ArrayList<Room> rooms;
    Room startRoom;

    public ExitGame() 
    {
        this.rooms = new ArrayList();
    }
    
    private void createRooms()
    {
        this.rooms.add(new Room("Room 1", "This is room 1."));
        this.startRoom = this.rooms.get(0);
        
        this.rooms.add(new LockedRoom("Room 2", "This is room 2.", "What is the capital of France?", "Paris"));
        this.rooms.add(new LockedRoom("Room 3", "This is room 3.", "What is the square root of 16?", "4"));
        this.rooms.add(new LockedRoom("Room 4", "This is room 4.", "What is the largest planet in our solar system?", "Jupiter"));
        this.rooms.add(new LockedRoom("Room 5", "This is room 5.", "What is the largest continent by land area?", "Asia"));
        this.rooms.add(new LockedRoom("Room 6", "This is room 6.", "What is the capital of Japan?", "Tokyo"));
        this.rooms.add(new LockedRoom("Room 7", "This is room 7.", "What is the smallest country in the world by land area?", "Vatican City"));
        this.rooms.add(new LockedRoom("Room 8", "This is room 8.", "What is the capital of Italy?", "Rome"));
        this.rooms.add(new LockedRoom("Room 9", "This is room 9.", "What is the largest ocean on Earth?", "Pacific"));
        
        connectRooms(1, 2);
        connectRooms(1, 3);
        connectRooms(1, 4);
        connectRooms(2, 5);
        connectRooms(2, 6);
        connectRooms(3, 7);
        connectRooms(4, 8);
        connectRooms(5, 9);
    }
    
    private void connectRooms(int index1, int index2)
    {
        index1--;
        index2--;
        
        if(index1 < 0 || index1 >= this.rooms.size())
            return;
        
        if(index2 < 0 || index2 >= this.rooms.size())
            return;
        
        this.rooms.get(index1).addNeighbor(this.rooms.get(index2));
    }
    
    private boolean allRoomsUnlocked(ArrayList<Room> rooms) {
        for(Room room : rooms)
        {
            if(room.isLocked())
            {
                return false;
            }
        }
        
        System.out.println("Congratulations, you have unlocked all the rooms!");
        return true;
    }
    
    private Player createPlayer(Room startRoom)
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");

        String userName = myObj.nextLine();
        
        return new Player(userName, startRoom);
    }
    
    public void play()
    {
        createRooms();
        Player player = createPlayer(startRoom);
        
        // Game loop
        while (!allRoomsUnlocked(rooms)) {
            // Move to next room
            player.moveOn();
        }
    }
}
