import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Avatar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Avatar extends Actor
{
    //Instance variables
    private int health = 3;
    private int hitDelay = 0;
    
    /**
     * Act - do whatever the Avatar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followMouse();
        checkForCollisions();
    }    
    
    private void followMouse() {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if(mi != null) {
            setLocation(mi.getX(), mi.getY());
        }
    }
    
    public int getHealth() {
        return health;
    }
    
    private void checkForCollisions() {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if(hitDelay == 0 && enemy != null) {
            //System.out.println("My health is " + health);
            switch(health){
                case 3:
                    setImage("skull1.png");
                    break;
                case 2:
                    setImage("skull2.png");
                    break;
                case 1:
                    setImage("skull3.png");
                    break;
                default: //The only other option would be if they have 0 health. Then it's game over!
                    AvoiderWorld world = (AvoiderWorld) getWorld();
                    world.endGame();
                    break;
            }
            health--;
            hitDelay = 50;
            AvoiderWorld world = (AvoiderWorld) getWorld();
            world.updateHealthCounter();
        }
        if(hitDelay > 0) {
            hitDelay--;
        }
    }
    
}
