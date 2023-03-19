package machine;

import java.util.Scanner;

public class CoffeeMaker {
    public enum Action {
        BUY,
        FILL,
        TAKE,
        REMAINING,
        EXIT
    }
    private int water;
    private int milk;
    private int coffeebeans;
    private int cups;
    private int money;

    public CoffeeMaker(int water, int milk, int coffeebeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeebeans = coffeebeans;
        this.cups = cups;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffebeans() {
        return coffeebeans;
    }

    public void setCoffebeans(int coffeebeans) {
        this.coffeebeans = coffeebeans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeebeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println(money + " of money");
    }

    public int take() {
        int moneyGive;
        moneyGive = money;
        money = 0;
        return moneyGive;
    }

    public void fill(int water, int milk, int coffeebeans, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffeebeans += coffeebeans;
        this.cups += cups;
    }

    public void whatToDo(Action a) {
        Scanner in = new Scanner(System.in);
        switch (a) {
            case BUY:
                String choose;
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                choose = in.nextLine();
                buyFromCoffeeMaker(choose);
                break;
            case FILL:
                int water;
                int milk;
                int coffeebeans;
                int cups;
                System.out.println("Write how many ml of water you want to add:");
                water = in.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                milk = in.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                coffeebeans = in.nextInt();
                System.out.println("Write how many disposable cups you want to add:");
                cups = in.nextInt();
                fill(water, milk, coffeebeans, cups);
                break;
            case TAKE:
                take();
                break;
            case REMAINING:
                printStatus();
                break;
        }
    }

    private void buyFromCoffeeMaker(String typeOfCoffee) {
        if (typeOfCoffee.equals("back"))
            return;

        switch (Integer.parseInt(typeOfCoffee)) {
            case 1: //Espresso
                makeCoffee(250, 0, 16, 4);
                break;
            case 2: // Latte
                makeCoffee(350, 75, 20, 7);
                break;
            case 3: // Cappuccino
                makeCoffee(200, 100, 12, 6);
                break;
        }
    }

    private void makeCoffee(int water, int milk, int coffeebeans, int money) {
        if(checkIfHave(water, milk, coffeebeans)) {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= water;
            this.milk -= milk;
            this.coffeebeans -= coffeebeans;
            this.money += money;
            this.cups -= 1;
        } else {
            if (water > this.water)
                System.out.println("Sorry, not enough water!");
            if (milk > this.milk)
                System.out.println("Sorry, not enough milk!");
            if (coffeebeans > this.coffeebeans)
                System.out.println("Sorry, not enough coffee beans!");
        }
    }

    public boolean checkIfHave(int water, int milk, int coffeebeans) {
        if (water <= this.water && milk <= this.milk && coffeebeans <= this.coffeebeans) {
            return true;
        } else {
            return false;
        }
    }
}
