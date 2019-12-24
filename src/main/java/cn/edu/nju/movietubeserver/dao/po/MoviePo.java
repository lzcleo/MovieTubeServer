package cn.edu.nju.movietubeserver.dao.po;

import cn.edu.nju.movietubeserver.api.dto.MovieDto;
import cn.edu.nju.movietubeserver.utils.ObjectUtil;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author dc
 * @date 2019/12/23 15:09
 */
@Document(indexName = "movie", type = "_doc", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviePo
{

    @Id
    private Long id;

    private String title;

    private String rate;

    private String star;

    private String url;

    private String cover;

    private List<String> casts;

    private List<String> directors;

    public static MoviePo valueOf(MovieDto movieDto)
    {
        return ObjectUtil.deepCloneByJson(movieDto, MoviePo.class);
    }

    public MovieDto toDto()
    {
        return ObjectUtil.deepCloneByJson(this, MovieDto.class);
    }

}
