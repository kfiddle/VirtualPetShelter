

public class VirtualPet {
    private String name;
    private String description;
    private int age;
    private int hunger;
    private int thirst;
    private int vigilance;
    private int fatigue;
    private int huntDesire;
    private int assessment;


    public VirtualPet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public VirtualPet(String name, int age, String description) {
        this.name = name;
        setAge(age);
        setAssessment();
        this.description = description;
    }

    public VirtualPet(String name, int age, String description, int hunger, int thirst, int vigilance, int fatigue, int huntDesire) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.hunger = hunger;
        this.thirst = thirst;
        this.vigilance = vigilance;
        this.fatigue = fatigue;
        this.huntDesire = huntDesire;
        setAssessment();
    }

    //setting age will initialize other variables

    public void setAge(int age) {
        this.age = age;

        if (age >= 15) {
            hunger = 6;
            thirst = 20;
            vigilance = 5;
            fatigue = 25;
            huntDesire = 0;


        } else if (age >= 10) {
            hunger = 10;
            thirst = 15;
            vigilance = 15;
            fatigue = 15;
            huntDesire = 5;


        } else if (age >= 5) {
            hunger = 10;
            thirst = 15;
            vigilance = 15;
            fatigue = 10;
            huntDesire = 10;


        } else if (age >= 2) {
            hunger = 15;
            thirst = 15;
            vigilance = 20;
            fatigue = 10;
            huntDesire = 15;


        } else {
            hunger = 20;
            thirst = 20;
            vigilance = 15;
            fatigue = 0;
            huntDesire = 20;
        }
    }

    public void setAssessment(){
        assessment = hunger + thirst + vigilance + fatigue + huntDesire;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getAge() {
        return age;
    }
    public int getHunger() {
        return hunger;
    }
    public int getThirst() {
        return thirst;
    }
    public int getVigilance() {
        return vigilance;
    }
    public int getFatigue() {
        return fatigue;
    }
    public int getHuntDesire() {
        return huntDesire;
    }
    public int getAssessment() {
        return assessment;
    }



    public void addHunger(int i) {
        hunger += i;
    }

    public void addFatigue(int i) {
        fatigue += i;
    }

    public void addThirst(int i) {
        thirst += i;
    }

    public String petToString() {
        setAssessment();
        return String.format("%-10s %8d %8d %8d %8d %9d %9d", name, assessment, hunger, thirst, vigilance, fatigue, huntDesire);
    }


    // basic feeding, which affects the variables for hunger, fatigue, thirst, and vigilance.
    // feed either wet food, dry food, or a treat. Each of these call the feeding method


    public void giveWater(int i) {
        thirst -= (2 * i);
    }

    public void feed(int i) {
        hunger -= i;
        vigilance -= i;
        fatigue += i;
    }

    public void feedDryFood(int i) {
        feed(i);
        thirst += 2;
    }

    public void feedWetFood(int i) {
        feed(i * 3);
        thirst -= 5;
    }

    public void feedTreat(int i) {
        feed(i * 2);
        vigilance -= 10;
    }

    public void stroke() {
        vigilance -= 10;
        huntDesire -= 10;
    }


    public void hunt() {
        if (age > 10) {
            System.out.println(name + " is getting a bit old for this!");
            hunger -= 5;
            fatigue += 10;
        } else if (age > 5) {
            hunger -= 10;
            huntDesire -= 10;
        } else {
            hunger -= 20;
            huntDesire -= 25;
            vigilance -= 10;
            fatigue += 10;
        }
    }

    public void play() {
        if (age > 10) {
            System.out.println(name + " isn't as into this as a few years ago, but ok.");
            fatigue += 10;
            vigilance -= 10;
            huntDesire -= 5;

        } else if (age > 5) {
            fatigue += 5;
            vigilance -= 5;
            huntDesire -= 10;

        } else {
            System.out.println("Wise choice for a young one!");
            fatigue += 10;
            vigilance -= 5;
            huntDesire -= 10;
        }
    }
}









