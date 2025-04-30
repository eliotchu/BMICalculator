import javax.swing.*;
import java.util.Scanner;

public class BMICalculator extends JFrame {
    private int feet;
    private int inches;
    private double weight;
    private int height;

    public BMICalculator(int feet, int inches, double weight){
        this.feet = feet;
        this.inches = inches;
        this.weight = weight;
        height = feet * 12 + inches;
    }

    public double calculateBMI(){
        return (int) ((weight / Math.pow(height, 2) * 703) * 100);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        BMICalculator bmiCalculator = new BMICalculator()
    }
}
