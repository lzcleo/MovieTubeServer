package cn.edu.nju.movietubeserver.service.impl;

import cn.edu.nju.movietubeserver.dao.MovieTagDao;
import cn.edu.nju.movietubeserver.model.dto.MovieTagDto;
import cn.edu.nju.movietubeserver.model.dto.TagDto;
import cn.edu.nju.movietubeserver.model.po.MovieTagPo;
import cn.edu.nju.movietubeserver.service.MovieTagService;
import cn.edu.nju.movietubeserver.service.TagService;
import cn.edu.nju.movietubeserver.support.elasticsearch.dao.BaseElasticSearchDao;
import cn.edu.nju.movietubeserver.support.elasticsearch.service.impl.BaseElasticSearchServiceImpl;
import java.util.List;
import org.elasticsearch.index.query.MultiMatchQueryBuilder.Type;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

/**
 * @author dc
 * @date 2020/2/7 0:38
 */
@Service
public class MovieTagServiceImpl extends BaseElasticSearchServiceImpl<MovieTagDto, MovieTagPo, Long>
    implements MovieTagService
{

    @Autowired
    private MovieTagDao movieTagDao;

    @Autowired
    private TagService tagService;

    @Override
    public BaseElasticSearchDao<MovieTagPo, Long> getBaseElasticSearchDao()
    {
        return movieTagDao;
    }

    @Override
    public Page<MovieTagDto> searchByKeyword(Integer pageNo, Integer pageSize, String searchKeyword,
        String... fieldNames)
    {
        String[] tagIndexes = tagService.getTagsMap()
            .values()
            .stream()
            .flatMap(List::stream)
            .map(TagDto::getValue)
            .distinct()
            .toArray(String[]::new);

        //TODO 去重
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withIndices(tagIndexes)
            .withQuery(QueryBuilders.multiMatchQuery(searchKeyword, fieldNames).type(Type.BEST_FIELDS).tieBreaker(0.1f))
            .withPageable(PageRequest.of(pageNo, pageSize))
            .withSort(SortBuilders.scoreSort().order(SortOrder.DESC))
            .build();
        return search(searchQuery);
    }

    @Override
    public MovieTagDto convert(MovieTagPo movieTagPo)
    {
        return movieTagPo.toDto();
    }
}
