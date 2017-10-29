package com.boliangshenghe.outteam.repository;

import java.util.List;

import com.boliangshenghe.outteam.entity.LinkDetail;

public interface LinkDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LinkDetail record);

    int insertSelective(LinkDetail record);

    LinkDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LinkDetail record);

    int updateByPrimaryKey(LinkDetail record);
    
    int deleteByLinkDetail(LinkDetail linkDetail);
    
    List<LinkDetail> selectLinkDetailList(LinkDetail record);
}