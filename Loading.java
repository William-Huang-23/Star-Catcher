import greenfoot.*;

public class Loading extends World
{
    public Loading()
    {   
        super(1000, 800, 1); 
        prepare();
    }
    
    private void prepare()
    {
        Loading_Logo loading_Logo = new Loading_Logo();
        addObject(loading_Logo,500,400);

        Loading_Bar loading_Bar = new Loading_Bar();
        addObject(loading_Bar,500,500);

        Loading_Rocket loading_Rocket = new Loading_Rocket();
        addObject(loading_Rocket,290,500);

        Loading_Star loading_Star = new Loading_Star();
        addObject(loading_Star,720,500);
        
        Logo logo = new Logo();
        addObject(logo,510,125);
    }
}
