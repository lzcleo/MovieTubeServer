package cn.edu.nju.movietubeserver.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2019/12/31 0:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUser
{

    private Integer userId;

    private String username;

    //未来可能会有头像等

    private static class NullSimpleUser extends SimpleUser
    {
        private NullSimpleUser()
        {
            super(-1, "");
        }

        @Override
        public String toString()
        {
            return "很抱歉，找不到用户信息";
        }
    }

    private static class SingletonHolder
    {
        private static final NullSimpleUser NULL_SIMPLE_USER = new NullSimpleUser();
    }

    public static NullSimpleUser getDefaultUser()
    {
        return SingletonHolder.NULL_SIMPLE_USER;
    }
}
