package com.litbo.hospital.lifemanage.controller.MyController;

import com.litbo.hospital.lifemanage.bean.MyBean.EqBraz;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqBrazMapper;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*病人安置*/
@RestController
@RequestMapping("/lifeManage")
public class EqBrazController {
    @Autowired
    private EqBrazMapper mapper;

    /*id查详情*/
    @PostMapping("/selectBrazById")
    public Result ListEqInfo(@RequestParam(name = "id") String id) {

        EqBraz braz = mapper.selectEqBrazById(id);
        return Result.success(braz);

    }

    @PostMapping("/updateBraz")
    public Result updateBraz(@RequestBody EqBraz braz) {
        int i = mapper.updateEqBraz(braz);
        if(i==1) {
            return Result.success(braz);

        }
        else{
            return Result.error("保存失败");

        }
    }

}
