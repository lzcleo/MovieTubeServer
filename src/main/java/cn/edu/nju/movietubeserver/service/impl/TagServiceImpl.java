package cn.edu.nju.movietubeserver.service.impl;

import cn.edu.nju.movietubeserver.dao.TagDao;
import cn.edu.nju.movietubeserver.model.dto.TagDto;
import cn.edu.nju.movietubeserver.model.po.TagPo;
import cn.edu.nju.movietubeserver.service.TagService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author dc
 * @date 2020/2/7 20:54
 */
@Service
public class TagServiceImpl implements TagService
{

    @Autowired
    private TagDao tagDao;

    /**
     * Cacheable注解
     * value：缓存key的前缀。
     * key：缓存key的后缀。
     * sync：设置如果缓存过期是不是只放一个请求去请求数据库，其他请求阻塞，默认是false。
     */
    @Override
    @Cacheable(value = "MOVIE_TAGS", sync = true)
    public Map<String, List<TagDto>> getTagsMap()
    {
        return tagDao.listAllTags().stream().map(TagPo::toDto).collect(Collectors.groupingBy(TagDto::getType));
    }
}
