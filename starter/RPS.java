import java.util.Scanner;

public class RPS extends RPSAbstract {
    // Messages for the game.
    protected static final String GAME_NOT_IMPLEMENTED =
            "Game not yet implemented.";

    /**
     * Construct a new instance of RPS with the given possible moves.
     * @param moves all possible moves in the game.
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }


    public int determineWinner(String playerMove, String cpuMove) {
        // TODO
        int playerInt = 0, cpuInt = 0;

        //Looks for move validity right away. If not valid, return -1 and exit
        if(!isValidMove(playerMove)){
            return RPS.INVALID_INPUT_OUTCOME;
        }

        //Record game number
        playerMoves[numGames] = playerMove;
        cpuMoves[numGames] = cpuMove;
        numGames++;
    
        for(int i = 0; i < this.possibleMoves.length; i++){
            if(playerMove.equals(this.possibleMoves[i]))
                playerInt = i;
            if(cpuMove.equals(this.possibleMoves[i]))
                cpuInt = i;
        }
        
        //Same move, then tie
        if(playerInt == cpuInt)
            return RPS.TIE_OUTCOME;

        //DEFAULT_MOVES = {"scissors", "paper", "rock"}
        //In order to win, player - cpu has to be -1 and 2 (scissor beats paper, paper beats rock, rock beats scissors)
        //To lose, player - cpu can be anything else
        if(playerInt - cpuInt == -1 || playerInt - cpuInt == 2){
            return RPS.PLAYER_WIN_OUTCOME;
        } else{
            return RPS.CPU_WIN_OUTCOME;
        }    
    }

    public static void main(String[] args) {
        //Create scanner
        Scanner in = new Scanner(System.in);
        String input = "";

        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            for (int i = 0; i < args.length; i++) {
                moves[i] = args[i];
            }
        } else {
            moves = RPS.DEFAULT_MOVES;
        }

        // Create new game
        RPS game = new RPS(moves);

        // TODO: Insert the code to play the game. 
        // See the writeup for an example of the game play.
        // Hint: call the methods we/you have already written 
        // to do most of the work! And don't forget Javadoc.

        //Starting message and takes line input
     
        //While loop that runs while user input is not "q"
        while(!input.equals(RPS.QUIT)){
            System.out.println(RPS.PROMPT_MOVE);
            input = in.nextLine();
            game.playRPS(input, game.genCPUMove());
        }
        
        game.displayStats();
        in.close();
    }
}
