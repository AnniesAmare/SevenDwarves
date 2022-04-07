public class Dopey extends Dwarf {

    public Dopey(String dwarfName) {
        super(dwarfName);
        this.dwarfType = "dopey";
        isHere(this);
    }

    public void startWith(Dwarf second) {
        String firstDwarf = this.dwarfName;
        String secondDwarf = second.dwarfName;
        isHere(second);
        System.out.println(firstDwarf+ " runs into "+secondDwarf);
        switch (second.dwarfType) {
            case "grumpy" -> {
                System.out.println(secondDwarf + " gets angry and starts yelling at " + firstDwarf);
                System.out.println(firstDwarf + " doesn't understand and asks Doc for help.");
                Dwarf doc = new Doc("Doc");
                this.summon(doc);
                isHere(doc);
            }
            case "sneezy" -> {
                System.out.println(firstDwarf + " starts teasing " + secondDwarf + " with a feather.");
                this.dismiss(second);
                isAway(second);
            }
            case "doc" -> System.out.println(secondDwarf + " catches " + firstDwarf + " so he doesn't fall");
            default -> System.out.println(firstDwarf + " and " + secondDwarf + " both fall on their butts");
        }
    }

    public void summon(Dwarf summoned){
        String summoner = this.dwarfName;
        String summonedDwarf = summoned.dwarfName;
        System.out.println(summoner + " asks "+summonedDwarf+" for help.");
        summoned.react(this);
    }

    public void react(Dwarf actingDwarf){
        String reactingDwarf = this.dwarfName;
        if (actingDwarf.dwarfType.equals("sneezy")){
            System.out.println(reactingDwarf + " decides to tickle "+actingDwarf.dwarfName+" with a feather");
            this.dismiss(actingDwarf);
        } else {
            System.out.println(reactingDwarf+" comes around");
        }
    }

    public void end(){
        String lastDwarf = this.dwarfName;
        System.out.println(lastDwarf+ " stumbles, lands on his butt and farts.");
        System.out.println("Everyone thinks that it's hilarious! They all laugh.");
        System.out.println("HAHAHAHA - The end");
    }
}
