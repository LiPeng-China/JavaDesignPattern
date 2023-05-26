package com.taiyi.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象组件类
 */
abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void display();
}

/**
 * 叶子结点类
 */
class File extends Component {

    public File(String name) {
        super(name);
    }

    // 展示
    @Override
    public void display() {
        System.out.println(name);
    }
}

/**
 * 组合节点类
 */
class Folder extends Component {

    private List<Component> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    // 添加
    public void add(Component component) {
        children.add(component);
    }

    // 删除
    public void remove(Component component) {
        children.remove(component);
    }

    // 展示
    @Override
    public void display() {
        System.out.println(name);
        for (Component child : children) {
            child.display();
        }
    }
}

/**
 * 主类
 */
public class Composite {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        Component file1 = new File("file1");
        Component file2 = new File("file1");
        Folder folder1 = new Folder("folder1");
        Component file3 = new File("file3");
        Folder folder2 = new Folder("folder2");
        Component file4 = new File("file4");

        folder2.add(file4);
        folder1.add(file3);
        folder1.add(folder2);
        root.add(file1);
        root.add(file2);
        root.add(folder1);

        root.display();
    }
}
