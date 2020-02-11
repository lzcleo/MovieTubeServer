package cn.edu.nju.movietubeserver.model.po;

import cn.edu.nju.movietubeserver.model.dto.RateDetailDto;
import cn.edu.nju.movietubeserver.utils.ObjectUtil;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2020/2/11 20:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateDetailPo
{

    private Integer id;

    private Integer userId;

    private Long movieId;

    private Integer rate;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public static RateDetailPo valueOf(RateDetailDto rateDetailDto)
    {
        return ObjectUtil.deepCloneByJson(rateDetailDto, RateDetailPo.class);
    }

    public RateDetailDto toDto()
    {
        return ObjectUtil.deepCloneByJson(this, RateDetailDto.class);
    }

}
