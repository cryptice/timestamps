package org.timestamps.application.resources;

import org.timestamps.application.api.TimestampDto;

import java.time.ZonedDateTime;

public class DtoConverter {

    public TimestampDto toDto(ZonedDateTime timestamp) {
        return new TimestampDto(timestamp);
    }
}
