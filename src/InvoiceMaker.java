//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;


public class InvoiceMaker {
  public static double RunningTotal=0;
  //Swing elements
 public static InvoiceMakerFrame PrintAnInvoice = new InvoiceMakerFrame("Print-An-Invoice");
  public static ArrayList<LineItem> ItemsForInvoice =new ArrayList<LineItem>();
 public static JPanel Canvas = new JPanel();

public static Customer CurrentCustomer = new Customer("?","?","?",0);
 public static JPanel CustomerZone = new JPanel();

 public static JPanel ItemZone = new JPanel();


  public static JLabel NameLabel = new JLabel("Enter Customer Name");
 public static JTextField NameField = new JTextField(45);
public static   JLabel StreetLabel = new JLabel("Enter Street Address");
 public static JTextField StreetField = new JTextField(45);
 public static JLabel CSLabel = new JLabel("Enter City and State");
 public static JTextField CityStateField = new JTextField( 45);
 public static JLabel ZIPLabel = new JLabel("Enter ZIP Code");
 public static JTextField ZIPCodeField = new JTextField(9);

public  static   JLabel ProductLabel = new JLabel("Enter Product Name");
 public static JTextField ProductField = new JTextField(45);
 public static JLabel QuantityLabel = new JLabel("Enter Product Quantity");
  public static JTextField QuantityField=new JTextField(10);
 public static JLabel PriceLabel = new JLabel("Enter Price Per Item In $_.__ Format");
 public static JTextField PriceField=new JTextField(15);

 public static JButton SubmitButton = new JButton("Print invoice");
  public  static JButton AddButton = new JButton("Add line item");
    public static void main(String[] args) {

      CustomerZone.setLayout(new BoxLayout(CustomerZone,BoxLayout.Y_AXIS));
      ItemZone.setLayout(new BoxLayout(ItemZone,BoxLayout.Y_AXIS));


        PrintAnInvoice.add(Canvas);
        Canvas.add(CustomerZone);
        Canvas.add(ItemZone);

        CustomerZone.add(NameLabel);
        CustomerZone.add(NameField);
        CustomerZone.add(StreetLabel);
        CustomerZone.add(StreetField);
        CustomerZone.add(CSLabel);
        CustomerZone.add(CityStateField);
        CustomerZone.add(ZIPLabel);
        CustomerZone.add(ZIPCodeField);

        ItemZone.add(ProductLabel);
        ItemZone.add(ProductField);
        ItemZone.add(QuantityLabel);
        ItemZone.add(QuantityField);
        ItemZone.add(PriceLabel);
        ItemZone.add(PriceField);

        CustomerZone.add(SubmitButton);
        ItemZone.add(AddButton);
      ActionListener itemListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent LineItemAddAttempt) {
          Boolean GotAnInt=true;
          Boolean GotADouble=true;
          try {
            Integer.parseInt(QuantityField.getText());
          }catch (NumberFormatException BadQuantityInput){GotAnInt=false;}
          try{
            Double.parseDouble(PriceField.getText());
          }catch (NumberFormatException BadPriceInput){GotADouble=false;}
          if (GotAnInt && GotADouble){
            ItemsForInvoice.add(new LineItem(ProductField.getText(),Integer.parseInt(QuantityField.getText()),Double.parseDouble(PriceField.getText())));
            JOptionPane.showMessageDialog(Canvas,"Line item added to invoice!");
          }
          else {JOptionPane.showMessageDialog(Canvas,"Check price and quantity, unexpected input");}

        }
      };

      ActionListener submitListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent SubmitAttempt) {
          Boolean GotAnInt = true;
          try {
            Integer.parseInt(ZIPCodeField.getText());
          }catch (NumberFormatException BadZIP_Input){GotAnInt=false;}

          if (GotAnInt){
            CurrentCustomer.setName(NameField.getText());
            CurrentCustomer.setStreetAddress(StreetField.getText());
            CurrentCustomer.setStateAndTown(CityStateField.getText());
            CurrentCustomer.setZipCode(Integer.parseInt(ZIPCodeField.getText()));

            System.out.println("CUSTOMER: "+ CurrentCustomer.getName());
            System.out.println("ADDRESS: "+CurrentCustomer.getStreetAddress());
            System.out.println("LOCALE: "+CurrentCustomer.getStateAndTown()+" "+CurrentCustomer.getZipCode());
            System.out.println("ITEMS: ");
            for (LineItem item : ItemsForInvoice)
            {RunningTotal = RunningTotal+item.getItemTotal();
              System.out.println(
                      "ITEM: " + item.getProduct()+" "+"QUANTITY: "+item.getQuantity()+" "+"UNIT PRICE: $"+item.getItemPrice()+" "+"TOTAL: $"+item.getItemTotal()
              );
            }
            System.out.println("AMMOUNT DUE: $"+RunningTotal);
            RunningTotal=0;
            JOptionPane.showMessageDialog(Canvas,"Receipt printed to console!");
          }
          else {JOptionPane.showMessageDialog(Canvas,"Check customer data, improper entry");}
        }
      };
        AddButton.addActionListener(itemListener);
        SubmitButton.addActionListener(submitListener);
        PrintAnInvoice.setVisible(true);

    }
}