package AI;
import dataRecording.DataTuple;
import javafx.scene.Node;
import pacman.game.Game;
import pacman.game.Constants.*;

public class ClosestGhostAttribute extends Attribute
{
    public  ClosestGhostAttribute()
    {
        //Inky = 0, Blinky = 1, Pinky = 2, Sue = 3
        amountOfValues = 4;

    }

    @Override
    public int ExecuteAttribute(Game game)
    {

        int closestG = Integer.MAX_VALUE;
        int returnValue =-1;

        int inkyDist = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.INKY));
        int blinkyDist = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.BLINKY));
        int pinkyDist = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.PINKY));
        int sueDist = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(GHOST.SUE));

        if(inkyDist<closestG)
        {
            closestG = inkyDist;
            returnValue =0;
        }
        else if(blinkyDist <closestG)
        {
            closestG = blinkyDist;
            returnValue = 1;

        }
        else if(pinkyDist <closestG)
        {
            closestG = pinkyDist;
            returnValue = 2;

        }
        else if(sueDist <closestG)
        {
            closestG = sueDist;
            returnValue =3;

        }
        return returnValue;
    }

    @Override
    public int ExecuteClassification(DataTuple tuple)
    {
        int closestG = Integer.MAX_VALUE;
        int returnValue =-1;

        int inkyDist = tuple.inkyDist;
        int blinkyDist = tuple.blinkyDist;
        int pinkyDist =tuple.pinkyDist;
        int sueDist = tuple.sueDist;

        if(inkyDist<closestG)
        {
            closestG = inkyDist;
            returnValue =0;
        }
        else if(blinkyDist <closestG)
        {
            closestG = blinkyDist;
            returnValue = 1;

        }
        else if(pinkyDist <closestG)
        {
            closestG = pinkyDist;
            returnValue = 2;

        }
        else if(sueDist <closestG)
        {
            closestG = sueDist;
            returnValue =3;

        }
        return returnValue;
    }
}
