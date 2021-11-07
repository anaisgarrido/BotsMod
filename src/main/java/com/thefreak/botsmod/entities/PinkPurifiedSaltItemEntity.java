package com.thefreak.botsmod.entities;

import com.thefreak.botsmod.init.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;

public class PinkPurifiedSaltItemEntity extends ItemEntity {

    public int lifespan = 6000;

    public PinkPurifiedSaltItemEntity(EntityType<? extends ItemEntity> p_i50217_1_, World world) {
        super(p_i50217_1_, world);
    }

    public PinkPurifiedSaltItemEntity(World world, double posX, double posY, double posZ, ItemStack itemstack) {
        super(world, posX, posY, posZ, itemstack);
        this.setItem(itemstack);
        this.lifespan = (itemstack.getItem() == null ? 6000 : itemstack.getEntityLifespan(world));
    }

    @Override
    public void setPickupDelay(int ticks) {
        super.setPickupDelay(500);
    }

    @Override
    public boolean cannotPickup() {
        return true;
    }
}
