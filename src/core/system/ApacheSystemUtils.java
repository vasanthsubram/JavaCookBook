package core.system;

import org.apache.commons.lang3.SystemUtils;


public class ApacheSystemUtils {

    public static void main(String[] args) {

        System.out.println(SystemUtils.getUserHome());
        System.out.println(SystemUtils.getUserDir());
        System.out.println(SystemUtils.getJavaHome());
        System.out.println(SystemUtils.getJavaIoTmpDir());
    }
}
