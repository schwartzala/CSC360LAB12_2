import java.io.File;
import java.util.*;

/*
AUTHOR: Alan Schwartz Jr.
ProviderTester.java
 */

public class ProviderTester {

    public static void main(String args[]) {
        try {
            List<Provider> providerList = new ArrayList();
            Scanner file = new Scanner(new File("C:\\Users\\AJ\\IdeaProjects\\CSC360LAB12_2\\src\\a-data"));
            while (file.hasNextLine()) {
                String line = file.nextLine();
                if (new ProviderValidator(line).parser()) {
                    providerList.add(new Provider(line));
                    System.out.println(providerList.get(providerList.size() - 1).getNpi() + " successfully added!" + "\n");
                }
                else {
                    System.out.println("Invalid Line: " + line + "\n");
                }
            }
            System.out.println("Unsorted List: " + providerList);
            Collections.sort(providerList);
            System.out.println("Sorted List: " + providerList);
            System.out.println(providerList.get(0) + " == " + providerList.get(1) + " ? " +
                providerList.get(0).equals(providerList.get(1)));
            System.out.println("hashCode() for first entry == hashCode() for second entry ? + " +
                    (providerList.get(0).hashCode() == providerList.get(1).hashCode()));
            System.out.println(providerList.get(0) + " == " + providerList.get(providerList.size() - 1) + " ? " +
                providerList.get(0).equals(providerList.get(providerList.size() - 1)));
            System.out.println("Number of valid entries: " + providerList.size());
            Set<Provider> providerSet = new HashSet();
            providerSet.addAll(providerList);
            System.out.println("Number of unique entries: " + providerSet.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

