package cn.edu.nju.movietubeserver.model.po;

import cn.edu.nju.movietubeserver.model.dto.MovieDto;
import cn.edu.nju.movietubeserver.utils.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author dc
 * @date 2020/2/7 0:28
 */
@Document(indexName = "#{@movieIndexBean.getIndexName()}", type = "doc", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviePo
{

    @Id
    private Long id;

    private String title;

    private String url;

    private Double star;

    @JsonProperty("rate")
    private Double doubanRate;

    private Double localRate;

    private String cover;

    @JsonProperty("cover_x")
    private Long coverX;

    @JsonProperty("cover_y")
    private Long coverY;

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
