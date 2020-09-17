//import org.junit.Assert;
//import org.junit.Test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class VirtualPetTest {
    VirtualPet testPet1 = new VirtualPet("grace", "is very sweet");
    VirtualPet testPet2 = new VirtualPet("azaneth", 12, "is a demon");
    VirtualPet testPet3 = new VirtualPet("sophie", 5, "is also very sweet", 9, 11, 20, 15, 8);
    VirtualPet testPet4 = new VirtualPet("scamper", 20, "is a twit", 18, 17, 5, 10, 25);

    // test the new constructors and also makes sure age will initialize other variables

    @Test
    public void testCreatingPetObjectConstructors() {
        assertEquals(testPet3.getHunger(), 9);
        assertEquals(testPet1.getName(), "grace");
        assertEquals(testPet1.getDescription(), "is very sweet");
        assertEquals(testPet2.getAge(), 12);
        assertEquals(testPet4.getThirst(), 17);
    }


    @Test
    public void testingNewWaterMethod() {
        testPet3.giveWater(2);
        assertEquals(testPet3.getThirst(), 7);
    }

    @Test
    public void testingAssessmentCalculation() {
        assertEquals(testPet4.getAssessment(), 75);
        assertEquals(testPet2.getAssessment(), 60);
    }

    @Test
    public void testIftheBasicFeedingPetWorks() {

        testPet3.feed(5);
        assertEquals(testPet3.getHunger(), 4);
        assertEquals(testPet3.getVigilance(), 15);
    }

    @Test
    public void letsGiveDryFoodByCallingFeedMethod() {

        testPet4.feedDryFood(3);
        assertEquals(testPet4.getHunger(), 15);
        assertEquals(testPet4.getVigilance(), 2);
    }


    @Test
    public void sameTestButWithWetFood() {

        testPet3.feedWetFood(3);
        assertEquals(testPet3.getHunger(), 0);
        assertEquals(testPet3.getVigilance(), 11);
    }


    @Test
    public void sameTestButWithTreat() {

        testPet4.feedTreat(3);
        assertEquals(testPet4.getHunger(), 12);
        assertEquals(testPet4.getVigilance(), -11);
        assertEquals(testPet4.getFatigue(), 16);

    }

    @Test
    public void testGiveWaterToSpecificPet() {
        testPet3.giveWater(4);
        assertEquals(testPet3.getThirst(), 3);

    }

    @Test
    public void testThePettingMethod() {

        testPet3.stroke();
        assertEquals(testPet3.getVigilance(), 5);
    }

    @Test
    public void testHuntingMethodForPlaying() {
        testPet1.setAge(2);
        testPet1.hunt();
        assertEquals(testPet1.getHunger(), -5);
    }

    @Test
    public void testPetToy() {
        testPet1.setAge(3);
        testPet1.play();
        assertEquals(testPet1.getVigilance(), 15);
    }
}



