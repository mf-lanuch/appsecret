package com.app.secret.core.util;

import com.app.secret.core.vo.AjaxResult;
import com.app.secret.core.vo.TreeDataSetVo;
import com.app.secret.entity.AppMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtil {

    public static AjaxResult<TreeDataSetVo> converMenuToTree(List<AppMenu> list) {
        List<TreeDataSetVo> tree = new ArrayList<>();
        Map<String, TreeDataSetVo> map = new HashMap<>();
        for(AppMenu menu: list) {
            map.put(menu.getUuid(), converMenuToTree(menu));
        }

        for(AppMenu menu: list) {
            if(StringUtil.isNull(menu.getParentMenuId())) {
                tree.add(converMenuToTree(menu));
            } else {
                map.get(menu.getParentMenuId()).addChildren(converMenuToTree(menu));
            }
         }

        return AjaxResultUtil.ok("",tree);
    }

    public static TreeDataSetVo converMenuToTree(AppMenu menu) {
        TreeDataSetVo vo = new TreeDataSetVo();
        vo.setId(menu.getUuid());
        vo.setCode(menu.getMenuCode());
        vo.setName(menu.getMenuName());
        vo.setIcon(menu.getMenuIcon());
        vo.setPath(menu.getMenuPath());
        return vo;
    }
}
