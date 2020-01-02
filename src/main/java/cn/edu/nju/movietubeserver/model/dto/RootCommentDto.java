package cn.edu.nju.movietubeserver.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2019/12/31 14:28
 *
 * 电影的根评论
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RootCommentDto
{
    private String id;

    private Long movieId;

    private Integer fromUserId;

    private String fromUsername;

    private String content;

    private String createTime;

    // 所有子评论数量
    private Long totalReplyCommentCount;

    // 默认展示两条子评论
    private List<ReplyCommentDto> defaultReplyCommentList;
}
