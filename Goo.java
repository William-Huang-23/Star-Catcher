import greenfoot.*;

public class Goo extends Entities
{
    public void rotate(int rotation)
    {
        turn(rotation);
    }
    
    public void act() 
    {
        move(4);
        
        if(isTouching(Star.class))
        {
            Greenfoot.playSound("goo.mp3");
            
            Actor actor = getOneIntersectingObject(Actor.class);
            
            if(actor != null)
            {
                getWorld().removeObject(actor);
            }
            
            getWorld().removeObject(this);
            
            return;
        }
        
        if(isTouching(Fuel.class))
        {
            Greenfoot.playSound("goo.mp3");
            
            Actor actor = getOneIntersectingObject(Actor.class);
            
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
