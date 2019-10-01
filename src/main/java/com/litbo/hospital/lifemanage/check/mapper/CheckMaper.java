package com.litbo.hospital.lifemanage.check.mapper;


import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.check.pojo.Check;
import com.litbo.hospital.result.Result;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
@Component
public interface CheckMaper {
    public List<Check> getCheck(String plan_id);
    public Result updateStatus(List<String> ids, String userId, String check);
}
