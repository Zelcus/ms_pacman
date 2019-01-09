package AI;

import dataRecording.DataSaverLoader;
import dataRecording.DataTuple;
import pacman.game.Constants;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeBuilder
{
    DataPoint dataPoint[];
    ArrayList<DataPoint> data;
    boolean attributeList[];

    int numOfDataPoints;
    int numOfAttributes;
    int selectedAttribute;

    Node Root;

    public  TreeBuilder()
    {
        numOfAttributes =6;
        attributeList = new  boolean[numOfAttributes];
        data = new ArrayList<>();

        ConvertToDataPoint();
        Root = BuildTree(data);

        Root.PrintAll();

    }
    private  Node BuildTree(ArrayList<DataPoint> data)
    {
        Node N = new Node();

        int numOfLeft =0;
        int numOfRight =0;
        int numOfUp =0;
        int numOfDown =0;

        int majority =0;
        Constants.MOVE majorityMove = Constants.MOVE.LEFT;

        double entropy =0;

        for (int i=0;i<data.size();i++)
        {
            if(data.get(i).move == Constants.MOVE.LEFT)
                numOfLeft++;
            else if(data.get(i).move == Constants.MOVE.RIGHT)
                numOfRight++;
            else if(data.get(i).move == Constants.MOVE.UP)
                numOfUp++;
            else if(data.get(i).move == Constants.MOVE.DOWN)
                numOfDown++;
        }

        majority = numOfLeft;

        if(numOfRight >majority)
        {
            majorityMove = Constants.MOVE.RIGHT;
            majority = numOfRight;
        }
        if(numOfUp > majority)
        {
            majorityMove = Constants.MOVE.UP;
            majority = numOfUp;
        }
        if(numOfDown > majority)
        {
            majorityMove = Constants.MOVE.DOWN;
            majority = numOfDown;
        }


        if(numOfLeft == data.size()) {
            N.move = Constants.MOVE.LEFT;
            return N;
        }
        if(numOfRight == data.size()) {
            N.move = Constants.MOVE.RIGHT;
            return N;
        }
        if(numOfUp == data.size()) {
            N.move = Constants.MOVE.UP;
            return N;
        }
        if(numOfDown == data.size()) {
            N.move = Constants.MOVE.DOWN;
            return N;
        }

        if(attributeList[0]&&attributeList[1]&&attributeList[2]&&attributeList[3]&&attributeList[4]&&attributeList[5]) {
            N.move =majorityMove;
            return N;
        }

        int selectedAttribute = CalculateGain(data);

        N.attribute = selectedAttribute;
        attributeList[selectedAttribute] = true;


        for(int i=0;i<dataPoint[i].possibleAttributeValues[selectedAttribute];i++)
        {
            ArrayList<DataPoint> subset = new ArrayList<DataPoint>();

            for(int j=0;j <numOfDataPoints;j++)
            {
                if(dataPoint[j].CheckAttribute(selectedAttribute,i))
                    subset.add(dataPoint[j]);
            }

            if(subset.size() ==0)
            {
                Node tempNode = new Node();
                tempNode.move = majorityMove;
                N.AddChild(tempNode);
            }
            else
            {
                N.AddChild(BuildTree(subset));
            }
        }


        System.out.println("Attribute: " +N.attribute);
        System.out.println("Children: " +N.attribute);
        N.PrintAll();
        return  N;
    }

    private void ConvertToDataPoint()
    {
        DataTuple tuples[];
        tuples = DataSaverLoader.LoadPacManData();
        dataPoint = new DataPoint[tuples.length];

        for(int i=0;i<tuples.length;i++) {

            dataPoint[i] = new DataPoint(tuples[i]);
            data.add(dataPoint[i]);
            numOfDataPoints++;
        }
    }

    private int CalculateGain(ArrayList<DataPoint> data)
    {
        Random rand = new Random();
        int temp = rand.nextInt(6) + 1;
        while (attributeList[temp-1])
        {
            if(attributeList[0]&&attributeList[1]&&attributeList[2]&&attributeList[3]&&attributeList[4]&&attributeList[5])
            {
                return -1;
            }
            temp = rand.nextInt(6) + 1;
        }

        return  temp-1;
    }
    private  void  SelectAttribute(int selectedAttribute)
    {
        ArrayList<DataPoint> subset = new ArrayList<DataPoint>();

        for(int i=0;i <numOfDataPoints;i++)
        {
                subset.add(dataPoint[i]);
        }

        for(int j=0;j<dataPoint[0].possibleAttributeValues[selectedAttribute];j++)
        {

            for(int i=0;i <numOfDataPoints;i++)
            {
                if(dataPoint[i].CheckAttribute(selectedAttribute,j))
                    subset.add(dataPoint[i]);
            }
        }
    }


    private double CalculateEntropy(ArrayList<DataPoint> set)
    {
        int numOfLeft =0;
        int numOfRight =0;
        int numOfUp =0;
        int numOfDown =0;

        double entropy =0;

        for (int i=0;i<set.size();i++)
        {
            if(set.get(i).move == Constants.MOVE.LEFT)
                numOfLeft++;
            else if(set.get(i).move == Constants.MOVE.RIGHT)
                numOfRight++;
            else if(set.get(i).move == Constants.MOVE.UP)
                numOfUp++;
            else if(set.get(i).move == Constants.MOVE.DOWN)
                numOfDown++;
        }

        entropy = -numOfLeft*Math.log(2)*numOfLeft-numOfRight*Math.log(2)*numOfRight-numOfUp*Math.log(2)*numOfUp-numOfDown*Math.log(2)*numOfDown;

        return entropy;
    }

}
