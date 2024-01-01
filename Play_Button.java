import greenfoot.*;

public class Play_Button extends Buttons
{
    int flag = 0;
    
    GreenfootSound music = new GreenfootSound("main_menu_music.mp3");
    
    public void stopMusic()
    {
        music.stop();
    }
    
    public void act() 
    {
        if(flag == 0)
        {
            music.playLoop();
            
            flag = 1;
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.playSound("click.mp3");
            
            Greenfoot.setWorld(new Space());
            
            stopMusic();
            
            return;
        }
    }    
}
