package chessgui.pieces;

import chessgui.Board;

public class Rook extends Piece {

    public Rook(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        // A rook can move as many squares as he wants either forward,
        // backward, or sideways without jumping any pieces. 
        
        // We check the square we want to move to and see if there is
        // a piec  0ccupying it. We then initialize a Piece object
        
        Piece potentialPiece = board.getPiece(destination_x, destination_y);
        
        // If there is a piece there
        if(potentialPiece != null){
            
            // Are they both white?
            if(potentialPiece.isWhite() && this.isWhite()) {
                return false;
            }
            // Are they both black?
            if(potentialPiece.isBlack() && this.isBlack()) {
                return false;
            }
        }
        
        // Check if rook is attempting to move in a straught line
        if (this.getX() != destination_x && this.getY() != destination_y) {
            
            return false;
        }
        
        String direction = "";
                
        if (destination_y > this.getY()) {
            direction = "south";
        }
        
        if (destination_y < this.getY()) {
            direction = "north";
        }
        
        if (destination_x > this.getX()) {
            direction = "east";
        }
        
        if (destination_x < this.getX()) {
            direction = "west";
        }
        
        // This checks if any piecces are blocking a given move
        switch (direction) {
            case "south":
                int spaces_to_move_down = Math.abs(destination_y - this.getY());
                for (int i = 1; i < spaces_to_move_down; i++) {
                    Piece p = board.getPiece(this.getX(), this.getY() + i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "north":
                int spaces_to_move_up = Math.abs(destination_y - this.getY());
                for (int i = 1; i < spaces_to_move_up; i++) {
                    Piece p = board.getPiece(this.getX(), this.getY() - i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "east":
                int spaces_to_move_right = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_right; i++) {
                    Piece p = board.getPiece(this.getX() + i, this.getY());
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "west":
                int spaces_to_move_left = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_left; i++) {
                    Piece p = board.getPiece(this.getX() - i, this.getY());
                    if (p != null) {
                        return false;
                    }
                }
                break;
        }
        
        return true;
    }
}
