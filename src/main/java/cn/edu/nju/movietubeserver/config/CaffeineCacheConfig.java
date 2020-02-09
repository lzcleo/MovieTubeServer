package cn.edu.nju.movietubeserver.config;

import cn.edu.nju.movietubeserver.constant.Caches;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author dc
 * @date 2020/2/8 19:50
 */
@Configuration
public class CaffeineCacheConfig
{
    @Bean
    @Primary
    public CacheManager caffeineCacheManager()
    {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> caches = Arrays.stream(Caches.values())
            .map(cache -> new CaffeineCache(cache.name(),
                Caffeine.newBuilder()
                    .initialCapacity(cache.getInitialCapacity())
                    .maximumSize(cache.getMaxSize())
                    .expireAfterAccess(cache.getExpireTime(), TimeUnit.SECONDS)
                    .weakKeys()
                    .recordStats()
                    .build()))
            .collect(Collectors.toList());

        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
