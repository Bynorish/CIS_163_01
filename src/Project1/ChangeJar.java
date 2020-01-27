package Project1;


import java.io.*;
import java.text.ParsePosition;
import java.util.*;

/**
 * The purpose this class is to simulate a change Jar.
 * NOTE: MUCH MORE CODING IS NEEDED IN THESE METHODS, and you
 * will need to comply with the Java Style Guide.
 * HOWEVER,  HERE IS SOME STARTING CODE.
 *
 * @author Croitoru Adrian
 */

public class ChangeJar {

    /**
     * The number of quarters in the current Jar
     */
    private int quarters;

    /**
     * The number of dimes in the current Jar
     */
    private int dimes;

    /**
     * The number of nickels in the current Jar
     */
    private int nickels;

    /**
     * The number of pennies in the current Jar
     */
    private int pennies;
    /**
     * The current status of the jar, open or closed
     */
    private static boolean isOpen = true;

    /******************************************************************
     *  The is the default constructor for ChangeJar
     */

    public ChangeJar() {

        quarters = 0;
        dimes = 0;
        nickels = 0;
        pennies = 0;

    }

    /******************************************************************
     *
     *   This constructor creates a Change Jar from an existing
     *    Change Jar.
     *
     * @param other is an existing Change Jar
     */

    public ChangeJar(ChangeJar other) {
        super();
        quarters = other.quarters;
        dimes = other.dimes;
        nickels = other.nickels;
        pennies = other.pennies;

    }

/*
    public ChangeJar(Object temp) {
        super();

        if (temp != null) {
            if (temp instanceof ChangeJar) {
                ChangeJar other = (ChangeJar) temp;
                if (other.quarters < 0 || other.dimes < 0 ||
                        other.nickels < 0 || other.pennies < 0)
                    throw new IllegalArgumentException();

                quarters = other.quarters;
                dimes = other.dimes;
                nickels = other.nickels;
                pennies = other.pennies;

            } else throw new IllegalArgumentException();
        }
    }
*/


    /******************************************************************
     *
     *   This constructor creates a Change Jar from with some
     *   initial values for Quarters, Dimes, Nickels, and Pennies.
     **
     * @param quarters is the number of quarters to start with.
     * @param dimes is the number of dimes to start with.
     * @param nickels is the number of nickels to start with.
     * @param pennies is the number of pennies to start with.
     *
     */
    public ChangeJar(int quarters, int dimes, int nickels, int pennies) {


        if (quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0)
            throw new IllegalArgumentException();
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;

    }

// REMEMBER to use the Java Style Guide for the rest of your code.

    /******************************************************************
     *  Method that receives an amount to be converted into coins
     *  @param amount is to be converted in coins
     */
    public ChangeJar(double amount) {
        super();
        if (amount > 0.0) {

            int tempamount = (int) (amount * 100);
            this.quarters = tempamount / 25;

            tempamount = tempamount % 25;

            this.dimes = tempamount / 10;
            tempamount = tempamount % 10;

            this.nickels = tempamount / 5;
            tempamount = tempamount % 5;

            this.pennies = tempamount;
        } else
            throw new IllegalArgumentException();

    }

    /**
     * Constructor that accepts a string and converts it to coins
     *
     * @param number is a string that ends in .0 or .00
     */
    public ChangeJar(String number) {
        super();

        if (number.matches("^\\d+(\\.\\d{1,2})$")) {
            double coins = Double.parseDouble(number);
            int amount = (int) (coins * 100);

            this.quarters = (amount / 25);
            amount = amount % 25;

            this.dimes = (amount / 10);
            amount = amount % 10;

            this.nickels = (amount / 5);
            amount = amount % 5;

            this.pennies = (amount);

        } else
            throw new IllegalArgumentException();

    }

    /**
     * Subtracts the given coins from jar
     */
/*
    public void subtract(int quarters, int dimes, int nickels, int pennies) {
        if (isOpen) {
            if (quarters > this.quarters || dimes > this.dimes ||
                    nickels > this.nickels || pennies > this.pennies)
                throw new IllegalArgumentException();
            else if (quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0)
                throw new IllegalArgumentException();
            else {
                this.quarters = this.quarters - quarters;
                this.dimes = this.dimes - dimes;
                this.nickels = this.nickels - nickels;
                this.pennies = this.pennies - pennies;
            }
        } else
            System.out.println("Jar is closed");
    }
*/

