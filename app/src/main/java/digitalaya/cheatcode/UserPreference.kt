package digitalaya.cheatcode

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("user_preferences")

class UserPreference(val context: Context) {

    companion object {
      val platformIndex = stringPreferencesKey("1")
    }
    val platformIndexStatus: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[platformIndex] ?: "1"

    }


    suspend fun savePlatformIndexStatus(status: String = "1") {
        context.dataStore.edit { preferences ->
            preferences[platformIndex] = status
        }
    }

}
