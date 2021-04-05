package javaPractice.simple.pattern;

import io.swagger.annotations.Api;
import javaPractice.common.utils.FilePathUtils;


@Api(value="路径遍历")
public class PathTravel {
    public static void main(String[] args) {
        String path ="D:\\FileInstall\\WeChatFiles\\WeChat Files\\wxid_vzwgz6oijhtu21\\FileStorage\\File\\2021-03";
//        String path ="D:/FileWorkspace2/eclipse/../file.jpg";
        System.out.println(FilePathUtils.isAbsolutePath(path));
        System.out.println(FilePathUtils.fileNameValidate(path));

//        boolean flag = new File(path).isAbsolute();
//        System.out.println(new File(path).getAbsolutePath());
//        try {
//            System.out.println(new File(path).getAbsolutePath().equals(new File(path).getCanonicalPath()));
//            String newPath = new File(path).getCanonicalPath();
//            String newPath = FilePathUtils.fileNameValidate(path);
//            System.out.println(newPath);
//            File  newFile =new File(newPath);
//            if (!newFile.exists()) {
//                newFile.mkdirs();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(flag);
//        System.out.println(FilePathUtils.filePathFilter(path));
    }
}
