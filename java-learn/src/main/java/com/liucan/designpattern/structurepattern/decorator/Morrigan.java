package com.liucan.designpattern.structurepattern.decorator;

/**
 * 装饰者（decorator）模式：在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式，它属于对象结构型模式
 * <p>
 * 装饰（Decorator）模式的主要优点有：
 * 采用装饰模式扩展对象的功能比采用继承方式更加灵活。
 * 可以设计出多个不同的具体装饰类，创造出多个不同行为的组合
 * <p>
 * 装饰模式主要包含以下角色。
 * 抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
 * 具体构件（Concrete    Component）角色：实现抽象构件，通过装饰角色为其添加一些职责。
 * 抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * 具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任
 * <p>
 * 应用场景
 * 需要给一个现有类添加附加职责，而又不能采用生成子类的方法进行扩充时。例如，该类被隐藏或者该类是终极类或者采用继承方式会产生大量的子类。
 * <p>
 * 装饰模式在 Java I/O 标准库的设计,如 FilterInputStream
 *
 * @author liucan
 * @version 19-3-26
 */
//抽象构建莫妮卡
public interface Morrigan {
    void display();
}
