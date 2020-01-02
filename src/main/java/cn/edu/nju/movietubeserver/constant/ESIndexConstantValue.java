package cn.edu.nju.movietubeserver.constant;

/**
 * @author dc
 * @date 2019/12/31 0:13
 */
public interface ESIndexConstantValue
{

    interface Comment
    {
        // parentId == -1 表示是根评论
        Integer NO_PARENT_COMMENT_ID = -1;

        // toUserId == -1 也表示是根评论
        Integer NO_TO_USER_ID = -1;
    }
}
