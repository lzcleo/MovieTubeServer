package cn.edu.nju.movietubeserver.dao;

import cn.edu.nju.movietubeserver.model.po.TagPo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author dc
 * @date 2020/2/7 20:34
 */
@Mapper
@Repository
public interface TagDao
{

    List<TagPo> listAllTags();
}
