package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        CoffeeMaker machine = new CoffeeMaker(400, 540, 120, 9, 550);
        Scanner in = new Scanner(System.in);
        String action;
        boolean exit = false;
        while (!exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = in.nextLine();
            switch (action) {
                case "buy":
                    machine.whatToDo(CoffeeMaker.Action.BUY);
                    break;
                case "fill":
                    machine.whatToDo(CoffeeMaker.Action.FILL);
                    break;
                case "take":
                    machine.whatToDo(CoffeeMaker.Action.TAKE);
                    break;
                case "remaining":
                    machine.whatToDo(CoffeeMaker.Action.REMAINING);
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        }
    }
}
