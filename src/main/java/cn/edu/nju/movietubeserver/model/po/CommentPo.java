package cn.edu.nju.movietubeserver.model.po;

import cn.edu.nju.movietubeserver.model.dto.CommentDto;
import cn.edu.nju.movietubeserver.utils.ObjectUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author leolu
 * @create 2019-12-25-20:00
 **/
@Document(indexName = "comment", type = "_doc", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPo
{

    @Id
    private String id;

    private String parentCommentId;

    private String rootCommentId;

    private Long movieId;

    private Integer fromUserId;

    private Integer toUserId;

    private String content;

    private String createTime;

    public static CommentPo valueOf(CommentDto commentDto)
    {
        return ObjectUtil.deepCloneByJson(commentDto, CommentPo.class);
    }

    public CommentDto toDto()
    {
        return ObjectUtil.deepCloneByJson(this, CommentDto.class);
    }
}
