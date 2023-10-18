package exceptions;

public class RadiatorFailureException extends Exception {
    public RadiatorFailureException(){
        super("======= Radiator Failure! ============");
    }
}
