package cn.edu.nju.movietubeserver.model.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2020/1/2 13:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleMovieInfo
{

    // 电影id
    private Long id;

    // 电影名称
    private String title;

    // 演员列表
    private List<String> casts;

    // 导演列表
    private List<String> directors;

    private static class NullSimpleMovieInfo extends SimpleMovieInfo
    {
        private NullSimpleMovieInfo()
        {
            super(-1L, "找不到该电影的信息", new ArrayList<>(), new ArrayList<>());
        }

        @Override
        public String toString()
        {
            return "很抱歉，找不到电影信息";
        }
    }

    private static class SingletonHolder
    {
        private static final NullSimpleMovieInfo NULL_SIMPLE_MOVIE_INFO = new NullSimpleMovieInfo();
    }

    public static NullSimpleMovieInfo getDefaultMovieInfo()
    {
        return SingletonHolder.NULL_SIMPLE_MOVIE_INFO;
    }

}
