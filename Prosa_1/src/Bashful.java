public class Bashful extends Dwarf{

    public Bashful(String dwarfName) {
        super(dwarfName);
        this.dwarfType = "bashful";
        isHere(this);
    }
    public void startWith(Dwarf second){
        String firstDwarf = this.dwarfName;
        String secondDwarf = second.dwarfName;
        isHere(second);
        System.out.println(firstDwarf+" is braiding his beard when "+secondDwarf+" shows up.");
        switch (second.dwarfType) {
            case "grumpy" -> {
                System.out.println(secondDwarf + " is very grumpy and starts yelling at " + firstDwarf);
                second.dismiss(this);
                isAway(this);
            }
            case "dopey" -> {
                System.out.println(secondDwarf + " tries to help with braiding but gets tangled up");
                System.out.println("They ask for help");
                Dwarf doc = new Doc("Doc");
                this.summon(doc);
                isHere(doc);
                doc.dismiss(this);
                isAway(this);
            }
            case "doc" -> {
                System.out.println(secondDwarf + " gives " + firstDwarf + " a gem from the mines.");
                System.out.println(firstDwarf + " is very thankful, becomes red and kisses " + secondDwarf + " on the cheek");
                System.out.println(secondDwarf + " is also embarrassed.");
                this.dismiss(second);
                isAway(second);
            }
            case "sneezy" -> {
                System.out.println(secondDwarf + " is about to sneeze.");
                System.out.println(firstDwarf + " pinches " + secondDwarf + "s nose to prevent the sneeze.");
                Dwarf dopey = new Dopey("Dopey");
                second.summon(dopey);
                isHere(dopey);
                isAway(second);
            }
        }
    }

    public void react(Dwarf actingDwarf){
        String reactingDwarf = this.dwarfName;
        if (actingDwarf.dwarfType.equals("doc")){
            System.out.println(reactingDwarf + " gets sneezed on.");
            System.out.println("But "+reactingDwarf+" tells "+actingDwarf.dwarfName+" that he is happy to help");
        }
        else {
            System.out.println(reactingDwarf+" comes around.");
        }
    }


    public void end(){
        String lastDwarf = this.dwarfName;
        System.out.println(lastDwarf+ " gets very embarrassed and hides away in his beard.");
        System.out.println("( 0//o//0)  - The end");
    }
}
