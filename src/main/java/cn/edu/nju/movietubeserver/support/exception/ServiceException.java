package cn.edu.nju.movietubeserver.support.exception;

/**
 * @author dc
 * @date 2019/12/21 18:41
 */
public class ServiceException extends RuntimeException
{

    public ServiceException(final String message)
    {
        super(message);
    }

    public ServiceException(final String message, final Throwable cause)
    {
        super(message, cause);
    }
}
