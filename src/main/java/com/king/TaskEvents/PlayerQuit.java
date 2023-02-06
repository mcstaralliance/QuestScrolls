package com.king.TaskEvents;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.*;

/**
 * @Author: RiceTofu123
 * @Date: 2023-02-05
 * @Discription: 退出事件监听，取消当前的定时任务
 * */
public class PlayerQuit implements Listener {

    //用于存储还没有执行的玩家定时任务，尤指每日任务发放的定时任务
    public static Map<String,Timer> map = new HashMap<>();

    public void playerQuit(PlayerQuitEvent event){
        //如果表中有就删除这个数据并取消这个定时任务
        if(map.containsKey(event.getPlayer().getUniqueId().toString()))map.remove(event.getPlayer().getPlayer().getUniqueId().toString()).cancel();
    }

}
