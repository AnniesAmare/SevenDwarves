import java.util.ArrayList;
import java.util.List;

//General dwarf class
public class Dwarf {
    String dwarfName;
    String dwarfType;
    List<Dwarf> presentDwarves=new ArrayList<>();
    Boolean isLast = false;

    //Constructor
    public Dwarf(String dwarfName) {
        this.dwarfName = dwarfName;
        this.dwarfType = "neutral";
        isHere(this);
    }

    //Start base (not used)
    public void startWith(Dwarf second){
        String firstDwarf = this.dwarfName;
        String secondDwarf = second.dwarfName;
        System.out.println(firstDwarf+" is talking to "+secondDwarf);
    }

    //Default summon
    public void summon(Dwarf summoned){
        summoned.react(this);
    }

    //Default reaction to summon
    public void react(Dwarf e){
        String reactingDwarf = this.dwarfName;
        System.out.println(reactingDwarf + " joins the fun");
    }

    //Dismiss reactions for each dwarf + default
    public void dismiss(Dwarf chasedAway){
        String chaser = this.dwarfName;
        String chasedAwayDwarf = chasedAway.dwarfName;
        switch (chasedAway.dwarfType) {
            case "grumpy" -> System.out.println(chasedAwayDwarf + " gets angry and walks away in a huff.");
            case "doc" -> System.out.println(chasedAwayDwarf + " decides to walk away to think.");
            case "bashful" -> System.out.println(chasedAwayDwarf+" gets embarrassed, hides in his beard and runs away blushing.");
            case "sneezy" -> System.out.println(chasedAwayDwarf+" starts sneezing so much that he rolls away.");
            default -> System.out.println(chasedAwayDwarf + " is then chased away by " + chaser+".");
        }
    }

    //Default end-reaction (not used)
    public void end(){
        String lastDwarf = this.dwarfName;
        System.out.println(lastDwarf+ " shrugs.");
        System.out.println("Huh... - The end");
    }

    //Sets a dwarf as the last dwarf on the list and triggers their end()-function.
    public void setLast() {
        this.isLast = true;
        this.end();
    }

    //Adds a dwarf to the list of present dwarves
    public void isHere(Dwarf here) {
        this.presentDwarves.add(here);
    }

    //Removes a dwarf from the list of present dwarves
    public void isAway(Dwarf away){
        this.presentDwarves.remove(away);
    }

}
