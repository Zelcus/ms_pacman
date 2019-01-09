package AI;

import dataRecording.DataTuple;
import pacman.game.Constants.MOVE;

public class DataPoint
{

    public enum isGhostWeak
    {
        Far,Semi,Close,Low,Medium,High;
    }
    public enum powerPills
    {
       None,Some,Many;
    }
    public enum closestGhost
    {
        Blinky,Inky,Pinky,Sue;
    }


    //Attribute 1-4
    public  isGhostWeak Blinky,Inky,Pinky,Sue;
    //Attribute 5
    public  powerPills Pills;
    //Attribute 6
    public  closestGhost closestG;

    public int possibleAttributeValues[];

    private  int close, medium,far;

    public MOVE move;

    public DataPoint(DataTuple Tuple)
    {
        close = 10;
        medium = 20;
        far = 30;

        InitAttributeValues();
        ProcessGhost(Tuple);
        ProcessPowerPills(Tuple);
        move = Tuple.DirectionChosen;


    }
    private  void InitAttributeValues()
    {
        possibleAttributeValues = new int[6];

        //IsGhostWeak
        possibleAttributeValues[0] = 6;
        possibleAttributeValues[1] = 6;
        possibleAttributeValues[2] = 6;
        possibleAttributeValues[3] = 6;

        //powerPills
        possibleAttributeValues[0] = 3;
        //ClosestGhost
        possibleAttributeValues[0] = 4;

    }

    private void ProcessGhost(DataTuple Tuple)
    {
        closestG = closestGhost.Blinky;
        int closest = Tuple.blinkyDist;
        if(Tuple.pinkyDist <closest)
        {
            closest = Tuple.pinkyDist;
            closestG = closestGhost.Pinky;
        }
        if(Tuple.inkyDist <closest)
        {
            closest = Tuple.inkyDist;
            closestG = closestGhost.Inky;
        }
        if(Tuple.sueDist <closest)
        {
            closest = Tuple.sueDist;
            closestG = closestGhost.Sue;
        }

        if(Tuple.isBlinkyEdible)
        {
            if(Tuple.blinkyDist <close)
                Blinky = isGhostWeak.High;
            else if(Tuple.blinkyDist < medium)
            {
                Blinky = isGhostWeak.Medium;
            }
            else {
                Blinky = isGhostWeak.Low;
            }
        }
        else
        {
            if(Tuple.blinkyDist <close)
                Blinky = isGhostWeak.Close;
            else if(Tuple.blinkyDist < medium)
            {
                Blinky = isGhostWeak.Semi;
            }
            else {
                Blinky = isGhostWeak.Far;
            }
        }
        if(Tuple.isInkyEdible)
        {
            if(Tuple.inkyDist <close)
                Inky = isGhostWeak.High;
            else if(Tuple.blinkyDist < medium)
            {
                Inky = isGhostWeak.Medium;
            }
            else
            {
                Inky = isGhostWeak.Low;
            }
        }
        else
        {
            if(Tuple.inkyDist <close)
                Inky = isGhostWeak.Close;
            else if(Tuple.blinkyDist < medium)
            {
                Inky = isGhostWeak.Semi;
            }
            else
            {
                Inky = isGhostWeak.Far;
            }
        }
        if(Tuple.isPinkyEdible)
        {
            if(Tuple.pinkyDist <close)
                Pinky = isGhostWeak.High;
            else if(Tuple.blinkyDist < medium)
            {
                Pinky = isGhostWeak.Medium;
            }
            else
            {
                Pinky = isGhostWeak.Low;
            }
        }
        else
        {
            if(Tuple.pinkyDist <close)
                Pinky = isGhostWeak.Close;
            else if(Tuple.blinkyDist < medium)
            {
                Pinky = isGhostWeak.Semi;
            }
            else
            {
                Pinky = isGhostWeak.Far;
            }
        }
        if(Tuple.isSueEdible) {
            if (Tuple.sueDist < close)
                Sue = isGhostWeak.High;
            else if (Tuple.blinkyDist < medium) {
                Sue = isGhostWeak.Medium;
            } else {
                Sue = isGhostWeak.Low;
            }
        }
        else
        {
            if (Tuple.sueDist < close)
                Sue = isGhostWeak.Close;
            else if (Tuple.blinkyDist < medium) {
                Sue = isGhostWeak.Semi;
            } else {
                Sue = isGhostWeak.Far;
            }
        }
    }
    private void ProcessPowerPills(DataTuple Tuple)
    {
        if(Tuple.numOfPowerPillsLeft > Tuple.numberOfTotalPowerPillsInLevel/2)
            Pills = powerPills.Many;
        else if(Tuple.numOfPowerPillsLeft > 0)
            Pills = powerPills.Some;
        else
            Pills = powerPills.None;
    }

    public boolean CheckAttribute(int i,int j)
    {
        if(i ==0)
        {
            if(Blinky == isGhostWeak.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }
        else if(i ==1)
        {
            if(Inky == isGhostWeak.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }
        else if(i ==2)
        {
            if(Pinky == isGhostWeak.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }
        else  if(i ==3)
        {
            if(Sue == isGhostWeak.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }
        else if(i ==4)
        {
            if(Pills == powerPills.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }
        else if(i ==5)
        {
            if(closestG == closestGhost.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }

        return  false;
    }


}
