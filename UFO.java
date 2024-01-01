import greenfoot.*;

public class UFO extends Entities
{
    int health = 5;
    int x = 2;
    int y = 2;
    
    int time = 0;
    
    int flag = 0;
    
    private void barrage()
    {
        for(int i = 0; i < 316 ; i = i + 45)
        {
            Goo barrage = new Goo();
            getWorld().addObject(barrage, getX(), getY());
            
            Greenfoot.playSound("barrage.mp3");
            
            barrage.rotate(i);
        }
    }
    
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
        
        time++;
        
        setLocation(getX() + x, getY() + y);
        
        if(time % 100 == 0)
        {
            barrage();
        }
        
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
            Actor actor = getOneIntersectingObject(Projectile.class);
            
            if(actor != null)
            {
                getWorld().removeObject(actor);
            }
            
            if(health > 1)
            {
                health--;
            }
            else
            {
                getWorld().removeObject(this);
                
                return;
            }
        }
    }    
}
