
package exitgame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andreas
 */
public class Room {

    private String name;
    private String description;
    private ArrayList<Room> neighbors;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        neighbors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isLocked() {
        return false;
    }

    public void addNeighbor(Room room) {
        neighbors.add(room);
        room.neighbors.add(this);
        System.out.println(name + " and " + room.getName() + " are now neighbors.");
    }

    public Room enter() {
        System.out.println("You have entered " + name + ".");
        System.out.println(description);
        return this;
    }

    public Room moveToNextRoom() {
        Scanner scanner = new Scanner(System.in);
        if (neighbors.isEmpty()) {
            System.out.println("There are no neighboring rooms.");
            return this;
        }
        System.out.println("From " + name + ", you can go to:");
        for (int i = 0; i < neighbors.size(); i++) {
            System.out.println((i + 1) + ". " + neighbors.get(i).getName());
        }
        int choice;
        do {
            System.out.print("Enter your choice (1-" + neighbors.size() + "): ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > neighbors.size());
        Room nextRoom = neighbors.get(choice - 1);
        System.out.println("You are now entering " + nextRoom.getName() + ".");
        return nextRoom.enter();
    }

    @Override
    public String toString() {
        return name;
    }

}
