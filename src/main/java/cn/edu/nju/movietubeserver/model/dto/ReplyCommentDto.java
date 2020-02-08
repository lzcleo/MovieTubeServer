package cn.edu.nju.movietubeserver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2019/12/31 14:55
 *
 * 评论回复对象，在根评论下的回复
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyCommentDto
{
    private String id;

    private String parentCommentId;

    private String rootCommentId;

    private Integer fromUserId;

    private String fromUsername;

    private Integer toUserId;

    private String toUsername;

    private String content;

    private String createTime;
}
