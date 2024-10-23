package com.mycompany.selectfavepet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Pet selector application that asks users to choose their favorite pet
 * and shows the pet's photo.
 * 
 * @author Anisha.Amondi
 */
public class SelectFavePet extends JFrame implements ActionListener {
    // Declare radio buttons as final
    private final JRadioButton dogButton;
    private final JRadioButton catButton;
    private final JRadioButton birdButton;
    private final JRadioButton rabbitButton;
    private final JRadioButton pigButton;
    private final ButtonGroup group;
    
    // Label to display the image
    private final JLabel imageLabel;

    public SelectFavePet() {
        // Set the title of the JFrame
        setTitle("Animal Selector");
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Change the background color of the frame to red
        getContentPane().setBackground(Color.RED);
        
        // Create the radio buttons
        dogButton = new JRadioButton("Dog");
        catButton = new JRadioButton("Cat");
        birdButton = new JRadioButton("Bird");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Group the radio buttons to allow only one selection at a time
        group = new ButtonGroup();
        group.add(dogButton);
        group.add(catButton);
        group.add(birdButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Add action listeners for the radio buttons
        dogButton.addActionListener(this);
        catButton.addActionListener(this);
        birdButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        // Label to display images
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        // Set up the layout of the window
        setLayout(new BorderLayout());

        // Panel for the radio buttons
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        buttonPanel.add(dogButton);
        buttonPanel.add(catButton);
        buttonPanel.add(birdButton);
        buttonPanel.add(rabbitButton);
        buttonPanel.add(pigButton);

        // Add the button panel and image label to the frame
        add(buttonPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        // Set the size of the window
        setSize(600, 400);
        setVisible(true);
        
        // Add a button panel for minimize, maximize, and close buttons
        JPanel titlePanel = new JPanel();
        JButton minimizeButton = new JButton("-");
        JButton maximizeButton = new JButton("+");
        JButton closeButton = new JButton("X");

        minimizeButton.addActionListener(e -> setState(Frame.ICONIFIED));
        maximizeButton.addActionListener(e -> {
            if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                setExtendedState(JFrame.NORMAL);
            } else {
                setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
        closeButton.addActionListener(e -> System.exit(0));

        titlePanel.add(minimizeButton);
        titlePanel.add(maximizeButton);
        titlePanel.add(closeButton);

        add(titlePanel, BorderLayout.NORTH);

        // Ask the user for their favorite pet
        askFavoritePet();
    }

    private void askFavoritePet() {
        String[] options = {"Dog", "Cat", "Bird", "Rabbit", "Pig"};
        
        // Show a dialog to the user to select their favorite pet
        String selectedPet = (String) JOptionPane.showInputDialog(
                this, 
                "What is your favorite Animal?", 
                "Select Your Favorite Animal", 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]
        );
        
        // If user cancels or closes the dialog, exit the program
        if (selectedPet == null) {
            System.exit(0);
        }

        // Set the corresponding radio button based on the selected pet
        switch (selectedPet) {
            case "Dog":
                dogButton.setSelected(true);
                setImage("C:\\Users\\Anisha.Amondi\\OneDrive - Osho chemical Industries Ltd\\Documents\\NetBeansProjects\\SelectFavePet\\images\\Dog.jpeg");
                break;
            case "Cat":
                catButton.setSelected(true);
                setImage("C:\\Users\\Anisha.Amondi\\OneDrive - Osho chemical Industries Ltd\\Documents\\NetBeansProjects\\SelectFavePet\\images\\Cat.jpeg");
                break;
            case "Bird":
                birdButton.setSelected(true);
                setImage("C:\\Users\\Anisha.Amondi\\OneDrive - Osho chemical Industries Ltd\\Documents\\NetBeansProjects\\SelectFavePet\\images\\Bird.png");
                break;
            case "Rabbit":
                rabbitButton.setSelected(true);
                setImage("C:\\Users\\Anisha.Amondi\\OneDrive - Osho chemical Industries Ltd\\Documents\\NetBeansProjects\\SelectFavePet\\images\\Rabbit.png");
                break;
            case "Fish":
                pigButton.setSelected(true);
                setImage("C:\\Users\\Anisha.Amondi\\OneDrive - Osho chemical Industries Ltd\\Documents\\NetBeansProjects\\SelectFavePet\\images\\Fish.png");
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which radio button is selected and show the corresponding image
        if (dogButton.isSelected()) {
            setImage("C:\\Users\\Anisha.Amondi\\OneDrive - Osho chemical Industries Ltd\\Documents\\NetBeansProjects\\SelectFavePet\\images\\Dog.jpeg");
        } else if (catButton.isSelected()) {
            setImage("C:\\Users\\Anisha.Amondi\\OneDrive - Osho chemical Industries Ltd\\Documents\\NetBeansProjects\\SelectFavePet\\images\\Cat.jpeg");
        } else if (birdButton.isSelected()) {
            setImage("C:\\Users\\Anisha.Amondi\\OneDrive - Osho chemical Industries Ltd\\Documents\\NetBeansProjects\\SelectFavePet\\images\\Bird.png");
        } else if (rabbitButton.isSelected()) {
            setImage("C:\\Users\\Anisha.Amondi\\OneDrive - Osho chemical Industries Ltd\\Documents\\NetBeansProjects\\SelectFavePet\\images\\Rabbit.png");
        } else if (pigButton.isSelected()) {
            setImage("C:\\Users\\Anisha.Amondi\\OneDrive - Osho chemical Industries Ltd\\Documents\\NetBeansProjects\\SelectFavePet\\images\\Pig.jpeg");
        }
    }

    // Method to set the image in the label
    private void setImage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        // Resize the image to fit the label
        Image scaledImage = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
    }

    public static void main(String[] args) {
        // Create an instance of the SelectFavePet class
        new SelectFavePet();
    }
}
