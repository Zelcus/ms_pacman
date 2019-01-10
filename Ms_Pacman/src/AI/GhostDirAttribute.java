package AI;

import dataRecording.DataTuple;
import pacman.game.Constants;
import pacman.game.Game;

public class GhostDirAttribute extends Attribute {

    private int ghostToCheck;

    private Constants.MOVE blinkyDir;
    private Constants.MOVE inkyDir;
    private Constants.MOVE pinkyDir;
    private Constants.MOVE sueDir;

    public GhostDirAttribute(int GhostToCheck) {

        ghostToCheck = GhostToCheck;
        //Up =0,Down = 1,Left =2 , Right =3
        amountOfValues = 4;
    }

    @Override
    public int ExecuteAttribute(Game game) {

        System.out.println(ghostToCheck);
        int returnValue =-1;

        if (ghostToCheck ==0) {
            this.inkyDir = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(Constants.GHOST.INKY), Constants.DM.PATH);

                if (inkyDir == Constants.MOVE.UP)
                    returnValue =0;
                else if (inkyDir == Constants.MOVE.DOWN) {
                    returnValue =1;
                } else if (inkyDir == Constants.MOVE.LEFT) {
                    returnValue =2;
                } else if (inkyDir == Constants.MOVE.RIGHT) {
                    returnValue =3;
                }

        } else if (ghostToCheck==1) {
            this.blinkyDir = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(Constants.GHOST.BLINKY), Constants.DM.PATH);

            if (blinkyDir == Constants.MOVE.UP)
                returnValue =0;
            else if (blinkyDir == Constants.MOVE.DOWN) {
                returnValue =1;
            } else if (blinkyDir == Constants.MOVE.LEFT) {
                returnValue =2;
            } else if (blinkyDir == Constants.MOVE.RIGHT) {
                returnValue =3;
            }
        } else if (ghostToCheck==2) {
            this.pinkyDir = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(Constants.GHOST.PINKY), Constants.DM.PATH);

            if (pinkyDir == Constants.MOVE.UP)
                returnValue =0;
            else if (pinkyDir == Constants.MOVE.DOWN) {
                returnValue =1;
            } else if (pinkyDir == Constants.MOVE.LEFT) {
                returnValue =2;
            } else if (pinkyDir == Constants.MOVE.RIGHT) {
                returnValue =3;
            }
        } else if (ghostToCheck==3) {
            this.sueDir = game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(Constants.GHOST.SUE), Constants.DM.PATH);

            if (sueDir == Constants.MOVE.UP)
                returnValue =0;
            else if (sueDir == Constants.MOVE.DOWN) {
                returnValue =1;
            } else if (sueDir == Constants.MOVE.LEFT) {
                returnValue =2;
            } else if (sueDir == Constants.MOVE.RIGHT) {
                returnValue =3;
            }
        }

        return  returnValue;
    }

    @Override
    public int ExecuteClassification(DataTuple tuple) {
        System.out.println(ghostToCheck);
        int returnValue =-1;

        if (ghostToCheck ==0) {
            this.inkyDir = tuple.inkyDir;

            if (inkyDir == Constants.MOVE.UP)
                returnValue =0;
            else if (inkyDir == Constants.MOVE.DOWN) {
                returnValue =1;
            } else if (inkyDir == Constants.MOVE.LEFT) {
                returnValue =2;
            } else if (inkyDir == Constants.MOVE.RIGHT) {
                returnValue =3;
            }

        } else if (ghostToCheck==1) {
            this.blinkyDir = tuple.blinkyDir;

            if (blinkyDir == Constants.MOVE.UP)
                returnValue =0;
            else if (blinkyDir == Constants.MOVE.DOWN) {
                returnValue =1;
            } else if (blinkyDir == Constants.MOVE.LEFT) {
                returnValue =2;
            } else if (blinkyDir == Constants.MOVE.RIGHT) {
                returnValue =3;
            }
        } else if (ghostToCheck==2) {
            this.pinkyDir =tuple.pinkyDir;

            if (pinkyDir == Constants.MOVE.UP)
                returnValue =0;
            else if (pinkyDir == Constants.MOVE.DOWN) {
                returnValue =1;
            } else if (pinkyDir == Constants.MOVE.LEFT) {
                returnValue =2;
            } else if (pinkyDir == Constants.MOVE.RIGHT) {
                returnValue =3;
            }
        } else if (ghostToCheck==3) {
            this.sueDir = tuple.sueDir;

            if (sueDir == Constants.MOVE.UP)
                returnValue =0;
            else if (sueDir == Constants.MOVE.DOWN) {
                returnValue =1;
            } else if (sueDir == Constants.MOVE.LEFT) {
                returnValue =2;
            } else if (sueDir == Constants.MOVE.RIGHT) {
                returnValue =3;
            }
        }

        return  returnValue;
    }

}
