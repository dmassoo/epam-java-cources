package com.epam.university.java.core.task041;

import java.util.Collection;

public class Task041Impl implements Task041 {
    /**
     * Perform <p>Create</p> operation with <code>collection</code> of entities.
     * Tip: Pay attention that id of entity is unique.
     *
     * @param collection in which should create new entity.
     * @param value      for creation new entity.
     * @return created entity.
     */
    @Override
    public Entity create(Collection<Entity> collection, String value) {
        if (collection == null || value == null) {
            throw new IllegalArgumentException();
        }
        Entity entity = new Entity() {
            @Override
            public int getId() {
                return collection.size() - 1;
            }

            @Override
            public String getValue() {
                return value;
            }
        };
        collection.add(entity);
        return entity;
    }

    /**
     * Perform <p>Read</p> operation with <code>collection</code> of entities.
     *
     * @param collection from which should read entity.
     * @param entity     to be read.
     * @return read entity.
     */
    @Override
    public Entity read(Collection<Entity> collection, Entity entity) {
        if (collection == null || entity == null) {
            throw new IllegalArgumentException();
        }
        return entity;
    }

    /**
     * Perform <p>Update</p> operation with <code>collection</code> of entities.
     *
     * @param collection in which have to update entity object.
     * @param entity     to be updated.
     * @param value      that have to be changed in entity object.
     */
    @Override
    public void update(Collection<Entity> collection, Entity entity, String value) {
        if (collection == null || value == null || entity == null) {
            throw new IllegalArgumentException();
        }
        for (Entity en : collection) {
            if (en.getId() == entity.getId()) {
//                delete(collection, en);
//                create(collection, entity.getValue());
                en = new Entity() {
                    @Override
                    public int getId() {
                        return entity.getId();
                    }

                    @Override
                    public String getValue() {
                        return value;
                    }
                };
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * Perform <p>Delete</p> operation with <code>collection</code> of entities.
     *
     * @param collection from which have to delete object.
     * @param entity     to be deleted.
     */
    @Override
    public void delete(Collection<Entity> collection, Entity entity) {
        if (collection == null || entity == null) {
            throw new IllegalArgumentException();
        }
        for (Entity en : collection) {
            if (en.getId() == entity.getId()) {
                collection.remove(en);
            }
        }
    }
}
