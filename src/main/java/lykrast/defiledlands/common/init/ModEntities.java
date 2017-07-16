package lykrast.defiledlands.common.init;

import lykrast.defiledlands.client.render.entity.*;
import lykrast.defiledlands.common.entity.EntityShambler;
import lykrast.defiledlands.core.DefiledLands;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {
	
	private static int id = 1;
	
	public static void init()
	{
		registerEntity(EntityShambler.class, "shambler", 0x171717, 0xebebeb);
        LootTableList.register(EntityShambler.LOOT);
	}
	
	public static void registerEntity(Class<? extends Entity> entityClass, String name, int colorBack, int colorFront)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(DefiledLands.MODID, name), entityClass, DefiledLands.MODID + "." + name, id++, DefiledLands.instance, 64, 3, true, colorBack, colorFront);
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityShambler.class, RenderShambler.FACTORY);
    }

}