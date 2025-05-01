import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BMICalculator {
    private double weight;
    private int height;

    public BMICalculator(int feet, int inches, double weight){
        this.weight = weight;
        height = feet * 12 + inches;
    }

    public double calculateBMI(){
        return (int) ((weight / Math.pow(height, 2) * 703) * 100) / 100.0;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String tips(){
        double bmi = calculateBMI();
        String text = "Your BMI is: " + bmi + "\n";
        if (bmi < 18.5){
            text += "You are underweight based on your weight. You should aim to gain 10–15 lbs to reach a healthier range.\n" +
                    "(1) Eat more calorie-dense, nutritious foods like nuts, avocados, and lean proteins.\n" +
                    "(2) Strength train 3–4 times a week to build muscle mass.\n" +
                    "(3) Get adequate sleep and manage stress to support healthy weight gain.";
        } else if (bmi >= 18.5 && bmi < 24.9){
            text += "You have a normal weight. Keep up the good work maintaining your health.\n" +
                    "(1) Maintain a balanced diet with fruits, vegetables, lean proteins, and whole grains.\n" +
                    "(2) Stay active with 150 minutes of moderate exercise per week.\n" +
                    "(3) Monitor your weight occasionally and keep healthy lifestyle habits.";
        } else if (bmi >= 25 && bmi < 29.9){
            text += "You are overweight based on your weight. You should consider shedding between 10–20 lbs.\n" +
                    "(1) Cut down on carbs and sugary drinks in your diet.\n" +
                    "(2) Spend 30 mins or more on the treadmill at least 4 times a week.\n" +
                    "(3) Take a walk for about 30 mins daily.\n" +
                    "(4) Reduce portion sizes and avoid eating late at night.";
        } else {
            text += "You are obese based on your weight. It's important to take action for your health.\n" +
                    "(1) Consult a healthcare provider or dietitian to create a personalized weight loss plan.\n" +
                    "(2) Aim to lose 1–2 lbs per week with a calorie deficit.\n" +
                    "(3) Engage in at least 150 minutes of moderate to vigorous exercise per week.\n" +
                    "(4) Stay consistent with your routine and track your progress.";
        }
        return text;
    }

    public static void main(String[] args){
        BMICalculator bmiCalculator = new BMICalculator(0, 0, 0);

        JFrame jframe = new JFrame("BMI Calculator");
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setSize(600, 500);
        jframe.setLayout(new BorderLayout());

        JTextField jTextField1 = new JTextField(8);
        JTextField jTextField2 = new JTextField(8);
        JTextField jTextField3 = new JTextField(8);
        JTextArea jTextArea = new JTextArea(10, 40);
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Feet:"));
        inputPanel.add(jTextField1);
        inputPanel.add(new JLabel("Inches:"));
        inputPanel.add(jTextField2);
        inputPanel.add(new JLabel("Weight (lbs):"));
        inputPanel.add(jTextField3);

        JButton jbutton = new JButton("Calculate BMI");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(jbutton);

        JScrollPane scrollPane = new JScrollPane(jTextArea);
        scrollPane.setPreferredSize(new Dimension(580, 200));

        jframe.add(inputPanel, BorderLayout.NORTH);
        jframe.add(buttonPanel, BorderLayout.CENTER);
        jframe.add(scrollPane, BorderLayout.SOUTH);

        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int feet = Integer.parseInt(jTextField1.getText());
                    int inches = Integer.parseInt(jTextField2.getText());
                    double weight = Double.parseDouble(jTextField3.getText());
                    bmiCalculator.setHeight(feet * 12 + inches);
                    bmiCalculator.setWeight(weight);
                    jTextArea.setText(bmiCalculator.tips());
                } catch (NumberFormatException n) {
                    jTextArea.setText("Invalid input, please enter an integer for feet and inches and a double for weight.");
                }
            }
        });

        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Scanner scanner = new Scanner(System.in);
                boolean check = true;
                while (check){
                    try{
                        System.out.println("Enter the first part of your height (feet)");
                        int feet = scanner.nextInt();
                        System.out.println("Enter the second part of your height (inches)");
                        int inches = scanner.nextInt();
                        System.out.println("Enter your weight (pounds)");
                        double weight = scanner.nextDouble();
                        bmiCalculator.setHeight(feet * 12 + inches);
                        bmiCalculator.setWeight(weight);
                        System.out.println(bmiCalculator.tips());
                        check = false;
                    }catch (InputMismatchException ex){
                        System.out.println("Invalid input, please enter an integer for feet and inches and a double for weight.");
                        scanner.nextLine();
                    }
                }
            }
        });

        jframe.setVisible(true);
    }
}
