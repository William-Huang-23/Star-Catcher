import greenfoot.*;

public class Fuel extends Entities
{
    int direction = 1;
    int time = 0;
    
    int flag = 0;
    
    public void act() 
    {
        if(flag == 0)
        {
            if(Greenfoot.getRandomNumber(2) == 0)
            {
                direction = direction * -1;
            }
            
            flag = 1;
        }
        
        time++;
        
        turn(direction);
        
        if(time == 1000)
        {
            getWorld().removeObject(this);
        }
    }    
}
