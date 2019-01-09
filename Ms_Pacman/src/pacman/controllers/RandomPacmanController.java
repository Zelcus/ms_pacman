package pacman.controllers;

import pacman.game.Constants;
import pacman.game.Game;

import java.awt.event.KeyEvent;
import java.util.Random;

public class RandomPacmanController extends Controller<Constants.MOVE>
{
    Random rand;

    public RandomPacmanController()
    {
         rand = new Random();
    }


    public Constants.MOVE getMove(Game game, long dueTime)
    {
       int r = rand.nextInt(4)+1;

       if(r ==1)
           return  Constants.MOVE.RIGHT;
       else if( r== 2)
           return  Constants.MOVE.LEFT;
       else if( r== 3)
           return  Constants.MOVE.UP;
       else if( r== 4)
           return  Constants.MOVE.DOWN;

       return  Constants.MOVE.NEUTRAL;

    }
}
