package io.github.fabspu.biggertreesplugin;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MessageListener implements Listener {


    @EventHandler
    public void onPlayerPing(AsyncPlayerChatEvent event){
        if(event.getMessage().compareTo("ping") == 0)
            event.getPlayer().sendMessage(Component.text("pong"));
    }



}
