import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.io.FileNotFoundException;

public class DND
{
    public static void main(String[] args) throws FileNotFoundException
    {
        HashMap<String, HashMap<String, Integer>> names = new HashMap<>(); // Hashmap for Chacter nanes with nested hm for skills
        HashMap<String, Integer> skills = new HashMap<>(); // HashMap for skills
        Scanner sc = new Scanner(new File("DND.txt")); // Reads from file
        String temp = "";
        while(sc.hasNextLine())
        {
            String txt = sc.nextLine();
            if(txt.contains("-")) // THis will read names and class
            {
                skills = new HashMap<>();
                temp = txt;
                names.put(temp, skills); // Sets the name and skills
            }// End if
            else if(txt.equals(""))
            {

            }
            else
            {
                String[] halves = txt.split(":"); // Splits the skill and its values
                String sName = halves[0].trim().toLowerCase(); // For name
                String sValue = halves
                [1].trim().toLowerCase(); // for stats
                int skillValue = Integer.parseInt(sValue);
                skills.put(sName, skillValue);
                names.put(temp, skills);
            }// End Else
        }// End while
        System.out.println(names.toString());
        sSort(names);
        sc.close();
    }// End Main
    public static void sSort(HashMap<String, HashMap<String, Integer>> names)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Which Skill would you like to sort by?");
        String skill = s.nextLine();
        skill = skill.toLowerCase().toLowerCase();
        if(skill.equalsIgnoreCase("hoorah!"));
        {
            System.out.println("Finished the sort");
        }// Ends if
        if(skill.equals("strength") || skill.equals("dexterity") || skill.equals("constitution") || skill.equals("wisdom") || skill.equals("intelligence") || skill.equals("charisma"))
        {
            HashMap<String, Integer> finishedSort = new HashMap<>();
            for(String key : names.keySet())
            {
                finishedSort.put(key, names.get(key).get(skill));
            }// End for
            HashMap<String, Integer> sortedHashMap = finishedSort.entrySet().stream().sorted(Comparator.comparingInt(e -> e.getValue())).collect(Collectors.toMap(Map.Entry :: getKey,HashMap.Entry :: getValue,(a, b) -> {throw new AssertionError();}, LinkedHashMap :: new));
            for(String key : sortedHashMap.keySet())
            {
                System.out.println(key + " : " + "(" + sortedHashMap.get(key) + ")");
            }// End for 
            sSort(names); // Recursion
        }// End If
        else
        {
            sSort(names); // Recursion
        }
    }// End sSort
}// End class