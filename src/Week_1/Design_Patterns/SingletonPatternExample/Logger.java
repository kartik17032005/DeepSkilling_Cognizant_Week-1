package Week_1.Design_Patterns.SingletonPatternExample;

public class Logger {
    private static Logger loggerInstance;

    private Logger(){
        if(loggerInstance != null){
            System.out.println("You are breaking the rule of singleton");
        }
    }

    public static Logger getLogger(){
        if(loggerInstance == null){
            synchronized (Logger.class) {
                if (loggerInstance == null) {
                    loggerInstance = new Logger();
                }
            }
        }

        return loggerInstance;
    }
}
