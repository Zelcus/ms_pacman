package AI;

import pacman.game.Constants;

import java.util.ArrayList;

public class Node
{
    public Constants.MOVE move;
    public int attribute;
    public int numberOfChildren;
    public ArrayList<Node> children;


    public Node()
    {
        children = new ArrayList<>();
        numberOfChildren =0;
    }

    public void AddChild(Node node)
    {
        children.add(node);
        numberOfChildren++;
    }

    public void PrintAll()
    {
        System.out.println("I am attribute " + attribute);
        System.out.println("I have move " + move);

        for(int i=0;i<numberOfChildren;i++)
            children.get(i).PrintAll();
    }

}
