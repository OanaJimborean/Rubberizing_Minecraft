package net.oana.rubbermod;

import com.google.common.eventbus.Subscribe;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.oana.rubbermod.block.ModBlocks;
import net.oana.rubbermod.item.ModItems;
import net.oana.rubbermod.item.custom.DivingMaskItem;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RubberMod.MOD_ID)
public class RubberMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "rubbermod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RubberMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        //modEventBus.register(DivingMaskItem.class);
        //modEventBus.addListener(DivingMaskItem::onEntityTick);
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
