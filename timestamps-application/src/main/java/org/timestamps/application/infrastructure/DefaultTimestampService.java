package org.timestamps.application.infrastructure;

import org.timestamps.application.domain.TimestampService;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DefaultTimestampService implements TimestampService {

    @Override
    public ZonedDateTime get() {
        return ZonedDateTime.now(ZoneOffset.UTC);
    }
}
