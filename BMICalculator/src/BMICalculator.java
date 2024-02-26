import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printIntroduction();
        double bmi = getBMI(scanner);
        String status = getStatus(bmi);
        reportResult("1", bmi, status);
    }

    public static void printIntroduction(){
        System.out.println("Hello\nThis is BMI Calculator");
    }

    public static double getBMI(Scanner scanner){
        System.out.print("Enter your weight: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height: ");
        double height = scanner.nextDouble();

        weight *= 0.453592;
        height *= 2.54;

        return bmiFor(weight, height);
    }

    public static double bmiFor(double weight, double height){
        return weight*703/(height*height);
    }

    public static String getStatus(double bmi){
        if(bmi <= 18.5){
            return "underweight";
        }else if(bmi <= 25){
            return "normal";
        }else if(bmi <= 30){
            return "overweight";
        }else{
            return "obese";
        }
    }

    public static void reportResult(String idNum, double bmiIndex, String status){
        System.out.println("The person with id number: "+idNum+" has BMI="+Math.round(bmiIndex));
        System.out.println("This is diagnosed as: "+status);
    }

}