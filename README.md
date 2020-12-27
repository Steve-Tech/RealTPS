# RealTPS
### A Live TPS PlaceholderAPI Expansion
The TPS is calculated every tick from `System.nanoTime()` instead of the TPS averages built into Spigot (and PAPI).
Although do note that the TPS isn't calculated at the start or end of every tick but rather somewhere in the middle since it uses the Bukkit Scheduler,
so it might not be very consistent, but it should still be fairly accurate. 

## Placeholders
- %realtps\_tps% - The TPS to 1 decimal
- %realtps\_tps\_\<num\>% - The TPS to \<num\> decimals
