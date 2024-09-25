package tech.fivedhub.exception;

public class CompanyNotFoundException extends RuntimeException {

    public CompanyNotFoundException(final String message) {
        super(message);
    }
}
