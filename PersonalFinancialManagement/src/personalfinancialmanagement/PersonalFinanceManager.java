import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PersonalFinanceManager extends JFrame {
    private JTextField descriptionField, amountField;
    private JComboBox<String> typeComboBox;
    private DefaultTableModel tableModel;
    private ArrayList<Transaction> transactions;

    public PersonalFinanceManager() {
        setTitle("Personal Finance Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        transactions = new ArrayList<>();

        // Top Panel for input
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel descriptionLabel = new JLabel("Description:");
        JLabel amountLabel = new JLabel("Amount:");
        JLabel typeLabel = new JLabel("Type:");

        descriptionField = new JTextField();
        amountField = new JTextField();
        typeComboBox = new JComboBox<>(new String[]{"Income", "Expense"});

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addTransaction());

        inputPanel.add(descriptionLabel);
        inputPanel.add(descriptionField);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
        inputPanel.add(typeLabel);
        inputPanel.add(typeComboBox);
        inputPanel.add(addButton);

        // Table for transaction history
        String[] columnNames = {"Description", "Type", "Amount", "Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable transactionTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(transactionTable);

        // Bottom Panel for actions
        JPanel actionPanel = new JPanel();
        JButton sortByDateButton = new JButton("Sort by Date");
        JButton sortByAmountButton = new JButton("Sort by Amount");
        JButton undoButton = new JButton("Undo Last");

        sortByDateButton.addActionListener(e -> sortTransactions("date"));
        sortByAmountButton.addActionListener(e -> sortTransactions("amount"));
        undoButton.addActionListener(e -> undoLastTransaction());

        actionPanel.add(sortByDateButton);
        actionPanel.add(sortByAmountButton);
        actionPanel.add(undoButton);

        // Adding panels to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addTransaction() {
        try {
            String description = descriptionField.getText().trim();
            double amount = Double.parseDouble(amountField.getText().trim());
            String type = (String) typeComboBox.getSelectedItem();
            Transaction transaction = new Transaction(description, type, amount);

            transactions.add(transaction);
            tableModel.addRow(new Object[]{description, type, amount, transaction.getDate()});

            // Clear input fields
            descriptionField.setText("");
            amountField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.");
        }
    }

    private void sortTransactions(String criterion) {
        if (transactions.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No transactions to sort.");
            return;
        }

        Comparator<Transaction> comparator;
        if (criterion.equals("date")) {
            comparator = Comparator.comparing(Transaction::getDate);
        } else {
            comparator = Comparator.comparingDouble(Transaction::getAmount);
        }

        Collections.sort(transactions, comparator);
        refreshTable();
    }

    private void undoLastTransaction() {
        if (!transactions.isEmpty()) {
            transactions.remove(transactions.size() - 1);
            tableModel.removeRow(tableModel.getRowCount() - 1);
        } else {
            JOptionPane.showMessageDialog(this, "No transactions to undo.");
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Transaction transaction : transactions) {
            tableModel.addRow(new Object[]{
                    transaction.getDescription(),
                    transaction.getType(),
                    transaction.getAmount(),
                    transaction.getDate()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PersonalFinanceManager::new);
    }
}

class Transaction {
    private String description;
    private String type;
    private double amount;
    private String date;

    public Transaction(String description, String type, double amount) {
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = java.time.LocalDate.now().toString();
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
