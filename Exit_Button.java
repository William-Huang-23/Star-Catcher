import greenfoot.*;

public class Exit_Button extends Buttons
{
    int flag = 0;
    
    Guide_Button guide = new Guide_Button();
    
    public void act() 
    {
        if(flag == 0)
        {
            getWorld().addObject(guide, 500, 500);
            
            flag = 1;
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.playSound("click.mp3");
            
            guide.play.stopMusic();
            
            Greenfoot.stop();
            
            return;
        }
    }    
}
