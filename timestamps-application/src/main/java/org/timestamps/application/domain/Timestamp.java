package org.timestamps.application.domain;

import java.time.ZonedDateTime;

public class Timestamp {

    private ZonedDateTime timestamp;

    public Timestamp() {
        this(ZonedDateTime.now());
    }

    public Timestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
