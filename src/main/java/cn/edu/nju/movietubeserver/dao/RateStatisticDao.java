package cn.edu.nju.movietubeserver.dao;

import cn.edu.nju.movietubeserver.model.po.RateDetailPo;
import cn.edu.nju.movietubeserver.model.po.RateStatisticPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author dc
 * @date 2020/2/11 21:05
 */
@Mapper
@Repository
public interface RateStatisticDao
{

    int insertOrUpdateRateStatistic(@Param("rateDetailPo") RateDetailPo rateDetailPo);

    RateStatisticPo getByMovieId(@Param("movieId") Long movieId);

}
