package model;

import exceptions.InvalidInputException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Country.*;
import static model.Material.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ClothingTest {

    private Clothing clothingTest1;
    private Clothing clothingTest2;
    private Clothing clothingTest3;
    private Clothing clothingTest4;


    @BeforeEach
    public void runBefore() {
        try {
            clothingTest1 = new Clothing("top", BANGLADESH, COTTON);
        } catch (InvalidInputException e) {
            fail();
        }
        try {
            clothingTest2 = new Clothing("skirt", CAMBODIA, DENIM);
        } catch (InvalidInputException e) {
            fail();
        }
    }


    @Test
    public void testConstructor1() {
        assertEquals("top", clothingTest1.getName());
        assertEquals(BANGLADESH, clothingTest1.getCountry());
        assertEquals(COTTON, clothingTest1.getMaterial());
    }

    @Test
    public void testConstructor2() {
        assertEquals("skirt", clothingTest2.getName());
        assertEquals(CAMBODIA, clothingTest2.getCountry());
        assertEquals(DENIM, clothingTest2.getMaterial());
    }

    @Test
    public void testSetCountry() {
        clothingTest1.setCountry(PAKISTAN);
        assertEquals(PAKISTAN, clothingTest1.getCountry());
    }

    @Test
    public void testSetMaterial() {
        clothingTest1.setMaterial(NYLON);
        assertEquals(NYLON, clothingTest1.getMaterial());
    }

    @Test
    public void testSetName() {
        clothingTest1.setName("shirt");
        assertEquals("shirt", clothingTest1.getName());
    }

    @Test
    public void exceptionThrownTest() {
        try {
            clothingTest3 = new Clothing("jacket", null, null);
            fail();
        } catch (InvalidInputException e) {
            //thrown
        }

    }

    @Test
    public void exceptionThrownTestNullName() {
        try {
            clothingTest3 = new Clothing(null, CAMBODIA, NYLON);
            fail();
        } catch (InvalidInputException e) {
            //thrown
        }
    }

    @Test
    public void exceptionThrownTestNullCountry() {
        try {
            clothingTest3 = new Clothing("jacket", null, NYLON);
            fail();
        } catch (InvalidInputException e) {
            //thrown
        }
    }

    @Test
    public void exceptionThrownTestNullMaterial() {
        try {
            clothingTest3 = new Clothing("jacket", CAMBODIA, null);
            fail();
        } catch (InvalidInputException e) {
            //thrown
        }
    }

    @Test
    public void testToJson() {
        // Create a Clothing object

        // Convert the Clothing object to a JSON object
        JSONObject json = clothingTest1.toJson();

        // Verify the properties in the JSON object
        assertEquals("top", json.getString("name"));
        assertEquals("BANGLADESH", json.getString("country"));
        assertEquals("COTTON", json.getString("material"));
    }


}
