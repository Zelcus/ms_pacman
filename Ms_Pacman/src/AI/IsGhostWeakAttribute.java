package AI;

import dataRecording.DataTuple;
import javafx.scene.Node;
import pacman.game.Game;
import pacman.game.Constants.*;

public class IsGhostWeakAttribute extends  Attribute
{
    int ghostToCheck;

    public IsGhostWeakAttribute(int GhostToCheck)
    {
        ghostToCheck = GhostToCheck;

        //Yes =0, No = 1
        amountOfValues = 2;
    }
    @Override
    public int ExecuteAttribute(Game game)
    {

        int returnValue =-1;
        if(ghostToCheck ==0)
        {
            if(game.isGhostEdible(GHOST.INKY))
                returnValue =0;
            else
            {
                returnValue = 1;
            }
        }
        else if(ghostToCheck ==1)
        {
            if(game.isGhostEdible(GHOST.BLINKY))
                returnValue = 0;
            else
            {
                returnValue = 1;
            }
        }
        else if(ghostToCheck ==2)
        {
            if(game.isGhostEdible(GHOST.PINKY))
                returnValue = 0;
            else
            {
                returnValue = 1;
            }
        }
        else if(ghostToCheck ==3)
        {
            if(game.isGhostEdible(GHOST.SUE))
                returnValue = 0;
            else
            {
                returnValue = 1;
            }
        }

        return returnValue;
    }

    @Override
    public int ExecuteClassification(DataTuple tuple) {

        int returnValue =-1;
        if(ghostToCheck ==0)
        {
            if(tuple.isInkyEdible)
                returnValue =0;
            else
            {
                returnValue = 1;
            }
        }
        else if(ghostToCheck ==1)
        {
            if(tuple.isBlinkyEdible)
                returnValue = 0;
            else
            {
                returnValue = 1;
            }
        }
        else if(ghostToCheck ==2)
        {
            if(tuple.isPinkyEdible)
                returnValue = 0;
            else
            {
                returnValue = 1;
            }
        }
        else if(ghostToCheck ==3)
        {
            if(tuple.isSueEdible)
                returnValue = 0;
            else
            {
                returnValue = 1;
            }
        }

        return returnValue;
    }

}
