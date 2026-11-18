package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.BlogArticle
import com.example.data.CuratedFind
import com.example.data.CustomWishlistLink
import com.example.data.FindCategory
import com.example.data.HerFindsCatalog
import com.example.data.HerFindsPreferencesRepository
import com.example.data.ShoppingGuide
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class HerFindsUiState(
    val selectedCategory: FindCategory? = null,
    val searchQuery: String = "",
    val showSavedOnlyInCatalog: Boolean = false,
    val savedFindIds: Set<String> = emptySet(),
    val subscribedEmail: String? = null,
    val customLinks: List<CustomWishlistLink> = emptyList(),
    val allFinds: List<CuratedFind> = HerFindsCatalog.curatedFinds,
    val trendingFinds: List<CuratedFind> = HerFindsCatalog.curatedFinds.filter { it.isTrending },
    val guides: List<ShoppingGuide> = HerFindsCatalog.shoppingGuides,
    val articles: List<BlogArticle> = HerFindsCatalog.blogArticles
) {
    val filteredFinds: List<CuratedFind>
        get() = allFinds.filter { find ->
            val matchesCategory = selectedCategory == null || find.category == selectedCategory
            val matchesSaved = !showSavedOnlyInCatalog || find.id in savedFindIds
            val q = searchQuery.trim()
            val matchesQuery = q.isEmpty() ||
                find.title.contains(q, ignoreCase = true) ||
                find.shortDescription.contains(q, ignoreCase = true) ||
                find.category.title.contains(q, ignoreCase = true) ||
                find.highlightTag.contains(q, ignoreCase = true)
            matchesCategory && matchesSaved && matchesQuery
        }

    val savedFinds: List<CuratedFind>
        get() = allFinds.filter { it.id in savedFindIds }
}

class HerFindsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = HerFindsPreferencesRepository(application.applicationContext)

    private val selectedCategory = MutableStateFlow<FindCategory?>(null)
    private val searchQuery = MutableStateFlow("")
    private val showSavedOnlyInCatalog = MutableStateFlow(false)

    val uiState: StateFlow<HerFindsUiState> = combine(
        selectedCategory,
        searchQuery,
        showSavedOnlyInCatalog,
        repository.savedFindIds,
        repository.subscribedEmail,
        repository.customWishlistLinks
    ) { values ->
        val category = values[0] as FindCategory?
        val query = values[1] as String
        val savedOnly = values[2] as Boolean
        @Suppress("UNCHECKED_CAST")
        val savedIds = values[3] as Set<String>
        val email = values[4] as String?
        @Suppress("UNCHECKED_CAST")
        val links = values[5] as List<CustomWishlistLink>

        HerFindsUiState(
            selectedCategory = category,
            searchQuery = query,
            showSavedOnlyInCatalog = savedOnly,
            savedFindIds = savedIds,
            subscribedEmail = email,
            customLinks = links
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = HerFindsUiState()
    )

    fun selectCategory(category: FindCategory?) {
        selectedCategory.value = category
    }

    fun updateSearchQuery(query: String) {
        searchQuery.value = query
    }

    fun toggleSavedOnlyInCatalog() {
        showSavedOnlyInCatalog.value = !showSavedOnlyInCatalog.value
    }

    fun clearCatalogFilters() {
        selectedCategory.value = null
        searchQuery.value = ""
        showSavedOnlyInCatalog.value = false
    }

    fun toggleSavedFind(findId: String) {
        viewModelScope.launch {
            repository.toggleSavedFind(findId)
        }
    }

    fun subscribeNewsletter(email: String) {
        viewModelScope.launch {
            repository.subscribeNewsletter(email)
        }
    }

    fun unsubscribeNewsletter() {
        viewModelScope.launch {
            repository.unsubscribeNewsletter()
        }
    }

    fun addCustomWishlistLink(title: String, url: String, note: String) {
        viewModelScope.launch {
            val normalizedUrl = if (url.startsWith("http://") || url.startsWith("https://")) {
                url
            } else {
                "https://$url"
            }
            repository.addCustomWishlistLink(title, normalizedUrl, note)
        }
    }

    fun removeCustomWishlistLink(id: String) {
        viewModelScope.launch {
            repository.removeCustomWishlistLink(id)
        }
    }
}
