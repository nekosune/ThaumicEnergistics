package thaumicenergistics.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import thaumicenergistics.aspect.AspectStackComparator.ComparatorMode;
import thaumicenergistics.container.ContainerEssentiaCell;
import thaumicenergistics.gui.abstraction.AbstractGuiCellTerminalBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Gui for a cell in ME chest.
 * 
 * @author Nividica
 * 
 */
@SideOnly(Side.CLIENT)
public class GuiEssentiaCell
	extends AbstractGuiCellTerminalBase
{
	/**
	 * Create the gui.
	 * 
	 * @param player
	 * Player viewing the gui.
	 * @param world
	 * World the chest is in.
	 * @param x
	 * X position of the chest.
	 * @param y
	 * Y position of the chest.
	 * @param z
	 * Z position of the chest.
	 */
	public GuiEssentiaCell( final EntityPlayer player, final World world, final int x, final int y, final int z )
	{
		super( player, new ContainerEssentiaCell( player, world, x, y, z ) );
	}

	@Override
	protected void sortModeButtonClicked( final ComparatorMode modeRequested )
	{
		// Pass to the container
		( (ContainerEssentiaCell)this.inventorySlots ).sendSortModeChangeRequest( modeRequested );
	}

}
