package test;

import as.Direction;
import as.Rect;
import as.*;
import com.company.*;
import java.awt.Color;
import javafx.geometry.Point2D;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class SnakeTest {



    @Test
    public void testSnakeMoves() {
        Snake snake = new Snake(10, 48, 48 + 24, 24, 24, background);

        for (Direction direction : Direction.values()) {
            ;

            snake.setDirection(Direction.RIGHT);

            snake.update(dt);

           assertThat(snake.getPosition(), (new snake.head(1,0)));
        }
    }

    @Test
    public void testSnakeFoodCollision() {
        Snake snake = new Snake(10, 48, 48 + 24, 24, 24, background)

        Food food = new Food(foreground, snake, 12, 12, Color.GREEN);

        assertTrue(snake.CollideWith(food));
    }

    @Test
    public void testSnakeGrows() {
        Snake snake = new Snake(10, 48, 48 + 24, 24, 24, background);

        snake.setDirection(Direction.RIGHT);
        snake.update();
        snake.grow();

        assertThat(snake.getLength(), is(2));
        assertThat(snake.getBody(), hasItem(new Point2D(0, 0)));
    }

    @Test
    public void testSnakeOutOfBounds() {
        Snake snake = new Snake(10, 48, 48 + 24, 24, 24, background);

        assertTrue(snake.outOfBounds(Rect head));
        assertFalse(snake.outOfBounds(Rect head));
    }

    @Test
    public void testSnakeDies() {
        Snake snake = new Snake(10, 48, 48 + 24, 24, 24, background);

        for (int i = 0; i < 5; i++) {
            snake.setDirection(Direction.RIGHT);
            snake.update(dt);
            snake.grow();
        }

        snake.setDirection(Direction.UP);
        snake.update(dt);

        snake.setDirection(Direction.LEFT);
        snake.update(dt);

        snake.setDirection(Direction.DOWN);
        snake.update(dt);

        assertTrue(snake.isDead());
    }

    @Test
    public void testHeadIsInFront() {
       
      Snake snake = new Snake(10, 48, 48 + 24, 24, 24, background);

        snake.setDirection(Direction.RIGHT);
        snake.update(dt);
        snake.grow();

        snake.update(dt);

       assertThat(snake.body, (snake.getPosition()));
    }
}
