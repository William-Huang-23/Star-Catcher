import greenfoot.*;

public class Back_Button extends Buttons
{
    GreenfootSound music = new GreenfootSound("main_menu_music.mp3");
    
    public void act() 
    {
        music.playLoop();
        
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.playSound("click.mp3");
            
            Greenfoot.setWorld(new Main_Menu());
            
            music.stop();
            
            return;
        }
    }    
}
