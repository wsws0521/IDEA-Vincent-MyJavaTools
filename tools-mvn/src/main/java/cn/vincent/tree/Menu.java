package cn.vincent.tree;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Menu {
    private Integer id;
    private String name;
    private Integer parentId;
    private List<Menu> childList;

    public Menu(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Menu(Integer id, String name, Integer parentId, List<Menu> childList) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childList = childList;
    }
}
