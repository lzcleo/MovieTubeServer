package cn.edu.nju.movietubeserver.service;

import cn.edu.nju.movietubeserver.model.dto.TagDto;
import java.util.List;
import java.util.Map;

/**
 * @author dc
 * @date 2020/2/7 20:54
 */
public interface TagService
{

    Map<String, List<TagDto>> getTagsMap();
}
