
package mtgodeckpricegetter;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MTGODeckPriceGetter {

    public static void main(String[] args) {
        displayMain();
    }
    
    public static void displayMain()
    {
        //confirm button
        JButton button = new JButton("Get JSON Data");
        button.setSize(150, 50);
        button.setLocation(50, 525);
        
        //deck paste area
        JTextArea textarea = new JTextArea();
        textarea.setText("Lightning Bolt\nSnapcaster Mage\nMaro");
        textarea.setSize(250, 500);
        textarea.setLocation(10, 10);
        textarea.setLineWrap(true);
        
        //results label
        JTextArea label = new JTextArea("Raw JSON results go here");
        label.setLineWrap(true);

        //scroll for json results
        JScrollPane scroll = new JScrollPane(label, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setSize(250,500);
        scroll.setLocation(530, 10);
        scroll.setVisible(true);
        
        
        //detected card names selected
        JTextArea label2 = new JTextArea("Detected card names");
        label2.setLineWrap(true);
        
        //scroll for detected card names
        JScrollPane scroll2 = new JScrollPane(label2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll2.setSize(250,500);
        scroll2.setLocation(270, 10);
        scroll2.setVisible(true);
        
        //Panel Setup
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        
        //Add components to Panel
        mainPanel.add(textarea);
        mainPanel.add(button);
        mainPanel.add(scroll);
        mainPanel.add(scroll2);

        //Create frame and add panel
        JFrame frame = new JFrame("MTGO Deck Price Getter");
        frame.add(mainPanel);
        
        //Frame Setup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1070, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Save user input as String list
                String tempdecklist = textarea.getText();
                tempdecklist = tempdecklist.replaceAll("\n", "ggsplitgg");
                tempdecklist = tempdecklist.replaceAll("\\s+", "+");
                String[] deckStrings = tempdecklist.split("ggsplitgg");
                
                // Convert list to ArrayList
                List<String> deckArray = new ArrayList<>(Arrays.asList(deckStrings));
                String finalResult = "";
                
                // Do the thing
                for (int i = 0; i < deckArray.size(); i++)
                {
                    // If a line was empty, delete it from the Array
                    if (deckArray.get(i).length() == 0)
                    {
                        deckArray.remove(i);
                    }
                    finalResult += deckArray.get(i);
                }
                
                // AT THIS POINT, THE USER INPUT IS STORED IN AN ARRAY LINE BY LINE AND THE EMPTY LINES HAVE BEEN REMOVED
                
                
                
                label.setText(JSONgetter.getPrice("literally dont matter what i type here"));
                label2.setText(deckArray.toString());
          } 
        });
        
                
                
        
    }
    
}
