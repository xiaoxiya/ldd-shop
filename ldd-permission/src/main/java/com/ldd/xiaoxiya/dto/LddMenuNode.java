package com.ldd.xiaoxiya.dto;

import com.ldd.model.LddMenu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xiaoxiya
 * @date 2020/6/27 22:12
 * @describe 菜单节点
 */
@Getter
@Setter
public class LddMenuNode extends LddMenu {
    private List<LddMenuNode> children;
}
