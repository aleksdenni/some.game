import com.github.freva.asciitable.AsciiTable;

public class TableWin {

    void getTable(String [] args){
        var headers = new String[args.length+1];
        var data = new String[args.length][args.length+1];
        var rule = new Rules();
        for (int i=0; i<args.length; i++){
            headers[i+1]=args[i];
            data[i][0]=args[i];
            for (int j=1; j<=args.length; j++) {
                data[i][j] = rule.victoryConditions(args.length,i+1,j);
            }
        }

        System.out.println(AsciiTable.getTable(headers, data));
    }
}
