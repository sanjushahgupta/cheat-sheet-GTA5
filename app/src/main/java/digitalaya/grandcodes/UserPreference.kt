package digitalaya.grandcodes

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("user_preferences")

class UserPreference(val context: Context) {

    companion object {
      val platformIndex = stringPreferencesKey("")
    }
    val platformIndexStatus: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[platformIndex] ?: ""

    }


    suspend fun savePlatformIndexStatus(status: String) {
        context.dataStore.edit { preferences ->
            preferences[platformIndex] = status
        }
    }

}
