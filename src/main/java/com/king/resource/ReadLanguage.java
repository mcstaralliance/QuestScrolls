package com.king.resource;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.Objects;

public class ReadLanguage {

    public static String Prefix;
    public static String Delete_Reel;
    public static String Give_new_Rell;
    public static String Finish_One_Task;
    public static String Finish_All_Task;
    public static String Not_your_own;
    public static String Not_enough_space;
    public static String Insufficient_permissions;
    public static String Format_Incorrect;
    public static FileConfiguration fileConfiguration;
    public static String No_Item;
    public static String Open_GUI;
    public static String Gui_Delay;

    public static void reloadLanguage(){

        fileConfiguration = YamlConfiguration.loadConfiguration(new File(com.king.Zhu.getPlugin(com.king.Zhu.class).getDataFolder(),"language.yml"));

        Prefix = Objects.requireNonNull(fileConfiguration.getString("Prefix")).replace("&","§");

        Delete_Reel = Prefix+""+ Objects.requireNonNull(fileConfiguration.getString("Delete_Reel")).replace("&","§");

        Give_new_Rell = Prefix+""+ Objects.requireNonNull(fileConfiguration.getString("Give_new_Rell")).replace("&","§");

        Finish_One_Task = Prefix+""+ Objects.requireNonNull(fileConfiguration.getString("Finish_One_Task")).replace("&","§");

        Finish_All_Task = Prefix+""+ Objects.requireNonNull(fileConfiguration.getString("Finish_All_Task")).replace("&","§");

        Not_your_own = Prefix+""+ Objects.requireNonNull(fileConfiguration.getString("Not_your_own")).replace("&","§");

        Not_enough_space = Prefix+""+ Objects.requireNonNull(fileConfiguration.getString("Not_enough_space")).replace("&","§");

        Insufficient_permissions = Prefix+""+ Objects.requireNonNull(fileConfiguration.getString("Insufficient_permissions")).replace("&","§");

        Format_Incorrect = Prefix+""+ Objects.requireNonNull(fileConfiguration.getString("Format_Incorrect")).replace("&","§");

        No_Item = Prefix+""+Objects.requireNonNull(fileConfiguration.getString("No_Item")).replace("&","§");

        Open_GUI = Prefix+""+Objects.requireNonNull(fileConfiguration.getString("Open_GUI")).replace("&","§");

        Gui_Delay = Prefix+""+Objects.requireNonNull(fileConfiguration.getString("Gui_Delay")).replace("&","§");
    }

}
