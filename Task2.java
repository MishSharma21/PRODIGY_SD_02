import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Task2 {
    private int randomNumber;
    private int attempts;
    private JTextField guessField;
    private JLabel messageLabel;
    private JLabel attemptsLabel;

    public Task2() 
    {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
        attempts = 0;

        JFrame frame = new JFrame("Number Guessing Game");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        ImageIcon bgImage = new ImageIcon("C:\\Users\\misht\\OneDrive\\Pictures\\Screenshots\\game4.jpg");  

        JPanel backgroundPanel = new JPanel() 
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy = 0;
        JLabel titleLabel = new JLabel("Welcome to the Guessing Game!", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLUE);
        backgroundPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        JLabel instructionLabel = new JLabel("Enter a number between 1 and 100:", JLabel.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        backgroundPanel.add(instructionLabel, gbc);

        gbc.gridy = 2;
        guessField = new JTextField(10);
        guessField.setFont(new Font("Arial", Font.BOLD, 18));
        guessField.setHorizontalAlignment(JTextField.CENTER);
        backgroundPanel.add(guessField, gbc);

        gbc.gridy = 3;
        JButton guessButton = new JButton("Guess");
        guessButton.setFont(new Font("Arial", Font.BOLD, 18));
        guessButton.setBackground(Color.BLACK);
        guessButton.setForeground(Color.WHITE);
        backgroundPanel.add(guessButton, gbc);

        gbc.gridy = 4;
        messageLabel = new JLabel("", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        backgroundPanel.add(messageLabel, gbc);

        gbc.gridy = 5;
        attemptsLabel = new JLabel("Attempts: 0", JLabel.CENTER);
        attemptsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        backgroundPanel.add(attemptsLabel, gbc);

        guessButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    int guess = Integer.parseInt(guessField.getText());
                    attempts++;
                    if (guess < randomNumber) 
                    {
                        messageLabel.setText("Too low! Try again.");
                        messageLabel.setForeground(Color.RED);
                    } 
                    else if (guess > randomNumber) 
                    {
                        messageLabel.setText("Too high! Try again.");
                        messageLabel.setForeground(Color.RED);
                    } 
                    else 
                    {
                        messageLabel.setText("Congratulations! You guessed the number " + randomNumber + "!");
                        messageLabel.setForeground(Color.GREEN);
                        guessField.setEnabled(false);
                    }
                    attemptsLabel.setText("Attempts: " + attempts);
                } 
                catch (NumberFormatException ex) 
                {
                    messageLabel.setText("Please enter a valid number.");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        frame.add(backgroundPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        new Task2();
    }
}
