package as;

public class GameRules extends Snake {
        public boolean collideWithSelf() {
        Rect headR= body[head];
        return collideFood(headR)||outOfBounds(headR);
    }

    public boolean outOfBounds(Rect head){
        return (head.x<background.x||(head.x+head.width)>=background.x+background.width||
                head.y<background.y||(head.y+head.height)>=background.y+background.height);

    }

    public  boolean collideFood(Rect rect){
        for (int i = tail; i != head; i = (i + 1) % body.length) {
            if (colide((rect), body[i]))
            {
                return true;
            }
        }
        return false;
    }

    public boolean colide(Rect r1, Rect r2)
    {
        return (r1.x>=r2.x && r1.x+r1.width <=r2.x +r2.width&&
                r1.y>=r2.y && r1.y+r1.height<=r2.y+r2.height);

    }
    public void grow()
    {
        double newX=0;
        double newY=0;
        if (direction == Direction.RIGHT) {
            newX = body[tail].x - bodyWidth;
            newY = body[tail].y;
        } else if (direction == Direction.LEFT) {
            newX = body[tail].x + bodyWidth;
            newY = body[tail].y;
        } else if (direction == Direction.UP) {
            newX = body[tail].x;
            newY = body[tail].y + bodyHeight;
        } else if (direction == Direction.DOWN) {
            newX = body[tail].x;
            newY = body[tail].y - bodyHeight;
        }
        Rect newBodyPiece = new Rect(newX, newY,bodyWidth, bodyHeight);
        tail = (tail-1)%body.length;
        body[tail] = newBodyPiece;


    }
    
}