    /**
     * Subtracts coins from this Jar
     * and place them in the given Jar Object
     */
    public void subtract(ChangeJar other) {

        if (isOpen) {
            if (other.quarters > this.quarters || other.dimes > this.dimes ||
                    other.nickels > this.nickels || other.pennies > this.pennies)
                throw new IllegalArgumentException();
            else if (other.quarters < 0 || other.dimes < 0 ||
                    other.nickels < 0 || other.pennies < 0)
                throw new IllegalArgumentException();
   /*         else if (this.quarters < 0 || this.dimes < 0 ||
                    this.nickels < 0 || this.pennies < 0)
                throw new IllegalArgumentException();*/
            else {
                int q, d, n, p;
                q = this.quarters;
                d = this.dimes;
                n = this.nickels;
                p = this.pennies;

                this.quarters = this.quarters - other.quarters;
                this.dimes = this.dimes - other.dimes;
                this.nickels = this.nickels - other.nickels;
                this.pennies = this.pennies - other.pennies;

                other.quarters += q;
                other.dimes += d;
                other.nickels += n;
                other.pennies += p;
            }
        } else
            System.out.println("Jar is closed");
    }

    /**
     * Removes a penny from the jar
     */
    public void dec() {
        if (isOpen) {
            if (this.pennies > 0)
                this.pennies--;
            else
                throw new IllegalArgumentException();
        } else
            System.out.println("Jar is closed");
    }

    /**
     * Adds coins to the jar
     */
    public void add(int quarters, int dimes, int nickels, int pennies) {
        if (isOpen) {
            if (quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0)
                throw new IllegalArgumentException();

            this.quarters = this.quarters + quarters;
            this.dimes = this.dimes + dimes;
            this.nickels = this.nickels + nickels;
            this.pennies = this.pennies + pennies;
        } else
            System.out.println("Jar is closed");
    }

    /**
     * Adds a penny to the jar
     */

    public void inc() {
        if (isOpen) {
/*            if (this.pennies < 0)
                throw new IllegalArgumentException();*/
            this.pennies++;
        } else
            System.out.println("Jar is closed");
    }

    /**
     * Add all the coins from another jar
     */
    public void add(ChangeJar other) {
        if (isOpen) {
            if (other.quarters < 0 || other.dimes < 0 ||
                    other.nickels < 0 || other.pennies < 0)
                throw new IllegalArgumentException();
            this.quarters = this.quarters + other.quarters;
            this.dimes = this.dimes + other.dimes;
            this.nickels = this.nickels + other.nickels;
            this.pennies = this.pennies + other.pennies;
            other.quarters = 0;
            other.dimes = 0;
            other.nickels = 0;
            other.pennies = 0;
        } else
            System.out.println("Jar is closed");
    }

    /**
     * Converts all coins to pennies
     */
    private static int convertToPennies(ChangeJar temp) {

        return (temp.quarters * 25) + (temp.dimes * 10) + (temp.nickels * 5) + temp.pennies;


    }

    /**
     * Turns jar modification on or off
     */
    public static void mutate(boolean selected) {

        ChangeJar.isOpen = selected;
    }

//    public boolean equals(ChangeJar s) {
//
//        return (this.quarters * 25 + this.dimes * 10 + this.nickels * 5 + this.dimes) ==
//                (s.quarters * 25 + s.dimes * 10 + s.nickels * 5 + s.dimes);
//
//    }

    public boolean equals(Object other) {
        if (other != null)
            if (other instanceof ChangeJar) {
                ChangeJar s = (ChangeJar) other;
                return (this.quarters * 25 + this.dimes * 10 + this.nickels * 5 + this.dimes) ==
                        (s.quarters * 25 + s.dimes * 10 + s.nickels * 5 + s.dimes);
            }
        throw new IllegalArgumentException();
    }

    public static boolean equals(ChangeJar s, ChangeJar s1) {
        return (s.quarters * 0.25 + s.dimes * 0.10 + s.nickels * 0.05 + s.pennies) ==
                (s1.quarters * 0.25 + s1.dimes * 0.10 + s1.nickels * 0.05 + s1.pennies);
    }

    public int compareTo(ChangeJar s) {
        return Integer.compare(this.quarters * 25 + this.dimes * 10 + this.nickels * 5 + this.pennies, s.quarters * 25 + s.dimes * 10 + s.nickels * 5 + s.pennies);
    }

    public static int compareTo(ChangeJar jar1, ChangeJar jar2) {
        return Integer.compare(jar2.quarters * 25 + jar2.dimes * 10 + jar2.nickels * 5 + jar2.pennies, jar1.quarters * 25 + jar1.dimes * 10 + jar1.nickels * 5 + jar1.pennies);
    }

    public void takeOut(int quarters, int dimes, int nickels, int pennies) {

        if (isOpen) {
            if (quarters < 0 || dimes < 0 ||
                    nickels < 0 || pennies < 0) {
                throw new IllegalArgumentException();
            } else if (this.quarters < quarters || this.dimes < dimes ||
                    this.nickels < nickels || this.pennies < pennies)
                throw new IllegalArgumentException();
            else {
                this.quarters -= quarters;
                this.dimes -= dimes;
                this.nickels -= nickels;
                this.pennies -= pennies;
            }
        } else {
            System.out.println("Jar is closed");
        }

    }

