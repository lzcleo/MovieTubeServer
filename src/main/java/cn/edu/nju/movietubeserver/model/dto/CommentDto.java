package cn.edu.nju.movietubeserver.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leolu
 * @create 2019-12-25-20:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto
{

    @ApiModelProperty(value = "评论的ID，全局唯一，新增评论时不用填，传入空字符串")
    private String id;

    @ApiModelProperty(value = "父评论的ID，如果没有父评论，值为‘-1’")
    private String parentCommentId;

    @ApiModelProperty(value = "根评论的ID，如果没有根评论，值为‘-1’")
    private String rootCommentId;

    @ApiModelProperty(value = "电影ID")
    private Long movieId;

    @ApiModelProperty(value = "评论时间")
    private String createTime;

    @ApiModelProperty(value = "发表评论的用户ID")
    private Integer fromUserId;

    @ApiModelProperty(value = "这条评论回复的用户的ID，如果是根评论（没有toUserId），则值为-1")
    private Integer toUserId;

    @ApiModelProperty(value = "评论内容")
    private String content;

}
