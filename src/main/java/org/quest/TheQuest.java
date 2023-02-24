package org.quest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheQuest {
    public static void main(String[] args) {
        String command = "";
        int room = 0;

        Player playerOne = new Player();

        boolean gameOver = false;

        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            if (room == 0) {
                System.out.println("Please enter your name to begin your adventure, traveler!");
                System.out.print("> ");
                playerOne.setName(scanner.nextLine());
                System.out.println(playerOne);
                room = 1;
            }
            if (room == 1) {
                System.out.println("Welcome " + playerOne.getName() + "! This is the start of one of the greatest. adventures you will go on...");
                makeSeparator();
                System.out.println("Please enter the name for your class! There are 2 classes to choose from. Mage or warlock.");
                makeSeparator();
                emptyLine();
                System.out.println("- Mages are exquisite beings of magical power. Mages are the only beings in the realm that are able to wield staffs of special abilities.");
                emptyLine();
                System.out.println("- Warlocks are exceptional fighters and pack a big punch. Warlocks start with an additional 70 health.");
                emptyLine();
                System.out.print("> ");
                playerOne.setPlayerClass(scanner.nextLine());
                if (playerOne.getPlayerClass().equalsIgnoreCase("warlock")) {
                    playerOne.setHealth(150);
                }
                room = 2;
            }
            if (room == 2) {
                emptyLine();
                System.out.println("Welcome " + playerOne.getName() + " the " + playerOne.getPlayerClass() + "!");
                emptyLine();
                System.out.println("Your adventure begins at a local inn,The Rowdy Goat, in the town of Black Falls....");
                emptyLine();
                System.out.println("A strange man with a missing approaches you and offers you a drink, he says it's the finest ale in all of the land.");
                System.out.println("Take the drink or ignore the man?");
                System.out.print("> ");
                command = scanner.nextLine();
                if (command.equalsIgnoreCase("take the drink")) {
                    System.out.println();
                    playerOne.setHealth(takeDamage(playerOne.getHealth(), 1000));
                    gameOver = true;
                }
            }
        }
    }

    public static void emptyLine() {
        System.out.println(" ");
    }
    public static void makeSeparator() {
        String separator = " _ ";
        System.out.println(separator.repeat(30));
    }
    public static int takeDamage(int playerHealth, int damage) {
        System.out.println("Player has taken " + damage + " damage.");
        int newPlayerHealth = playerHealth - damage;
        if (newPlayerHealth <= 0) {
            System.out.println("You Are Dead!");
        }
        return newPlayerHealth;
    }
}