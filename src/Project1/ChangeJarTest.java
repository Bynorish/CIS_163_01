package Project1;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;


public class ChangeJarTest {


    /**
     * Your assignment is to write many more test cases to
     * have a robust testing, more than just 100% coverage.
     * <p>
     * Some examples are provided to help you get started
     */


    // Testing valid constructors with wide range of values
    @Test
    public void testConstructor() {
        ChangeJar jar1 = new ChangeJar(6, 5, 4, 2);

        assertEquals(6, jar1.getQuarters());
        assertEquals(5, jar1.getDimes());
        assertEquals(4, jar1.getNickels());
        assertEquals(2, jar1.getPennies());

        ChangeJar jar2 = new ChangeJar();

        assertEquals(0, jar2.getQuarters());
        assertEquals(0, jar2.getDimes());
        assertEquals(0, jar2.getNickels());
        assertEquals(0, jar2.getPennies());

        ChangeJar jar3 = new ChangeJar(jar1);

        assertEquals(6, jar3.getQuarters());
        assertEquals(5, jar3.getDimes());
        assertEquals(4, jar3.getNickels());
        assertEquals(2, jar3.getPennies());

        ChangeJar jar4 = new ChangeJar(1.22);

        assertEquals(4, jar4.getQuarters());
        assertEquals(2, jar4.getDimes());
        assertEquals(0, jar4.getNickels());
        assertEquals(2, jar4.getPennies());

        ChangeJar jar5 = new ChangeJar(1.27);

        assertEquals(5, jar5.getQuarters());
        assertEquals(0, jar5.getDimes());
        assertEquals(0, jar5.getNickels());
        assertEquals(2, jar5.getPennies());


    /*    testOBJ testOBJ= new testOBJ(1,3,4,5);

        ChangeJar jar6 = new ChangeJar(testOBJ);

        assertEquals(1, jar6.getQuarters());
        assertEquals(3, jar6.getDimes());
        assertEquals(4, jar6.getNickels());
        assertEquals(5, jar6.getPennies());*/
    }

    // Testing all Setters
    @Test
    public void SetterTest() {
        ChangeJar jar = new ChangeJar(5, 3, 2, 6);

        jar.setQuarters(10);
        assertEquals(10, jar.getQuarters());
        jar.setDimes(1);
        assertEquals(1, jar.getDimes());
        jar.setNickels(5);
        assertEquals(5, jar.getNickels());
        jar.setPennies(0);
        assertEquals(0, jar.getPennies());

    }

    // Testing toString String class
    @Test
    public void ToString() {
        ChangeJar jar = new ChangeJar(5, 3, 2, 6);

        System.out.println(jar.toString());
        ChangeJar jar1 = new ChangeJar(1, 1, 1, 1);

        System.out.println(jar1.toString());

    }

    // Testing String Constructor with a 2 decimal string
    @Test
    public void testNormalStringtoJar1() {

        String s = "1.22";

        ChangeJar jar = new ChangeJar(s);

        assertEquals(4, jar.getQuarters());
        assertEquals(2, jar.getDimes());
        assertEquals(0, jar.getNickels());
        assertEquals(2, jar.getPennies());


    }

    // Testing String Constructor with a 2 decimal string
    @Test
    public void testNormalStringtoJar2() {

        String s = "1.27";

        ChangeJar jar = new ChangeJar(s);

        assertEquals(5, jar.getQuarters());
        assertEquals(0, jar.getDimes());
        assertEquals(0, jar.getNickels());
        assertEquals(2, jar.getPennies());


    }

    // Testing String Constructor with a 1 decimal string
    @Test
    public void testNormalStringtoJar3() {

        String s = "2.7";

        ChangeJar jar = new ChangeJar(s);

        assertEquals(10, jar.getQuarters());
        assertEquals(2, jar.getDimes());
        assertEquals(0, jar.getNickels());
        assertEquals(0, jar.getPennies());


    }

    // Testing String Constructor with a 1 decimal string
    @Test
    public void testNormalStringtoJar4() {

        String s = "0.9";

        ChangeJar jar = new ChangeJar(s);

        assertEquals(3, jar.getQuarters());
        assertEquals(1, jar.getDimes());
        assertEquals(1, jar.getNickels());
        assertEquals(0, jar.getPennies());


    }

/*
    @Test
    public void TestGetAmount()
    {
        ChangeJar jar = new ChangeJar(1.27);
        assertEquals(5, jar.getQuarters());
        assertEquals(0, jar.getDimes());
        assertEquals(0, jar.getNickels());
        assertEquals(2, jar.getPennies());


    }
*/


