public class Grumpy extends Dwarf {
    public Grumpy(String dwarfName) {
        super(dwarfName);
        this.dwarfType = "grumpy";
        isHere(this);
    }

    public void startWith(Dwarf second){
        String firstDwarf = this.dwarfName;
        String secondDwarf = second.dwarfName;
        isHere(second);
        System.out.println(firstDwarf+" is yelling at "+secondDwarf);
        switch (second.dwarfType) {
            case "doc" -> System.out.println(secondDwarf + " doesn't care.");
            case "dopey" -> {
                System.out.println(secondDwarf + " doesn't understand.");
                System.out.println(firstDwarf + " starts yelling even louder");
                Dwarf doc = new Doc("Doc");
                this.summon(doc);
                isHere(doc);
            }
            case "sneezy" -> {
                System.out.println(secondDwarf + " sneezes " + firstDwarf + " in the face");
                second.dismiss(this);
                isAway(this);
            }
            case "bashful" -> {
                this.dismiss(second);
                isAway(second);
            }
        }
    }

    public void summon(Dwarf summoned){
        String summoner = this.dwarfName;
        String summonedDwarf = summoned.dwarfName;
        System.out.println(summoner + " is yelling so loud that "+summonedDwarf+" comes to see what's going on.");
        summoned.react(this);
    }

    public void end(){
        String lastDwarf = this.dwarfName;
        System.out.println(lastDwarf+ " becomes so angry that his face looks like a beet.");
        System.out.println("He walks away in a rage, yelling very loudly.");
        System.out.println("AARRGH! - The end");
    }


}
