package cn.edu.nju.movietubeserver.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2020/2/11 21:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateStatisticPo
{

    private Long movieId;

    private Long totalRate;

    private Long totalCount;
}
