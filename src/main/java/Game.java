import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        game.start(args);
    }

    public void start(String [] args ){
        var check = new Verification();
        var rule = new Rules();
        if (check.inputData(args)) {
            int compMove = check.getKey(args.length);
            int userMove = userMove(args);
            if ( userMove == 0) return;
            System.out.println("Your move: " + args[userMove - 1]);
            System.out.println("Computer move: " + args[compMove - 1]);
            String result = rule.victoryConditions(args.length, compMove, userMove);
            System.out.println(result.equals("draw") ? "Draw!" : "You " + result + "!");
        }
    }

    public void menu(String [] args ){
        System.out.println("Available moves:");
        for (int i=1; i<=args.length; i++){
            System.out.println(i + " - " + args[i-1]);
        }
        System.out.println("0 - exit"+"\n"+
                "? - help");
        System.out.print("Enter your move: ");
    }

    public int userMove(String[] args){
        String userStrMove;
        int userMove = 0;
        try (
                var br = new BufferedReader(new InputStreamReader(System.in))) {
            menu(args);
            do {
                userStrMove = br.readLine();
                if (userStrMove.equals("?")) {
                    new TableWin().getTable(args);
                    menu(args);
                    continue;
                }
                try {
                    userMove = Integer.parseInt(userStrMove);
                    if (userMove > args.length || userMove < 0) {
                        throw new NumberFormatException();
                    }else{
                        br.close();
                        break;
                    }
                } catch (NumberFormatException ignored) {
                    System.out.println("You need to select from the menu");
                    start(args);
                }
            } while (!userStrMove.isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userMove;
    }

    public int compMove(){
        return 0;
    }
}