package com.driver;

public class Pizza {
    private int price;
    private boolean isVeg;
    private boolean extraCheeseAdded;
    private boolean extraToppingsAdded;
    private boolean takeawayAdded;
    private final int baseVegPrice = 300;
    private final int baseNonVegPrice = 400;
    private final int extraCheesePrice = 80;
    private final int extraToppingsVegPrice = 70;
    private final int extraToppingsNonVegPrice = 120;
    private final int paperBagPrice = 20;
    private StringBuilder bill;

    public Pizza(boolean isVeg){
        this.isVeg = isVeg;
        this.extraCheeseAdded = false;
        this.extraToppingsAdded = false;
        this.takeawayAdded = false;
        this.bill = new StringBuilder();
        this.price = isVeg ? baseVegPrice : baseNonVegPrice;
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        if (!extraCheeseAdded) {
            this.price += extraCheesePrice;
            extraCheeseAdded = true;
            bill.append("Extra Cheese Added: ").append(extraCheesePrice).append("\n");
        }
    }

    public void addExtraToppings(){
        if (!extraToppingsAdded) {
            int extraToppingsPrice = isVeg ? extraToppingsVegPrice : extraToppingsNonVegPrice;
            this.price += extraToppingsPrice;
            extraToppingsAdded = true;
            bill.append("Extra Toppings Added: ").append(extraToppingsPrice).append("\n");
        }
    }

    public void addTakeaway(){
        if (!takeawayAdded) {
            this.price += paperBagPrice;
            takeawayAdded = true;
            bill.append("Paper bag Added: ").append(paperBagPrice).append("\n");
        }
    }

    public String getBill(){
        bill.insert(0, "Base Price Of The Pizza: " + this.getPrice() + "\n");
        bill.append("Total Price: ").append(this.price).append("\n");
        return bill.toString();
    }

}
