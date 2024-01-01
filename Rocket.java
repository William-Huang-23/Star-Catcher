import greenfoot.*;
import java.util.*;

public class Rocket extends Entities
{
    // rocket data
    int health = 3;
    int score = 0;
    int speed = 4;
    int rotation = -90;
    int fuel_count = 3;
   
    // entity modifiers
    int shoot_delay = 20;
    int shooting = 0;
    int fuel_duration = 200;
    int using_fuel = 0;
    int time = 70;
    int immunity_duration = 0;
    int recently_hit = 0;
    
    int flag = 0;
    
    Health_Bar health_bar = new Health_Bar();
    Fuel_Bar fuel_bar = new Fuel_Bar();
    
    GreenfootImage usual = new GreenfootImage("rocket.png");
    GreenfootImage immune = new GreenfootImage("rocket_immune.png");
    GreenfootSound music = new GreenfootSound("background_music.mp3");
    
    private void display_stats()
    {
        getWorld().showText("Score: " + score, 100, 100);
        getWorld().showText("" + time/70, 500, 50);
        
        return;
    }
    
    private void spawn_star()
    {
        Star star = new Star();
            
        getWorld().addObject(star, Greenfoot.getRandomNumber(getWorld().getWidth() - 200) + 100, Greenfoot.getRandomNumber(getWorld().getHeight() - 200) + 100);
        
        return;
    }
    
    private void spawn_fuel()
    {
        Fuel fuel = new Fuel();
            
        getWorld().addObject(fuel, Greenfoot.getRandomNumber(getWorld().getWidth() - 200) + 100, Greenfoot.getRandomNumber(getWorld().getHeight() - 200) + 100);
    
        return;
    }
    
    private void spawn_asteroid()
    {
        for(int i = 0 ; i <= time/3000 ; i++)
        {
            Asteroid asteroid = new Asteroid();
            
            switch(Greenfoot.getRandomNumber(3))
            {
                case 0:
                {
                    getWorld().addObject(asteroid, Greenfoot.getRandomNumber(getWorld().getWidth() - 1), 0);
                    
                    break;
                }
                
                case 1:
                {
                    getWorld().addObject(asteroid, 0, Greenfoot.getRandomNumber(getWorld().getHeight() - 1));
                    
                    break;
                }
                
                case 2:
                {
                    getWorld().addObject(asteroid, Greenfoot.getRandomNumber(getWorld().getWidth() - 1), getWorld().getHeight() - 1);
                    
                    break;
                }
                
                case 3:
                {
                    getWorld().addObject(asteroid, getWorld().getHeight() - 1, Greenfoot.getRandomNumber(getWorld().getHeight() - 1));
                    
                    break;
                }
            }
        }
    
        return;
    }
    
    private void spawn_UFO()
    {
        Greenfoot.playSound("alien.mp3");
        
        for(int i = 0 ; i <= time/10000 ; i++)
        {
            UFO ufo = new UFO();
            
            switch(Greenfoot.getRandomNumber(3))
            {
                case 0:
                {
                    getWorld().addObject(ufo, Greenfoot.getRandomNumber(getWorld().getWidth() - 1), 0);
                    
                    break;
                }
                
                case 1:
                {
                    getWorld().addObject(ufo, 0, Greenfoot.getRandomNumber(getWorld().getHeight() - 1));
                    
                    break;
                }
                
                case 2:
                {
                    getWorld().addObject(ufo, Greenfoot.getRandomNumber(getWorld().getWidth() - 1), getWorld().getHeight() - 1);
                    
                    break;
                }
                
                case 3:
                {
                    getWorld().addObject(ufo, getWorld().getHeight() - 1, Greenfoot.getRandomNumber(getWorld().getHeight() - 1));
                    
                    break;
                }
            }
        }
    
        return;
    }
    
    private void shoot()
    {
       Projectile projectile = new Projectile();
       
       getWorld().addObject(projectile, getX(), getY());
       projectile.rotate(rotation);
       
       Greenfoot.playSound("shoot.mp3");
    
       return;
    }
    
    private void lose()
    {
        health = 0;
        
        health_bar.changeImage(health);
        
        music.stop();
        
        Greenfoot.playSound("game_over.mp3");
        
        Game_Over_Logo end = new Game_Over_Logo();
        getWorld().addObject(end, 500, 400);
        
        getWorld().showText("Your score: " + score, 500, 600);
        
        for(int i = 5 ; i > 0 ; i--)
        {
            getWorld().showText("Exiting in " + i, 500, 700);
            
            Greenfoot.delay(70);
        }
        
        Greenfoot.setWorld(new Main_Menu());
        
        return;
    }
    
