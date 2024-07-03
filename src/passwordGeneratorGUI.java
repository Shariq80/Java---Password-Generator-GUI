import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class passwordGeneratorGUI {
    JFrame f;

    passwordGeneratorGUI() {
        f = new JFrame("Password Generator GUI");
        JLabel l1, l2, l3;
        JTextField t1;
        JTextArea t2;
        JComboBox<String> cBox;
        JButton b1, bClose;
        JPanel p1, p2;

        l1 = new JLabel("Enter the Length of the Password: ");
        t1 = new JTextField(); // Increased the size of the text field
        String placeholderText = "Enter a number";
        t1.setText(placeholderText);
        t1.setEditable(true);

        l2 = new JLabel("Choose Difficulty of Password: ");
        String[] difficulty = {"Easy", "Medium", "Hard"};
        cBox = new JComboBox<>(difficulty);

        b1 = new JButton("Generate");
        t2 = new JTextArea(5, 20);
        t2.setEditable(false);

        l3 = new JLabel("Generated Password: ");

        t1.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (t1.getText().equals(placeholderText)) {
                    t1.setText("");
                    t1.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (t1.getText().isEmpty()) {
                    t1.setForeground(Color.GRAY);
                    t1.setText(placeholderText);
                }
            }
        });

        b1.addActionListener(new ActionListener() {
            int leftLimit, rightLimit, targetStringLength;

            public void actionPerformed(ActionEvent e) {
                try {
                    if (t1.getText().isEmpty()) {
                        throw new NumberFormatException();
                    }
                    targetStringLength = Integer.parseInt(t1.getText());
                    String option = (String) cBox.getItemAt(cBox.getSelectedIndex());
                    Random random = new Random();
                    StringBuilder buffer = new StringBuilder(targetStringLength);

                    switch (option) {
                        case "Easy":
                            leftLimit = 65; // letter 'A'
                            rightLimit = 122; // letter 'z'
                            for (int i = 0; i < targetStringLength; i++) {
                                int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
                                buffer.append((char) randomLimitedInt);
                            }
                            t2.setText(buffer.toString());
                            break;
                        case "Medium":
                            leftLimit = 48; // digit '0'
                            rightLimit = 122; // letter 'z'
                            for (int i = 0; i < targetStringLength; i++) {
                                int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
                                char c = (char) randomLimitedInt;
                                if (Character.isLetter(c) || Character.isDigit(c)) {
                                    buffer.append(c);
                                } else {
                                    i--; // Re-roll if a special character is generated
                                }
                            }
                            t2.setText(buffer.toString());
                            break;
                        case "Hard":
                            leftLimit = 33; // '!'
                            rightLimit = 126; // '~'
                            for (int i = 0; i < targetStringLength; i++) {
                                int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
                                buffer.append((char) randomLimitedInt);
                            }
                            t2.setText(buffer.toString());
                            break;
                        default:
                            t2.setText("Choose a Difficulty of Password.");
                            break;
                    }
                } catch (NumberFormatException ex) {
                    t2.setLineWrap(true);
                    t2.setWrapStyleWord(true);
                    t2.setText("Please enter a valid number for the password length.");
                }
            }
        });

        bClose = new JButton("Close");
        bClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        p1 = new JPanel(new GridBagLayout());
        p2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(l1, gbc);

        gbc.gridx = 1;
        p1.add(t1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        p1.add(l2, gbc);

        gbc.gridx = 1;
        p1.add(cBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        p1.add(b1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        p2.add(l3, gbc);

        gbc.gridx = 1;
        p2.add(t2, gbc);

        f.setLayout(new BorderLayout());
        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.CENTER);
        f.add(bClose, BorderLayout.SOUTH);

        f.setSize(400, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new passwordGeneratorGUI();
    }
}
