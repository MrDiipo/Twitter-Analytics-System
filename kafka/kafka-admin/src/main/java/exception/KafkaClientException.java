package exception;

public class KafkaClientException extends RuntimeException{
    public KafkaClientException() {
    }

    public KafkaClientException(String message) {
        super(message);
    }

    public KafkaClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public KafkaClientException(Throwable cause) {
        super(cause);
    }
}
