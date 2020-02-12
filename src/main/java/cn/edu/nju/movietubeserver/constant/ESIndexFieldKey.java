package cn.edu.nju.movietubeserver.constant;

/**
 * @author dc
 * @date 2019/12/24 9:46
 *
 * 存放ElasticSearch索引的schema
 */
public interface ESIndexFieldKey
{

    interface Movie
    {
        String ID = "id";

        String TITLE = "title";

        String RATE = "rate";

        String STAR = "star";

        String DIRECTORS = "directors";

        String CASTS = "casts";
    }

    interface Comment
    {
        String MOVIE_ID = "movieId";

        String TO_USER_ID = "toUserId";

        String FROM_USER_ID = "fromUserId";

        String PARENT_COMMENT_ID = "parentCommentId";

        String ROOT_COMMENT_ID = "rootCommentId";

        String CREATE_TIME = "createTime";
    }
}
