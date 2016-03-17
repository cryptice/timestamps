package org.timestamps.application;

import com.google.inject.AbstractModule;
import org.timestamps.application.domain.TimestampService;
import org.timestamps.application.infrastructure.DefaultTimestampService;

public class TimestampsGuiceModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(TimestampService.class).to(DefaultTimestampService.class);

    }

}