    public ChangeJar takeOut(double amount) {
        final double threshold = 0.006;

        if ((amount + threshold) * 100 < 0) {
            throw new IllegalArgumentException();
        }

        if ((amount) * 100 > convertToPennies(this))
            throw new IllegalArgumentException();

        if (isOpen) {


            /*
        String x = String.valueOf(amount);
        int index = x.indexOf(".");

        if (index >0)
            x = x.substring(0,index+2);

        if (!x.matches("^\\d+(\\.\\d{1,2})$"))
            throw new IllegalArgumentException();
*/

            int a = -1, b = -1, c = -1, d = -1;


            for (int i = 0; i < 4; i++) {
                int tempQuarter = 0;
                int tempDime = 0;
                int tempNickle = 0;
                int tempPenny = 0;
                int counterA = 0, counterB = 0, counterC = 0, counterD = 0;

                int tempamount = (int) ((amount + threshold) * 100);
                ChangeJar jartest = new ChangeJar(this.quarters, this.dimes, this.nickels, this.pennies);

                while (jartest.quarters > a + 1 && tempamount >= 25) {
                    jartest.quarters--;
                    tempamount -= 25;
                    tempQuarter++;
                    counterA++;
                }
                while (jartest.dimes > b + 1 && tempamount >= 10) {
                    jartest.dimes--;
                    tempamount -= 10;
                    tempDime++;
                    counterB++;
                }
                while (jartest.nickels > c + 1 && tempamount >= 5) {
                    jartest.nickels--;
                    tempamount -= 5;
                    tempNickle++;
                    counterC++;
                }
                while (jartest.pennies > d + 1 && tempamount >= 1) {
                    jartest.pennies--;
                    tempamount -= 1;
                    tempPenny++;
                    counterD++;
                }
                if (tempamount == 0) {

                    System.out.println("Removed " + amount + " from Jar");
                    this.quarters -= tempQuarter;
                    this.dimes -= tempDime;
                    this.nickels -= tempNickle;
                    this.pennies -= tempPenny;

                    jartest.quarters = tempQuarter;
                    jartest.dimes = tempDime;
                    jartest.nickels = tempNickle;
                    jartest.pennies = tempPenny;

                    return jartest;

                } else if (c >= 0)
                    d = this.pennies - counterD;
                if (b >= 0 && c + 1 == 0)
                    c = this.nickels - counterC;
                if (a >= 0 && b + 1 == 0)
                    b = this.dimes - counterB;
                if (a + 1 == 0)
                    a = this.quarters - counterA;
            }

        } else {
           /* System.out.println("Unable to take out the specified amount");*/
            return null;
        }

        return null;
    }

    public String toString() {


        String s = this.quarters + " Quarter" + ((quarters != 1) ? "s" : "") + "\n";
        s = s + this.dimes + " Dime" + ((dimes != 1) ? "s" : "") + "\n";
        s = s + this.nickels + " Nickel" + ((nickels != 1) ? "s" : "") + "\n";
        s = s + this.pennies + " Penn" + ((dimes != 1) ? "ies" : "y") + "\n";

        return s;
    }

    public void save(String fileName) throws IOException {

        PrintWriter out;
        out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

        out.println(this.quarters + "," + this.dimes + "," +
                this.nickels + "," + this.pennies + "\n");
        out.close();
    }


    public void load(String fileName) {

        Scanner scanner = null;
        int q, d, n, p;
        try {
            scanner = new Scanner(new File(fileName));
            scanner.useDelimiter("[,\r\n]+");


            q = scanner.nextInt();
            d = scanner.nextInt();
            n = scanner.nextInt();
            p = scanner.nextInt();
            if (q < 0 || d < 0 || n < 0 || p < 0) {
                throw new IllegalArgumentException();
            }
            this.quarters = q;
            this.dimes = d;
            this.nickels = n;
            this.pennies = p;

        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

    }

    public double getAmount() {
        return convertToPennies(this) / 100.0;
    }


    public static void main(String[] args) {
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        if (quarters >= 0)
            this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        if (dimes >= 0)
            this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        if (nickels >= 0)
            this.nickels = nickels;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        if (pennies >= 0)
            this.pennies = pennies;
    }

    public void setNegQuarters(int quarters) {
        this.quarters = quarters;
    }

    public void setNegDimes(int quarters) {
        this.dimes = quarters;
    }

    public void setNegNickels(int quarters) {
        this.nickels = quarters;
    }

    public void setNegPennies(int quarters) {
        this.pennies = quarters;
    }


}