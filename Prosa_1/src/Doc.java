public class Doc extends Dwarf{
    public Doc(String dwarfName) {
        super(dwarfName);
        this.dwarfType = "doc";
        isHere(this);
    }

    public void startWith(Dwarf second) {
        String firstDwarf = this.dwarfName;
        String secondDwarf = second.dwarfName;
        isHere(second);
        System.out.println(firstDwarf + " is gathering everyone and finds " + secondDwarf+" first.");
        switch (second.dwarfType) {
            case "grumpy" -> System.out.println(firstDwarf + " tries to make " + secondDwarf + " calm down.");
            case "bashful" -> {
                System.out.println(firstDwarf + " is really happy to see " + secondDwarf);
                System.out.println("He gives " + secondDwarf + " a kiss on the cheek.");
                this.dismiss(second);
                isAway(second);
            }
            case "sneezy" -> {
                System.out.println(secondDwarf + " is about to sneeze on " + firstDwarf);
                Dwarf bashful = new Bashful("Bashful");
                this.summon(bashful);
                isHere(bashful);
                System.out.println(firstDwarf + " is a little embarrassed.");
                bashful.dismiss(this);
                isAway(this);
            }
        }
    }

    public void summon(Dwarf summoned){
        String summoner = this.dwarfName;
        String summonedDwarf = summoned.dwarfName;
        System.out.println(summoner + " takes cover behind "+summonedDwarf+".");
        summoned.react(this);
    }

    public void react(Dwarf actingDwarf){
        String reactingDwarf = this.dwarfName;
        if (actingDwarf.dwarfType.equals("dopey")){
            System.out.println(reactingDwarf + " tries to help "+ actingDwarf.dwarfName);
            System.out.println(actingDwarf.dwarfName +" doesn't understand so "+ reactingDwarf+ " gives up");
        } else if (actingDwarf.dwarfType.equals("grumpy")){
            System.out.println(reactingDwarf+" makes "+actingDwarf.dwarfName+" calm down.");
        }
        else {
            System.out.println(reactingDwarf+" comes over and quickly solves the problem.");
        }
    }

    public void end(){
        String lastDwarf = this.dwarfName;
        System.out.println(lastDwarf+ " decides it's time for everyone to go to the mines.");
        System.out.println("He gathers everyone and they go together to the mine.");
        System.out.println("HEIHOOOOO - The end");
    }

}