    public void act() 
    {
        if(flag == 0)
        {
            turn(-90);
            
            for(int i = 3 ; i > 0 ; i--)
            {
                Greenfoot.playSound("beep.mp3");
                
                getWorld().showText("" + i, 500, 250);
                Greenfoot.delay(70);
            }
            
            Greenfoot.playSound("whistle.mp3");
            
            getWorld().showText("GO!", 500, 250);
            Greenfoot.delay(70);
            
            getWorld().showText("", 500, 250);
            
            getWorld().addObject(health_bar, 150, 50);
            getWorld().addObject(fuel_bar, 950, 80);
            
            flag = 1;
        }
        
        display_stats();
        
        shoot_delay++;
        time++;
        
        music.playLoop();
        
        if(Greenfoot.isKeyDown("w"))
        {
            move(speed + 2);
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            move(speed - 2);
        }
        else
        {
            move(speed);
        }
        
        if(Greenfoot.isKeyDown("a"))
        {
            turn(-4);
            rotation = rotation - 4;
        }
        
        if(Greenfoot.isKeyDown("d"))
        {
            turn(4);
            rotation = rotation + 4;
        }
        
        if(shooting == 1 && (Greenfoot.mouseDragEnded(null) || Greenfoot.mouseClicked(null)))
        {
            shooting = 0;
        }
        
        if(Greenfoot.mousePressed(null) && shooting == 0)
        {
            shooting = 1;
        }
        
        if(shooting == 1 && shoot_delay > 20)
        {
            shoot();
            shoot_delay = 0;
        }
        
        if(fuel_duration < 200 && using_fuel == 1)
        {
            fuel_duration++;
        }
        else if(using_fuel == 1)
        {
            speed = speed - 4;
            using_fuel = 0;
        }
        
        if(Greenfoot.isKeyDown("space") && fuel_count > 0 && fuel_duration == 200)
        {
            Greenfoot.playSound("boost.mp3");
            
            fuel_duration = 0;
            using_fuel = 1;
            speed = speed + 4;
            
            fuel_count--;
            fuel_bar.changeImage(fuel_count);
        }
            
        if(time % 200 == 0)
        {
            spawn_star();
        }
        
        if(time % 1000 == 0)
        {
            spawn_fuel();
        }
        
        if(time % 300 == 0)
        {
            spawn_asteroid();
        }
        
        if(time % 5000 == 0)
        {
            spawn_UFO();
        }
        
        if(isTouching(Star.class))
        {
            Greenfoot.playSound("star_shine.mp3");
            
            score = score + 100;
            
            Actor actor = getOneIntersectingObject(Actor.class);
            
            if(actor != null)
            {
                getWorld().removeObject(actor);
            }
        }
        
        if(isTouching(Fuel.class) && fuel_count < 4)
        {
            Greenfoot.playSound("fuel_splash.mp3");
            
            fuel_count++;
            fuel_bar.changeImage(fuel_count);
            
            Actor actor = getOneIntersectingObject(Actor.class);
            
            if(actor != null)
            {
                getWorld().removeObject(actor);
            }
        }
        
        if(immunity_duration < 200 && recently_hit == 1)
        {
            immunity_duration++;
            
            setImage(immune);
        }
        else
        {
            immunity_duration = 0;
            recently_hit = 0;
            
            setImage(usual);
        }
        
        if(isTouching(Asteroid.class) || isTouching(Goo.class))
        {
            if(isTouching(Asteroid.class))
            {
                Greenfoot.playSound("asteroid_break.mp3");
            }
            else
            {
                Greenfoot.playSound("goo.mp3");
            }
            
            Actor actor = getOneIntersectingObject(Actor.class);
            
            if(actor != null)
            {
                getWorld().removeObject(actor);
            }
            
            if(recently_hit == 0)
            {
                if(health > 1)
                {
                    health--;
                    
                    health_bar.changeImage(health);
                    
                    recently_hit = 1;
                }
                else
                {
                    lose();
                    
                    return;
                }
            }
            
        }
        
        if(isTouching(UFO.class))
        {
            lose();
            
            return;
        }
    }    
}
