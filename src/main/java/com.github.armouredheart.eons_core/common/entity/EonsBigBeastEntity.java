// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.api.IEonsMultiPart;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsBigBeastEntity extends EonsBeastEntity implements IEonsMultiPart {

    // *** Attributes ***
    private final EonsBeastPartEntity[] parts;
    private final int partCount;
    private boolean shellBroken;

    // *** Constructors ***

    /** */
    public EonsBigBeastEntity(final EntityType<? extends EonsBeastEntity> type, final World world, final EonsFieldNotes fieldNotes, final EonsBeastPartEntity[] parts, final EonsDiet diet, int sexRatio, boolean isNocturnal) {
        super(type, world, fieldNotes, diet, sexRatio, isNocturnal);
        this.parts = parts;
        this.shellBroken = false;
        this.partCount = parts.length;
    }

    // *** Methods ***

    /** */
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.restoreShell();
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    /** */
    @Override
    public void setShellBroken(){
        this.shellBroken = true;
    }

    /**
    * Called when the entity is attacked.
    */
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return super.attackEntityFrom(source, amount);
    }

    /** */
    @Override
    public boolean isWounded() {return IEonsBeast.testForWounds(this, 0.7D, this.shellBroken);}

    /**
    * Returns true if other Entities should be prevented from moving through this Entity.
    */
    public boolean canBeCollidedWith() {return false;}
}