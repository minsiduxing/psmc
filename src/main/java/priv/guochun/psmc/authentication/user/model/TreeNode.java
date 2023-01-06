package priv.guochun.psmc.authentication.user.model;

import java.util.List;

/**
 * @description 树形结构
 * @author wangt
 * @create 2023/1/5 11:30
 */
public class TreeNode {

    private String id;

    private String text;

    private String pId;

    private List<TreeNode> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
