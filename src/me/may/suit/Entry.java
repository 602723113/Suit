package me.may.suit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.may.attribute.dto.Attribute;
import me.may.suit.dao.SuitDao;
import me.may.suit.dto.Suit;
import me.may.suit.utils.FileUtil;

public class Entry extends JavaPlugin {

	private static Entry instance;
	private File suitDirectory = new File(getDataFolder().getAbsolutePath() + "\\Suits\\");
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§a[套装] §e>> §f已加载");
		instance = this;
		loadSuits();
	}

	public void loadSuits() {
		FileConfiguration filec = null;
		for (File file : suitDirectory.listFiles()) {
			filec = FileUtil.loadYml(file);
			String suitName = filec.getString("Suit.Name").replaceAll("&", "§");
			SuitDao.suitNames.add(suitName);
			
			int maxSuit = filec.getInt("Suit.MaxSuit");
			List<Attribute> datas = new ArrayList<Attribute>();
			Attribute att = null;
			for (int i = 2; i <= maxSuit; i++) {
				att = new Attribute(suitName, 
						filec.getDouble("Suit.Attribute." + i + ".Health"),
						filec.getDouble("Suit.Attribute." + i + ".PercentHealth"),
						filec.getDouble("Suit.Attribute." + i + ".Attack"),
						filec.getDouble("Suit.Attribute." + i + ".Defense"),
						filec.getDouble("Suit.Attribute." + i + ".Hit"),
						filec.getDouble("Suit.Attribute." + i + ".Dodge"),
						filec.getDouble("Suit.Attribute." + i + ".Knowing"),
						filec.getDouble("Suit.Attribute." + i + ".KnowingDefense"),
						filec.getDouble("Suit.Attribute." + i + ".Strenth"),
						filec.getDouble("Suit.Attribute." + i + ".ToughNess"),
						filec.getDouble("Suit.Attribute." + i + ".Ability"),
						filec.getDouble("Suit.Attribute." + i + ".Body"),
						filec.getDouble("Suit.Attribute." + i + ".PhysicalPower"),
						filec.getDouble("Suit.Attribute." + i + ".Ice"),
						filec.getDouble("Suit.Attribute." + i + ".IceDefense"),
						filec.getDouble("Suit.Attribute." + i + ".Fire"),
						filec.getDouble("Suit.Attribute." + i + ".FireDefense"),
						filec.getDouble("Suit.Attribute." + i + ".Xuan"),
						filec.getDouble("Suit.Attribute." + i + ".XuanDefense"),
						filec.getDouble("Suit.Attribute." + i + ".Poison"),
						filec.getDouble("Suit.Attribute." + i + ".PoisonDefense"));
				datas.add(att);
			}
			SuitDao.getList().add(new Suit(suitName, datas));
		}
		Bukkit.getConsoleSender().sendMessage("§a[套装] §e>> §f已读取所有的套装至缓存中!");
	}
	
	public boolean isSuit(ItemStack item) {
		if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
			for (String suitName: SuitDao.suitNames) {
				if (item.getItemMeta().getDisplayName().indexOf(suitName) != -1) {
					return true;
				}
			}
		}
		return false;
	}
	
	public final static Entry getInstance() {
		return instance;
	}
	

}
