import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private static Map<String, Double> exchangeRates;

    public static void main(String[] args) {
        // Initialize exchange rates for 30 currencies (relative to USD for simplicity)
        exchangeRates = new HashMap<>();
        exchangeRates.put("United States - USD", 1.0);
        exchangeRates.put("Eurozone - EUR", 0.90);
        exchangeRates.put("Japan - JPY", 145.65);
        exchangeRates.put("United Kingdom - GBP", 0.78);
        exchangeRates.put("Australia - AUD", 1.55);
        exchangeRates.put("Canada - CAD", 1.33);
        exchangeRates.put("Switzerland - CHF", 0.88);
        exchangeRates.put("China - CNY", 7.12);
        exchangeRates.put("India - INR", 82.40);
        exchangeRates.put("Brazil - BRL", 4.88);
        exchangeRates.put("Mexico - MXN", 16.90);
        exchangeRates.put("Russia - RUB", 96.42);
        exchangeRates.put("South Africa - ZAR", 18.50);
        exchangeRates.put("South Korea - KRW", 1315.0);
        exchangeRates.put("Sweden - SEK", 10.80);
        exchangeRates.put("Norway - NOK", 10.20);
        exchangeRates.put("Singapore - SGD", 1.35);
        exchangeRates.put("Hong Kong - HKD", 7.80);
        exchangeRates.put("Turkey - TRY", 27.0);
        exchangeRates.put("United Arab Emirates - AED", 3.67);
        exchangeRates.put("Saudi Arabia - SAR", 3.75);
        exchangeRates.put("New Zealand - NZD", 1.67);
        exchangeRates.put("Malaysia - MYR", 4.55);
        exchangeRates.put("Thailand - THB", 35.15);
        exchangeRates.put("Indonesia - IDR", 15100.0);
        exchangeRates.put("Poland - PLN", 4.10);
        exchangeRates.put("Israel - ILS", 3.68);
        exchangeRates.put("Argentina - ARS", 340.0);
        exchangeRates.put("Egypt - EGP", 30.90);
        exchangeRates.put("Pakistan - PKR", 285.0);

        // Set up the GUI
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label1 = new JLabel("From Currency:");
        label1.setBounds(30, 30, 120, 30);
        frame.add(label1);

        JComboBox<String> fromCurrency = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        fromCurrency.setBounds(160, 30, 220, 30);
        frame.add(fromCurrency);

        JLabel label2 = new JLabel("To Currency:");
        label2.setBounds(30, 80, 120, 30);
        frame.add(label2);

        JComboBox<String> toCurrency = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        toCurrency.setBounds(160, 80, 220, 30);
        frame.add(toCurrency);

        JLabel label3 = new JLabel("Amount:");
        label3.setBounds(30, 130, 120, 30);
        frame.add(label3);

        JTextField amountField = new JTextField();
        amountField.setBounds(160, 130, 220, 30);
        frame.add(amountField);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(160, 180, 100, 30);
        frame.add(convertButton);

        JLabel resultLabel = new JLabel("Converted Amount: ");
        resultLabel.setBounds(30, 230, 350, 30);
        frame.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String from = fromCurrency.getSelectedItem().toString();
                    String to = toCurrency.getSelectedItem().toString();
                    double amount = Double.parseDouble(amountField.getText());

                    double fromRate = exchangeRates.get(from);
                    double toRate = exchangeRates.get(to);

                    double convertedAmount = (amount / fromRate) * toRate;
                    resultLabel.setText("Converted Amount: " + String.format("%.2f", convertedAmount) + " ("
                            + to.split(" - ")[1] + ")");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for the amount.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
