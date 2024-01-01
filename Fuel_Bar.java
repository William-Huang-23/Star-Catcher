import greenfoot.*;

public class Fuel_Bar extends Entities
{
    public void changeImage(int fuel_count)
    {
        if(fuel_count == 4)
        {
            setImage("fuel_4.png");
        }
        else if(fuel_count == 3)
        {
            setImage("fuel_3.png");
        }
        else if(fuel_count == 2)
        {
            setImage("fuel_2.png");
        }
        else if(fuel_count == 1)
        {
            setImage("fuel_1.png");
        }
        else
        {
            setImage("fuel_0.png");
        }
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
