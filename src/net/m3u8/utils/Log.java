package net.m3u8.utils;

public class Log {

    private static volatile int level = Constant.INFO;

    public static void i(CharSequence message) {
        if (level == Constant.INFO)
            System.out.println("\33[0;2m" + message);
    }

    public static void d(CharSequence message) {
        if (level == Constant.INFO || level == Constant.DEBUG) {
            System.out.println("\33[36;2m" + message);
            System.out.print("\33[0;2m");
        }
    }

    public static void e(CharSequence message) {
        if (level == Constant.INFO || level == Constant.ERROR) {
            System.out.println("\33[31;2m" + message);
            System.out.print("\33[0;2m");
        }
    }

    public static void setLevel(int level) {
        if (level != Constant.NONE && level != Constant.INFO && level != Constant.DEBUG && level != Constant.ERROR)
            throw new IllegalArgumentException("日志参数信息设置错误！");
        Log.level = level;
    }

    public static int getLevel() {
        return level;
    }
}
