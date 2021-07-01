package day3.cleanCode.tennisGame;

public class TennisGame {
    static String PLAYER1_ADVANTAGE = "Advantage player1";
    static String PLAYER2_ADVANTAGE = "Advantage player2";
    static String PLAYER1_WIN = "Win for player1";
    static String PLAYER2_WIN = "Win for player2";

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
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
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
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }

        return score;
    }
}
