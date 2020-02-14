package cn.edu.nju.movietubeserver.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2020/2/7 0:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto
{

    private Long id;

    private String title;

    private String url;

    private Double star;

    private Double doubanRate;

    private Double localRate;

    private Double myRate;

    private String cover;

    private Long coverX;

    private Long coverY;

    private List<String> casts;

    private List<String> directors;

}