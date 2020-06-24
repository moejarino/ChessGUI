package chessgui.pieces;

import chessgui.Board;

public class Bishop extends Piece {

    public Bishop(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        // A bishop is allowed to move as many squares diagonally as it wants
        // without jumping over another piece.
        
        Piece potentialPiece = board.getPiece(destination_x, destination_y);
        
        // If there is a piece there
        if(potentialPiece != null) {
            
            // Are they both white?
            if(potentialPiece.isWhite() && this.isWhite()) {
                return false;
            }
            // Are they both black?
            if(potentialPiece.isBlack() && this.isBlack()) {
                return false;
            }
        }
        
        
        
        // Check if bishop is attempting to diagonally
        if (Math.abs(this.getY() - destination_y) !=  Math.abs(destination_x - this.getX())) {
            
            return false;
        }
        
        String direction = "";
        
        // y increasing, x decreasing
        if (destination_y > this.getY() && destination_x < this.getX()) {
            direction = "southwest";
        }
        
        if (destination_y > this.getY() && destination_x > this.getX()) {
            direction = "southeast";
        }
        
        // y decreasing, x decreasing
        if (destination_y < this.getY() && destination_x < this.getX()) {
            direction = "northwest";
        }
        
        // y decreasing, x increasing
        if (destination_y < this.getY() && destination_x > this.getX()) {
            direction = "northeast";
        }
        
        //Are there pieces in the way of making this move
        switch (direction) {
            case "southwest":
                int spaces_to_move_sw = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_sw; i++) {
                    Piece p = board.getPiece(this.getX() - i, this.getY() + i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "southeast":
                int spaces_to_move_se = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_se; i++) {
                    Piece p = board.getPiece(this.getX() + i, this.getY() + i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "northwest":
                int spaces_to_move_nw = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_nw; i++) {
                    Piece p = board.getPiece(this.getX() - i, this.getY() - i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "northeast":
                int spaces_to_move_ne = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_ne; i++) {
                    Piece p = board.getPiece(this.getX() + i, this.getY() - i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
        }
        
        
        return true;
    }
}
