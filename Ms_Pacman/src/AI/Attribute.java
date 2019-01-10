package AI;

import dataRecording.DataTuple;
import pacman.game.Game;
import pacman.game.Constants.*;

public abstract class Attribute
{
    public int amountOfValues;
    public abstract int ExecuteAttribute(Game game);
    public abstract int ExecuteClassification(DataTuple tuple);

}
