package cn.edu.nju.movietubeserver.model.domain;

import org.springframework.stereotype.Component;

/**
 * @author dc
 * @date 2020/2/7 0:26
 */
@Component("movieIndexBean")
public class MovieIndexBean
{

    // 使用ThreadLocal，避免并发问题
    private static ThreadLocal<String> indexContext = ThreadLocal.withInitial(() -> "hot");

    public String getIndexName()
    {
        return indexContext.get();
    }

    public void setIndexName(String indexName)
    {
        indexContext.set(indexName);
    }
}
