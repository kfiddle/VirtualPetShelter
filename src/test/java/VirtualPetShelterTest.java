import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class VirtualPetShelterTest {

    VirtualPetShelter testingShelter = new VirtualPetShelter();

    VirtualPet test1 = new VirtualPet("sandy", 11, "loves to gnaw hair");
    VirtualPet test2 = new VirtualPet("zed", 2, "is a siamese athlete");
    VirtualPet test3 = new VirtualPet("jackie", 11, "eats all day", 10, 12, 15, 20, 5);
    VirtualPet test4 = new VirtualPet("Zara", 4, "is Zed's girlfriend");
    VirtualPet test5 = new VirtualPet("Pinot", 25, "he's one old cat");
    VirtualPet test6 = new VirtualPet("Juniper", 8, "sits around", 40, 13, 11, 26, 17);
    VirtualPet test7 = new VirtualPet("Scooter", 1, "is quite playful", 30, 20, 5, 0, 20);


    @Test
    public void testingAddAPet() {
        VirtualPet homelessTestCase = new VirtualPet("sophie", "eats alot");
        testingShelter.add(homelessTestCase);
        assertEquals(testingShelter.pets.size(), 1);
        assertEquals(testingShelter.pets.get("sophie").getDescription(), "eats alot");
    }

    @Test
    public void testingTickMethod() {
        testingShelter.add(test2);
        testingShelter.tick();
        assertEquals(test2.getHunger(), 17);
    }

    @Test
    public void testingAdoption() {
        testingShelter.add(test1);
        testingShelter.adopt("sandy");
        assertEquals(testingShelter.pets.size(), 0);
    }

    @Test
    public void testingFeedAllPets() {
        testingShelter.add(test1);
        testingShelter.add(test2);
        testingShelter.feedAll(3);
        assertEquals(7, test1.getHunger());
        assertEquals(12, test2.getHunger());
    }

    @Test
    public void feedDryFoodToAPet() {
        testingShelter.add(test6);
        testingShelter.feedDryFood("Juniper", 3);
        assertEquals(test6.getHunger(), 37);
    }

    @Test
    public void feedWetFoodToAPet() {
        testingShelter.add(test6);
        testingShelter.feedWetFood("Juniper", 3);
        assertEquals(test6.getHunger(), 31);
    }

    @Test
    public void feedTreatToAPet() {
        testingShelter.add(test6);
        testingShelter.feedTreat("Juniper", 3);
        assertEquals(34, test6.getHunger(), 34);
    }

    @Test
    public void testingWaterAllPets() {
        testingShelter.add(test1);
        testingShelter.add(test2);
        testingShelter.waterAll(2);
        assertEquals(test1.getThirst(), 11);
        assertEquals(test2.getThirst(), 11);
    }

    @Test
    public void testGiveWaterToSpecificPet() {
        testingShelter.add(test2);
        testingShelter.add(test3);
        testingShelter.waterSpecificPet("zed");
        testingShelter.waterSpecificPet("jackie");
        assertEquals(test3.getThirst(), 4);
        assertEquals(test2.getThirst(), 7);
    }

    @Test
    public void testStrokePet() {
        testingShelter.add(test2);
        testingShelter.add(test3);
        test2.stroke();
        test3.stroke();
        assertEquals(test2.getHuntDesire(), 5);
        assertEquals(test3.getVigilance(), 5);
    }

    @Test
    public void testingPlayWithPet() {
        testingShelter.add(test1);
        testingShelter.playWith("sandy");
        assertEquals(test1.getVigilance(), 5);
        assertEquals(test1.getHuntDesire(), 0);
    }

    @Test
    public void testingPetNameExists() {
        testingShelter.add(test1);
        assertEquals(testingShelter.confirmName("sandy"), true);
        assertEquals(testingShelter.confirmName("larry"), false);
    }

    @Test
    public void testingFinalAverageAssessmentCalculation() {
        testingShelter.add(test3);
        testingShelter.add(test6);
        testingShelter.add(test7);
        assertEquals(testingShelter.finalPetAverageAssessment(), 81);

    }
}



