package net.javaguide.banking.exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp,String massage,String details, String errorCode) {

}
