package com.king.TaskEvents;

import com.king.mysql.MysqlManager;
import com.king.plugincore.giveTask;
import com.king.resource.ReadConfig;
import com.king.resource.ReadTime;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerJoin implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent event){

        // 数据库判断玩家有没有领取过任务卷轴
        if(MysqlManager.isReceiveToday(event.getPlayer().getName()))return;
        /*else {
            MysqlManager.receive(event.getPlayer().getName());
        }*/
        //Bukkit.getLogger().log(Level.INFO,"Here!!");
        //一分钟后运行
        Timer timer = new Timer();

        PlayerQuit.map.put(event.getPlayer().getUniqueId().toString(),timer);//存入定时任务map

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                //执行时删除map中的记录
                if (PlayerQuit.map.containsKey(event.getPlayer().getUniqueId().toString())) PlayerQuit.map.remove(event.getPlayer().getUniqueId().toString());

                if(ReadConfig.task.equalsIgnoreCase("-")){
                    return;
                }

                if(!ReadTime.time.equalsIgnoreCase(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yy")))){ //假如时间不对了 就重载
                    ReadTime.reload();
                }

                //if(ReadTime.cha(event.getPlayer().getName())){
                giveTask.give(event.getPlayer().getName(),ReadConfig.task,event.getPlayer());
                //}
                //Bukkit.getLogger().log(Level.INFO,"Send!!!!");
            }
        },1000*60);

        //Bukkit.getLogger().log(Level.INFO,"End!!");
    }

}
