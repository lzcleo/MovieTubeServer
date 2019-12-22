package cn.edu.nju.movietubeserver.dao.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dc
 * @date 2019/12/22 15:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationPo
{
    private Integer operationId;

    private String operation;
}
