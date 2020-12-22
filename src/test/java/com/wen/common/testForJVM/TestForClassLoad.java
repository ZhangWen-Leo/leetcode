package com.wen.common.testForJVM;

public class TestForClassLoad {
    public static void main(String[] args) {
        staticFunction();
    }

    static TestForClassLoad test = new TestForClassLoad();

    static {
        System.out.println("初始静态");
    }

    {
        System.out.println("初始普通");
    }

    TestForClassLoad() {
        System.out.println("构造方法");
        System.out.println("a=" + a + ", b=" + b);
    }

    public static void staticFunction() {
        System.out.println("静态方法");
    }

    int a = 100;
    static int b = 1;
}

class Grandpa {
    static {
        System.out.println("爷爷静态");
    }

    public Grandpa() {
        System.out.println("我是爷爷");
    }
}

class Father extends Grandpa {
    static  {
        System.out.println("爸爸静态");
    }

    public static int factor = 25;

    public Father() {
        System.out.println("我是爸爸");
    }
}

class Son extends Father {
    static {
        System.out.println("儿子静态");
    }

    public Son() {
        System.out.println("我是儿子");
    }
}
