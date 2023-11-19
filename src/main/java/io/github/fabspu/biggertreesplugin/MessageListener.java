package io.github.fabspu.biggertreesplugin;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class MessageListener implements Listener {


    @EventHandler
    public void onPlayerPing(PlayerChatEvent event){
        if(event.getMessage().compareTo("ping") == 0)
            event.getPlayer().sendMessage("pong");
    }



}
