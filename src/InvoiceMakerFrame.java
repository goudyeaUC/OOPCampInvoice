import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class InvoiceMakerFrame extends JFrame {
    public InvoiceMakerFrame (String title){
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize= kit.getScreenSize();
        this.setSize(screenSize.width, screenSize.height);



    }

}
