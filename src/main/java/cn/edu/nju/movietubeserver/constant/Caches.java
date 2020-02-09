package cn.edu.nju.movietubeserver.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dc
 * @date 2020/2/8 19:52
 */
@Getter
@AllArgsConstructor
public enum Caches
{

    MOVIE_TAGS(25, 100, 20),
    ;

    private int initialCapacity; // 初始的缓存空间大小

    private int maxSize; // 缓存的最大条数

    private int expireTime; // 过期时间（秒）
}
