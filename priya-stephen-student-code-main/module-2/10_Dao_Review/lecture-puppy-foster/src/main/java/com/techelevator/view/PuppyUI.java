package com.techelevator.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URI;

/*
 * Instructions to use:
 * 1. Create an object of this class
 * 2. Call addPuppyCard(String url, String description) to display the image
 *    at the url and a text description.
 */
public class PuppyUI {
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 1000;

    private JFrame frame;
    private JPanel mainPanel;
    PuppyCard newPuppyCard;

    public PuppyUI(){
        mainPanel = new JPanel();
        newPuppyCard = null;

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setTitle("Puppy Foster");
        frame.add(mainPanel);
        frame.pack();
    }

    public void addPuppyCard(String url, String description){
        newPuppyCard = new PuppyCard(url, description);

        mainPanel.removeAll();
        mainPanel.add(newPuppyCard);
        mainPanel.repaint();
        mainPanel.revalidate();
        frame.setVisible(true);
        frame.pack();
    }

    class PuppyCard extends JPanel{
        private JLabel imageLabel;
        private JLabel descriptionLabel;

        public PuppyCard(String url, String description){
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            if( url != null ) {
                BufferedImage image = loadImage(url);
                imageLabel = new JLabel(new ImageIcon(image));
                add(imageLabel);
            }

            if( description != null ) {
                descriptionLabel = new JLabel(description);
                descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                add(descriptionLabel);
            }
        }
    }

    private BufferedImage loadImage(String imageFileURL) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(URI.create(imageFileURL).toURL());
        } catch (Exception e){
            System.out.println("Unable to find file: " + imageFileURL);
            e.printStackTrace();
        }

        return image;
    }
}
