package AI;

import dataRecording.DataTuple;
import pacman.game.Constants;

public class DataPoint
{
    GhostDirAttribute ghostDirection[];
    IsGhostWeakAttribute ghostWeak[];
    ClosestGhostAttribute closestGhost;

    public int attributeData[];
    private int index;

    public Constants.MOVE lable;

    public DataPoint(DataTuple data)
    {
        closestGhost = new ClosestGhostAttribute();
        ghostWeak = new IsGhostWeakAttribute[4];
        ghostDirection = new GhostDirAttribute[4];
        attributeData = new int[9];

        index =0;

        for(int i=0;i<4;i++)
        {
            ghostWeak[i] = new IsGhostWeakAttribute(i);
            ghostDirection[i] = new GhostDirAttribute(i);

        }

        attributeData[index]= closestGhost.ExecuteClassification(data);
        index++;

        for(int i=0;i<4;i++)
        {
            attributeData[index] = ghostWeak[i].ExecuteClassification(data);
            index++;
        }

        for(int i=0;i<4;i++)
        {
            attributeData[index] = ghostDirection[i].ExecuteClassification(data);
            index++;
        }

        lable = data.DirectionChosen;
    }
    public void Print()
    {   System.out.println("_______________DataPoint_______________");
        System.out.println("MOVE: "+lable);
        System.out.println("Closest Ghost: " + attributeData[0]);
        System.out.println("InkyWeak: " + attributeData[1]+ " BlinkyWeak: " + attributeData[2]+ " PinkyWeak: " + attributeData[3]+ " SueWeak: " + attributeData[4]);
        System.out.println("InkyDir: " + attributeData[5]+ " BinkyDir: " + attributeData[6]+ " PinkyDir: " + attributeData[7]+ " SueDir: " + attributeData[8]);
        System.out.println("_______________EndOfDataPoint_______________");
    }
}
