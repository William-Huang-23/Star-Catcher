import greenfoot.*;

public class Loading_Rocket extends Actor
{
    int speed = 1;
    
    public void act() 
    {
        move(speed);
        
        if(isTouching(Loading_Star.class))
        {
            Greenfoot.setWorld(new Main_Menu());
            
            return;
        }
    }    
}
