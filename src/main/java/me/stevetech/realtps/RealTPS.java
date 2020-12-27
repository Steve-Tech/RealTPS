package me.stevetech.realtps;
import me.clip.placeholderapi.expansion.Taskable;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;


public class RealTPS extends PlaceholderExpansion implements Taskable {
    private int task;
    private long time;
    public float tps = 0;

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public String getAuthor(){
        return "Steve-Tech";
    }

    @Override
    public String getIdentifier(){
        return "RealTPS";
    }

    @Override
    public String getVersion(){
        return "1.0.0";
    }

    @Override
    public void start() {
        time = System.nanoTime();
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(getPlaceholderAPI(), () -> {
            long timeNow = System.nanoTime();
            long difference = timeNow-time; // 20 tps = 50 ms = 50000000 ns
            tps = 1000000000F/difference;

            time = timeNow;
        }, 1, 1);
    }

    @Override
    public void stop() {
        Bukkit.getScheduler().cancelTask(task);
    }

    @Override
    public String onRequest(OfflinePlayer player, String identifier){
        if (identifier.equals("tps")){ // %realtps_tps%
            return String.format("%.1f", tps);
        } else if (identifier.startsWith("tps_")) { // %realtps_tps_digits%
            return String.format("%." + identifier.substring(4) + "f", tps);
        } else return null;
    }
}
