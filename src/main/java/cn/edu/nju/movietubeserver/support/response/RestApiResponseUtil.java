package cn.edu.nju.movietubeserver.support.response;

import org.springframework.http.HttpStatus;

/**
 * @author dc
 * @date 2019/12/21 17:57
 */
public class RestApiResponseUtil
{

    private static final String DEFAULT_SUCCESS_MESSAGE = "OK";

    private RestApiResponseUtil()
    {

    }

    public static <T> RestApiResponse<T> createSuccessResponse()
    {
        return new RestApiResponse.Builder<T>(HttpStatus.OK.value()).message(DEFAULT_SUCCESS_MESSAGE).build();
    }

    public static <T> RestApiResponse<T> createSuccessResponse(final T data)
    {
        return new RestApiResponse.Builder<T>(HttpStatus.OK.value()).message(DEFAULT_SUCCESS_MESSAGE)
            .data(data)
            .build();
    }

    public static <T> RestApiResponse<T> createErrorResponse(final HttpStatus status, final String errorMessage)
    {
        return new RestApiResponse.Builder<T>(status.value()).message(errorMessage).build();
    }

    public static <T> RestApiResponse<T> createErrorResponse(final String errorMessage)
    {
        return new RestApiResponse.Builder<T>(HttpStatus.BAD_REQUEST.value()).message(errorMessage).build();
    }
}
