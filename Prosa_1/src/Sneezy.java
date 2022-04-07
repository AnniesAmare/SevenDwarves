public class Sneezy extends Dwarf{

    public Sneezy(String dwarfName) {
        super(dwarfName);
        this.dwarfType = "sneezy";
        isHere(this);
    }

    public void startWith(Dwarf second) {
        String firstDwarf = this.dwarfName;
        String secondDwarf = second.dwarfName;
        isHere(second);
        System.out.println(firstDwarf+" is talking with "+secondDwarf);
        switch (second.dwarfType) {
            case "grumpy" -> {
                System.out.println(firstDwarf + " accidentally sneezes " + secondDwarf + " in the face");
                this.dismiss(second);
                isAway(second);
            }
            case "dopey" -> {
                System.out.println(secondDwarf + " starts teasing " + firstDwarf + " with a feather.");
                this.dismiss(this);
                isAway(this);
            }
            case "bashful" -> {
                System.out.println(firstDwarf + " is about to sneeze, but " + secondDwarf + " pinches his nose");
                Dwarf dopey = new Dopey("Dopey");
                this.summon(dopey);
                isHere(dopey);
                isAway(this);
            }
        }
    }

    public void summon(Dwarf summoned){
        String summoner = this.dwarfName;
        String summonedDwarf = summoned.dwarfName;
        System.out.println(summonedDwarf + " notices that "+summoner+" is about to sneeze.");
        summoned.react(this);
    }

    public void end(){
        String lastDwarf = this.dwarfName;
        System.out.println(lastDwarf+ " sneezes very loudly.");
        System.out.println("ACHOOOOO - The end");
    }
}
