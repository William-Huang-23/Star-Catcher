import greenfoot.*;

public class Health_Bar extends Entities
{
    public void changeImage(int health)
    {
        if(health == 2)
        {
            setImage("health_2.png");
        }
        else if(health == 1)
        {
            setImage("health_1.png");
        }
        else
        {
            setImage("health_0.png");
        }
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
