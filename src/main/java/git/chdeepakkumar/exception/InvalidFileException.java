package git.chdeepakkumar.exception;


public class InvalidFileException extends Exception {
    @java.io.Serial
    private static final long serialVersionUID = 5546789112123L;

    public InvalidFileException(String message) {
        super(message);
    }
}
