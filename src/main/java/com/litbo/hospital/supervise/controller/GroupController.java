package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SGroup;
import com.litbo.hospital.supervise.dao.GroupDao;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.service.GroupService;
import com.litbo.hospital.supervise.vo.GroupInsertDetailVO;
import com.litbo.hospital.supervise.vo.GroupReadyForSubmitVO;
import com.litbo.hospital.supervise.vo.GroupSelectDetailVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sybm/ksgl")
@Api(tags = "科室团队管理")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private BmService bmService;

    @Autowired
    private GroupDao groupDao;


    //获得所有科室管理团队
    @GetMapping("/listGroups")
    public Result getGroups(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = groupService.getGroups(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/listGroups2")
    public Result listGroups2(){
        List<SGroup> groups = groupDao.getGroups();
        return Result.success(groups);
    }

    //获得科室管理团队
    @GetMapping("/listSelectGroups")
    public Result getSelectGrouplistWclGroupBms(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = groupService.getSelectGroups(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    //获得科室管理团队通过审核code
    @GetMapping("/listSelectGroupsByShCode")
    public Result listSelectGroupsByShCode(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                                @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,String shCode){
        PageInfo pageInfo = groupService.getSelectGroupsByShCode(pageNum,pageSize,shCode);
        return Result.success(pageInfo);
    }


    //获得科室管理团队通过审核code科室名称和团队名称的组联模糊查询
    @GetMapping("/listSelectGroupsByBmNameAndGNameAndShCode")
    public Result listSelectGroupsByBmNameAndGNameAndShCode(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                                      @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,String bmName,String groupName,String shCode){
        PageInfo pageInfo = groupService.getSelectGroupsByBmNameAndGNameAndShCode(pageNum,pageSize,bmName,groupName,shCode);
        return Result.success(pageInfo);
    }





    //通过id获得科室管理团队
    @GetMapping("/getGroupById")
    public Result getGroupById(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                               @RequestParam String group_id){
        SGroup date = groupService.getGroupById(pageNum, pageSize, group_id);
        return Result.success(date);
    }

    //提交前数据准备
    @GetMapping("/readyForSubmit")
    public Result readyForSubmit(){
        // 获取所有科室
        List<SBm> bmList = bmService.getYZBmList();
        //  审核人准备


        GroupReadyForSubmitVO submitVO = new GroupReadyForSubmitVO();
        submitVO.setBms(bmList);
        return Result.success(submitVO);
    }



    //提交
    @PostMapping("/submitGroups")
    public Result submitGroups(@RequestBody GroupInsertDetailVO groupInsertDetailVO){
        groupService.submitGroups(groupInsertDetailVO);
        return Result.success();
    }
    @PostMapping("/reSubmitGroups")
    public Result reSubmitGroups(@RequestBody GroupInsertDetailVO groupInsertDetailVO){
        groupService.reSubmitGroups(groupInsertDetailVO);

        return Result.success();
    }
    //通过审核人id 获取待审核的团队
    @GetMapping("/getDshGroupByShr")
    public Result getDshGroupByShr(@RequestParam String shrId){

        SGroup sGroup = groupService.getDshGroupByShr(shrId);
        return Result.success(sGroup);
    }

    //通过团队id 获取团队的详细信息
    @GetMapping("/getGroupDetailByGId")
    public Result getGroupDetailByGId(@RequestParam String gid){

        GroupSelectDetailVO vo = groupService.getGroupDetailByGId(gid);
        return Result.success(vo);
    }

    //审核人提交审核结果
    @PostMapping("/shrShGroup")
    public Result shrShGroup(@RequestBody GroupInsertDetailVO groupInsertDetailVO){
        if(groupInsertDetailVO.getShYj()==null)groupInsertDetailVO.setShYj("");
        groupService.shrShGroup(groupInsertDetailVO);
        return Result.success();
    }

    //获得已退回的团队信息
    @GetMapping("/getYTHGroup")
    public Result getYTHGroup(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){

        PageInfo date =  groupService.getYTHGroup(pageNum,pageSize);
        return Result.success(date);
    }
    //通过创建人获得已退回的团队信息
    @GetMapping("/getYTHGroupByCId")
    public Result getYTHGroupByCId(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,String createId){

        PageInfo date =  groupService.getYTHGroupByCId(pageNum,pageSize,createId);
        return Result.success(date);
    }

    //获得所有管理科室的基本详情信息
    @GetMapping("/getGroupsMSGDetail")
    public Result getGroupsMSGDetail(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                   @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){

        PageInfo date =  groupService.getGroupsMSGDetail(pageNum,pageSize);
        return Result.success(date);
    }

    //获得管理科室的基本详情信息通过科室名称
    @GetMapping("/getGroupsMSGDetailByBmName")
    public Result getGroupsMSGDetailByBmName(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                     @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,String bmName){

        PageInfo date =  groupService.getGroupsMSGDetailByBmName(pageNum,pageSize,bmName);
        return Result.success(date);
    }

    //获得未成立科室
    @GetMapping("/listWclGroupBm")
    public Result listWclGroupBm(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                     @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){

        PageInfo date =  groupService.listWclGroupBm(pageNum,pageSize);
        return Result.success(date);
    }

    @GetMapping("/listPreEmps")
    public Result listPreEmps(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              String gwName){

        PageInfo date =  groupService.listPreEmps(pageNum,pageSize,gwName);
        return Result.success(date);
    }

    @GetMapping("/listPreEmpsByBmNameAndUserXm")
    public Result listPreEmpsByBmNameAndGwName(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              String gwName,String userXm,String bmName){

        PageInfo date =  groupService.listPreEmpsByBmNameAndGwName(pageNum,pageSize,gwName,userXm,bmName);
        return Result.success(date);
    }


    @GetMapping("/getEstablishJd")
    public Result getEstablishJd(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                 @RequestParam(name="tdName",required = false)String tdName,
                                 @RequestParam(name="bmName",required = false)String bmName
                                 ){

        PageInfo info = groupService.getEstablishJd(pageNum,pageSize,tdName,bmName);

        return Result.success(info);
    }

}
