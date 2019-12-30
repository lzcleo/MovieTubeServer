package cn.edu.nju.movietubeserver.api.dto;

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
public class CommentDto {

    private Long id;

    private Long parentId;

    private Long movieId;

    private String time;

    private Integer fromUserId;

    private Integer toUserId;

    private String content;

}
