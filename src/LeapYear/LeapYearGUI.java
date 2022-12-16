package LeapYear;

import javax.swing.*;
import java.awt.event.*;

public class LeapYearGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;
    private JLabel txtInputYear;

    public static void main(String[] args){
        LeapYearGUI app = new LeapYearGUI();
        app.setContentPane(app.panel1);
        app.setTitle("Leap Year Checker");
        app.setSize(400, 300);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setLocationRelativeTo(null);
    }

    public LeapYearGUI() {
        tfYear.setText("");
        txtInputYear.setText("Input Year");
        btnCheckYear.setText("Check");
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if(tfYear.getText().isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                    int year = Integer.parseInt(tfYear.getText());
                    if(year < 0){
                        throw new ArithmeticException();
                    }
                    if (isLeapYear(year)) {
                        JOptionPane.showMessageDialog(null, "Leap year");
                    } else {
                        JOptionPane.showMessageDialog(null, "Not a leap year");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Field must only contain valid integer to be a year!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null,"Field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE );
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, "Year cannot be negative!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Unknown Error!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
