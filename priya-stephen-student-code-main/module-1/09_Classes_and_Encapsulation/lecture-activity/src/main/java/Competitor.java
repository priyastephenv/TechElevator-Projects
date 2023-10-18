import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/*
 * This class holds attributes of a single competitor in a race
 * and has the ability to update and draw themselves during a race
 */
public class Competitor {
    private BufferedImage image;

    /*
     * Add some variables to keep track of the
     * competitor's position
     */

    private int x;
    private int y;


    public Competitor(String imageURL, int laneNumber){
        image = Racetrack.loadImage(imageURL);
        this.x = 0;

        this.y = (laneNumber - 1) * 100;

    }

    public void update(){
        /*
         * Move the competitor some distance each game frame
         *  - for random distance: new Random().nextInt(10);
         */

        this.x += new Random().nextInt(10);



    }

    public void draw(Graphics g){
        //                 x, y,  width, height
        g.drawImage(image, x, y, 100,   100, null);
    }
}
