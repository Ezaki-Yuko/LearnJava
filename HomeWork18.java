/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork18
 * @Author: LENOVO
 * Date: 2020/4/6 20:01
 * project name: 20200406
 * @Version:
 * @Description:
 */
//实现一个简单的控制台版用户登陆程序, 程序启动提示用户输入用户名密码. 如果用户名密码出错, 使用自定义异常的方式来处理
class UserError extends Exception {
    public UserError(String message) {
        super(message);
    }
}
class PasswordError extends Exception {
    public PasswordError(String message) {
        super(message);
    }
}

public class HomeWork18 {
    private static String userName = "admin";
    private static String password = "123456";
    public static void login(String userName, String password) throws UserError,
            PasswordError {
        if (!HomeWork18.userName.equals(userName)) {
            throw new UserError("用户名错误");
        }
        if (!HomeWork18.password.equals(password)) {
            throw new PasswordError("密码错误");
        }
        System.out.println("登陆成功");
    }
    public static void main(String[] args) {
        try {
            login("admin", "123456");
        } catch (UserError userError) {
            userError.printStackTrace();
        } catch (PasswordError passwordError) {
            passwordError.printStackTrace();
        }
    }
}