import greenfoot.*;  

public class Snake extends Actor
{
    public Snake snake;
    public static int delta=10;
    public int arahx=1,arahy=0,posx=0,posy=0;
    public static boolean ADDEKOR=false;
    protected boolean SUDAHTAMBAH=false;
    
    public void addedToWorld(World Latar)
    {
        setGambar(delta);
        posx=getX();posy=getY();  
        SUDAHTAMBAH=false;
    }
    
    private void setGambar(int d)
    {
        GreenfootImage image=new GreenfootImage(d,d);
        image.setColor(Color.RED);
        image.fill();
        setImage(image);
    }
    
    public void addUlar()
    {
        if(SUDAHTAMBAH)return;
        Snake ularo=new Snake();
        ularo.snake=this;
        getWorld().addObject(ularo,getX(),getY());
        SUDAHTAMBAH=true;
        ADDEKOR=false;
    }
    
    public void act() 
    {
        if(((MyWorld)getWorld()).GAMEOVER)return;
        posx=getX();posy=getY();
        if(snake!=null){
            if((getX()==snake.posx && getY()==snake.posy)||(getX()==snake.getX() && getY()==snake.getY())){
            }else setLocation(snake.posx,snake.posy); 
        }else{
            int px=getX()+arahx*delta;
            int py=getY()+arahy*delta;
            if(px>getWorld().getWidth()+delta)px=-delta;
            if(px<-delta)px=getWorld().getWidth()+delta;
            if(py>getWorld().getHeight()+delta)py=-delta;
            if(py<-delta)py=getWorld().getHeight()+delta;
            setLocation(px,py);
        }     
        if(ADDEKOR)addUlar();  
    }    
}
