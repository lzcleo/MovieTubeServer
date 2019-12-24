package cn.edu.nju.movietubeserver.support.exception;

/**
 * @author dc
 * @date 2019/12/23 17:21
 */
public class ElasticSearchException extends RuntimeException
{

    public ElasticSearchException(final String message)
    {
        super(message);
    }

    public ElasticSearchException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

}
