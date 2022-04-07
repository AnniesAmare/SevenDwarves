import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //creates the dwarves
        Dwarf grumpy = new Grumpy("Grumpy");
        Dwarf sneezy = new Sneezy("Sneezy");
        Dwarf dopey = new Dopey("Dopey");
        Dwarf doc = new Doc("Doc");
        Dwarf bashful = new Bashful("Bashful");

        //Makes a list that contains all dwarves
        List<Dwarf> allDwarves=new ArrayList<>();
        allDwarves.add(grumpy);
        allDwarves.add(dopey);
        allDwarves.add(sneezy);
        allDwarves.add(doc);
        allDwarves.add(bashful);

        //Generates two random dwarves to start the story.
        Random random = new Random();

        int first = random.nextInt(allDwarves.size());
        Dwarf firstDwarf = allDwarves.get(first);
        allDwarves.remove(firstDwarf);

        int second = random.nextInt(allDwarves.size());
        Dwarf secondDwarf = allDwarves.get(second);
        allDwarves.remove(secondDwarf);

        //Starts the story
        firstDwarf.startWith(secondDwarf);
        List <Dwarf> presentDwarves = firstDwarf.presentDwarves;
        Dwarf lastDwarf = presentDwarves.get(presentDwarves.size()-1);
        lastDwarf.setLast();

    }
}
