import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VotingSystem extends JFrame implements ActionListener {
    JButton voteButton, checkBTN;
    ButtonGroup partyGroup;
    JTextField nameField, phoneField;

    Connection connection;

    JRadioButton partyAButton, partyBButton, partyCButton;

    VotingSystem() {
        super("ONLINE VOTING SYSTEM");

        // Set custom colors
        Color backgroundColor = new Color(245, 245, 245); // Light gray
        Color buttonColor = new Color(70, 130, 180); // Steel blue
        Color textColor = Color.BLACK;

        getContentPane().setBackground(backgroundColor);

        JLabel titleLabel = new JLabel("ONLINE VOTING SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(textColor);
        titleLabel.setBounds(150, 10, 500, 50);
        add(titleLabel);

        JLabel label1 = new JLabel("ENTER NAME ");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(textColor);
        label1.setBounds(50, 70, 300, 50);
        add(label1);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.BOLD, 20));
        nameField.setBounds(250, 80, 300, 30);
        add(nameField);

        JLabel label2 = new JLabel("ENTER PHONE ");
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setForeground(textColor);
        label2.setBounds(50, 150, 300, 50);
        add(label2);

        phoneField = new JTextField();
        phoneField.setFont(new Font("Arial", Font.BOLD, 20));
        phoneField.setBounds(250, 160, 300, 30);
        add(phoneField);

        JLabel label3 = new JLabel("CAST YOUR VOTE HERE");
        label3.setFont(new Font("Arial", Font.BOLD, 20));
        label3.setForeground(textColor);
        label3.setBounds(50, 230, 300, 50);
        add(label3);

        voteButton = new JButton("SUBMIT YOUR VOTE ");
        voteButton.addActionListener(this);
        voteButton.setFont(new Font("Arial", Font.BOLD, 20));
        voteButton.setBackground(buttonColor);
        voteButton.setForeground(Color.WHITE);
        voteButton.setBounds(300, 270, 250, 50);
        add(voteButton);

        checkBTN = new JButton("CHECK RESULTS");
        checkBTN.addActionListener(this);
        checkBTN.setFont(new Font("Arial", Font.BOLD, 20));
        checkBTN.setBackground(buttonColor);
        checkBTN.setForeground(Color.WHITE);
        checkBTN.setBounds(300, 340, 250, 50);
        add(checkBTN);

        partyGroup = new ButtonGroup();
        partyAButton = new JRadioButton("PARTY A");
        partyAButton.setFont(new Font("Arial", Font.BOLD, 20));
        partyAButton.setForeground(textColor);
        partyAButton.setBounds(50, 270, 200, 30);
        partyGroup.add(partyAButton);
        add(partyAButton);

        partyBButton = new JRadioButton("PARTY B");
        partyBButton.setFont(new Font("Arial", Font.BOLD, 20));
        partyBButton.setForeground(textColor);
        partyBButton.setBounds(50, 310, 200, 30);
        partyGroup.add(partyBButton);
        add(partyBButton);

        partyCButton = new JRadioButton("PARTY C");
        partyCButton.setFont(new Font("Arial", Font.BOLD, 20));
        partyCButton.setForeground(textColor);
        partyCButton.setBounds(50, 350, 200, 30);
        partyGroup.add(partyCButton);
        add(partyCButton);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        // Establish database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/voting_db", "root", "ROOT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voteButton) {
            // Handle vote submission
            String name = nameField.getText();
            String phone = phoneField.getText();
            String party = "";
            if (partyAButton.isSelected()) {
                party = "Party A";
            } else if (partyBButton.isSelected()) {
                party = "Party B";
            } else if (partyCButton.isSelected()) {
                party = "Party C";
            }

            if (!name.isEmpty() && !phone.isEmpty() && !party.isEmpty()) {
                try {
                    // Insert vote into database
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO votes (name, phone, party) VALUES (?, ?, ?)");
                    statement.setString(1, name);
                    statement.setString(2, phone);
                    statement.setString(3, party);
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Vote submitted successfully!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields and select a party.");
            }
        } else if (e.getSource() == checkBTN) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT party, COUNT(*) AS votes FROM votes GROUP BY party");

                StringBuilder resultMessage = new StringBuilder("Voting Results:\n");
                while (resultSet.next()) {
                    String partyName = resultSet.getString("party");
                    int voteCount = resultSet.getInt("votes");
                    resultMessage.append(partyName).append(": ").append(voteCount).append("\n");
                }

                JOptionPane.showMessageDialog(this, resultMessage.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Set the look and feel to Nimbus
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Launch the application
        new VotingSystem();
    }
}
