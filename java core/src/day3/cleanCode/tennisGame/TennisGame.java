package day3.cleanCode.tennisGame;

public class TennisGame {
    static String PLAYER1_ADVANTAGE = "Advantage player1";
    static String PLAYER2_ADVANTAGE = "Advantage player2";
    static String PLAYER1_WIN = "Win for player1";
    static String PLAYER2_WIN = "Win for player2";
    static final int LOVE = 0;
    static final int FIFTEEN = 1;
    static final int THIRTY = 2;
    static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        boolean isDeuce = player1Score == player2Score;
        
        String score = "";
        
        if (isDeuce) {
            score = deuceScore(player1Score);
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            int minusResult = player1Score-player2Score;
            if (minusResult==1) {
                score = PLAYER1_ADVANTAGE;
            } else if (minusResult ==-1) {
                score = PLAYER2_ADVANTAGE;
            } else if (minusResult >= 2) {
                score = PLAYER1_WIN;
            } else {
                score = PLAYER2_WIN;
            }
        }
        else
        {
            score = scoreBoard(player1Score, player2Score);
        }
        return score;
    }

    public static String deuceScore(int playerScore){
        String score = "";

        switch (playerScore) {
            case LOVE:
                score = "Love-All";
                break;
            case FIFTEEN:
                score = "Fifteen-All";
                break;
            case THIRTY:
                score = "Thirty-All";
                break;
            case FORTY:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        
        return score;
    }

    public static String scoreBoard(int player1Score, int player2Score){
        int tempScore = 0;
        String score = "";

        for (int i=1; i<3; i++)
        {
            if (i==1) {
                tempScore = player1Score;
            } else { 
                score += "-"; 
                tempScore = player2Score;
            }

            switch(tempScore) {
                case LOVE:
                    score += "Love";
                    break;
                case FIFTEEN:
                    score += "Fifteen";
                    break;
                case THIRTY:
                    score += "Thirty";
                    break;
                case FORTY:
                    score += "Forty";
                    break;
            }
        }

        return score;
    }
}
