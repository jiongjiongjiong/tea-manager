package com.zc.tea.service;


import com.zc.tea.mapper.TbItemMapper;
import com.zc.tea.pojo.TbItem;
import com.zc.tea.pojo.TbItemExample;
import com.zc.tea.pojo.TbItemExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: zc
 * @date: 2017/10/21
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem getItemById(Long itemId) {
        //根据主键查询
//        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
        //设置查询条件
        TbItemExample example = new TbItemExample();
        Criteria criteria = example.createCriteria();
        //执行查询
        List<TbItem> list = tbItemMapper.selectByExample(example);
        if (list !=null && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }
}
