package exceptions;

public class LightsFailureException extends Exception {
    public LightsFailureException(){
        super("======= Check lights failure =======");
    }
}
