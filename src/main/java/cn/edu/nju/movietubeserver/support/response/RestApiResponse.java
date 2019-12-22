package cn.edu.nju.movietubeserver.support.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2019/12/21 17:30
 *
 * 后端给前端的统一返回体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestApiResponse<T> implements Serializable
{
    private static final long serialVersionUID = -3598902077164744672L;

    private Integer returnCode;

    private String message;

    private T data;

    private RestApiResponse(final Builder<T> builder)
    {
        this.returnCode = builder.returnCode;
        this.message = builder.message;
        this.data = builder.data;
    }

    public static class Builder<T>
    {

        private Integer returnCode;

        private String message;

        private T data;

        public Builder(final Integer returnCode)
        {
            this.returnCode = returnCode;
        }

        public Builder<T> message(final String message)
        {
            this.message = message;
            return this;
        }

        public Builder<T> data(final T data)
        {
            this.data = data;
            return this;
        }

        public RestApiResponse<T> build()
        {
            return new RestApiResponse<>(this);
        }
    }
}
