package cn.edu.nju.movietubeserver.model.po;

import cn.edu.nju.movietubeserver.model.dto.MovieTagDto;
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
@Document(indexName = "#{@movieTagIndexBean.getIndexName()}", type = "doc", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieTagPo
{

    @Id
    private Long id;

    private String title;

    private String url;

    private Double rate;

    private Double star;

    private String cover;

    @JsonProperty("cover_x")
    private Long coverX;

    @JsonProperty("cover_y")
    private Long coverY;

    private List<String> casts;

    private List<String> directors;

    public static MovieTagPo valueOf(MovieTagDto movieTagDto)
    {
        return ObjectUtil.deepCloneByJson(movieTagDto, MovieTagPo.class);
    }

    public MovieTagDto toDto()
    {
        return ObjectUtil.deepCloneByJson(this, MovieTagDto.class);
    }
}