    // testing valid takeOut with wide range of
    // quarters, dimes, nickels, pennies
    @Test
    public void testTakeOut1() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);

        jar.takeOut(1, 1, 1, 1);

        assertEquals(2, jar.getQuarters());
        assertEquals(2, jar.getDimes());
        assertEquals(1, jar.getNickels());
        assertEquals(1, jar.getPennies());
    }

    // testing valid takeOut with wide range of amounts
    @Test
    public void testTakeOut2() {
        ChangeJar jar1 = new ChangeJar(5, 3, 4, 3);
        ChangeJar jar2 = jar1.takeOut(1.22);

        assertEquals(1, jar1.getQuarters());
        assertEquals(1, jar1.getDimes());
        assertEquals(4, jar1.getNickels());
        assertEquals(1, jar1.getPennies());

        assertEquals(4, jar2.getQuarters());
        assertEquals(2, jar2.getDimes());
        assertEquals(0, jar2.getNickels());
        assertEquals(2, jar2.getPennies());
    }

    // testing valid takeOut with wide range of amounts


    // testing valid takeOut with wide range of
    // quarters, dimes, nickels, pennies
    @Test
    public void testTakeOut3() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);

        ChangeJar.mutate(false);
        jar.takeOut(1, 1, 1, 1);

        assertEquals(3, jar.getQuarters());
        assertEquals(3, jar.getDimes());
        assertEquals(2, jar.getNickels());
        assertEquals(2, jar.getPennies());
        ChangeJar.mutate(true);
    }

    // testing valid takeOut with wide range of amounts
    @Test
    public void testTakeOut4() {
        ChangeJar jar1 = new ChangeJar(8, 5, 4, 3);
        ChangeJar jar2 = jar1.takeOut(1.30);

        assertEquals(3, jar1.getQuarters());
        assertEquals(5, jar1.getDimes());
        assertEquals(3, jar1.getNickels());
        assertEquals(3, jar1.getPennies());

        assertEquals(5, jar2.getQuarters());
        assertEquals(0, jar2.getDimes());
        assertEquals(1, jar2.getNickels());
        assertEquals(0, jar2.getPennies());
    }

    @Test
    public void testTakeOut5() {
        ChangeJar jar1 = new ChangeJar(36, 3, 0, 0);
        ChangeJar jar2 = jar1.takeOut(0.80);

        assertEquals(34, jar1.getQuarters());
        assertEquals(0, jar1.getDimes());
        assertEquals(0, jar1.getNickels());
        assertEquals(0, jar1.getPennies());

        assertEquals(2, jar2.getQuarters());
        assertEquals(3, jar2.getDimes());
        assertEquals(0, jar2.getNickels());
        assertEquals(0, jar2.getPennies());

    }

    @Test
    public void testTakeOut6() {
        ChangeJar jar1 = new ChangeJar(0, 0, 0, 1);
        ChangeJar jar2 = jar1.takeOut(0.01);

        assertEquals(0, jar1.getQuarters());
        assertEquals(0, jar1.getDimes());
        assertEquals(0, jar1.getNickels());
        assertEquals(0, jar1.getPennies());

        assertEquals(0, jar2.getQuarters());
        assertEquals(0, jar2.getDimes());
        assertEquals(0, jar2.getNickels());
        assertEquals(1, jar2.getPennies());

    }

    //Test when unable to exactly takeout
    @Test
    public void testTakeOut7() {

        ChangeJar jar1 = new ChangeJar(8, 5, 4, 3);


        ChangeJar.mutate(false);
        ChangeJar jar2 = jar1.takeOut(1.30);
        ChangeJar.mutate(true);

        assertNull(jar2);
    }

    //Test with Takeout with closed Jar
    @Test
    public void testTakeOut8() {
        ChangeJar jar1 = new ChangeJar(1, 5, 6, 0);
        ChangeJar jar2 = jar1.takeOut(0.77);

        assertNull(jar2);
    }

    @Test
    public void testGetAmount() {
        ChangeJar jar1 = new ChangeJar(1, 5, 4, 0);
        double test = jar1.getAmount();
        assertEquals(0.95, test, 0.001);
    }


    @Test
    //Test subtract method with ChangerJar object
    public void subtract() {
        ChangeJar jar1 = new ChangeJar(5, 6, 8, 1);
        ChangeJar jar2 = new ChangeJar(2, 3, 6, 0);
        jar1.subtract(jar2);

        assertEquals(3, jar1.getQuarters());
        assertEquals(3, jar1.getDimes());
        assertEquals(2, jar1.getNickels());
        assertEquals(1, jar1.getPennies());

        //test with mutate off + subtract

        jar1 = new ChangeJar(5, 8, 1, 2);
        jar2 = new ChangeJar(2, 1, 0, 2);

        ChangeJar.mutate(false);

        jar1.subtract(jar2);

        assertEquals(5, jar1.getQuarters());
        assertEquals(8, jar1.getDimes());
        assertEquals(1, jar1.getNickels());
        assertEquals(2, jar1.getPennies());

        ChangeJar.mutate(true);

    }


    @Test
    //Test dec method with that removes 1 penny
    public void dec() {
        ChangeJar jar1 = new ChangeJar(2, 3, 3, 5);
        jar1.dec();

        assertEquals(2, jar1.getQuarters());
        assertEquals(3, jar1.getDimes());
        assertEquals(3, jar1.getNickels());
        assertEquals(4, jar1.getPennies());

        //test with mutate off

        ChangeJar.mutate(false);

        jar1.dec();

        assertEquals(2, jar1.getQuarters());
        assertEquals(3, jar1.getDimes());
        assertEquals(3, jar1.getNickels());
        assertEquals(4, jar1.getPennies());

        ChangeJar.mutate(true);

    }

    // testing putIn for valid low numbers
    @Test
    public void testPutIn() {
        ChangeJar jar = new ChangeJar();
        jar.add(2, 3, 4, 5);
        assertEquals(2, jar.getQuarters());
        assertEquals(3, jar.getDimes());
        assertEquals(4, jar.getNickels());
        assertEquals(5, jar.getPennies());

        //test with mutate off

        ChangeJar.mutate(false);

        jar.add(1, 3, 4, 6);

        assertEquals(2, jar.getQuarters());
        assertEquals(3, jar.getDimes());
        assertEquals(4, jar.getNickels());
        assertEquals(5, jar.getPennies());

        ChangeJar.mutate(true);
    }

    @Test
    //Test inc method with that adds 1 penny
    public void inc() {
        ChangeJar jar1 = new ChangeJar(1, 5, 1, 0);
        jar1.inc();

        assertEquals(1, jar1.getQuarters());
        assertEquals(5, jar1.getDimes());
        assertEquals(1, jar1.getNickels());
        assertEquals(1, jar1.getPennies());

        //test with mutate off

        ChangeJar.mutate(false);

        jar1.inc();

        assertEquals(1, jar1.getQuarters());
        assertEquals(5, jar1.getDimes());
        assertEquals(1, jar1.getNickels());
        assertEquals(1, jar1.getPennies());

        ChangeJar.mutate(true);

    }

    //Test the add method which all coins from the second jar to the first
    @Test
    public void TestIncrease() {
        ChangeJar jar1 = new ChangeJar(2, 1, 5, 1);
        ChangeJar jar2 = new ChangeJar(3, 1, 0, 2);

        jar1.add(jar2);

        assertEquals(5, jar1.getQuarters());
        assertEquals(2, jar1.getDimes());
        assertEquals(5, jar1.getNickels());
        assertEquals(3, jar1.getPennies());

        assertEquals(0, jar2.getQuarters());
        assertEquals(0, jar2.getDimes());
        assertEquals(0, jar2.getNickels());
        assertEquals(0, jar2.getPennies());

        //test with mutate off

        jar1 = new ChangeJar(1, 3, 1, 8);
        jar2 = new ChangeJar(1, 1, 3, 2);

        ChangeJar.mutate(false);

        jar1.add(jar2);

        assertEquals(1, jar1.getQuarters());
        assertEquals(3, jar1.getDimes());
        assertEquals(1, jar1.getNickels());
        assertEquals(8, jar1.getPennies());

        assertEquals(1, jar2.getQuarters());
        assertEquals(1, jar2.getDimes());
        assertEquals(3, jar2.getNickels());
        assertEquals(2, jar2.getPennies());

        ChangeJar.mutate(true);

    }


    // Testing equals for valid numbers
    @Test
    public void testEqual() {
        ChangeJar jar1 = new ChangeJar(2, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar3 = new ChangeJar(2, 5, 4, 2);

        assertFalse(jar1.equals(jar2));
        assertTrue(jar1.equals(jar3));

    }

    @Test
    public void testEqualWithObject() {
        ChangeJar jar1 = new ChangeJar(1, 3, 6, 8);
        Object quart = new Object();
    }


    // testing compareTo all returns
    @Test
    public void testCompareTo() {
        ChangeJar jar1 = new ChangeJar(2, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar3 = new ChangeJar(2, 3, 4, 2);
        ChangeJar jar4 = new ChangeJar(2, 5, 4, 2);

        assertTrue(jar2.compareTo(jar1) > 0);
        assertTrue(jar3.compareTo(jar1) < 0);
        assertEquals(0, jar1.compareTo(jar4));
        assertTrue(ChangeJar.equals(jar1, jar4));
        assertFalse(ChangeJar.equals(jar1, jar2));
    }

    @Test
    public void testCompareTo1() {
        ChangeJar jar1 = new ChangeJar(1, 2, 3, 5);
        ChangeJar jar2 = new ChangeJar(1, 2, 3, 5);
        int test = 0;
        assertEquals(test, ChangeJar.compareTo(jar1, jar2));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////

    // load and save tests ///////////////////////////////////////////////////////////////////////
    @Test(expected = IOException.class)
    public void testLoadSave1() throws IOException {
        ChangeJar jar1 = new ChangeJar(6, 5, 4, 2);
        jar1.save("file!@#$%^&*()");
        assert false;
    }

    // load and save combined.
    @Test
    public void testLoadSave() {
        ChangeJar jar1 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);

        try {
            jar1.save("file1");
            jar1 = new ChangeJar();  // resets to zero
            jar1.load("file1");
            assertTrue(jar1.equals(jar2));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void LoadFileWithNegNumbers() throws IOException {
        ChangeJar jar1 = new ChangeJar(6, 5, 4, 2);

        jar1.load("file3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFileNotFoundWhenLoading() throws IOException {
        ChangeJar jar1 = new ChangeJar(6, 5, 4, 2);

        jar1.load("file2");
        assert false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testSubtract() {
        ChangeJar jar1 = new ChangeJar(2, 5, 4, 2);
        jar1.takeOut(1, 1, 1, 1);

        assertEquals(1, jar1.getQuarters());
        assertEquals(4, jar1.getDimes());
        assertEquals(3, jar1.getNickels());
        assertEquals(1, jar1.getPennies());

        ChangeJar.mutate(false);

        jar1.takeOut(1, 1, 1, 1);

        ChangeJar.mutate(true);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullEquals() {
        ChangeJar jar1 = new ChangeJar(1, 3, 6, 7);
        assertFalse(jar1.equals(null));
    }


    // IMPORTANT: only one test per exception!!!  //////////////////////////////////////////////////////////////
    // testing negative number for nickels in takeOut /////////////////////////////////////////////////////////////


    @Test(expected = IllegalArgumentException.class)
    public void testTakeOutNegNickels() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 1, -1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTakeOutMoreThanInJar() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 1, 3, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestMoreTakeout() {

        ChangeJar jar1 = new ChangeJar(1, 0, 2, 5);
        ChangeJar jar2 = new ChangeJar();
        jar2 = jar1.takeOut(51.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSubtractBiggerJar() {

        ChangeJar jar1 = new ChangeJar(1, 0, 2, 5);
        ChangeJar jar2 = new ChangeJar(2, 0, 2, 5);

        jar1.subtract(jar2);
    }

    // testing negative number for dimes in takeOut
    @Test(expected = IllegalArgumentException.class)
    public void testTakeOutNegDimes() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, -1, 1, 1);
    }

    // testing negative number quarters for the constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegQuarters() {

        new ChangeJar(-300, 0, 0, 0);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testStringtoJar2() {

        ChangeJar jar1 = new ChangeJar("a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringtoJar3() {

        ChangeJar jar1 = new ChangeJar("1.234");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringtoJar4() {

        ChangeJar jar1 = new ChangeJar("-12.23");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringtoJar5() {

        ChangeJar jar1 = new ChangeJar("23.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorDoubleAmount() {

        ChangeJar jar1 = new ChangeJar(-1.22);
    }


    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorOtherJar() {

        ChangeJar jar1 = new ChangeJar(-1.22);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNegTakeOutDouble() {

        ChangeJar jar1 = new ChangeJar(1, 2, 3, 4);
        jar1.takeOut(-0.25);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSubtractCoins1() {
        ChangeJar jar1 = new ChangeJar(2, 1, 4, 6);
        jar1.takeOut(2, 1, 5, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNegativeCoinsSubtract() {
        ChangeJar jar1 = new ChangeJar(2, 1, 4, 6);
        jar1.takeOut(2, -1, 2, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNegativeDec() {
        ChangeJar jar1 = new ChangeJar(2, 1, 4, 2);
        jar1.dec();
        jar1.dec();
        jar1.dec();
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNegativeadd1() {
        ChangeJar jar1 = new ChangeJar(2, 1, 4, 2);
        jar1.add(1, -4, 5, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNegativeadd2() {
        ChangeJar jar1 = new ChangeJar(1, 7, 1, 12);
        jar1.add(-4, 1, 2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNegativeadd3() {
        ChangeJar jar1 = new ChangeJar(7, 12, 4, 6);
        jar1.add(2, 4, -3, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNegativeadd4() {
        ChangeJar jar1 = new ChangeJar(0, 2, 0, 2);
        jar1.add(4, 2, 0, -9);
    }


    @Test(expected = IllegalArgumentException.class)
    public void TestNegativePenniesWithInc() {
        ChangeJar jar1 = new ChangeJar(1, 3, 4, 8);
        jar1.add(4, 2, 0, -9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNeg() {
        ChangeJar jar1 = new ChangeJar(1, 3, 4, 8);
        jar1.setNegQuarters(-1);
        ChangeJar jar2 = new ChangeJar(1, 1, 1, 1);
        jar1.subtract(jar2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNeg2() {
        ChangeJar jar1 = new ChangeJar(1, 3, 4, 8);
        ChangeJar jar2 = new ChangeJar(1, 1, 1, 1);
        jar2.setNegQuarters(-1);

        jar1.subtract(jar2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNeg3() {
        ChangeJar jar1 = new ChangeJar(1, 3, 4, 8);
        jar1.setNegDimes(-1);
        ChangeJar jar2 = new ChangeJar(1, 1, 1, 1);
        jar1.subtract(jar2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNeg4() {
        ChangeJar jar1 = new ChangeJar(1, 3, 4, 8);
        ChangeJar jar2 = new ChangeJar(1, 1, 1, 1);
        jar2.setNegDimes(-1);

        jar1.subtract(jar2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNeg5() {
        ChangeJar jar1 = new ChangeJar(1, 3, 4, 8);
        jar1.setNegNickels(-1);
        ChangeJar jar2 = new ChangeJar(1, 1, 1, 1);
        jar1.subtract(jar2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNeg6() {
        ChangeJar jar1 = new ChangeJar(1, 3, 4, 8);
        ChangeJar jar2 = new ChangeJar(1, 1, 1, 1);
        jar2.setNegNickels(-1);

        jar1.subtract(jar2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNeg7() {
        ChangeJar jar1 = new ChangeJar(1, 3, 4, 8);
        jar1.setNegPennies(-1);
        ChangeJar jar2 = new ChangeJar(1, 1, 1, 1);
        jar1.subtract(jar2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorNeg8() {
        ChangeJar jar1 = new ChangeJar(1, 3, 4, 8);
        ChangeJar jar2 = new ChangeJar(1, 1, 1, 1);
        jar2.setNegPennies(-1);

        jar1.subtract(jar2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNegAdd() {
        ChangeJar jar1 = new ChangeJar(1, 3, 7, 1);
        ChangeJar jar2 = new ChangeJar(3, 1, 5, 1);
        jar2.setNegPennies(-1);

        jar1.add(jar2);
    }


}