package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.json.JSONArray
import org.json.JSONObject
import java.util.UUID

private val Context.herFindsDataStore: DataStore<Preferences> by preferencesDataStore(name = "herfinds_prefs")

class HerFindsPreferencesRepository(private val context: Context) {

    private object Keys {
        val SAVED_FIND_IDS = stringSetPreferencesKey("saved_find_ids")
        val NEWSLETTER_EMAIL = stringPreferencesKey("newsletter_email")
        val NEWSLETTER_AGREED = booleanPreferencesKey("newsletter_agreed")
        val CUSTOM_WISHLIST_LINKS = stringPreferencesKey("custom_wishlist_links")
    }

    val savedFindIds: Flow<Set<String>> = context.herFindsDataStore.data.map { prefs ->
        prefs[Keys.SAVED_FIND_IDS] ?: emptySet()
    }

    val subscribedEmail: Flow<String?> = context.herFindsDataStore.data.map { prefs ->
        val email = prefs[Keys.NEWSLETTER_EMAIL]
        if (email.isNullOrBlank()) null else email
    }

    val newsletterAgreed: Flow<Boolean> = context.herFindsDataStore.data.map { prefs ->
        prefs[Keys.NEWSLETTER_AGREED] ?: false
    }

    val customWishlistLinks: Flow<List<CustomWishlistLink>> = context.herFindsDataStore.data.map { prefs ->
        parseLinksJson(prefs[Keys.CUSTOM_WISHLIST_LINKS])
    }

    suspend fun toggleSavedFind(findId: String) {
        context.herFindsDataStore.edit { prefs ->
            val current = prefs[Keys.SAVED_FIND_IDS] ?: emptySet()
            prefs[Keys.SAVED_FIND_IDS] = if (findId in current) current - findId else current + findId
        }
    }

    suspend fun subscribeNewsletter(email: String) {
        context.herFindsDataStore.edit { prefs ->
            prefs[Keys.NEWSLETTER_EMAIL] = email.trim()
            prefs[Keys.NEWSLETTER_AGREED] = true
        }
    }

    suspend fun unsubscribeNewsletter() {
        context.herFindsDataStore.edit { prefs ->
            prefs.remove(Keys.NEWSLETTER_EMAIL)
            prefs[Keys.NEWSLETTER_AGREED] = false
        }
    }

    suspend fun addCustomWishlistLink(title: String, url: String, note: String) {
        context.herFindsDataStore.edit { prefs ->
            val current = parseLinksJson(prefs[Keys.CUSTOM_WISHLIST_LINKS]).toMutableList()
            current.add(
                0,
                CustomWishlistLink(
                    id = UUID.randomUUID().toString(),
                    title = title.trim(),
                    url = url.trim(),
                    note = note.trim()
                )
            )
            prefs[Keys.CUSTOM_WISHLIST_LINKS] = encodeLinksJson(current)
        }
    }

    suspend fun removeCustomWishlistLink(id: String) {
        context.herFindsDataStore.edit { prefs ->
            val updated = parseLinksJson(prefs[Keys.CUSTOM_WISHLIST_LINKS]).filterNot { it.id == id }
            prefs[Keys.CUSTOM_WISHLIST_LINKS] = encodeLinksJson(updated)
        }
    }

    private fun parseLinksJson(raw: String?): List<CustomWishlistLink> {
        if (raw.isNullOrBlank()) return emptyList()
        return try {
            val array = JSONArray(raw)
            buildList {
                for (i in 0 until array.length()) {
                    val obj = array.getJSONObject(i)
                    add(
                        CustomWishlistLink(
                            id = obj.optString("id"),
                            title = obj.optString("title"),
                            url = obj.optString("url"),
                            note = obj.optString("note")
                        )
                    )
                }
            }
        } catch (_: Exception) {
            emptyList()
        }
    }

    private fun encodeLinksJson(links: List<CustomWishlistLink>): String {
        val array = JSONArray()
        links.forEach { link ->
            array.put(
                JSONObject().apply {
                    put("id", link.id)
                    put("title", link.title)
                    put("url", link.url)
                    put("note", link.note)
                }
            )
        }
        return array.toString()
    }
}
