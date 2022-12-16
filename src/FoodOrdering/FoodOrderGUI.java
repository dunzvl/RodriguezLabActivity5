package FoodOrdering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class FoodOrderGUI extends JFrame{
    private JPanel panel1;
    private JCheckBox cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae;
    private JRadioButton rbNone, rb5, rb10, rb15;
    private JButton btnOrder;
    private JLabel lblFoods, lblDiscount, lblPizza, lblBurger, lblFries, lblSoftDrinks, lblTea, lblSundae;

    public static void main(String[] args){
        FoodOrderGUI app = new FoodOrderGUI();
        app.setContentPane(app.panel1);
        app.setTitle("Food Ordering System");
        app.setSize(700, 500);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setLocationRelativeTo(null);
    }

    public FoodOrderGUI(){
        lblFoods.setText("Foods");
        cPizza.setText("Pizza");
        cBurger.setText("Burger");
        cFries.setText("Fries");
        cSoftDrinks.setText("Soft Drinks");
        cTea.setText("Tea");
        cSundae.setText("Sundae");
        lblPizza.setText("Php 100");
        lblBurger.setText("Php 80");
        lblFries.setText("Php 65");
        lblSoftDrinks.setText("Php 55");
        lblTea.setText("Php 50");
        lblSundae.setText("Php 40");

        lblDiscount.setText("Discounts");
        rbNone.setText("None");
        rbNone.setSelected(true);
        rb5.setText("5% Off");
        rb10.setText("10% Off");
        rb15.setText("15% Off");
        btnOrder.setText("Order");
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalPrice = 0, discount = 0, amount;
                if(cPizza.isSelected()){
                    totalPrice+=100;
                } if(cBurger.isSelected()){
                    totalPrice+=80;
                } if(cFries.isSelected()){
                    totalPrice+=65;
                } if(cSoftDrinks.isSelected()){
                    totalPrice+=55;
                } if(cTea.isSelected()){
                    totalPrice+=50;
                } if(cSundae.isSelected()){
                    totalPrice+=40;
                }
                if (rb5.isSelected()) {
                    discount = totalPrice*0.05;
                } else if(rb10.isSelected()){
                    discount = totalPrice*0.1;
                } else if(rb15.isSelected()){
                    discount = totalPrice*0.15;
                }
                amount = totalPrice - discount;
                DecimalFormat df = new DecimalFormat("#.00");
                String finalAmount = df.format(amount);
                JOptionPane.showMessageDialog(null,"The total price is Php " + finalAmount);
            }
        });
    }
}
