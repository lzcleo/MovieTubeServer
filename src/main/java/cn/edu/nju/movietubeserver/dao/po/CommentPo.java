package cn.edu.nju.movietubeserver.dao.po;

import cn.edu.nju.movietubeserver.api.dto.CommentDto;
import cn.edu.nju.movietubeserver.utils.ObjectUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;



/**
 * @author leolu
 * @create 2019-12-25-20:00
 **/
@Document(indexName = "comment",type = "_doc", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPo {

    private Long id;

    private Long parentId;

    private Long movieId;

    private String time;

    private Integer fromUserId;

    private Integer toUserId;

    private String content;

    public static CommentPo valueOf(CommentDto commentDto)
    {
        return ObjectUtil.deepCloneByJson(commentDto, CommentPo.class);
    }

    public CommentDto toDto()
    {
        return ObjectUtil.deepCloneByJson(this, CommentDto.class);
    }
}
