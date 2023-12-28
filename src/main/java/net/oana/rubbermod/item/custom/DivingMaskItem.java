package net.oana.rubbermod.item.custom;

import com.google.common.eventbus.Subscribe;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.oana.rubbermod.RubberMod;
import net.oana.rubbermod.item.ModItems;


@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = "rubbermod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DivingMaskItem extends Item {

    public DivingMaskItem(Properties properties) {
        super(properties);
    }

    @SubscribeEvent
    public static void onEntityTick(TickEvent.PlayerTickEvent event) {
       // System.out.println("Entity tick event triggered!");

        Level world = event.player.level;
        //System.out.println("Breathing effect applied!");

        if (event.player.isUnderWater() && event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.DIVING_MASK.get()) {
            applyBreathingEffect(event.player);
        }
    }

    //@Subscribe
    private static void applyBreathingEffect(Entity entity) {
        //System.out.println("Breathing effect applied!");
        if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity.isUnderWater()) {
                livingEntity.setAirSupply(livingEntity.getMaxAirSupply());
                //System.out.println("Breathing effect applied!"); // Add this line for debugging
            }
        }
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }







}
