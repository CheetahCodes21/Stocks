import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class StockTracker {
  private String[] stocks = {"AAPL", "GOOG", "TSLA"};
  private double[] prices = {120.0, 200.0, 500.0};

  public void showUI() {
    JFrame frame = new JFrame("Stock Tracker");
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    
    JTextField stockField = new JTextField();
    panel.add(stockField, BorderLayout.NORTH);

    JButton getPriceButton = new JButton("Get Price");
    getPriceButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String stock = stockField.getText();
        int index = -1;
        for (int i = 0; i < stocks.length; i++) {
          if (stocks[i].equals(stock)) {
            index = i;
            break;
          }
        }
        if (index == -1) {
          JOptionPane.showMessageDialog(frame, "Stock not found");
        } else {
          JOptionPane.showMessageDialog(frame, "Price: $" + prices[index]);
        }
      }
    });
    panel.add(getPriceButton, BorderLayout.SOUTH);

    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    StockTracker tracker = new StockTracker();
    tracker.showUI();
  }
}
