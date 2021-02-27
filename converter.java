import java.util.ArrayList;

/**
 *
 */
public class converter {
    public String degree_to_sign(double degree){
        if(degree < 30){
            return "aries";
        }else if(degree < 60){
            return "taurus";
        }else if(degree < 90){
            return "gemini";
        }else if(degree < 120){
            return "cancer";
        }else if(degree < 150){
            return "leo";
        }else if(degree < 180){
            return "virgo";
        }else if(degree < 210){
            return "libra";
        }else if(degree < 240){
            return "scorpio";
        }else if(degree < 270){
            return "sag";
        }else if(degree < 300){
            return "capricorn";
        }else if(degree < 330){
            return "aquarius";
        }else if(degree <= 360){
            return "pisces";
        }
        return "not valid";
    }
    public double sign_to_degree(double degree){
        if(degree < 30){
            return degree;
        }else if(degree < 60){
            return degree-30;
        }else if(degree < 90){
            return degree-60;
        }else if(degree < 120){
            return degree-90;
        }else if(degree < 150){
            return degree-120;
        }else if(degree < 180){
            return degree-150;
        }else if(degree < 210){
            return degree-180;
        }else if(degree < 240){
            return degree-210;
        }else if(degree < 270){
            return degree-240;
        }else if(degree < 300){
            return degree-270;
        }else if(degree < 330){
            return degree-300;
        }else if(degree <= 360){
            return degree-330;
        }
        return -1;
    }
    public static double make_degree (String Sign, double degree){
        switch(Sign){
            case "aries":break;
            case "taurus": degree = degree + 30;break;
            case "gemini": degree = degree + 60;break;
            case "cancer": degree = degree + 90;break;
            case "leo": degree = degree + 120;break;
            case "virgo": degree = degree + 150;break;
            case "libra": degree = degree + 180;break;
            case "scorpio": degree = degree + 210;break;
            case "sag": degree = degree + 240;break;
            case "capricorn": degree = degree + 270;break;
            case "aquarius": degree = degree + 300;break;
            case "pisces": degree = degree + 330;break;
            default:break;
        }
        return degree;
    }
    public static double make_asc_axis(House asc, double cusp){
        double degree = cusp - asc.getDegree();
        if(degree < 0){
            return degree + 360;
        }else{
            return degree;
        }
    }
}
