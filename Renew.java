/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as;

/**
 *
 * @author PC
 */
public class Renew extends Snake {
    public GameRules gm= new GameRules();
       
    public void update(double dt) {
        if (waitTimeLeft > 0) {
            waitTimeLeft -= dt;
            return;
        }
        if (gm.collideWithSelf())
        {
            Window.getWindow().changeState(0);
            isDead=true;
        }
        waitTimeLeft = ogWaitBetweenUpdates;
        double newX = 0;
        double newY = 0;
        if (direction == Direction.RIGHT) {
            newX = body[head].x + bodyWidth;
            newY = body[head].y;
        } else if (direction == Direction.LEFT) {
            newX = body[head].x - bodyWidth;
            newY = body[head].y;
        } else if (direction == Direction.UP) {
            newX = body[head].x;
            newY = body[head].y - bodyHeight;
        } else if (direction == Direction.DOWN) {
            newX = body[head].x;
            newY = body[head].y + bodyHeight;
        }
        body[(head + 1) % body.length] = body[tail];
        body[tail] = null;
        head = (head + 1) % body.length;
        tail = (tail + 1) % body.length;
        body[head].x = newX;
        body[head].y = newY;
    }
}
