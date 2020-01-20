package de.melanx.morexfood.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class RegisterLoot {

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        LivingEntity deadEntity = event.getEntityLiving();
        World world = deadEntity.getEntityWorld();
        BlockPos position = deadEntity.getPosition();
        double x = position.getX();
        double y = position.getY();
        double z = position.getZ();
        if (deadEntity instanceof HorseEntity) {
            // TODO make it more pretty
            if (world.rand.nextInt(2) == 1) {
                event.getDrops().add(new ItemEntity(world, x, y, z, new ItemStack(Registry.horse_meat.get())));
            } else if (world.rand.nextInt(5) == 3) {
                event.getDrops().add(new ItemEntity(world, x, y, z, new ItemStack(Registry.horse_meat.get())));
                event.getDrops().add(new ItemEntity(world, x, y, z, new ItemStack(Registry.horse_meat.get())));
            }
        }
        if (deadEntity instanceof WolfEntity) {
            if (world.rand.nextInt(3) == 1) {
                event.getDrops().add(new ItemEntity(world, x, y, z, new ItemStack(Registry.dog_goulash_raw.get())));
            }
        }
    }

}
