package pacman.entries.pacman;

import jdk.nashorn.api.tree.Tree;
import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import pacman.game.internal.Node;

import AI.*;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */
public class MTreePacMan extends Controller<MOVE>
{
    private MOVE myMove=MOVE.NEUTRAL;

    TreeNode RootNode;
    public MTreePacMan()
    {
        TreeNode[] isGhostWeakNodes = new TreeNode[4];
        TreeNode[] GhostDirAttribute = new TreeNode[2];
        TreeNode[] LeafNodes = new TreeNode[4];

        RootNode = new TreeNode(new ClosestGhostAttribute());

        LeafNodes[0] = new TreeNode(null);
        LeafNodes[0].move = MOVE.LEFT;
        LeafNodes[1] = new TreeNode(null);
        LeafNodes[1].move = MOVE.RIGHT;
        LeafNodes[2] = new TreeNode(null);
        LeafNodes[2].move = MOVE.UP;
        LeafNodes[3] = new TreeNode(null);
        LeafNodes[3].move = MOVE.DOWN;

        isGhostWeakNodes[0] = new TreeNode(new IsGhostWeakAttribute(0));
        isGhostWeakNodes[1] = new TreeNode(new IsGhostWeakAttribute(1));
        isGhostWeakNodes[2] = new TreeNode(new IsGhostWeakAttribute(2));
        isGhostWeakNodes[3] = new TreeNode(new IsGhostWeakAttribute(3));

        GhostDirAttribute[0] = new TreeNode(new GhostDirAttribute(0));
        GhostDirAttribute[1] = new TreeNode(new GhostDirAttribute(1));


        for(int j=0;j<2;j++) {
            for (int i = 0; i < 4; i++) {
                GhostDirAttribute[j].AddChild(LeafNodes[i]);
            }
        }

        for(int j=0;j<4;j++) {
            for (int i = 0; i < 2; i++) {
                isGhostWeakNodes[j].AddChild(GhostDirAttribute[i]);
            }
        }

        RootNode.AddChild(isGhostWeakNodes[0]);
        RootNode.AddChild(isGhostWeakNodes[1]);
        RootNode.AddChild(isGhostWeakNodes[2]);
        RootNode.AddChild(isGhostWeakNodes[3]);

    }

    public MOVE getMove(Game game, long timeDue)
    {
        //Place your game logic here to play the game as Ms Pac-Man
       return RootNode.Execute(game);
    }
}