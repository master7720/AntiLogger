public class AntiLogger extends Module {
    
    public AntiLogger() {
        super("AntiLogger", "Log4j thing", Category.MISC, Priority.HIGHEST);
    }
    
    @EventListener(priority = ListenerPriority.HIGHEST)
    public void onPacketRecieve(PacketEvent.Recieve event) {
        if (event.getPacket() instanceof SPacketChat) {
            String text = ((SPacketChat)event.getPacket()).getChatComponent().getUnformattedText();
            if (text.contains("${")) event.setCancelled(true);
        }
    }
}
