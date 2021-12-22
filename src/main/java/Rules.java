public class Rules {

    public String victoryConditions(int argsLength, int compMove, int userMove){
        int a = argsLength/2;
        if (userMove<=a){
            if(compMove <= (userMove+a) && compMove > userMove ){
                return "lose";
            }else return compMove != userMove ? "win" : "draw";
        }else {
            if(compMove >= (userMove-a) && compMove < userMove){
                return "win";
            }else return compMove != userMove ? "lose" : "draw";
        }
    }
}