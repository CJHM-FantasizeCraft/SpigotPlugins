package cjhm.spigotplugins;

import cjhm.spigotplugins.commands.sp;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotPlugins extends JavaPlugin {

    @Override
    public void onEnable() {
        // 插件启动输出
        System.out.println("***********SpigotPlugins，V1.1.2**********");
        System.out.println("*****插件作者：CJHM， 始构建于：2023/4/29*****");
        System.out.println("**插件启动中，请稍后……请注意本插件适用于Paper端**");
        System.out.println("***插件启动成功！如有疑问，联系QQ：1196808704***");
        getCommand( "spigotplugins" ).setExecutor(new sp());
    }
    @Override
    public void onDisable() {
        // 插件卸载输出
        System.out.println("*******您的服务器已停止运行，插件卸载中……*******");
        // 卸载插件脚本，保存用户数据

        // 脚本结束，插件停止
        System.out.println("卸载完毕!");
    }
}