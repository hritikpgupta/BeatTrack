package com.hg.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hg.core.database.dao.RunDao
import com.hg.core.database.entity.RunEntity
import com.hg.core.database.dao.RunPendingSyncDao
import com.hg.core.database.entity.DeletedRunSyncEntity
import com.hg.core.database.entity.RunPendingSyncEntity


@Database(
    entities = [RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao

}