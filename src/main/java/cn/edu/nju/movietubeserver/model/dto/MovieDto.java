package cn.edu.nju.movietubeserver.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2019/12/23 17:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto
{
    private Long id;

    private String title;

    private String rate;

    private String star;

    private String url;

    private String cover;

    private List<String> casts;

    private List<String> directors;
}
