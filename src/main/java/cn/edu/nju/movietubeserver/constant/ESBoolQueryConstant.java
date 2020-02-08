package cn.edu.nju.movietubeserver.constant;

/**
 * @author dc
 * @date 2020/1/2 14:50
 */
public interface ESBoolQueryConstant
{

    // AND，文档需要完全匹配must选项下的查询条件
    String MUST = "must";

    // MUST 取反，文档不能匹配must选项下的查询条件
    String MUST_NOT = "mustNot";

    // OR， should下面会带一个以上的条件，文档至少匹配一个should选项下的条件
    String SHOULD = "should";

    // 与must类似，但是filter不评分，只起过滤功能
    String FILTER = "filter";
}
