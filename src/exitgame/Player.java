
package exitgame;

/**
 *
 * @author Andreas
 */
public class Player {
    private final String name;
    private Room currentRoom;

    public Player(String name, Room startRoom) {
        this.name = name;
        this.currentRoom = startRoom;
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }
    
    public void moveOn(){
        Room nextRoom = currentRoom.moveToNextRoom();
        if(nextRoom != null){
            currentRoom = nextRoom;
        }
    }
    
    @Override
    public String toString() {
        return name;
    }
}
