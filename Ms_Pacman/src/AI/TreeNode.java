package AI;

import javafx.scene.Node;
import pacman.game.Game;
import pacman.game.Constants.*;

public class TreeNode
{
    Attribute attribute;
    public TreeNode children[];
    private  int currentIndex =0;
    public MOVE move;

    public TreeNode(Attribute _attribute)
    {
        attribute = _attribute;
        if(attribute !=null)
        {
            children = new TreeNode[attribute.amountOfValues];
        }

    }
    public void AddChild(TreeNode child)
    {
        children[currentIndex] = child;
        currentIndex++;
    }
    public MOVE Execute(Game game)
    {
        if(attribute !=null)
        {
            return children[attribute.ExecuteAttribute(game)].Execute(game);
        }
        else
        {
            System.out.println(move);
            return move;
        }
    }

}
