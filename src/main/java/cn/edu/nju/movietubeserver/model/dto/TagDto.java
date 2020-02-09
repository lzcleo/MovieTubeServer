package cn.edu.nju.movietubeserver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2020/2/7 20:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDto
{

    private Integer id;

    // 电影标签的值，也就是es索引
    private String value;

    // 电影标签中文，即value的中文
    private String name;

    // 电影标签的分类，如类型、地区、年份等
    private String type;
}
