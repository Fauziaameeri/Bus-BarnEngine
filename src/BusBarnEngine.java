import java.util.*;
import java.io.*;

public class BusBarnEngine {

    public static void main(String[] args) {
        Random rand = new Random();
        Set<Bus> barn = new HashSet<>();
        Map<Integer,String> routes = new HashMap<>();

        addBuses(barn, rand);
        setRoutes(routes, "routes.txt");
        //printBarn(barn);
        printBarnRoutes(barn, routes);
    }

    public static void addBuses(Set<Bus> barn, Random r) {
        int number = r.nextInt(10);
        int route = 0;
        for(int i = 0; i < number; i++){
            Bus bus = new Bus();
            do {
                route = r.nextInt(300);
            } while (route <= 100);
            bus.setRoute(route);
            barn.add(bus);
        }
    }

    public static void printBarn(Set<Bus> barn) {
        System.out.println("\nBuses at the Bus Barn");
        System.out.println("=====================");
        for(Bus b : barn) {
            System.out.println(b);
        }
        if(barn.isEmpty()) {
            System.out.println("The bus barn is empty!");
        }
    }

    public static void printBarnRoutes(Set<Bus> barn, Map<Integer, String> routes) {
        System.out.println("\nBuses at the Bus Barn");
        System.out.println("======================");
        for (Bus b : barn) {
            String string = b.toString();
            if (routes.containsKey(b.getRoute())) {
                string += " (" + routes.get(b.getRoute()) + ")";
            }
            System.out.println(string);
        }
        if (barn.isEmpty()) {
            System.out.println("The bus barn is empty!");
        }
    }
    public static void setRoutes(Map<Integer, String> routes, String fileName) {
        try (Scanner file = new Scanner(new File(fileName))){
            int lineNumber = 0;

            while (file.hasNextLine()) {
                if (lineNumber % 2 == 0) {
                    String routeNumber = file.nextLine();
                    String routeDescription = file.nextLine();
                    routes.put(Integer.parseInt(routeNumber), routeDescription);
                }
                lineNumber++;
            }

            System.out.println("Routes = " + routes);


        } catch(FileNotFoundException e) {

            System.err.println(e);

        }

    }

}