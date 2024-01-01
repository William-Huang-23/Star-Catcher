import greenfoot.*;

public class Star extends Entities
{
    int time = 0;
    
    public void act() 
    {
        time++;
        
        if(time == 700)
        {
            getWorld().removeObject(this);
        }
    }    
}
