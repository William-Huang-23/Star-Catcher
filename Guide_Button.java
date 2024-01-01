import greenfoot.*;

public class Guide_Button extends Buttons
{
    int flag = 0;
    
    Play_Button play = new Play_Button();
    
    public void act() 
    {
        if(flag == 0)
        {
            getWorld().addObject(play, 500, 300);
            
            flag = 1;
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.playSound("click.mp3");
            
            Greenfoot.setWorld(new Guide());
            
            play.stopMusic();
            
            return;
        }
    }    
}
