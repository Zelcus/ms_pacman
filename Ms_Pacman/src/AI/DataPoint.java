package AI;

import dataRecording.DataTuple;
import pacman.game.Constants.MOVE;

public class DataPoint
{
    //Attribute 1-4
    public  AttributeList.isGhostWeak Blinky,Inky,Pinky,Sue;
    //Attribute 5
    public  AttributeList.powerPills Pills;
    //Attribute 6
    public  AttributeList.closestGhost closestG;

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
        closestG =  AttributeList.closestGhost.Blinky;
        int closest = Tuple.blinkyDist;

        if(Tuple.pinkyDist <closest)
        {
            closest = Tuple.pinkyDist;
            closestG =  AttributeList.closestGhost.Pinky;
        }
        if(Tuple.inkyDist <closest)
        {
            closest = Tuple.inkyDist;
            closestG =  AttributeList.closestGhost.Inky;
        }
        if(Tuple.sueDist <closest)
        {
            closest = Tuple.sueDist;
            closestG =  AttributeList.closestGhost.Sue;
        }

        if(Tuple.isBlinkyEdible)
        {
            if(Tuple.blinkyDist <close)
                Blinky = AttributeList.isGhostWeak.High;
            else if(Tuple.blinkyDist < medium)
            {
                Blinky = AttributeList.isGhostWeak.Medium;
            }
            else {
                Blinky = AttributeList.isGhostWeak.Low;
            }
        }
        else
        {
            if(Tuple.blinkyDist <close)
                Blinky = AttributeList.isGhostWeak.Close;
            else if(Tuple.blinkyDist < medium)
            {
                Blinky = AttributeList.isGhostWeak.Semi;
            }
            else {
                Blinky = AttributeList.isGhostWeak.Far;
            }
        }
        if(Tuple.isInkyEdible)
        {
            if(Tuple.inkyDist <close)
                Inky = AttributeList.isGhostWeak.High;
            else if(Tuple.blinkyDist < medium)
            {
                Inky = AttributeList.isGhostWeak.Medium;
            }
            else
            {
                Inky = AttributeList.isGhostWeak.Low;
            }
        }
        else
        {
            if(Tuple.inkyDist <close)
                Inky = AttributeList.isGhostWeak.Close;
            else if(Tuple.blinkyDist < medium)
            {
                Inky = AttributeList.isGhostWeak.Semi;
            }
            else
            {
                Inky = AttributeList.isGhostWeak.Far;
            }
        }
        if(Tuple.isPinkyEdible)
        {
            if(Tuple.pinkyDist <close)
                Pinky = AttributeList.isGhostWeak.High;
            else if(Tuple.blinkyDist < medium)
            {
                Pinky = AttributeList.isGhostWeak.Medium;
            }
            else
            {
                Pinky = AttributeList.isGhostWeak.Low;
            }
        }
        else
        {
            if(Tuple.pinkyDist <close)
                Pinky = AttributeList.isGhostWeak.Close;
            else if(Tuple.blinkyDist < medium)
            {
                Pinky = AttributeList.isGhostWeak.Semi;
            }
            else
            {
                Pinky = AttributeList.isGhostWeak.Far;
            }
        }
        if(Tuple.isSueEdible) {
            if (Tuple.sueDist < close)
                Sue = AttributeList.isGhostWeak.High;
            else if (Tuple.blinkyDist < medium) {
                Sue = AttributeList.isGhostWeak.Medium;
            } else {
                Sue = AttributeList.isGhostWeak.Low;
            }
        }
        else
        {
            if (Tuple.sueDist < close)
                Sue = AttributeList.isGhostWeak.Close;
            else if (Tuple.blinkyDist < medium) {
                Sue = AttributeList.isGhostWeak.Semi;
            } else {
                Sue = AttributeList.isGhostWeak.Far;
            }
        }
    }
    private void ProcessPowerPills(DataTuple Tuple)
    {
        if(Tuple.numOfPowerPillsLeft > Tuple.numberOfTotalPowerPillsInLevel/2)
            Pills = AttributeList.powerPills.Many;
        else if(Tuple.numOfPowerPillsLeft > 0)
            Pills = AttributeList.powerPills.Some;
        else
            Pills = AttributeList.powerPills.None;
    }

    public boolean CheckAttribute(int i,int j)
    {
        if(i ==0)
        {
            if(Blinky == AttributeList.isGhostWeak.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }
        else if(i ==1)
        {
            if(Inky == AttributeList.isGhostWeak.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }
        else if(i ==2)
        {
            if(Pinky == AttributeList.isGhostWeak.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }
        else  if(i ==3)
        {
            if(Sue == AttributeList.isGhostWeak.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }
        else if(i ==4)
        {
            if(Pills == AttributeList.powerPills.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }
        else if(i ==5)
        {
            if(closestG == AttributeList.closestGhost.values()[j])
            {
                return  true;
            }
            else
                return  false;
        }

        return  false;
    }


}
