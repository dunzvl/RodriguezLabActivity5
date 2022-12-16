package SimpleCalc;

import javax.swing.*;
import java.awt.event.*;

public class SimpleCalcGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfNumber1, tfNumber2, tfResult;
    private JComboBox<String> cbOperations;
    private JButton btnCompute;
    private JLabel lblResult, lblNumber1, lblNumber2;

    public static void main(String[] args){
        SimpleCalcGUI app = new SimpleCalcGUI();
        app.setContentPane(app.panel1);
        app.setTitle("Simple Calculator");
        app.setSize(550,300);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setLocationRelativeTo(null);
    }

    public SimpleCalcGUI(){
        cbOperations.addItem("+");
        cbOperations.addItem("-");
        cbOperations.addItem("*");
        cbOperations.addItem("/");
        tfNumber1.setText("");
        tfNumber1.setHorizontalAlignment(SwingConstants.CENTER);
        tfNumber2.setText("");
        tfNumber2.setHorizontalAlignment(SwingConstants.CENTER);
        tfResult.setText("");
        tfResult.setHorizontalAlignment(SwingConstants.CENTER);
        tfResult.setEditable(false);
        lblNumber1.setText("1st Number");
        lblNumber2.setText("2nd Number");
        lblResult.setText("Result");
        btnCompute.setText("Compute Result");
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                double number1 = Double.parseDouble(tfNumber1.getText());
                double number2 = Double.parseDouble(tfNumber2.getText());
                String operator = (String) cbOperations.getSelectedItem();
                double result = 0;

                switch (operator) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "*":
                        result = number1 * number2;
                        break;
                    case "/":
                        result = number1 / number2;
                        break;
                }

                tfResult.setText(String.format("%.6f", result));
            }
        });
    }
}
