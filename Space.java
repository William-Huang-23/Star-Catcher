import greenfoot.*;

public class Space extends World
{  
    public Space()
    {   
        super(1000, 800, 1); 
        prepare();
    }

    private void prepare()
    {
        Rocket rocket = new Rocket();
        addObject(rocket,500,500);
    }
}
