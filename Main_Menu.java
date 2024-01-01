import greenfoot.*;

public class Main_Menu extends World
{
    public Main_Menu()
    {    
        super(1000, 800, 1); 
        prepare();
    }
    
    void prepare()
    {
        Exit_Button exit = new Exit_Button();
        addObject(exit,500,700);

        Logo logo = new Logo();
        addObject(logo,510,125);
    }
}
