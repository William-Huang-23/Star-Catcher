import greenfoot.*;

public class Guide extends World
{
    public Guide()
    {
        super(1000, 800, 1); 
        prepare();
    }
    
    private void prepare()
    {
        Back_Button back_Button = new Back_Button();
        addObject(back_Button,900,740);
        back_Button.setLocation(807,536);
        back_Button.setLocation(815,584);
        back_Button.setLocation(844,573);
    }
}
