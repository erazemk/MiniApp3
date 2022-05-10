package si.uni_lj.fri.pbd.miniapp3.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import si.uni_lj.fri.pbd.miniapp3.Constants
import si.uni_lj.fri.pbd.miniapp3.database.dao.RecipeDao
import si.uni_lj.fri.pbd.miniapp3.database.entity.RecipeDetails

@androidx.room.Database(entities = [RecipeDetails::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {
        @Volatile
        private var INSTANCE: Database? = null

        fun getDatabase(context: Context): Database? {
            if (INSTANCE == null) {
                synchronized(Database::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            Database::class.java, Constants.DB_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }

            return INSTANCE
        }
    }
}
