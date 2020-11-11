import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args){
        // Creating frame
        JFrame jFrame = new JFrame("Quadratic Equation Solver");

        // Creating panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Creating text areas and labels
        JLabel xSquaredLabel = new JLabel(" * x ^ 2");
        JTextField xSquaredText = new JTextField(7); // 7 columns in the text field
        JLabel plus1Label = new JLabel(" + ");
        JLabel plus2Label = new JLabel(" + ");
        JLabel xLabel = new JLabel(" * x ");
        JTextField xText = new JTextField(7); // 7 columns in the text field
        JTextField constantText = new JTextField(7); // 7 columns in the text field
        JLabel equalsZeroLabel = new JLabel(" = 0");
        JLabel rootsLabel = new JLabel("------------");
        JButton solveButton = new JButton("SOLVE");

        // Adding graphics objects to the panel
        panel.add(xSquaredText);
        panel.add(xSquaredLabel);
        panel.add(plus1Label);
        panel.add(xText);
        panel.add(xLabel);
        panel.add(plus2Label);
        panel.add(constantText);
        panel.add(equalsZeroLabel);
        panel.add(rootsLabel);
        panel.add(solveButton);

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Initialising important variables
                double a, b, c, discriminant, root1RealPart, root1ImaginaryPart, root2RealPart, root2ImaginaryPart;

                try {
                    // Getting the values of a, b, and c
                    a = Double.parseDouble(xSquaredText.getText());
                    b = Double.parseDouble(xText.getText());
                    c = Double.parseDouble(constantText.getText());
                    discriminant = b * b - (4 * a * c);

                    // Condition for real and different roots
                    if (discriminant > 0){
                        root1RealPart = (-b + Math.sqrt(discriminant)) / (2 * a);
                        root2RealPart = (-b - Math.sqrt(discriminant)) / (2 * a);
                        rootsLabel.setText("Root 1 = " + root1RealPart + ", Root 2 = " + root2RealPart);
                    }

                    // Condition for real and equal roots
                    else if (discriminant == 0){
                        root1RealPart = root2RealPart = (-b + Math.sqrt(discriminant)) / (2 * a);
                        rootsLabel.setText("Root 1 = Root 2 = " + root1RealPart);
                    }

                    // Condition for imaginary roots
                    else {
                        root1RealPart = root2RealPart = -b / (2 * a);
                        root1ImaginaryPart = root2ImaginaryPart = Math.sqrt(-discriminant) / (2 * a);
                        rootsLabel.setText("Root 1 = " + root1RealPart + " + " + root1ImaginaryPart +
                                "i, Root 2 = " + root2RealPart + " - " + root2ImaginaryPart + "i");
                    }
                }

                catch (Exception ex){
                    // Do nothing
                }
            }
        });

        // Adding the panel to the frame
        jFrame.add(panel);

        // Setting size of the window
        jFrame.setSize(800, 640);

        // Making the frame visible
        jFrame.setVisible(true);
    }
}
