package chessgui.pieces;

import chessgui.Board;

public class Knight extends Piece {

    public Knight(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        // A knight can move in any L shape and can jump over anyone
        // in order to do so. He cannot attack his own pieces.
 
        Piece potentialPiece = board.getPiece(destination_x, destination_y);

        // If there is a piece there
        if (potentialPiece != null) {

            // Are they both white?
            if (potentialPiece.isWhite() && this.isWhite()) {
                return false;
            }
            // Are they both black?
            if (potentialPiece.isBlack() && this.isBlack()) {
                return false;
            }
        }

        //  * *             *
        //  *               *
        //  *               * *
        // Checking for these moves
        if (Math.abs(destination_y - this.getY()) == 2 && Math.abs(destination_x - this.getX()) == 1) {
            return true;
        }

        //       * * *           *       
        //           *       * * *       
        // Checking for these moves
        if (Math.abs(destination_y - this.getY()) == 1 && Math.abs(destination_x - this.getX()) == 2) {
            return true;
        }

        return false;
    }
}
