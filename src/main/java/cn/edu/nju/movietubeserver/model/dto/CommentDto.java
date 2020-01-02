package cn.edu.nju.movietubeserver.model.dto;

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

    private String id;

    private String parentCommentId;

    private String rootCommentId;

    private Long movieId;

    private String createTime;

    private Integer fromUserId;

    private Integer toUserId;

    private String content;

}
