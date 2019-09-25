package io.github.cgh.cache.boundary;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class CacheConfig {

    public void configure(@Observes @Initialized(ApplicationScoped.class) Object init) {
        CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();
        cacheManager.createCache("orders", new MutableConfiguration<>());
    }

}
