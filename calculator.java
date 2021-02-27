import java.util.ArrayList;

/**
 *
 */
public class calculator {
    public double midpoint(double degree1, double degree2){
        double degree_dif = 0;
//        if(Math.abs(degree1 - degree2) <= 180 ){
            degree_dif = Math.abs(degree1 - degree2);
//        }else{
//            degree_dif = Math.abs(360 - Math.abs(degree1 - degree2));
//        }

        if(degree_dif > 180){
            degree_dif = - (360 - degree_dif);
        }
        degree_dif = degree_dif/2;

        if(degree1 < degree2){
            if(degree1 + degree_dif >= 0)
                return degree1 + degree_dif;
            else
                return 360 + degree1 + degree_dif;
        }else {
            if(degree1 + degree_dif >= 0)
                return degree2 + degree_dif;
            else
                return 360 + degree2 + degree_dif;
        }
    }
    public static void find_aspect(String planet1, double degree1, String planet2, double degree2){
        double degree_dif = 0;
        if(Math.abs(degree1 - degree2) <= 180 ){
            degree_dif = Math.abs(degree1 - degree2);
        }else{
            degree_dif = Math.abs(360 - Math.abs(degree1 - degree2));
        }

        //System.out.println(planet1 + " " + planet2 + " " + degree_dif);

        if(-9 <= degree_dif && degree_dif <= 9){
            double orb = degree_dif - 0;
            System.out.println(planet1 + " - " + planet2 + " conjunction orb " + orb);
        }else if(28 <= degree_dif && degree_dif <= 32){
            double orb = degree_dif - 30;
            System.out.println(planet1 + " - " + planet2 + " semi-sextile orb " + orb);
        }else if(39 <= degree_dif && degree_dif <= 41){
            double orb = degree_dif - 40;
            System.out.println(planet1 + " - " + planet2 + " novile orb " + orb);
        }else if(43 <= degree_dif && degree_dif <= 47){
            double orb = degree_dif - 45;
            System.out.println(planet1 + " - " + planet2 + " semi-square orb " + orb);
        }else if(50 <= degree_dif && degree_dif <= 51){
            double orb = degree_dif - 50.26;
            System.out.println(planet1 + " - " + planet2 + " septile orb " + orb);
        }else if(52 <= degree_dif && degree_dif <= 68){
            double orb = degree_dif - 60;
            System.out.println(planet1 + " - " + planet2 + " sextile orb " + orb);
        }else if(70 <= degree_dif && degree_dif <= 74){
            double orb = degree_dif - 72;
            System.out.println(planet1 + " - " + planet2 + " quintile orb " + orb);
        }else if(82 <= degree_dif && degree_dif <= 98){
            double orb = degree_dif - 90;
            System.out.println(planet1 + " - " + planet2 + " square orb " + orb);
        }else if(102 <= degree_dif && degree_dif <= 104){
            double orb = degree_dif - 103;
            System.out.println(planet1 + " - " + planet2 + " biSeptile orb " + orb);
        }else if(112 <= degree_dif && degree_dif <= 128){
            double orb = degree_dif - 120;
            System.out.println(planet1 + " - " + planet2 + " trine orb " + orb);
        }else if(133 <= degree_dif && degree_dif <= 138){
            double orb = degree_dif - 135;
            System.out.println(planet1 + " - " + planet2 + " sesquiquadrate orb " + orb);
        }else if(142 <= degree_dif && degree_dif <= 146){
            double orb = degree_dif - 144;
            System.out.println(planet1 + " - " + planet2 + " biquintile orb " + orb);
        }else if(148 <= degree_dif && degree_dif <= 152){
            double orb = degree_dif - 150;
            System.out.println(planet1 + " - " + planet2 + " inconjunction orb " + orb);
        }else if(153 <= degree_dif && degree_dif <= 155){
            double orb = degree_dif - 154;
            System.out.println(planet1 + " - " + planet2 + " triSeptile orb " + orb);
        }else if(172 <= degree_dif && degree_dif <= 188){
            double orb = degree_dif - 180;
            System.out.println(planet1 + " - " + planet2 + " opposition orb " + orb);
        }
    }
    public static void find_composite_natal_aspect(String planet1, double degree1, String planet2, double degree2){
        double degree_dif = 0;
        if(Math.abs(degree1 - degree2) <= 180 ){
            degree_dif = Math.abs(degree1 - degree2);
        }else{
            degree_dif = Math.abs(360 - Math.abs(degree1 - degree2));
        }

        //System.out.println(planet1 + " " + planet2 + " " + degree_dif);

        if(-4 <= degree_dif && degree_dif <= 4){
            double orb = degree_dif - 0;
            System.out.println(planet1 + " - " + planet2 + " conjunction orb " + orb);
        }else if(88 <= degree_dif && degree_dif <= 92){
            double orb = degree_dif - 90;
            System.out.println(planet1 + " - " + planet2 + " square orb " + orb);
        }else if(176 <= degree_dif && degree_dif <= 184){
            double orb = degree_dif - 180;
            System.out.println(planet1 + " - " + planet2 + " opposition orb " + orb);
        }
    }

