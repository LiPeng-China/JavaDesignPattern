package com.taiyi.creational;

/**
 * 抽象产品
 */
interface CPU {
}

interface RAM {
}

/**
 * 抽象每个产品的工厂
 */
interface CPUFactory {
    CPU createCPU();
}

interface RAMFactory {
    RAM createRAM();
}

/**
 * 实现具体的产品
 */
class WindowsCPU implements CPU {
}

class WindowsRAM implements RAM {
}

class MacCPU implements CPU {
}

class MacRAM implements RAM {
}

/**
 * 工厂方法的具体实现
 */
class WindowsCPUFactory implements CPUFactory {
    @Override
    public CPU createCPU() {
        return new WindowsCPU();
    }
}

class WindowsRAMFactory implements RAMFactory {

    @Override
    public RAM createRAM() {
        return new WindowsRAM();
    }
}

class MacCPUFactory implements CPUFactory {

    @Override
    public CPU createCPU() {
        return new MacCPU();
    }
}

class MacRAMFactory implements RAMFactory {

    @Override
    public RAM createRAM() {
        return new MacRAM();
    }
}

/**
 * 定义抽象工厂
 */
interface PCAbstractFactory {
    CPU createCPU();

    RAM createRAM();
}

/**
 * Mac 工厂的实现
 */
class MacFactory implements PCAbstractFactory {

    @Override
    public CPU createCPU() {
        return new MacCPUFactory().createCPU();
    }

    @Override
    public RAM createRAM() {
        return new MacRAMFactory().createRAM();
    }
}

/**
 * Windows 工厂实现
 */
class WindowsFactory implements PCAbstractFactory {

    @Override
    public CPU createCPU() {
        return new WindowsCPUFactory().createCPU();
    }

    @Override
    public RAM createRAM() {
        return new WindowsRAMFactory().createRAM();
    }
}


public class AbstractFactory {
    public static void main(String[] args) {
        PCAbstractFactory factory = new MacFactory();
        CPU cpu = factory.createCPU();
        RAM ram = factory.createRAM();
    }
}
