package webstationapi.Exception;

public class WebStationException extends RuntimeException {

	private static final long serialVersionUID = 5903894468039127451L;

	WebStationException() {
        super();
    }

    public WebStationException(String message) {
        super(message);
    }

}