    public static void find_house_placements_equal(double ascendant_degree, ArrayList<Planet> planets){
        for (int i = 0; i < planets.size() ; i++) {
            double degree = planets.get(i).getDegree() - ascendant_degree;
            if(degree < 0){
                degree = degree + 360;
            }

//            System.out.println(degree);
                if (degree < 30 && degree >= 0){
                    System.out.println(planets.get(i).getPlanet() + " in 1st house");
                }else if (degree < 60 && degree >= 30){
                    System.out.println(planets.get(i).getPlanet() + " in 2nd house");
                }else if (degree < 90 && degree >= 60){
                    System.out.println(planets.get(i).getPlanet() + " in 3rd house");
                }else if (degree < 120 && degree >= 90){
                    System.out.println(planets.get(i).getPlanet() + " in 4th house");
                }else if (degree < 150 && degree >= 120){
                    System.out.println(planets.get(i).getPlanet() + " in 5th house");
                }else if (degree < 180 && degree >= 150){
                    System.out.println(planets.get(i).getPlanet() + " in 6th house");
                }else if (degree < 210 && degree >= 180){
                    System.out.println(planets.get(i).getPlanet() + " in 7th house");
                }else if (degree < 240 && degree >= 210){
                    System.out.println(planets.get(i).getPlanet() + " in 8th house");
                }else if (degree < 270 && degree >= 240){
                    System.out.println(planets.get(i).getPlanet() + " in 9th house");
                }else if (degree < 300 && degree >= 270){
                    System.out.println(planets.get(i).getPlanet() + " in 10th house");
                }else if (degree < 330 && degree >= 300){
                    System.out.println(planets.get(i).getPlanet() + " in 11th house");
                }else if (degree >= 330){
                    System.out.println(planets.get(i).getPlanet() + " in 12th house");
                }
        }


    }


    public static void find_house_placements_placidus(ArrayList<House> cusps, ArrayList<Planet> planets){
        for (int i = 0; i < planets.size() ; i++) {
            double degree = planets.get(i).getDegree()
                    - cusps.get(0).getDegree();
            if(degree < 0){
                degree = degree + 360;
            }

            if (degree < cusps.get(1).getDegree() && degree >= 0){
                System.out.println(planets.get(i).getPlanet() + " in 1st house");
            }else if (degree < cusps.get(2).getDegree() && degree >= cusps.get(1).getDegree()){
                System.out.println(planets.get(i).getPlanet() + " in 2nd house");
            }else if (degree < cusps.get(3).getDegree() && degree >= cusps.get(2).getDegree()){
                System.out.println(planets.get(i).getPlanet() + " in 3rd house");
            }else if (degree < cusps.get(4).getDegree() && degree >= cusps.get(3).getDegree()){
                System.out.println(planets.get(i).getPlanet() + " in 4th house");
            }else if (degree < cusps.get(5).getDegree() && degree >= cusps.get(4).getDegree()){
                System.out.println(planets.get(i).getPlanet() + " in 5th house");
            }else if (degree < cusps.get(6).getDegree() && degree >= cusps.get(5).getDegree()){
                System.out.println(planets.get(i).getPlanet() + " in 6th house");
            }else if (degree < cusps.get(7).getDegree() && degree >= cusps.get(6).getDegree()){
                System.out.println(planets.get(i).getPlanet() + " in 7th house");
            }else if (degree < cusps.get(8).getDegree() && degree >= cusps.get(7).getDegree()){
                System.out.println(planets.get(i).getPlanet() + " in 8th house");
            }else if (degree < cusps.get(9).getDegree() && degree >= cusps.get(8).getDegree()){
                System.out.println(planets.get(i).getPlanet() + " in 9th house");
            }else if (degree < cusps.get(10).getDegree() && degree >= cusps.get(9).getDegree()){
                System.out.println(planets.get(i).getPlanet() + " in 10th house");
            }else if (degree < cusps.get(11).getDegree() && degree >= cusps.get(10).getDegree()){
                System.out.println(planets.get(i).getPlanet() + " in 11th house");
            }else if (degree >= cusps.get(11).getDegree()){
                System.out.println(planets.get(i).getPlanet() + " in 12th house");
            }
        }


    }


}
