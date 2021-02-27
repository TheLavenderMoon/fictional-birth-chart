import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class options {

    public void get_natal_aspects(){

        ArrayList<Planet> planets = new ArrayList<Planet>();
        Scanner sc = new Scanner(System.in);
        System.out.println("how many planets/points?");
        int numOfplanets = sc.nextInt();
        planets = get_natal(numOfplanets, sc);
        calculator cal = new calculator();

        for (int i = 0; i < numOfplanets; i++) {
            for (int j = i+1; j < numOfplanets; j++) {
                cal.find_aspect(planets.get(i).getPlanet(), planets.get(i).getDegree(), planets.get(j).getPlanet(), planets.get(j).getDegree());
            }
        }
    }

    public void synastry(){

        ArrayList<Planet> planets1 = new ArrayList<Planet>();
        ArrayList<Planet> planets2 = new ArrayList<Planet>();
        calculator cal = new calculator();
        Scanner sc = new Scanner(System.in);
//        converter conv = new converter();

        System.out.println("how many planets/points?");
        int numOfplanets1 = sc.nextInt();

        System.out.println("person one");
        planets1 = get_natal(numOfplanets1, sc);

        System.out.println("how many planets/points?");
        int numOfplanets2 = sc.nextInt();

        System.out.println("person two");
        planets2 = get_natal(numOfplanets2, sc);

        for (int i = 0; i < numOfplanets1; i++) {
            for (int j = 0; j < numOfplanets2; j++) {
//                System.out.println(planets1.get(i).getSign() +" "+ planets1.get(i).getDegree()+"   "+ conv.sign_to_degree(planets1.get(i).getDegree()));
//                System.out.println(planets2.get(j).getSign() +" "+ planets2.get(j).getDegree()+"   "+ conv.sign_to_degree(planets2.get(j).getDegree()));
//                System.out.println();
                cal.find_aspect(planets1.get(i).getPlanet(), planets1.get(i).getDegree(),
                        planets2.get(j).getPlanet(), planets2.get(j).getDegree());
            }
        }

        System.out.println("\n for house placements enter 1 (equal) or 2 (placidus)");
        int op = sc.nextInt();

        if(op == 1){
            System.out.println("\n enter ascendant sign and degree for the first person");
            String sign1 = sc.next();
            int degree1 = sc.nextInt();
            cal.find_house_placements_equal(converter.make_degree(sign1, degree1), planets2);
            System.out.println("\n enter ascendant sign and degree for the second person");
            String sign2 = sc.next();
            int degree2 = sc.nextInt();
            cal.find_house_placements_equal(converter.make_degree(sign2, degree2), planets1);
        }else if(op == 2){
            System.out.println("\n enter ascendant sign and degree for the first person");
            ArrayList<House> cups1 = new ArrayList<House>();
            cups1 = get_natal_cups_asc_axis(sc);
            cal.find_house_placements_placidus(cups1,planets2);
            System.out.println("\n enter ascendant sign and degree for the second person");
            ArrayList<House> cups2 = new ArrayList<House>();
            cups2 = get_natal_cups_asc_axis(sc);
            cal.find_house_placements_placidus(cups2,planets1);
        }

    }

    public void composite(){
        ArrayList<Planet> planets1 = new ArrayList<Planet>();
        ArrayList<Planet> planets2 = new ArrayList<Planet>();
        calculator cal = new calculator();
        Scanner sc = new Scanner(System.in);
        System.out.println("how many planets/points?");
        int numOfplanets = sc.nextInt();

        System.out.println("person one");
        planets1 = get_natal(numOfplanets, sc);
        System.out.println("person two");
        planets2 = get_natal(numOfplanets, sc);

        converter conv = new converter();
        ArrayList<Planet> planets = new ArrayList<Planet>();
        for (int i = 0; i < numOfplanets ; i++) {
            Planet p = new Planet();
            p.setPlanet(planets1.get(i).getPlanet());
            p.setDegree(cal.midpoint(
                    planets1.get(i).getDegree(),
                    planets2.get(i).getDegree()
                    )
            );

//            System.out.println(planets1.get(i).getDegree()+" "+
//                    planets2.get(i).getDegree() +" "+ p.getDegree());

            p.setSign(conv.degree_to_sign(p.getDegree()));

            planets.add(p);
        }

        for (int i = 0; i < numOfplanets; i++) {
            System.out.println(planets.get(i).getPlanet() + " -> " + planets.get(i).getSign() + " " + conv.sign_to_degree(planets.get(i).getDegree()));
            for (int j = i+1; j < numOfplanets; j++) {
                cal.find_aspect(planets.get(i).getPlanet(), planets.get(i).getDegree(), planets.get(j).getPlanet(), planets.get(j).getDegree());
            }
        }

        System.out.println("\n for composite to natals enter 1");
        if(sc.nextInt() == 1){
            System.out.println("person one:");
            for (int i = 0; i < numOfplanets; i++) {
                for (int j = 0; j < numOfplanets; j++) {
                    cal.find_composite_natal_aspect(planets1.get(i).getPlanet(), planets1.get(i).getDegree(), planets.get(j).getPlanet(), planets.get(j).getDegree());
                }
            }
            System.out.println();
            System.out.println("person two:");
            for (int i = 0; i < numOfplanets; i++) {
                for (int j = 0; j < numOfplanets; j++) {
                    cal.find_composite_natal_aspect(planets2.get(i).getPlanet(), planets2.get(i).getDegree(), planets.get(j).getPlanet(), planets.get(j).getDegree());
                }
            }
        }

    }

    public ArrayList<Planet> get_natal(int numOfplanets, Scanner sc){
        converter conv = new converter();
        ArrayList<Planet> planets = new ArrayList<Planet>();
        System.out.println("enter planets/points, signs and their degrees");
        for (int i = 0; i < numOfplanets ; i++) {
            Planet p = new Planet();
            p.setPlanet(sc.next());
            p.setSign(sc.next());
            p.setDegree(conv.make_degree(p.getSign(), sc.nextInt()));
            planets.add(p);
        }
        return planets;
    }

    public ArrayList<House> get_natal_cups_asc_axis(Scanner sc){
        converter conv = new converter();
        ArrayList<House> cusps = new ArrayList<House>();
        System.out.println("enter cusp signs and their degrees");
        for (int i = 0; i < 12 ; i++) {
            House c = new House();
            c.setCusp(i);
            c.setSign(sc.next());
            if(i>0) {
                c.setDegree(conv.make_asc_axis(cusps.get(0), conv.make_degree(c.getSign(), sc.nextInt())));
            }
            cusps.add(c);
        }

        return cusps;
    }

}
