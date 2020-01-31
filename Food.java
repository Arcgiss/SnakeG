package as;

import java.awt.*;

public class Food {
    private Rect background;
    private Snake snake;
    private int width, height;
    private Color color;
public GameRules gm;
    private Rect rect;
    private int xPadding;
    boolean isSpanwed=false;

    public Food(Rect background, Snake snake, int width, int height, Color color) {
        this.background = background;
        this.snake =  snake;
        this.width = width;
        this.height = height;
        this.color = color;
        this.gm=new GameRules();

        this.rect = new Rect(0, 0, width, height);
        xPadding= (int)((Constants.Tile_Width - this.width)/2.0);

    }

    public boolean IsSpanwed() {
        return isSpanwed;
    }
    public void setIsSpanwed(boolean isSpanwed) {
        this.isSpanwed = isSpanwed;
    }
    public void multiply(){
        do {
            double randX=(int)(Math.random()*(int)(background.width/Constants.Tile_Width))*Constants.Tile_Width+background.x;
            double randY=(int)(Math.random()*(int)(background.height/Constants.Tile_Width))*Constants.Tile_Width+background.y;
            this.rect.x=randX;
            this.rect.y=randY;
        }while(gm.collideFood(this.rect));
        this.isSpanwed=true;

    }
    public void update(double dt){
        if(gm.collideFood(this.rect))
        {
            gm.grow();
            this.rect.x=-100;
            this.rect.y=-100;
            isSpanwed=false;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect((int)this.rect.x+xPadding,(int)this.rect.y+xPadding, width, height);
    }
}
