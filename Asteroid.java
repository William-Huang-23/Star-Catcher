import greenfoot.*;

public class Asteroid extends Entities
{
    int x = 5;
    int y = 5;
    
    int flag = 0;
    
    public void act() 
    {
        if(flag == 0)
        {
            switch(Greenfoot.getRandomNumber(3))
            {
                case 0:
                {
                    x = x * -1;
                    
                    break;
                }
                
                case 1:
                {
                    y = y * -1;
                    
                    break;
                }
                
                case 2:
                {
                    x = x * -1;
                    y = y * -1;
                    
                    break;
                }
            }
            
            flag = 1;
        }
        
        setLocation(getX() + x, getY() + y);
        
        turn(5);
        
        if(isAtEdge())
        {
            if(getX() == 0 || getX() == getWorld().getWidth() - 1)
            {
                x = x * -1;
            }
            
            if(getY() == 0 || getY() == getWorld().getHeight() - 1)
            {
                y = y * -1;
            }
        }
        
        if(isTouching(Projectile.class))
        {
            getWorld().removeObject(this);
        }
    }    
}
