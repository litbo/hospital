package com.litbo.hospital.lifemanage.checkBeforeUse.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResultList {

    List<SearchStandardTaskVO> list = new ArrayList<>();
}
