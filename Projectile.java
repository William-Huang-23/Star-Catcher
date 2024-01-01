import greenfoot.*;

public class Projectile extends Entities
{
    public void rotate(int rotation)
    {
        turn(rotation);
        
        return;
    }
    
    public void act() 
    {
        move(12);
        
        if(isTouching(Star.class))
        {
            Actor actor = getOneIntersectingObject(Star.class);
            
            if(actor != null)
            {
                getWorld().removeObject(actor);
            }
            
            getWorld().removeObject(this);
            
            return;
        }
        
        if(isTouching(Fuel.class))
        {
            Actor actor = getOneIntersectingObject(Fuel.class);
            
            if(actor != null)
            {
                getWorld().removeObject(actor);
            }
            
            getWorld().removeObject(this);
            
            return;
        }
        
        if(isTouching(Asteroid.class))
        {
            Actor actor = getOneIntersectingObject(Asteroid.class);
            
            if(actor != null)
            {
                getWorld().removeObject(actor);
            }
            
            Greenfoot.playSound("asteroid_break.mp3");
            
            getWorld().removeObject(this);
            
            return;
        }
        
        if(isTouching(Goo.class))
        {
            Actor actor = getOneIntersectingObject(Goo.class);
            
            if(actor != null)
            {
                getWorld().removeObject(actor);
            }
            
            getWorld().removeObject(this);
            
            return;
        }
        
        if(isAtEdge())
        {
            getWorld().removeObject(this);
            
            return;
        }
    }    
}
