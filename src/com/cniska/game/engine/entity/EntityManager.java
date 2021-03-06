package com.cniska.game.engine.entity;

import com.cniska.game.engine.base.Base;
import com.cniska.game.engine.base.BaseCollection;
import com.cniska.game.engine.util.SortedArrayList;

/**
 * Entity manager class file.
 * This class is derived from the Entity class to allow nesting of entity managers.
 * Its only purpose is to update the entities it manages.
 * @author Christoffer Niska <ChristofferNiska@gmail.com>
 * @license New BSD License http://www.opensource.org/licenses/bsd-license.php
 */
public final class EntityManager extends Base
{
	// ----------
	// Properties
	// ----------

	private BaseCollection entities;

	// -------
	// Methods
	// -------

	/**
	 * Creates the entity manager.
	 */
	public EntityManager()
	{
		super();
		entities = new BaseCollection();
	}

	/**
	 * Resets this entity manager.
	 */
	@Override
	public void reset()
	{
		entities.reset();
	}

	/**
	 * Updates the entities managed by this manager.
	 * @param parent The parent object.
	 */
	@Override
	public void update(Base parent)
	{
		final int entityCount = entities.getSize();

		if (entityCount > 0)
		{
			SortedArrayList<Base> objects = entities.getObjects();

			for (int i = 0; i < entityCount; i++)
			{
				Entity entity = (Entity) objects.get(i);

				if (entity.getRemoved())
				{
					entities.remove(entity);
				}
			}
		}

		entities.update(this);
	}

	/**
	 * Adds an entity to the manager.
	 * @param entity The entity to add.
	 */
	public void addEntity(Entity entity)
	{
		entities.add(entity);
	}

	/**
	 * Removes an entity from this manager.
	 * @param entity The entity to remove.
	 */
	public void removeEntity(Entity entity)
	{
		entities.remove(entity);
	}
}
