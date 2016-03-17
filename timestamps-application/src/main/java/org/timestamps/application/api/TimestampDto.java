package org.timestamps.application.api;

import java.time.ZonedDateTime;

public class TimestampDto {

    public final ZonedDateTime timestamp;

    public TimestampDto(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
