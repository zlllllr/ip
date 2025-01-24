public class MissingContentException extends Exception{
    private final String type;
    MissingContentException(String errorMessage, String type) {
        super(errorMessage);
        this.type = type;
    }
    public String toString() {
        return type;
    }
}
