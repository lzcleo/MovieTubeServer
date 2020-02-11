package cn.edu.nju.movietubeserver.model.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2020/2/11 21:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateDetailDto
{

    private Integer id;

    private Integer userId;

    private Long movieId;

    private Integer rate;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
