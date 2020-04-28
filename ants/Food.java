import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Food here.
 * 
 * @author Millie Harrison
 * @version 4/28/20
 */
public class Food extends Actor
{
    private GreenfootImage image;
    private int crumbs = 100;
    private final int size = 50;
    
    public Food()
    {
        image = new GreenfootImage(size, size);
        updateImage();
    }
    
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }  
    
    private void updateImage()
    {
        Random random = new Random();
        for (int i = 100; i > 0; i--)
        {
            int stDev = size / 6;
            int x = (int) (stDev * random.nextGaussian( ) + 3 * stDev);
            int y = (int) (stDev * random.nextGaussian( ) + 3 * stDev);
            if(x < 0) 
            {
                x = 0;
            }
            if(x >= size) 
            {
                x = size - 1;
            }
            if(y < 0)
            {
                y = 0;
            }
            if(y >= size)
            {
                y = size - 1;
            }
            Color color = new Color(129, 188, 104);  // pick the color you want by replacing r, g, b with values.
            image.setColorAt(x, y, color);
        }
        setImage(image);
    }
    
    public void removeCrumb()
    {
        crumbs --;
        getImage().clear();
        updateImage();
        if(crumbs <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}
