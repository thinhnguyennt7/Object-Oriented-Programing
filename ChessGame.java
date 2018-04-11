import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class ChessGame {
    private List<Move> moves;

    public Move getMove(int n) {
        return moves.get(n);
    }

    public List<Move> filter(Predicate<Move> filter) {
        List<Move> newMovesList = new ArrayList<Move>();
        for (int i = 0; i < moves.size(); i++) {
            if (filter.test(moves.get(i))) {
                newMovesList.add(moves.get(i));
            }
        }
        return newMovesList;
    }

    public List<Move> getMovesWithComment() {
        return filter(x -> x.getWhitePly().getComment().isPresent()
            || x.getBlackPly().getComment().isPresent());
    }

    public List<Move> getMovesWithoutComment() {
        return filter(new Predicate<Move>() {
            public boolean test(Move x) {
                return !(x.getWhitePly().getComment().isPresent())
                    && !(x.getBlackPly().getComment().isPresent());
            }
        });
    }

    //private inner class
    private class movesWithPiece implements Predicate<Move> {
        private Piece p;
        public movesWithPiece(Piece p) {
             this.p = p;
        }
        public boolean test(Move x) {
            return p.algebraicName()
               .equals(x.getWhitePly().getPiece().algebraicName())
               || p.algebraicName()
               .equals(x.getBlackPly().getPiece().algebraicName());
        }
    }


    public List<Move> getMovesWithPiece(Piece p) {
        //object input compare object we have in order to know input what kind of Piece is that?
        return filter(new movesWithPiece(p));
    }

    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

    public List<Move> getMoves() {
        return moves;
    }


}