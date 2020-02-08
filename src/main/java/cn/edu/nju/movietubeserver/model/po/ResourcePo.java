package cn.edu.nju.movietubeserver.model.po;

import java.util.List;
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
public class ResourcePo
{

    private String resource;

    private List<OperationPo> handleList;
}
